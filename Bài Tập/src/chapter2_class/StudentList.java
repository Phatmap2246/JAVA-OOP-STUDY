package chapter2_class;
import java.util.Scanner;
import java.util.Arrays;

public class StudentList {
    private Student[] list; // Thuộc tính mảng sinh viên
    private int count;      // Thuộc tính sĩ số

    // Constructors
    public StudentList() {
        this.list = new Student[0];
        this.count = 0;
    }

    public StudentList(Student[] list, int count) {
        this.count = count;
        this.list = Arrays.copyOf(list, count);
    }

    // 1. Nhập 1 sinh viên mới vào danh sách
    public void addOneStudent() {
        Student newSv = new Student();
        newSv.inputStudent();
        this.list = Arrays.copyOf(this.list, this.count + 1);
        this.list[this.count] = newSv;
        this.count++;
        System.out.println("Added 1 student! Current class size (Si so): " + this.count);
    }

    // 2. In toàn bộ danh sách sinh viên kèm sĩ số
    public void printStudentList() {
        if (this.count == 0) {
            System.out.println("The student list is currently empty (Si so = 0).");
            return;
        }
        System.out.println("=== STUDENT LIST (Total: " + this.count + " students) ===");
        for (int i = 0; i < this.count; i++) {
            this.list[i].printStudent();
            System.out.println("Average: " + this.list[i].getStudentAverage());
            System.out.print("Rank: ");
            this.list[i].rankingStudentV();
        }
    }

    // 3. Xóa 1 sinh viên theo Mã SV (ID)
    public boolean deleteStudentByID(String id) {
        int foundIndex = -1;
        for (int i = 0; i < this.count; i++) {
            if (this.list[i].getStudentID().equalsIgnoreCase(id)) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) return false;

        // Dồn mảng để xóa phần tử tại foundIndex
        for (int i = foundIndex; i < this.count - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.list = Arrays.copyOf(this.list, this.count - 1);
        this.count--;
        return true;
    }

    // 4. Tìm kiếm sinh viên theo Mã SV (ID)
    public Student searchStudentByID(String id) {
        for (int i = 0; i < this.count; i++) {
            if (this.list[i].getStudentID().equalsIgnoreCase(id)) {
                return this.list[i];
            }
        }
        return null;
    }

    // 5. Sửa thông tin sinh viên theo Mã SV (ID)
    public boolean updateStudentByID(String id) {
        Student target = searchStudentByID(id);
        if (target == null) return false;
        System.out.println("Enter new information for student ID " + id + ":");
        target.inputStudent();
        return true;
    }

    // Getters
    public int getCount() { return this.count; }
    public Student[] getList() { return this.list; }

    // Menu StudentList Class
    public static void studentListMenu() {
        Scanner sc = new Scanner(System.in);
        StudentList ds = new StudentList();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to StudentList (Bai 9) menu !!!");
            System.out.println("Option 1: Add a new student to list.");
            System.out.println("Option 2: Print all students & class size (Si so).");
            System.out.println("Option 3: Search a student (by ID).");
            System.out.println("Option 4: Update a student (by ID).");
            System.out.println("Option 5: Delete a student (by ID).");
            System.out.println("Option 6: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine(); // Chống trôi lệnh

            switch (subChoice) {
                case 1:
                    ds.addOneStudent();
                    break;
                case 2:
                    ds.printStudentList();
                    break;
                case 3:
                    System.out.print("Enter student ID to search: ");
                    String searchID = sc.nextLine();
                    Student found = ds.searchStudentByID(searchID);
                    if (found != null) {
                        System.out.println("Student found:");
                        found.printStudent();
                    } else {
                        System.out.println("No student found with ID: " + searchID);
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID to update: ");
                    String updateID = sc.nextLine();
                    if (ds.updateStudentByID(updateID)) {
                        System.out.println("Updated successfully!");
                    } else {
                        System.out.println("No student found with ID: " + updateID);
                    }
                    break;
                case 5:
                    System.out.print("Enter student ID to delete: ");
                    String delID = sc.nextLine();
                    if (ds.deleteStudentByID(delID)) {
                        System.out.println("Deleted! Remaining class size (Si so): " + ds.getCount());
                    } else {
                        System.out.println("No student found with ID: " + delID);
                    }
                    break;
                case 6:
                    System.out.println("Thanks and see you again.");
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}