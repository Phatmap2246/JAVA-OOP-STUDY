package chapter5_abstract;
import java.util.Scanner;
public abstract class MonHoc {
    protected String maMonHoc;
    protected String tenMonHoc;
    protected int soTinChi;

    public MonHoc(){
        this.maMonHoc = "";
        this.tenMonHoc = "";
        this.soTinChi = 0;
    }
    public MonHoc(String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    public void nhapThongTin(Scanner sc){
        System.out.println("=== Nhap ly thuyet ===");
        System.out.print("Vui long nhap ma mon hoc: ");
        this.maMonHoc = sc.nextLine();
        System.out.print("Vui long nhap ten mon hoc: ");
        this.tenMonHoc = sc.nextLine();
        System.out.print("Vui long nhap so tin chi: ");
        this.soTinChi = sc.nextInt();
        sc.nextLine();
    }
    
    public void hienThiThongTin(){
        System.out.println("=== Hien thi thong tin ===");
        System.out.println("Ma mon hoc: "+this.maMonHoc);
        System.out.println("Ten mon hoc: "+this.tenMonHoc);
        System.out.println("So tin chi: "+this.soTinChi);
    }

    public abstract double tinhDiemTB();

    public String xepLoaiDiemChu(){
        if (this.tinhDiemTB() < 4.0) {
            return "F";
        }
        else if (this.tinhDiemTB() < 5.5) {
            return "D";
        }
        else if (this.tinhDiemTB() < 7.0) {
            return "C";
        }
        else if (this.tinhDiemTB() < 8.5) {
            return "B";
        }
        return  "A";
    }

    public boolean isValidScore(double Score){
        return Score >0 && Score <=10;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }
    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
    public String getTenMonHoc() {
        return tenMonHoc;
    }
    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
    public int getSoTinChi() {
        return soTinChi;
    }
    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
    
}
