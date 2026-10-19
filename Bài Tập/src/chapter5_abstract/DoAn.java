package chapter5_abstract;

import java.util.Scanner;

public class DoAn extends MonHoc{
    private  double diemGVHD, diemGVPB;

    public DoAn() {
        super();
        this.diemGVHD = 0;
        this.diemGVPB = 0;
    }

    public DoAn(String maMonHoc, String tenMonHoc, int soTinChi, double diemGVHD, double diemGVPB) {
        super(maMonHoc, tenMonHoc, soTinChi);
        this.diemGVHD = diemGVHD;
        this.diemGVPB = diemGVPB;
    }

    @Override 
    public void nhapThongTin(Scanner sc){
        super.nhapThongTin(sc);
        while (true) {
            System.out.print("Vui long nhap diem GVHD: ");
            this.diemGVHD = sc.nextDouble();
            if (this.isValidScore(this.diemGVHD)) {
                break;
            }
            System.out.println("Invalid score !");
        }
        while (true) {
            System.out.print("Vui long nhap diem GVPB: ");
            this.diemGVPB = sc.nextDouble();
            if (this.isValidScore(this.diemGVPB)) {
                break;
            }
            System.out.println("Invalid score !");
        }
    }
    public double tinhDiemTB(){
        return (this.diemGVHD+this.diemGVPB)/2;
    }

    public double getDiemGVHD() {
        return diemGVHD;
    }

    public void setDiemGVHD(double diemGVHD) {
        this.diemGVHD = diemGVHD;
    }

    public double getDiemGVPB() {
        return diemGVPB;
    }

    public void setDiemGVPB(double diemGVPB) {
        this.diemGVPB = diemGVPB;
    }
    
}
