import chapter5_abstract.*;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) { // Đã sửa thành main
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        EmployeeManager list = new EmployeeManager();
        while (true) {
            System.out.println("=== Employee Menu ===");
            System.out.println("1. Add a new emplyee. ");
            System.out.println("2. Display all employee. ");
            System.out.println("3. Calculate total payroll.  ");
            System.out.println("4. Find the highest paid employee. ");
            System.out.println("5. Delete employee by ID. ");
            System.out.println("0. Exit Menu. ");
            System.out.print("Please enter your chocie: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Thanks you !");
                    return;
                case 1:
                    list.addEmployee(sc);
                    break;
                case 2: 
                    list.displayAll();
                    break;
                case 3:
                    System.out.println("=== Total payroll ===");
                    System.out.println("So luong nhan vien: "+list.getListSize());
                    System.out.println(list.calculateTotalPayroll()+" VND.");
                    break;
                case 4:
                    list.findHighestPaid();
                    break;
                case 5: 
                    System.out.println("=== Delete Employee ===");
                    if (list.getListSize() == 0) {
                        System.out.println("Your manager list is null !");
                        break;
                    }
                    System.out.print("Please enter employee ID: ");
                    String deleteID = sc.nextLine();
                    boolean check = list.deleteEmployeeByID(deleteID);
                    if (!check) {
                        System.out.println("Khong tim thay nhan vien voi ID "+deleteID);
                        break;
                    }
                    System.out.println("Da xoa thanh cong nhan vien ID "+deleteID);
                    list.displayAll();
                    break;
                default:
                    System.out.println("Invalid choice !");
                    break;
            }
        }
    } 
    }

