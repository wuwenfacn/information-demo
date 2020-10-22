package com.information.entity;
/*收藏水果信息实体类*/
public class Collection {

  private String username;
  private String namese;
  private long ciscancle;
  private java.sql.Timestamp ctime;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getNamese() {
    return namese;
  }

  public void setNamese(String namese) {
    this.namese = namese;
  }


  public long getCiscancle() {
    return ciscancle;
  }

  public void setCiscancle(long ciscancle) {
    this.ciscancle = ciscancle;
  }


  public java.sql.Timestamp getCtime() {
    return ctime;
  }

  public void setCtime(java.sql.Timestamp ctime) {
    this.ctime = ctime;
  }

}
