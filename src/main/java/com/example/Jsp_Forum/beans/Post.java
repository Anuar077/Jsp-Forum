package com.example.Jsp_Forum.beans;

public class Post implements java.io.Serializable{
    private int postid;
    private String title;
    private String pContent;
    private String username;

    public int getPostId() {
        return postid;
    }
    public void setPostId(int postid) {
        this.postid = postid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitles(String title) {
        this.title = title;
    }
    public String getpContent() {
        return pContent;
    }
    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid=" +postid +
                ", title='" + title + '\'' +
                ", pContent='" + pContent + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

