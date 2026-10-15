package chapter4_polymorphism;
import java.util.Scanner;

import chapter3_inheritance.Pupil;
public class TransferPupil extends Pupil {
    private String entryLevel;
    private String graduateSchool;
    private String trainingType;

    // Method

    public TransferPupil(){
        super();
        this.entryLevel = "";
        this.graduateSchool ="";
        this.trainingType = "";
    }
    @Override 
    public void input(Scanner sc){
        super.input(sc);
        System.out.print("Please enter transfer student Entry level: ");
            this.entryLevel = sc.nextLine();
        System.out.print("Please enter transfer student Graduate school: ");
            this.graduateSchool = sc.nextLine();
        System.out.print("Please enter transfer student Training type: ");
            this.trainingType = sc.nextLine();
    }
    @Override 
    public void print(){
        super.print();
        System.out.println("Entry level: "+this.entryLevel);
        System.out.println("Graduate school: "+this.graduateSchool);
        System.out.println("Training type: "+this.trainingType);
    }
}
