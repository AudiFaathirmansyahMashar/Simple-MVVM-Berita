package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("waktu")
    @Expose
    private String waktu;
    @SerializedName("tipe")
    @Expose
    private String tipe;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("kutipan")
    @Expose
    private String kutipan;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getKutipan() {
        return kutipan;
    }

    public void setKutipan(String kutipan) {
        this.kutipan = kutipan;
    }

}
