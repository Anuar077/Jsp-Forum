package com.example.Jsp_Forum.beans;

public class Comment implements java.io.Serializable{

        private int commentid;
        private String content;
        private int postid;
        private String username;

        public int getCommentid() {
            return commentid;
        }

        public void setCommentId(int commentid) {
            this.commentid = commentid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getPostId() {
            return postid;
        }

        public void setPostId(int postid) {
            this.postid = postid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }


