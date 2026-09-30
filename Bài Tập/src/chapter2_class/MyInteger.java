package chapter2_class;
import java.util.Scanner;

public class MyInteger {
    private int value;

    // Constructors
    public MyInteger() {
        this.value = 0;
    }

    public MyInteger(int value) {
        this.value = value;
    }

    // Input & Print
    public void inputInteger() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        this.value = sc.nextInt();
    }

    public void printInteger() {
        System.out.println("Current integer value: " + this.value);
    }

    // Check Prime (Kiểm tra số nguyên tố)
    public boolean isPrime() {
        if (this.value < 2) return false;
        for (int i = 2; i <= Math.sqrt(this.value); i++) {
            if (this.value % i == 0) return false;
        }
        return true;
    }

    // Check Even (Kiểm tra chẵn lẻ)
    public boolean isEven() {
        return this.value % 2 == 0;
    }

    // Sum of digits (Tính tổng các chữ số)
    public int sumDigits() {
        int temp = Math.abs(this.value);
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    // Getter & Setter
    public int getValue() { return this.value; }
    public void setValue(int value) { this.value = value; }

    // Menu MyInteger Class
    public static void integerMenu() {
        Scanner sc = new Scanner(System.in);
        MyInteger myInt = new MyInteger();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to MyInteger class menu !!!");
            System.out.println("Option 1: Input integer value.");
            System.out.println("Option 2: Print integer & its properties.");
            System.out.println("Option 3: Check Prime number.");
            System.out.println("Option 4: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    myInt.inputInteger();
                    System.out.println("Input successfully!");
                    break;
                case 2:
                    myInt.printInteger();
                    System.out.println("- Is Even: " + (myInt.isEven() ? "Yes (So chan)" : "No (So le)"));
                    System.out.println("- Sum of digits: " + myInt.sumDigits());
                    break;
                case 3:
                    if (myInt.isPrime()) {
                        System.out.println(myInt.getValue() + " is a PRIME number (So nguyen to).");
                    } else {
                        System.out.println(myInt.getValue() + " is NOT a prime number.");
                    }
                    break;
                case 4:
                    System.out.println("Thanks and see you again.");
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}