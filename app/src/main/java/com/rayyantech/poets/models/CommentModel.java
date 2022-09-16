package com.rayyantech.poets.models;

public class CommentModel {

    String userProfileImageUri, textUserName, textCommentTime, textUserComment;

    public CommentModel(String userProfileImageUri, String name, String time, String text) {
        this.userProfileImageUri = userProfileImageUri;
        this.textUserName = name;
        this.textCommentTime = time;
        this.textUserComment = text;
    }

    public String getUserProfileImageUri() {
        return userProfileImageUri;
    }

    public String getTextUserName() {
        return textUserName;
    }

    public String getTextCommentTime() {
        return textCommentTime;
    }

    public String getTextUserComment() {
        return textUserComment;
    }
}
