package model;

import java.io.Serializable;
import java.lang.String;

public class SV implements Serializable {
    private String maSV;
    private String hoten;
    private int nhom;

    public SV(String maSV, String hoten, int nhom) {
        this.maSV = maSV;
        this.hoten = hoten;
        this.nhom = nhom;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    @Override
    public String toString() {
        return String.format("Ma SV: %s | Ho ten: %s | Nhom: %d", this.maSV,this.hoten,this.nhom);
    }
}
