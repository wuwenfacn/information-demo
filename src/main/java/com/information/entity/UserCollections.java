package com.information.entity;

import java.sql.Timestamp;

/**
 * @Author qiaoshu
 * @since JDK 1.8
 * Date: 2020-10-22  17:00
 * Description:
 * 展示收藏的水果信息实体类
 */
public class UserCollections {
    private String username;
    private String namese;
    private long ciscancle;
    private Timestamp ctime;
    private long id;
    private String prices;
    private String describes;
    private String place;
    private String types;
    private String business;
    private String telephone;
    private String images;

    public UserCollections() {
    }

    public UserCollections(String username, String namese, long ciscancle, Timestamp ctime, long id,
                           String prices, String describes, String place, String types,
                           String business, String telephone, String images) {
        this.username = username;
        this.namese = namese;
        this.ciscancle = ciscancle;
        this.ctime = ctime;
        this.id = id;
        this.prices = prices;
        this.describes = describes;
        this.place = place;
        this.types = types;
        this.business = business;
        this.telephone = telephone;
        this.images = images;
    }

    @Override
    public String toString() {
        return "UserCollections{" +
                "username='" + username + '\'' +
                ", namese='" + namese + '\'' +
                ", ciscancle=" + ciscancle +
                ", ctime=" + ctime +
                ", id=" + id +
                ", prices='" + prices + '\'' +
                ", describes='" + describes + '\'' +
                ", place='" + place + '\'' +
                ", types='" + types + '\'' +
                ", business='" + business + '\'' +
                ", telephone='" + telephone + '\'' +
                ", images='" + images + '\'' +
                '}';
    }

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

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
