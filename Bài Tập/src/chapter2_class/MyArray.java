package chapter2_class;
import java.util.Scanner;
import java.util.Arrays;

public class MyArray {
    private int[] arr;
    private int size;

    // Constructors
    public MyArray() {
        this.arr = new int[0];
        this.size = 0;
    }

    public MyArray(int[] arr, int size) {
        this.size = size;
        this.arr = Arrays.copyOf(arr, size);
    }

    // 1. Nhập mảng ban đầu
    public void inputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements (size): ");
        this.size = sc.nextInt();
        this.arr = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            System.out.print("arr[" + i + "] = ");
            this.arr[i] = sc.nextInt();
        }
    }

    // 2. Duyệt (Xuất) mảng
    public void printArray() {
        if (this.size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.arr[i] + "  ");
        }
        System.out.println();
    }

    // 3. Thêm 1 phần tử vào cuối mảng (dùng Arrays.copyOf để nới rộng mảng)
    public void addElement(int newValue) {
        this.arr = Arrays.copyOf(this.arr, this.size + 1);
        this.arr[this.size] = newValue;
        this.size++;
    }

    // 4. Xóa phần tử tại vị trí index
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= this.size) return false;
        for (int i = index; i < this.size - 1; i++) {
            this.arr[i] = this.arr[i + 1]; // Dồn mảng sang trái
        }
        this.arr = Arrays.copyOf(this.arr, this.size - 1);
        this.size--;
        return true;
    }

    // 5. Sửa phần tử tại vị trí index
    public boolean updateByIndex(int index, int newValue) {
        if (index < 0 || index >= this.size) return false;
        this.arr[index] = newValue;
        return true;
    }

    // 6. Tìm kiếm giá trị (trả về vị trí đầu tiên tìm thấy, không thấy trả về -1)
    public int searchValue(int target) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == target) return i;
        }
        return -1;
    }

    // Getters & Setters
    public int getSize() { return this.size; }
    public int[] getArr() { return this.arr; }

    // Menu MyArray Class
    public static void arrayMenu() {
        Scanner sc = new Scanner(System.in);
        MyArray myArr = new MyArray();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to MyArray class menu !!!");
            System.out.println("Option 1: Input a new array.");
            System.out.println("Option 2: Traverse (Print) array.");
            System.out.println("Option 3: Add a new element.");
            System.out.println("Option 4: Update element (by index).");
            System.out.println("Option 5: Delete element (by index).");
            System.out.println("Option 6: Search element (by value).");
            System.out.println("Option 7: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    myArr.inputArray();
                    break;
                case 2:
                    myArr.printArray();
                    break;
                case 3:
                    System.out.print("Enter value to add: ");
                    int valAdd = sc.nextInt();
                    myArr.addElement(valAdd);
                    System.out.println("Added successfully!");
                    break;
                case 4:
                    System.out.print("Enter index to update: ");
                    int idxUp = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int valUp = sc.nextInt();
                    if (myArr.updateByIndex(idxUp, valUp)) {
                        System.out.println("Updated successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 5:
                    System.out.print("Enter index to delete: ");
                    int idxDel = sc.nextInt();
                    if (myArr.deleteByIndex(idxDel)) {
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 6:
                    System.out.print("Enter value to search: ");
                    int target = sc.nextInt();
                    int foundIdx = myArr.searchValue(target);
                    if (foundIdx != -1) {
                        System.out.println("Found value " + target + " at index: " + foundIdx);
                    } else {
                        System.out.println("Value not found in array!");
                    }
                    break;
                case 7:
                    System.out.println("Thanks and see you again.");
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}