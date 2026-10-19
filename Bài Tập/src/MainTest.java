import chapter5_abstract.*;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyMonHoc manager = new QuanLyMonHoc();
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- HE THONG QUAN LY DIEM MON HOC ---");
            System.out.println("1. Them mon hoc moi");
            System.out.println("2. Hien thi danh sach mon hoc");
            System.out.println("3. Tinh diem trung binh hoc ky");
            System.out.println("4. Tim mon hoc co diem TB cao nhat");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Vui long chon chuc nang (0-4): ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); 
            } else {
                sc.nextLine();
                System.out.println("Vui long nhap so!");
                continue; 
            }

            switch (choice) {
                case 1:
                    manager.themMonHoc(sc);
                    break;
                    
                case 2:
                    System.out.println("\n--- DANH SACH MON HOC ---");
                    manager.hienThiDanhSach();
                    break;
                    
                case 3:
                    double gpa = manager.tinhDiemTBHocKy();
                    if (gpa > 0) {
                        System.out.printf("\nDiem trung binh hoc ky: %.2f\n", gpa);
                    }
                    break;
                    
                case 4:
                    System.out.println("\n--- MON HOC DIEM CAO NHAT ---");
                    manager.timMonHocDiemCaoNhat();
                    break;
                    
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                    
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 0 den 4!");
                    break;
            }
        }
        
        sc.close();
    }
}