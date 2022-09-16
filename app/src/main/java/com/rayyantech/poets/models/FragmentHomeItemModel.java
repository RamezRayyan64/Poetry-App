package com.rayyantech.poets.models;

public class FragmentHomeItemModel {

    String userProfileImageUri, postImageUri, textUserName, textPostTime, textPostContext, textUserPhone;

    public FragmentHomeItemModel(String userProfileImageUri, String postImageUri, String textUserName,
                                 String textPostTime, String textPostContext, String textUserPhone) {
        this.userProfileImageUri = userProfileImageUri;
        this.postImageUri = postImageUri;
        this.textUserName = textUserName;
        this.textPostTime = textPostTime;
        this.textPostContext = textPostContext;
        this.textUserPhone = textUserPhone;
    }

    public String getUserProfileImageUri() {
        return userProfileImageUri;
    }

    public String getPostImageUri() {
        return postImageUri;
    }

    public String getTextUserName() {
        return textUserName;
    }

    public String getTextPostTime() {
        return textPostTime;
    }

    public String getTextPostContext() {
        return textPostContext;
    }

    public String getTextUserPhone() {
        return textUserPhone;
    }
}
