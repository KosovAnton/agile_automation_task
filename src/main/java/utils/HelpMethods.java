package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static utils.GlobalValues.*;

public class HelpMethods {

    /*
     * This method waits for JavaScript to finish working on page
     */
    public static void waitForJStoLoad() {
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        int counter = 0;
        int multiplier = 1;
        try {
            while (true) {
                if (jQueryLoad.apply(driver) && jsLoad.apply(driver)) {
                    return;
                } else {
                    counter++;
                    multiplier += multiplier;
                    if (multiplier > 29) {
                        throw new TimeoutException("Javascript is taking too long to finish");
                    } else {
                        Thread.sleep(1000 * multiplier);
                    }
                }
            }
        } catch (Throwable ex) {

        }
    }

    public static BufferedImage captureElementScreenshot(WebElement element) throws IOException {
        byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        InputStream targetStream = new ByteArrayInputStream(screen);
        BufferedImage img = ImageIO.read(targetStream);
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        java.awt.Rectangle rect = new java.awt.Rectangle(width, height);
        Point p = element.getLocation();
        return img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
    }

    /*public static File captureElementScreenshot(WebElement element) throws IOException {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screen);
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        Rectangle rect = new Rectangle(width, height);
        Point p = element.getLocation();
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        ImageIO.write(dest, "png", screen);
        return screen;
    }*/

    public static int compareImages(File originalImage, BufferedImage capturedBufferedImage) throws IOException {
        long difference = 0;
        BufferedImage originalBufferedImage = ImageIO.read(originalImage);

        //Crop images if theirs dimensions are not equal
        if (originalBufferedImage.getWidth() != capturedBufferedImage.getWidth()){
            if (originalBufferedImage.getWidth() > capturedBufferedImage.getWidth()){
                originalBufferedImage = originalBufferedImage
                        .getSubimage(0,0, capturedBufferedImage.getWidth(), capturedBufferedImage.getHeight());
            } else {
                capturedBufferedImage = capturedBufferedImage
                        .getSubimage(0, 0, originalBufferedImage.getWidth(), originalBufferedImage.getHeight());
            }
        }

        if (originalBufferedImage.getHeight() != capturedBufferedImage.getHeight()){
            if (originalBufferedImage.getHeight() > capturedBufferedImage.getHeight()){
                originalBufferedImage = originalBufferedImage
                        .getSubimage(0,0, capturedBufferedImage.getWidth(), capturedBufferedImage.getHeight());
            } else {
                capturedBufferedImage = capturedBufferedImage
                        .getSubimage(0, 0, originalBufferedImage.getWidth(), originalBufferedImage.getHeight());
            }
        }

        int originalImageWidth = originalBufferedImage.getWidth();
        int originalImageHeight = originalBufferedImage.getHeight();

        int capturedImageWidth = capturedBufferedImage.getWidth();
        int capturedImageHeight = capturedBufferedImage.getHeight();

        if (originalImageWidth != capturedImageWidth || originalImageHeight != capturedImageHeight){
            throw new IllegalArgumentException(String.format("Images must have the same dimensions: (%d,%d) vs. (%d,%d)",
                    originalImageWidth, originalImageHeight, capturedImageWidth, capturedImageHeight));
        } else {
            for (int y = 0; y < originalImageHeight; y++) {
                for (int x = 0; x < originalImageWidth; x++)
                {
                    int RGBOriginal = originalBufferedImage.getRGB(x, y);
                    int RGBCaptured = capturedBufferedImage.getRGB(x, y);

                    int redOriginal = (RGBOriginal >> 16) & 0xff;
                    int greenOriginal = (RGBOriginal >> 8) & 0xff;
                    int blueOriginal = (RGBOriginal) & 0xff;

                    int redCaptured = (RGBCaptured >> 16) & 0xff;
                    int greenCaptured = (RGBCaptured >> 8) & 0xff;
                    int blueCaptured = (RGBCaptured) & 0xff;

                    difference += Math.abs(redOriginal - redCaptured);
                    difference += Math.abs(greenOriginal - greenCaptured);
                    difference += Math.abs(blueOriginal - blueCaptured);
                }
            }
            double totalPixels = originalImageWidth * originalImageHeight * 3;
            double avgDifferentPixels = difference / totalPixels;
            double percentage = (avgDifferentPixels / 255) * 100;
            return (int) percentage;
        }
    }

    public static void writeToFile(String string){
        try {
            File file = new File("target/test-classes/files/created_courses_release_ids");
            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            writer.write(string);
            writer.append(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeFromFile(String string){
        File file = new File("target/test-classes/files/created_courses_release_ids");
        List<String> releaseIds = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String releaseId;
            while ((releaseId = reader.readLine())!= null){
                if (!releaseId.equals(string)){
                    releaseIds.add(releaseId);
                }
            }

            FileWriter writer = new FileWriter(file.getAbsoluteFile(), false);
            writer.write("");
            writer.close();

            writer = new FileWriter(file.getAbsoluteFile(), true);

            for (String id : releaseIds) {
                writer.write(id);
                writer.append(System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
