package chapter5_abstract;

import java.util.ArrayList;
import java.util.Scanner;
public class QuanLyMonHoc {
    private ArrayList<MonHoc> monHocList;
    
    public QuanLyMonHoc(){
        monHocList = new ArrayList<>();
    }

    public void themMonHoc(Scanner sc){
        int choice = 0;
        System.out.println("=== Them mon hoc ===");
        System.out.println("1. Ly thuyet.");
        System.out.println("2. Thuc hanh.");
        System.out.println("3. Do an.");
        System.out.print("Please enter your choice: ");
        choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                LyThuyet lt = new LyThuyet();
                lt.nhapThongTin(sc);
                this.monHocList.add(lt);
                break;
            case 2:
                ThucHanh th = new ThucHanh();
                th.nhapThongTin(sc);
                this.monHocList.add(th);
                break;
            case 3:
                DoAn da = new DoAn();
                da.nhapThongTin(sc);
                this.monHocList.add(da);
                break;
            default:
                System.out.println("Invalid choice !");
                break;
        }
    }
    public void hienThiDanhSach(){
        if (this.monHocList.isEmpty()) {
            System.out.println("Danh sach cua ban dang trong !");
            return;
        }
        for(MonHoc m : this.monHocList){
            m.hienThiThongTin();
        }
    }

    public double tinhDiemTBHocKy(){
        if (this.monHocList.isEmpty()) {
            System.out.println("Danh sach cua ban dang trong!");
            return 0;
        }
        double diemTBMon =0, tongTC = 0;
        for(MonHoc m : this.monHocList){
            diemTBMon += m.tinhDiemTB()*m.getSoTinChi();
            tongTC += m.getSoTinChi();
        }
        if (tongTC!=0) {
            return diemTBMon/tongTC;
        }
        return 0;
    }

    public void timMonHocDiemCaoNhat(){
        if (this.monHocList.isEmpty()) {
            System.out.println("Danh sach cua ban dang trong !");
            return;
        }
        double diemTBCaoNhat = -1;
        for(MonHoc m : this.monHocList){
            if (m.tinhDiemTB() > diemTBCaoNhat) {
                diemTBCaoNhat = m.tinhDiemTB();
            }
        }
        System.out.println("Cac mon co diem TB cao nhat");
        for(MonHoc m : this.monHocList){
            if (m.tinhDiemTB() == diemTBCaoNhat) {
                m.hienThiThongTin();
            }
        }
    }
}
