package chapter3_inheritance;

import java.util.Scanner;

public class MainChapter3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n========================================");
            System.out.println("      CHAPTER 3: INHERITANCE & OOP      ");
            System.out.println("========================================");
            System.out.println("1. Bai tap Dong vat (Cat & Animal)");
            System.out.println("2. Bai tap Hoc sinh (Pupil & Person)");
            System.out.println("3. Bai tap Doan thang (LineSegment & Point)");
            System.out.println("0. Exit (Thoat chuong trinh)");
            System.out.print("Your choice (0-3): ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n>>> REDIRECTING TO CAT CAFE MENU...");
                    // Thay "MainAnimal" bằng tên class đang chứa hàm catMenu() của cậu
                    Cat.catMenu(); 
                    break;
                    
                case 2:
                    System.out.println("\n>>> REDIRECTING TO PUPIL MENU...");
                    // Thay "MainPupil" bằng tên class đang chứa hàm pupilMenu() của cậu
                    Pupil.pupilMenu();
                    break;
                    
                case 3:
                    System.out.println("\n>>> REDIRECTING TO LINE SEGMENT MENU...");
                    // Thay "MainLineSegment" bằng tên class đang chứa hàm lineSegmentMenu() của cậu
                    LineSegment.lineSegmentMenu();
                    break;
                    
                case 0:
                    System.out.println("Exiting Chapter 3 Hub. Goodbye!");
                    break;
                    
                default:
                    System.out.println("[!] Invalid choice! Please select 0-3.");
            }
        }
        sc.close();
    }
}