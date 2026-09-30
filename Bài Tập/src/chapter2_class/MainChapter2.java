package chapter2_class;
import java.util.Scanner;

public class MainChapter2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mainChoice = -1;

        while (true) {
            System.out.println("\n================ MAIN MENU - CHAPTER 2 ================");
            System.out.println("1. Point Class (Bai 1: Diem 2D)");
            System.out.println("2. Rectangle Class (Bai 2: Hinh Chu Nhat)");
            System.out.println("3. Circle Class (Bai 3: Hinh Tron)");
            System.out.println("4. Student Class (Bai 4: Sinh Vien)");
            System.out.println("5. Fraction Class (Phan So)");
            System.out.println("6. MyInteger Class (Bai 6: Lop So Nguyen)");
            System.out.println("7. MyArray Class (Bai 7: Lop Mang)");
            System.out.println("8. MyString Class (Bai 8: Lop Chuoi)");
            System.out.println("9. StudentList Class (Bai 9: Danh Sach Sinh Vien)");
            System.out.println("0. Exit Program");
            System.out.print("Please select an exercise: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1: Point.pointMenu(); break;
                case 2: Rectangle.rectangleMenu(); break;
                case 3: Circle.circleMenu(); break;
                case 4: Student.studentMenu(); break;
                case 5: Fraction.fractionMenu(); break;
                case 6: MyInteger.integerMenu(); break;
                case 7: MyArray.arrayMenu(); break;
                case 8: MyString.stringMenu(); break;
                case 9: StudentList.studentListMenu(); break;
                case 0:
                    System.out.println("Goodbye! See you next time.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please choose from 0 to 9.");
                    break;
            }
        }
    }
}