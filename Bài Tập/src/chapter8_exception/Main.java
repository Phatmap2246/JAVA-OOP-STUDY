package chapter8_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n--- QUẢN LÝ SINH VIÊN (EXCEPTION) ---");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // Nuốt phím Enter
            } catch (Exception e) {
                System.out.println("[!] Lỗi: Bạn phải nhập số nguyên!");
                sc.nextLine(); // Xóa dữ liệu sai để không bị lặp vô hạn
                continue; // Quay lại đầu vòng lặp
            }

            switch (choice) {
                case 1:
                    System.out.println("--- NHẬP THÔNG TIN SINH VIÊN ---");
                    
                    System.out.print("Nhập mã SV: ");
                    String id = sc.nextLine();

                    System.out.print("Nhập tên SV: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập điểm GPA (0.0 - 4.0): ");
                    double gpa = sc.nextDouble();
                    sc.nextLine(); // Nuốt phím Enter

                    // BẮT LỖI KHI THÊM SINH VIÊN
                    try {
                        Student newStudent = new Student(id, name, gpa);
                        manager.addStudent(newStudent);
                    } catch (IllegalArgumentException e) {
                        // Bắt lỗi Unchecked (Điểm số âm hoặc > 4.0)
                        System.out.println(e.getMessage());
                    } catch (DuplicateIDException e) {
                        // Bắt lỗi Checked (Trùng mã sinh viên)
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    manager.displayAll();
                    break;

                case 0:
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("[!] Lựa chọn không hợp lệ!");
            }
        }
        
        sc.close();
    }
}