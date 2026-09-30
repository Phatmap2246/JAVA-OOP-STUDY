package chapter3_inheritance;


import java.util.Scanner;
public class Person {
    protected String fullName;
    protected MyDate birthDate;
    protected int gender;
    protected Address address;

    //Constructors
    public Person(){
        this.fullName ="";
        this.birthDate = new MyDate();
        this.gender = -1;
        this.address = new Address();
    }

    public Person(String fullName, MyDate birthDate, int gender, Address address){
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    private boolean isValidGender(){
        return (this.gender == 0 || this.gender == 1);
    }

    public void inputPerson(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter full name: ");
        this.fullName = sc.nextLine();
        
        this.birthDate.inputDate();

        while (true) {
            System.out.println("Please enter gender (1 for Male, 0 for Female): ");
            this.gender = sc.nextInt();
            if (this.isValidGender()) {
                break;
            }
            System.out.println("[!] Invalid gender! Please your gender again.");
        }

        this.address.inputAddress();
    }

    public void printPersonInformation(){
        System.out.println("=================================");
        System.out.println("Full name: "+this.fullName);
        System.out.println("Birthdate: "+this.birthDate.getDate());
        System.out.println("Gender: "+this.getGenderName());
        System.out.println("Address: "+this.address.getFullAddress());
    }

    // Get

    public String getFullName(){
        return this.fullName;
    }

    public MyDate getBirthDate(){
        return this.birthDate;
    }
    public int getAge(){
        return  this.birthDate.getAge();
    }

    public int getGender(){
        return this.gender;
    }
    public String getGenderName(){
        return this.gender == 0 ? "Female" : "Male";
    }

    public Address getAddress(){
        return this.address;
    }

    // Set

    public void setFullName(String newFullName){
        this.fullName = newFullName;
    }

    public void setGender( int newGender){
        int oldGender = this.gender;
        this.gender = newGender;
        if (!this.isValidGender()) {
            System.out.print("[!] Update gender failed! Invalid gender.");
            this.gender = oldGender;
        }
    }


}
