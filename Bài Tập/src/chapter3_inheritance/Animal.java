package chapter3_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Animal {
    protected String animalID;
    protected String animalName;
    protected int animalAge;
    protected float animalWeight;
    protected int animalGender;

    protected static final ArrayList<String> genderList = 
        new ArrayList<>(Arrays.asList("Male", "Female"));

    // Constructors
    public Animal() {
        this.animalID = "";
        this.animalName = "";
        this.animalAge = 1;
        this.animalWeight = 0;
        this.animalGender = 0;
    }

    public Animal(String animalID, String animalName, int animalAge, 
                  float animalWeight, int animalGender) {
        this.animalID = animalID;
        this.animalName = animalName;

        this.animalAge = animalAge;
        if (!this.isValidAge()) {
            System.out.println("[!] Invalid Age! Resetting animal age to 1 (Default).");
            this.animalAge = 1;
        }

        this.animalWeight = animalWeight;
        if (!this.isValidWeight()) {
            System.out.println("[!] Invalid Weight! Resetting animal weight to 0 (Default).");
            this.animalWeight = 0;
        }

        this.animalGender = animalGender;
        if (!this.isValidGender()) {
            System.out.println("[!] Invalid Gender! Resetting animal gender to 0 - [Male] (Default).");
            this.animalGender = 0;   // SỬA: trước đây gán nhầm animalAge
        }
    }

    // Input & Print
    public void inputAnimal(Scanner sc) {           // SỬA: nhận Scanner từ ngoài
        System.out.print("Please enter animal ID: ");   // SỬA: print thay vì println
        this.animalID = sc.nextLine();

        System.out.print("Please enter animal name: ");
        this.animalName = sc.nextLine();

        while (true) {
            System.out.print("Please enter animal age (Years): ");
            this.animalAge = sc.nextInt();
            sc.nextLine();                          // SỬA: hấp thụ ký tự xuống dòng
            if (this.isValidAge()) {
                break;
            }
            System.out.println("[!] Invalid Age! Please enter animal age again.");
        }

        while (true) {
            System.out.print("Please enter animal weight (kg): ");
            this.animalWeight = sc.nextFloat();
            sc.nextLine();                          // SỬA: hấp thụ ký tự xuống dòng
            if (this.isValidWeight()) {
                break;
            }
            System.out.println("[!] Invalid Weight! Please enter animal weight again.");
        }

        while (true) {
            System.out.println("Animal Genders: ");
            for (int i = 0; i < genderList.size(); i++) {
                System.out.print(i + ". " + genderList.get(i) + ", ");
            }
            System.out.print("\nPlease enter animal Gender: ");
            this.animalGender = sc.nextInt();
            sc.nextLine();                          // SỬA: hấp thụ ký tự xuống dòng
            if (this.isValidGender()) {
                break;
            }
            System.out.println("[!] Invalid Gender! Please enter animal gender again.");
        }
    }

    public void printAnimal() {
        System.out.println("Animal ID: " + this.animalID);
        System.out.println("Animal Name: " + this.animalName);
        System.out.println("Animal Age: " + this.animalAge + " Years");
        System.out.println("Animal Weight: " + this.animalWeight + " kg");
        System.out.println("Animal Gender: " + this.getGenderName());
    }

    public boolean isValidAge() {
        return (this.animalAge > 0 && this.animalAge < 500);
    }

    public boolean isValidWeight() {
        return (this.animalWeight > 0);
    }

    public boolean isValidGender() {
        return (this.animalGender == 0 || this.animalGender == 1);
    }

    // Setter & Getter
    // Get
    public String getAnimalNameString() {
        return this.animalName;
    }

    public String getAnimalIDString() {
        return this.animalID;
    }

    public int getAnimalAgeInt() {
        return this.animalAge;
    }

    public float getAnimalWeightFloat() {
        return this.animalWeight;
    }

    public int getAnimalGenderInt() {
        return this.animalGender;
    }

    public String getGenderName() {
        return genderList.get(this.animalGender);
    }

    // Set
    public void setAnimalName(String newAnimalName) {
        this.animalName = newAnimalName;
    }

    public void setAnimalID(String newAnimalID) {
        this.animalID = newAnimalID;
    }

    public void setAnimalAge(int newAnimalAge) {
        int oldAge = this.animalAge;
        this.animalAge = newAnimalAge;
        if (!this.isValidAge()) {
            System.out.println("[!] Update Animal Age Failed! Resetting animal age to the old age.");
            this.animalAge = oldAge;
        }
    }

    // SỬA: tham số đổi từ int sang float
    public void setAnimalWeight(float newAnimalWeight) {
        float oldWeight = this.animalWeight;
        this.animalWeight = newAnimalWeight;    // SỬA: gán đúng thuộc tính
        if (!this.isValidWeight()) {
            System.out.println("[!] Update Animal Weight Failed! Resetting animal weight to the old weight.");
            this.animalWeight = oldWeight;
        }
    }

    public void setAnimalGender(int newAnimalGender) {
        int oldGender = this.animalGender;
        this.animalGender = newAnimalGender;
        if (!this.isValidGender()) {           // SỬA: kiểm tra gender, không phải age
            System.out.println("[!] Update Animal Gender Failed! Resetting animal gender to the old gender. (" 
                             + this.getGenderName() + ")");
            this.animalGender = oldGender;
        }
    }

    // Bonus
    public abstract void makeSound();
}