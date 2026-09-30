package chapter2_class;
import java.util.Scanner;
import java.util.ArrayList;

public class Fraction {
    private int numerator;   // Tử số
    private int denominator; // Mẫu số

    // Constructors
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1; // Mẫu số mặc định phải khác 0
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = (denominator == 0) ? 1 : denominator;
        this.simplify();
    }

    // Input & Print
    public void inputFraction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter numerator (Tu so): ");
        this.numerator = sc.nextInt();
        do {
            System.out.print("Please enter denominator (Mau so != 0): ");
            this.denominator = sc.nextInt();
            if (this.denominator == 0) {
                System.out.println("Denominator cannot be 0! Try again.");
            }
        } while (this.denominator == 0);
        this.simplify(); // Tự động rút gọn sau khi nhập
    }

    public void printFraction() {
        if (this.denominator == 1) {
            System.out.println(this.numerator);
        } else if (this.numerator == 0) {
            System.out.println(0);
        } else {
            System.out.println(this.numerator + "/" + this.denominator);
        }
    }

    // Hàm tìm Ước chung lớn nhất (GCD) để rút gọn phân số
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void simplify() {
        int common = gcd(this.numerator, this.denominator);
        this.numerator /= common;
        this.denominator /= common;
        // Đẩy dấu trừ lên tử số nếu mẫu số bị âm
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    // Cộng 2 phân số
    public Fraction add(Fraction other) {
        int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    // Getters & Setters
    public int getNumerator() { return this.numerator; }
    public int getDenominator() { return this.denominator; }
    public void setNumerator(int numerator) { this.numerator = numerator; }
    public void setDenominator(int denominator) {
        if (denominator != 0) this.denominator = denominator;
    }

    // Menu Fraction Class
    public static void fractionMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Fraction> list = new ArrayList<>();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to Fraction class menu !!!");
            System.out.println("Option 1: Create a new fraction.");
            System.out.println("Option 2: Print all fractions.");
            System.out.println("Option 3: Sum all fractions in list.");
            System.out.println("Option 4: Delete a fraction (by index).");
            System.out.println("Option 5: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    Fraction f = new Fraction();
                    f.inputFraction();
                    list.add(f);
                    System.out.println("Fraction added and simplified successfully.");
                    break;
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any fraction.");
                        break;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print("Fraction #" + i + ": ");
                        list.get(i).printFraction();
                    }
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any fraction.");
                        break;
                    }
                    Fraction sum = new Fraction(0, 1);
                    for (Fraction item : list) {
                        sum = sum.add(item);
                    }
                    System.out.print("Total Sum = ");
                    sum.printFraction();
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any fraction.");
                        break;
                    }
                    System.out.print("Enter index to delete: ");
                    int idxDel = sc.nextInt();
                    if (idxDel >= 0 && idxDel < list.size()) {
                        list.remove(idxDel);
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
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