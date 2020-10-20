package com.information.entity;


public class User {

  private String username;
  private String password;
  private String type;
  private Integer is_delete = 1;
  private Integer id;

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", type='" + type + '\'' +
            ", is_delete=" + is_delete +
            ", id=" + id +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIs_delete() {
    return is_delete;
  }

  public void setIs_delete(Integer is_delete) {
    this.is_delete = is_delete;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
