package com.tj720.admin.dto;

import com.tj720.admin.model.MipOpenCollectionInfo;
import com.tj720.admin.model.MipTour;
import com.tj720.admin.model.MipTourCollection;

public class MipTourCollectionDto extends MipOpenCollectionInfo{

    private String tourCollectionId;
    private int sort;
    private String tourId;
    private String url;


    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getSort() {
        return sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getTourCollectionId() {
        return tourCollectionId;
    }

    public void setTourCollectionId(String tourCollectionId) {
        this.tourCollectionId = tourCollectionId;
    }
}
