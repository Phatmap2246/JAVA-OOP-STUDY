package chapter5_abstract;
import java.util.Scanner;
public class ThucHanh extends MonHoc {
    private double diem1,diem2,diem3,diem4;

    public ThucHanh() {
        super();
        this.diem1 = 0;
        this.diem2 = 0;
        this.diem3 = 0;
        this.diem4 = 0;
    }

    public ThucHanh(String maMonHoc, String tenMonHoc, int soTinChi, double diem1, double diem2, double diem3,
            double diem4) {
        super(maMonHoc, tenMonHoc, soTinChi);
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.diem4 = diem4;
    }


    @Override 
    public double tinhDiemTB(){
        return (this.diem1+this.diem2+this.diem3+this.diem4)/4;
    }

    public double getDiem1() {
        return diem1;
    }

    public void nhapThongTin(Scanner sc){
        super.nhapThongTin(sc);
        while (true) {
            System.out.print("Vui long nhap diem 1: ");
            this.diem1 = sc.nextDouble();
            if (this.isValidScore(this.diem1)) {
                break;
            }
            System.out.println("Invalid score !");
        }
        while (true) {
            System.out.print("Vui long nhap diem 2: ");
            this.diem2 = sc.nextDouble();
            if (this.isValidScore(this.diem2)) {
                break;
            }
            System.out.println("Invalid score !");
        }
        while (true) {
            System.out.print("Vui long nhap diem 3: ");
            this.diem3 = sc.nextDouble();
            if (this.isValidScore(this.diem3)) {
                break;
            }
            System.out.println("Invalid score !");
        }
        while (true) {
            System.out.print("Vui long nhap diem 4: ");
            this.diem4 = sc.nextDouble();
            if (this.isValidScore(this.diem4)) {
                break;
            }
            System.out.println("Invalid score !");
        }
        
        
    }

    public void setDiem1(double diem1) {
        this.diem1 = diem1;
    }

    public double getDiem2() {
        return diem2;
    }

    public void setDiem2(double diem2) {
        this.diem2 = diem2;
    }

    public double getDiem3() {
        return diem3;
    }

    public void setDiem3(double diem3) {
        this.diem3 = diem3;
    }

    public double getDiem4() {
        return diem4;
    }

    public void setDiem4(double diem4) {
        this.diem4 = diem4;
    }
}
