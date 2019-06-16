package com.kys.lg.mocon_btb;

public class AnnounceData {
    private String announce;
    private String day;

    public AnnounceData(String announce, String day) {
        this.announce = announce;
        this.day = day;
    }

    public String getAnnounce() {
        return announce;
    }

    public void setAnnounce(String announce) {
        this.announce = announce;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
