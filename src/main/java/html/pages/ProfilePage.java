package html.pages;

import html.blocks.PostMessagePopup;

public class ProfilePage extends BasePage {

    private PostMessagePopup postMessagePopup;

    public void postNewMessage(String text){
        postMessagePopup.open()
                .fillTextbox(text)
                .clickSubmitButton();
    }

    public void updateMessage(String oldText, String newText){

    }

    public void deleteMessage(String messageText){

    }

}
