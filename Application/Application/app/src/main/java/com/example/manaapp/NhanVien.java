package com.example.manaapp;

public class NhanVien {
    public int id;
    public String ten;
    public String sdt;
    public String diachi;
    public byte[] anh;

    public NhanVien(int id, String ten, String sdt, String diachi, byte[] anh) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.anh = anh;
    }
}
