package chapter3_inheritance;

import java.util.Scanner;
import java.time.LocalDate;

public class MyDate {
    private int day;
    private int month;
    private int year;
    private static int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Constructors
    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        if (!this.isValidDate()) {
            System.out.println("[!] Invalid date! Resetting to default 01/01/2000.");
            this.day = 1;
            this.month = 1;
            this.year = 2000;
        }
    }

    private boolean isLeapYear() {
        return (this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0));
    }

    private boolean isValidDate() {
        if (this.year < 1900 || this.year > LocalDate.now().getYear()) {
            return false;
        }
        if (this.month < 1 || this.month > 12) {
            return false;
        }
        // SỬA: dùng biến cục bộ thay vì sửa trực tiếp mảng static
        int maxDayOfMonth = maxDays[this.month - 1];
        if (this.month == 2 && this.isLeapYear()) {
            maxDayOfMonth = 29;
        }
        return this.day > 0 && this.day <= maxDayOfMonth;
    }

    // SỬA: nhận Scanner từ ngoài
    public void inputDate(Scanner sc) {
        while (true) {
            System.out.print("Please enter your Day: ");
            this.day = sc.nextInt();
            System.out.print("Please enter your Month: ");
            this.month = sc.nextInt();
            System.out.print("Please enter your Year: ");
            this.year = sc.nextInt();
            sc.nextLine();                      // hấp thụ ký tự xuống dòng

            if (this.isValidDate()) {
                break;
            }
            System.out.println("[!] Invalid date! Please enter a real date again.");
        }
    }

    public void printDate() {
        String d = (this.day < 10 ? "0" : "") + this.day;
        String m = (this.month < 10 ? "0" : "") + this.month;
        System.out.println(d + "/" + m + "/" + this.year);
    }

    // Getter
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    // SỬA: dùng this.month thay vì this.day cho phần tháng
    public String getDate() {
        String d = (this.day < 10 ? "0" : "") + this.day;
        String m = (this.month < 10 ? "0" : "") + this.month;
        return d + "/" + m + "/" + this.year;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - this.year;
        if (today.getMonthValue() < this.month 
            || (today.getMonthValue() == this.month && today.getDayOfMonth() < this.day)) {
            age -= 1;
        }
        return age;
    }

    // Setter
    public void setDay(int newDay) {
        int oldDay = this.day;
        this.day = newDay;
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalid date.");
            this.day = oldDay;
        }
    }

    public void setMonth(int newMonth) {
        int oldMonth = this.month;
        this.month = newMonth;
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalid date.");
            this.month = oldMonth;
        }
    }

    public void setYear(int newYear) {
        int oldYear = this.year;
        this.year = newYear;
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalid date.");
            this.year = oldYear;
        }
    }

    // SỬA: gán giá trị mới TRƯỚC khi validate
    public void setDate(int newDay, int newMonth, int newYear) {
        int oldDay = this.day;
        int oldMonth = this.month;
        int oldYear = this.year;
        
        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;
        
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalid date.");
            this.day = oldDay;
            this.month = oldMonth;
            this.year = oldYear;
        }
    }
}