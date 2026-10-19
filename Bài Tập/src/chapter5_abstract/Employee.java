package chapter5_abstract;

public abstract class Employee {
    protected String id;
    protected String name;
    protected double baseSalary;
    
    public Employee() {
        this.id = "";
        this.name="";
        this.baseSalary = 1;
    }

    public Employee(String id, String name, double basseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = basseSalary;
    }
    
    public abstract double calculateTotalSalary();
    public abstract String getRole();

    public void displayInfo(){
        System.out.println("=== Employee Info ===");
        System.out.println("ID: "+this.id);
        System.out.println("Name: "+this.name);
        System.out.println("Base Salary: "+this.baseSalary);
        System.out.println("Role: "+this.getRole());
        System.out.println("Total Salary: "+this.calculateTotalSalary());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
}
