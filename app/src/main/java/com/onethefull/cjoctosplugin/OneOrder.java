package com.onethefull.cjoctosplugin;

public class OneOrder {

    String key;
    String app_id;
    String lang;
    String reqDevice;
    String showImgCode;
    String speakStr;
    String use_yn;

    public void OneOrder(){

    }

    public OneOrder(String key, String app_id, String lang, String reqDevice, String showImgCode, String speakStr, String use_yn) {
        this.key = key;
        this.app_id = app_id;
        this.lang = lang;
        this.reqDevice = reqDevice;
        this.showImgCode = showImgCode;
        this.speakStr = speakStr;
        this.use_yn = use_yn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getReqDevice() {
        return reqDevice;
    }

    public void setReqDevice(String reqDevice) {
        this.reqDevice = reqDevice;
    }

    public String getShowImgCode() {
        return showImgCode;
    }

    public void setShowImgCode(String showImgCode) {
        this.showImgCode = showImgCode;
    }

    public String getSpeakStr() {
        return speakStr;
    }

    public void setSpeakStr(String speakStr) {
        this.speakStr = speakStr;
    }

    public String getUse_yn() {
        return use_yn;
    }

    public void setUse_yn(String use_yn) {
        this.use_yn = use_yn;
    }



}
