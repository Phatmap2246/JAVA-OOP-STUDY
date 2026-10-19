package chapter5_abstract;

import java.util.Scanner;

public class LyThuyet extends MonHoc {
    private double diemTieuLuan;
    private double diemCuoiKy;

    public LyThuyet() {
        super();
        this.diemTieuLuan = 0;
        this.diemCuoiKy = 0;
    }
    public LyThuyet(String maMonHoc, String tenMonHoc, int soTinChi, double diemTieuLuan, double diemCuoiKy) {
        super(maMonHoc, tenMonHoc, soTinChi);
        this.diemTieuLuan = diemTieuLuan;
        this.diemCuoiKy = diemCuoiKy;
    }

    @Override 
    public void nhapThongTin(Scanner sc){
        super.nhapThongTin(sc);
        while (true) {
            System.out.print("Vui long nhap diem tieu luan: ");
            this.diemTieuLuan = sc.nextDouble();
            if (this.isValidScore(this.diemTieuLuan)) {
                break;
            }
            System.out.println("Diem tieu luan khong hop le!");
        }
        while (true) {
            System.out.print("Vui long nhap diem cuoi ky");
            this.diemCuoiKy = sc.nextDouble();
            if (this.isValidScore(this.diemCuoiKy)) {
                break;
            }
            System.out.println("Diem cuoi ky khong hop le!");
        }
        
    }

    @Override 
    public double tinhDiemTB(){
        return this.diemTieuLuan * 0.4 + this.diemCuoiKy * 0.6;
    }

    public double getDiemTieuLuan() {
        return diemTieuLuan;
    }
    public void setDiemTieuLuan(double diemTieuLuan) {
        this.diemTieuLuan = diemTieuLuan;
    }
    public double getDiemCuoiKy() {
        return diemCuoiKy;
    }
    public void setDiemCuoiKy(double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }
}
