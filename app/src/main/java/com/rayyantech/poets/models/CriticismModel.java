package com.rayyantech.poets.models;

public class CriticismModel {

    String userProfileImageUri, textUserName, textCriticismTime, textUserCriticism;

    public CriticismModel(String userProfileImageUri, String name, String time, String text) {
        this.userProfileImageUri = userProfileImageUri;
        this.textUserName = name;
        this.textCriticismTime = time;
        this.textUserCriticism = text;
    }

    public String getUserProfileImageUri() {
        return userProfileImageUri;
    }

    public String getTextUserName() {
        return textUserName;
    }

    public String getTextCriticismTime() {
        return textCriticismTime;
    }

    public String getTextUserCriticism() {
        return textUserCriticism;
    }
}
