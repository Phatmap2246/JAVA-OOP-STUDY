package chapter5_abstract;
import java.util.Scanner;
public class FullTimeEmployee extends Employee{
    private double bonus;
    private double penalty;

    
    public FullTimeEmployee() {
        super();
        this.bonus = 0;
        this.penalty = 0;
    }
    public FullTimeEmployee(String id, String name, double baseSalary, double bonus, double penalty) {
        super(id, name, baseSalary);
        this.bonus = bonus;
        this.penalty = penalty;
    }
    public void inputFullTimeEmployee(Scanner sc){
        System.out.println("=== Input Full Time Employee ===");
        System.out.print("Please enter id: ");
        this.id = sc.nextLine();
        System.out.print("Please enter name: ");
        this.name = sc.nextLine();
        System.out.print("Please enter base salary: ");
        this.baseSalary = sc.nextDouble();
        System.out.print("Please enter bonus: ");
        this.bonus = sc.nextDouble();
        System.out.print("Please enter penalty: ");
        this.penalty = sc.nextDouble();
    }

    @Override 
    public double calculateTotalSalary(){
        return this.baseSalary + this.bonus - this.penalty;
    }
    @Override 
    public String getRole(){
        return "Full Time";
    }

    public double getBonus() {
        return bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
    
    
    
}