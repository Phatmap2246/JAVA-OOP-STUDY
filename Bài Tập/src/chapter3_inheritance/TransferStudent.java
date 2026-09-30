package chapter3_inheritance;
import java.util.Scanner;

import chapter2_class.Student;

public class TransferStudent extends Student{
    private String entryLevel;
    private String graduateSchool;
    private String trainingType;

    // Method

    public TransferStudent(){
        super();
        this.entryLevel = "";
        this.graduateSchool ="";
        this.trainingType = "";
    }

    public TransferStudent(String ID, String Name, String Class, String HomeAddress, String Street, String Quarter, String Ward, String City, String Country, float sub1, float sub2, float sub3, String entryLevel, String graduateSchool, String trainingType){
        super(ID,Name,Class,HomeAddress,Street,Quarter,Ward,City,Country,sub1,sub2,sub3);
        this.entryLevel = entryLevel;
        this.graduateSchool = graduateSchool;
        this.trainingType = trainingType;
    }

    public void inputTransferStudent(){
        super.inputStudent();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter transfer student Entry level: ");
            this.entryLevel = sc.nextLine();
        System.out.print("Please enter transfer student Graduate school: ");
            this.graduateSchool = sc.nextLine();
        System.out.print("Please enter transfer student Training type: ");
            this.trainingType = sc.nextLine();
    }
    
    public void printTransferStudent(){
        super.printStudent();
        System.out.println("Entry level: "+this.entryLevel);
        System.out.println("Graduate school: "+this.graduateSchool);
        System.out.println("Training type: "+this.trainingType);
    }
}
