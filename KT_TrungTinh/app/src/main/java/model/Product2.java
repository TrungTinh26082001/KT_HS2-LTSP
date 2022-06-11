package model;

import edu.csc.kt_trungtinh.R;

public class Product2 {
    private int hinh;
    private String ten;
    private double gia;

    public Product2() {
        hinh= R.drawable.thuy_tien;
        ten = "";
        gia = 0;
    }

    public Product2(int hinh, String ten, int gia) {
        this.hinh = hinh;
        this.ten = ten;
        this.gia = gia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getPrice() {
        return gia;
    }

    public void setPrice(double price) {
        gia = price;
    }
}
