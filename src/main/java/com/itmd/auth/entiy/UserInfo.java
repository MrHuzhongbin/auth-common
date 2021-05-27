package com.itmd.auth.entiy;

public class UserInfo {
    private Long id;

    private String username;

    private String image;

    public UserInfo() {
    }
    public UserInfo(Long id, String username){
        this.id = id;
        this.username = username;
    }
    public UserInfo(Long id, String username,String image) {
        this.id = id;
        this.username = username;
        this.image = image;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
