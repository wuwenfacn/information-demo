package com.information.entity;

import com.information.utils.ResponseEntity;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-20  16:14
 * Description:
 */
public class DetailsList {
    private Details details;
    private ResponseEntity responseEntity;

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public ResponseEntity getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity responseEntity) {
        this.responseEntity = responseEntity;
    }

    public DetailsList(Details details, ResponseEntity responseEntity) {
        this.details = details;
        this.responseEntity = responseEntity;
    }

    public DetailsList() {
    }
}
