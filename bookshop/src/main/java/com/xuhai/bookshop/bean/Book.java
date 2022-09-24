package com.xuhai.bookshop.bean;

import java.util.Date;
import java.util.List;

public class Book {
    private Integer bookId;

    private String bookName;

    private String lead;

    private Date releaseDate;

    private Integer status;

    private String profile;

    private Integer authorId;

    private Integer[] rangeScore;

    private String[] rangeRelease;

    private Integer score;

    private List<Category> categoryList;

    private List<BookImage> imageList;

    private String categories;

    private String images;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<BookImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<BookImage> imageList) {
        this.imageList = imageList;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer[] getRangeScore() {
        return rangeScore;
    }

    public void setRangeScore(Integer[] rangeScore) {
        this.rangeScore = rangeScore;
    }

    public String[] getRangeRelease() {
        return rangeRelease;
    }

    public void setRangeRelease(String[] rangeRelease) {
        this.rangeRelease = rangeRelease;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }


}
