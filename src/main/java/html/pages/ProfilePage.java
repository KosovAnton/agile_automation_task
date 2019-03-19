package html.pages;

import html.blocks.EditMessagePopup;
import html.blocks.PostMessagePopup;
import html.blocks.PostedMessage;

import java.util.List;

public class ProfilePage extends BasePage {

    private PostMessagePopup postMessagePopup;
    private EditMessagePopup editMessagePopup;
    private List<PostedMessage> posts;

    public void postMessage(String text) {
        postMessagePopup.open()
                .fillTextbox(text)
                .clickSubmitButton();
    }

    public void updateMessage(String currentText, String newText) {
        posts.stream().filter(post -> post.getPostedText().contains(currentText)).findFirst().get()
                .openOptionsMenu()
                .selectEditOption();
        editMessagePopup.fillTextbox(newText)
                .clickSubmitButton();
    }

    public void deleteMessage(String messageText) {

    }

}
