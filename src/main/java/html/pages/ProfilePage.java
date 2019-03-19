package html.pages;

import html.blocks.DeleteMessagePopup;
import html.blocks.EditMessagePopup;
import html.blocks.PostMessagePopup;
import html.blocks.PostedMessage;

import java.util.List;

public class ProfilePage extends BasePage {

    private PostMessagePopup postMessagePopup;
    private EditMessagePopup editMessagePopup;
    private DeleteMessagePopup deleteMessagePopup;
    private List<PostedMessage> posts;

    public List<PostedMessage> createPost(String postText) {
        postMessagePopup.open()
                .fillTextbox(postText)
                .clickSubmitButton();
        return posts;
    }

    public List<PostedMessage> updatePost(String currentText, String newText) {
        posts.stream().filter(post -> post.getPostedText().equals(currentText)).findFirst().get()
                .openOptionsMenu()
                .selectEditOption();
        editMessagePopup.uppendText(newText)
                .clickSubmitButton()
                .shouldNotBeDisplayed();
        return posts;
    }

    public List<PostedMessage> deletePost(String postText) {
        posts.stream().filter(post -> post.getPostedText().equals(postText)).findFirst().get()
                .openOptionsMenu()
                .selectDeleteOption();
        deleteMessagePopup.clickSubmitButton()
                .shouldNotBeDisplayed();
        return posts;
    }

}
