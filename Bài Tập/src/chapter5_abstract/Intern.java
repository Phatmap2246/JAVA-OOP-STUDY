package chapter5_abstract;

import java.util.Scanner;

public class Intern extends Employee {
    private String university;

    public Intern(){
        super();
        this.university ="";
    }

    public Intern(String id, String name, double basseSalary, String university) {
        super(id, name, basseSalary);
        this.university = university;
    }

    public void inputInternEmployee(Scanner sc){
        System.out.println("=== Input Intern Employee ===");
        System.out.print("Please enter id: ");
        this.id = sc.nextLine();
        System.out.print("Please enter name: ");
        this.name = sc.nextLine();
        System.out.print("Please enter base salary: ");
        this.baseSalary = sc.nextDouble();
        System.out.print("Please enter university: ");
        this.university = sc.nextLine();
    }

    
    @Override 
    public double calculateTotalSalary(){
        return this.baseSalary;
    }
    public String getRole(){
        return "Intern";
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

}
