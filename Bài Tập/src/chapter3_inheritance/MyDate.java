package chapter3_inheritance;
import java.util.Scanner;
import java.time.LocalDate;
public class MyDate {
    private int day;
    private int month;
    private int year;
    private  static int[] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    // Constructors
    public MyDate(){
        this.day= 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        if (!this.isValidDate()) {
            System.out.println("[!] Invalid date! Resetting to default 01/01/2000. ");
            this.day = 1;
            this.month = 1;
            this.year = 2000;
        }
    }
    
    private boolean isLeapYear(){
        if (this.year%400 == 0 || (this.year%4==0 && this.year%100 !=0)) return true;
        return false;
    }

    private boolean isValidDate(){
        if (this.year <1900 || this.year > LocalDate.now().getYear()) {
            return false;
        }
        if (this.month < 1 || this.month > 12) {
            return false;
        }
        if (this.isLeapYear()) {
           maxDays[1] = 29; // max day of february is 29
        }
        return this.day > 0 && this.day <= maxDays[this.month -1];
    }

    public void inputDate(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter your Day: ");
            this.day = sc.nextInt();
            System.out.print("Please enter your Month: ");
            this.month = sc.nextInt();
            System.out.print("Please enter your Year: ");
            this.year = sc.nextInt();

            if (this.isValidDate()) {
                break;
            }
            System.out.println("[!] Invalid date! Please enter a real date again. ");
        }
    }

    public void printDate(){
        String d = (this.day < 10 ? "0":"")+this.day;
        String m = (this.month < 10 ?  "0":"")+this.month;
        System.out.println(d+"/"+m+"/"+this.year);
    }

    // setter, getter
    // Get
    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return  this.year;
    }

    public String getDate(){
        String d = (this.day < 10 ? "0":"")+this.day;
        String m = (this.month < 10 ?  "0":"")+this.day;
        return d+"/"+m+"/"+this.year;
    }

    public int getAge(){
        LocalDate today = LocalDate.now();
        int age = today.getYear() - this.year;
        if (today.getMonthValue() < this.month || (today.getMonthValue() == this.month && today.getDayOfMonth()<this.day)) {
            age -=1;
        }
        return age;
    }
    //Set
    public void setDay(int newDay){
        int oldDay = this.day;
        this.day = newDay;
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalied date.");
            this.day = oldDay;
        }
    }  

    public void setMonth(int newMonth){
        int oldMonth = this.month;
        this.month = newMonth;
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalied date.");
            this.month = oldMonth;
        }
    }

    public void setYear(int newYear){
        int oldYear = this.year;
        this.year = newYear;
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalied date.");
            this.year = oldYear;
        }
    }

    public void setDate(int newDay, int newMonth, int newYear){
        int oldDay = this.day;
        int oldMonth = this.month;
        int oldYear = this.year;
        if (!this.isValidDate()) {
            System.out.println("[!] Update failed! Invalied date.");
            this.day = oldDay;
            this.month = oldMonth;
            this.year = oldYear;
        }
    }
}
