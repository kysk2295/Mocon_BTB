package com.kys.lg.mocon_btb;

public class SearchData {

    private int imgSrcOfProfile;
    private String title;
    private String janru;
    private String writer;
    private String publisher;

    public SearchData(int imgSrcOfProfile, String title, String janru, String writer, String publisher) {
        this.imgSrcOfProfile = imgSrcOfProfile;
        this.title = title;
        this.janru = janru;
        this.writer = writer;
        this.publisher = publisher;
    }

    public int getImgSrcOfProfile() {
        return imgSrcOfProfile;
    }

    public void setImgSrcOfProfile(int imgSrcOfProfile) { this.imgSrcOfProfile = imgSrcOfProfile; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJanru() {
        return janru;
    }

    public void setJanru(String janru) {
        this.janru = janru;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
