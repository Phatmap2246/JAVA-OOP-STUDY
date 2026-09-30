package chapter2_class;
import java.util.Scanner;

public class MyString {
    private String str;

    // Constructors
    public MyString() {
        this.str = "";
    }

    public MyString(String str) {
        this.str = str;
    }

    // Input & Print
    public void inputString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        this.str = sc.nextLine();
    }

    public void printString() {
        System.out.println("Current string: \"" + this.str + "\"");
        System.out.println("Length: " + this.str.length());
    }

    // Chuẩn hóa chuỗi: Xóa khoảng trắng thừa + Viết hoa chữ cái đầu mỗi từ
    public void normalizeString() {
        if (this.str == null || this.str.trim().isEmpty()) {
            this.str = "";
            return;
        }
        // Bước 1: Xóa khoảng trắng 2 đầu và tách các từ dựa trên 1 hoặc nhiều khoảng trắng (\\s+)
        String[] words = this.str.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        // Bước 2: Viết hoa chữ cái đầu của từng từ rồi ghép lại
        for (String w : words) {
            if (w.length() > 0) {
                String capitalized = Character.toUpperCase(w.charAt(0)) + w.substring(1);
                result.append(capitalized).append(" ");
            }
        }
        this.str = result.toString().trim();
    }

    // Đếm số lượng từ trong chuỗi
    public int countWords() {
        if (this.str == null || this.str.trim().isEmpty()) return 0;
        String[] words = this.str.trim().split("\\s+");
        return words.length;
    }

    // Đảo ngược chuỗi
    public String getReversedString() {
        return new StringBuilder(this.str).reverse().toString();
    }

    // Getter & Setter
    public String getStr() { return this.str; }
    public void setStr(String str) { this.str = str; }

    // Menu MyString Class
    public static void stringMenu() {
        Scanner sc = new Scanner(System.in);
        MyString myStr = new MyString();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to MyString class menu !!!");
            System.out.println("Option 1: Input a string.");
            System.out.println("Option 2: Print string & length.");
            System.out.println("Option 3: Normalize string (Chuan hoa chuoi).");
            System.out.println("Option 4: Count words & Print reversed string.");
            System.out.println("Option 5: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    myStr.inputString();
                    break;
                case 2:
                    myStr.printString();
                    break;
                case 3:
                    myStr.normalizeString();
                    System.out.println("Normalized successfully!");
                    myStr.printString();
                    break;
                case 4:
                    System.out.println("Word count: " + myStr.countWords());
                    System.out.println("Reversed string: \"" + myStr.getReversedString() + "\"");
                    break;
                case 5:
                    System.out.println("Thanks and see you again.");
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}