package com.information.entity;

/*展示所有水果信息实体类*/
public class Details {

  @Override
  public String toString() {
    return "Details{" +
            "id=" + id +
            ", namese='" + namese + '\'' +
            ", prices='" + prices + '\'' +
            ", describes='" + describes + '\'' +
            ", place='" + place + '\'' +
            ", types='" + types + '\'' +
            ", business='" + business + '\'' +
            ", telephone='" + telephone + '\'' +
            ", images='" + images + '\'' +
            '}';
  }

  public Details() {
  }

  private long id;
  private String namese;
  private String prices;
  private String describes;
  private String place;
  private String types;
  private String business;
  private String telephone;
  private String images;

  public Details(long id, String namese, String prices, String describes,
                 String place, String types, String business, String telephone, String images) {
    this.id = id;
    this.namese = namese;
    this.prices = prices;
    this.describes = describes;
    this.place = place;
    this.types = types;
    this.business = business;
    this.telephone = telephone;
    this.images = images;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getNamese() {
    return namese;
  }

  public void setNamese(String namese) {
    this.namese = namese;
  }


  public String getPrices() {
    return prices;
  }

  public void setPrices(String prices) {
    this.prices = prices;
  }


  public String getDescribes() {
    return describes;
  }

  public void setDescribes(String describes) {
    this.describes = describes;
  }


  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }


  public String getTypes() {
    return types;
  }

  public void setTypes(String types) {
    this.types = types;
  }


  public String getBusiness() {
    return business;
  }

  public void setBusiness(String business) {
    this.business = business;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }



}
