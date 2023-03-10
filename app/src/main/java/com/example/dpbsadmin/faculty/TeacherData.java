package com.example.dpbsadmin.faculty;

public class TeacherData {
    private String name,email,post,image,Key;

    public TeacherData(String name, String email, String post, String image, String Key) {
        this.name = name;
        this.email = email;
        this.post = post;
        this.image = image;
        this.Key = Key;
    }

    public TeacherData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String uniqueKey) {
        this.Key = uniqueKey;
    }
}
