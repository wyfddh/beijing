package com.tj720.admin.model;

public class MipTourCollection {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_topic_collection.id
     *
     * @mbggenerated Wed Aug 08 15:42:19 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_topic_collection.topic_id
     *
     * @mbggenerated Wed Aug 08 15:42:19 CST 2018
     */
    private String tourId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_topic_collection.collection_id
     *
     * @mbggenerated Wed Aug 08 15:42:19 CST 2018
     */
    private String collectionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_topic_collection.sort
     *
     * @mbggenerated Wed Aug 08 15:42:19 CST 2018
     */
    private Integer sort;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
