package com.information.entity;

/*水果类型实体类*/
public class Navbar {

  private long id;
  private String name;
  private long sort;

  public Navbar(long id, String name, long sort) {
    this.id = id;
    this.name = name;
    this.sort = sort;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }

}
