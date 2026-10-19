package chapter5_abstract;
import java.util.Scanner;
import java.util.ArrayList;
public class EmployeeManager {
    private ArrayList<Employee> managerList;

    public EmployeeManager() {
        this.managerList = new ArrayList<Employee>();
    }

    public void addEmployee(Scanner sc){
        int choice =0;
            System.out.println("=== Add Employee ===");
            System.out.println("1. Fulltime. ");
            System.out.println("2. Parttime. ");
            System.out.println("3. Intern. ");
            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    FullTimeEmployee ft = new FullTimeEmployee();
                    ft.inputFullTimeEmployee(sc);
                    this.managerList.add(ft);
                    break;
                case 2:
                    PartTimeEmployee pt = new PartTimeEmployee();
                    pt.inputPartTimeEmployee(sc);
                    this.managerList.add(pt);
                    break;
                case 3:
                    Intern it = new Intern();
                    it.inputInternEmployee(sc);
                    this.managerList.add(it);
                    break;
                default:
                    System.out.println("Invalid Choice !");
                    break;
        }
    }
    
    private int findEmployeeByID(String findID){
        for(int i = 0 ;i<this.managerList.size();i++){
            if (this.managerList.get(i).getId().equals(findID)) {
                return i;
            }
        }
        return -1;
    }

    public void displayAll(){
        if (this.managerList.isEmpty()) {
            System.out.println("Your manager list is null !");
            return;
        }
        for(Employee e : this.managerList){
            e.displayInfo();
        }
        System.out.println("Total employee: "+this.managerList.size());
    }
    
    public double calculateTotalPayroll(){
        if (this.managerList.isEmpty()) {
            System.out.println("Your manager is null !");
            return 0;
        }
        double totalPayroll = 0;
        for(Employee e : this.managerList){
            totalPayroll += e.calculateTotalSalary();
        }
        return  totalPayroll;
    }
    public void findHighestPaid(){
        if (this.managerList.isEmpty()) {
            System.out.println("Your manager list is null!");
            return;
        }
        double highestPaid = -1;
        for(Employee e : this.managerList){
            if (e.calculateTotalSalary() > highestPaid ) {
                highestPaid = e.calculateTotalSalary();
            }
        }
        System.out.println("=== The highest paid ===");
        for(Employee e : this.managerList){
            if (e.calculateTotalSalary() == highestPaid) {
                e.displayInfo();
                System.out.println("================");
            }
        }
    }

    public boolean deleteEmployeeByID(String deleteID){
        int deleteIndex = this.findEmployeeByID(deleteID);
        if (deleteIndex != -1) {
            this.managerList.remove(deleteIndex);
            return true;
        }
        return false;
    }

    public int getListSize(){
        return this.managerList.size();
    }
}
