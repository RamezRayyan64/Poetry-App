package com.example.rayyantech.poetry_app_ui.models;

public class UsersInfoModel {

    String userProfileImageUri, textUsername, textUserPhone;

    public UsersInfoModel(String poemProfileImageUri, String poemUsername, String poemPhone) {
        this.userProfileImageUri = poemProfileImageUri;
        this.textUsername = poemUsername;
        this.textUserPhone = poemPhone;
    }

    public String getUserProfileImageUri() {
        return userProfileImageUri;
    }

    public String getTextUsername() {
        return textUsername;
    }

    public String getTextUserPhone() {
        return textUserPhone;
    }
}
