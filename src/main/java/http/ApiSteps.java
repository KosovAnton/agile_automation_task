package http;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.Feed;
import models.Post;
import utils.GlobalValues;

import java.util.List;

import static http.QueryParameter.MESSAGE;
import static io.restassured.RestAssured.given;

public class ApiSteps {

    private static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(GlobalValues.GRAPH_FB_BASE_URL)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.ANY)
            .addHeader("Authorization", "Bearer " + GlobalValues.GRAPH_FB_PAGE_ACCESS_TOKEN)
            .build();

    public static ValidatableResponse createPost(String message) {
        return given()
                .spec(requestSpecification)
                .when()
                .queryParam(MESSAGE, message)
                .post(EndPoints.USER_FEED, "me")
                .then();
    }

    public static ValidatableResponse updatePost(String currentMessage, String newMessage) {
        return given()
                .spec(requestSpecification)
                .when()
                .queryParam(MESSAGE, newMessage)
                .post(EndPoints.FEED_POST, getPostByMessage(currentMessage, getUserFeed()).getId())
                .then();
    }

    public static ValidatableResponse deletePost(String message) {
        return given()
                .spec(requestSpecification)
                .when()
                .delete(EndPoints.FEED_POST, getPostByMessage(message, getUserFeed()).getId())
                .then();
    }

    public static List<Post> getUserFeed() {
        return given().spec(requestSpecification)
                .when()
                .get(EndPoints.USER_FEED, "me")
                .then().extract().body().as(Feed.class)
                .getData();
    }

    public static Post getPostByMessage(String message, List<Post> feed) {
        return feed.stream().filter(post -> post.getMessage().equals(message)).findFirst()
                .orElseThrow(() -> new java.lang.AssertionError("User feed does not contain message: '" + message + "'"));
    }
}
