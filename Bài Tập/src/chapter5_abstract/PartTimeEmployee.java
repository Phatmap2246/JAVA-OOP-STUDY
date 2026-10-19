package chapter5_abstract;

import java.util.Scanner;

public class PartTimeEmployee extends Employee {
    private int workingHours;

    public PartTimeEmployee(){
        super();
        this.workingHours =0;
    }

    public PartTimeEmployee(String id, String name, double basseSalary, int workingHours) {
        super(id, name, basseSalary);
        this.workingHours = workingHours;
    }
    
    public void inputPartTimeEmployee(Scanner sc){
        System.out.println("=== Input Part Time Employee ===");
        System.out.print("Please enter id: ");
        this.id = sc.nextLine();
        System.out.print("Please enter name: ");
        this.name = sc.nextLine();
        System.out.print("Please enter base salary: ");
        this.baseSalary = sc.nextDouble();
        System.out.print("Please enter working hours: ");
        this.workingHours = sc.nextInt();
    }


    @Override 
    public double calculateTotalSalary(){
        return this.baseSalary*this.workingHours;
    }
    @Override 
    public String getRole(){
        return "Part Time";
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
    
}
