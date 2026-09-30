package chapter2_class;
import java.util.Scanner;

import chapter3_inheritance.Address;

import java.util.ArrayList;

public class Student {
    private String studentID;
    private String studentName;
    private String studentClass;
    private Address studentAddress;
    private float sub1Score;
    private float sub2Score;
    private float sub3Score;
    public static String school = "DHSG";
    private static int countStudent = 0;

    // Method
    public Student(){
        this.studentID = "";
        this.studentName = "";
        this.studentClass = "";
        this.studentAddress = new Address();
        this.sub1Score = 0;
        this.sub2Score = 0;
        this.sub3Score = 0;
        countStudent++;
    }

    public Student(String ID, String Name, String Class,String HomeAddress, String Street, String Quarter, String Ward, String City, String Country,float sub1, float sub2, float sub3){
        this.studentID = ID;
        this.studentName = Name;
        this.studentClass = Class;
        this.studentAddress = new Address(HomeAddress, Street,Quarter, Ward, City, Country);
        this.sub1Score = sub1;
        this.sub2Score = sub2;
        this.sub3Score = sub3;
        countStudent++;
    }

    // Function

    public void inputStudent(){
        System.out.println("=========================");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter ID: ");
            this.studentID = sc.nextLine();
        System.out.print("Please input Name: ");
            this.studentName = sc.nextLine();
        System.out.print("Please press Class: ");
            this.studentClass = sc.nextLine();
        this.studentAddress.inputAddress();
        System.out.print("Please press Subject 1 score: ");
            this.sub1Score = sc.nextFloat();
        System.out.print("Please press Subject 2 score: ");
            this.sub2Score = sc.nextFloat();
        System.out.print("Please press Subject 3 score: ");
            this.sub3Score = sc.nextFloat();
        System.out.println("=========================");
    }

    public void printStudent(){
        System.out.println("=========================");
        System.out.println("Student ID: "+this.studentID);
        System.out.println("Student Name: "+this.studentName);
        System.out.println("Student Class: "+this.studentClass);
        this.studentAddress.printAddress();
        System.out.println("Subject 1 score: "+this.sub1Score);
        System.out.println("Subject 2 score: "+this.sub2Score);
        System.out.println("Subject 3 score: "+this.sub3Score);
        System.out.println("School: "+school);
        System.out.println("=========================");
    }
    // Get

    public String getStudentID(){
        return this.studentID;
    }

    public String getStudentName(){
        return this.studentName;
    }
    public String getStudentClass(){
        return this.studentClass;
    }
    public float getStudentSub1Score(){
        return this.sub1Score;
    }
    public float getStudentSub2Score(){
        return this.sub2Score;
    }
    public float getStudentSub3Score(){
        return this.sub3Score;
    }

    // Set
    public void setStudentID(String ID){
        this.studentID = ID;
    }

    public void setStudentName(String Name){
        this.studentName = Name;
    }
    public void setStudentClass(String Class){
        this.studentClass = Class;
    }
    public void setStudentSub1Score(float Sub1){
        this.sub1Score = Sub1;
    }
    public void setStudentSub2Score(float Sub2){
        this.sub2Score = Sub2;
    }
    public void setStudentSub3Score(float Sub3){
        this.sub3Score = Sub3;
    }

    // Average
    public float getStudentAverage(){
        return (this.sub1Score+this.sub2Score+this.sub3Score)/3.0f;
    }

    // Ranking
    public  void rankingStudentV(){
        float avg = this.getStudentAverage();
        if (avg<5) {
            System.out.println("Low quality !");
        }
        else if (avg <8) {
            System.out.println("Normal quality !");
        }
        else{
            System.out.println("Good quality !");
        }
    }

    // menu student class
    public static void studentMenu(){
        System.out.println("!!! Welcome to Student class menu !!!");
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        int subChoice = -1;
        while (true) {
            System.out.println("!!! Welcome to Student class menu !!!");
            System.out.println("Option 1: Create a new student.");
            System.out.println("Option 2: Print all students.");
            System.out.println("Option 3: Adjust student's information (by ID)");
            System.out.println("Option 4: Delete student (by ID)");
            System.out.println("Option 5: Average students scores.");
            System.out.println("Option 6: Ranking student quality.");
            System.out.println("Option 7: Back the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            switch (subChoice) {
                case 1:
                    Student newStudent = new Student();
                    newStudent.inputStudent();
                    list.add(newStudent);
                    System.out.println("Student added successfully.");
                break;
                case 2: 
                    if (list.isEmpty()) {
                        System.out.println("You don't have any student.");
                        break;
                    }
                    System.out.println("Your students: ");
                    for(Student s : list){
                        s.printStudent();
                    }
                break;
                case 3: 
                    if (list.isEmpty()) {
                        System.out.println("You don't have any student.");
                        break;
                    }
                    System.out.print("Please Enter your student ID:");
                    String adjustID = sc.nextLine();
                    boolean Edited = false;
                    for(Student s : list){
                        if (s.getStudentID().equalsIgnoreCase(adjustID)) {
                            System.out.println("Please enter student's new information");
                            s.inputStudent();
                            Edited = true;
                            System.out.println("Adjusted successfully");
                            s.printStudent();
                            break;
                        }
                    }
                    if (!Edited) {
                       System.out.println("Your ID is not correct with any student. ");
                        break;
                    }
                case 4: 
                    if (list.isEmpty()) {
                        System.out.println("You don't have any student.");
                        break;
                    }
                    System.out.print("Please enter your student ID:");
                    String deleteID = sc.nextLine();
                    boolean deleted = false;
                    for(int i = 0; i<list.size();i++){
                        if (list.get(i).getStudentID().equalsIgnoreCase(deleteID)) {
                            deleted = true;
                            list.remove(i);
                            System.out.println("Deleted successfully");
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Your ID is not correct with any student.");
                        break;
                    }
                case 5: 
                    if (list.isEmpty()) {
                        System.out.println("You don't have any student.");
                        break;
                    }
                    for(Student s: list){
                        s.printStudent();
                        System.out.println("Average: "+s.getStudentAverage());
                    }
                    break;
                case 6: 
                    if (list.isEmpty()) {
                        System.out.println("You don't have any student.");
                        break;
                    }
                    for(Student s: list){
                        s.printStudent();
                        System.out.println("Student rank: ");
                        s.rankingStudentV();
                    }
                    break;
                case 7:
                    System.out.println("Thanks and see you again.");
                    Student.countStudent = 0;
                    return;
            
                default:
                    break;
            }

        }
    }
    

}
