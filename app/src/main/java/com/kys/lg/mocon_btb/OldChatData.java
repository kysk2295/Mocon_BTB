package com.kys.lg.mocon_btb;

public class OldChatData {
    private int imgSrcOfProfileOldchat;
    private String name;

    public OldChatData(int imgSrcOfProfileOldchat, String name) {
        this.imgSrcOfProfileOldchat = imgSrcOfProfileOldchat;
        this.name = name;
    }

    public int getImgSrcOfProfileOldchat() {
        return imgSrcOfProfileOldchat;
    }

    public void setImgSrcOfProfileOldchat(int imgSrcOfProfileOldchat) {
        this.imgSrcOfProfileOldchat = imgSrcOfProfileOldchat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
