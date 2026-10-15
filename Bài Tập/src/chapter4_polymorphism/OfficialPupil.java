package chapter4_polymorphism;
import chapter3_inheritance.Pupil;
import java.util.Scanner;

public class OfficialPupil extends Pupil{
    private int socialCredits;

    // Method

    public OfficialPupil(){
        super();
        this.socialCredits = 0;
    }
    @Override 
    public void input(Scanner sc){
        super.input(sc);
        System.out.print("Please enter official student social credits: ");
            this.socialCredits = sc.nextInt();
            sc.nextLine();
    }
    @Override 
    public void print(){
        super.print();
        System.out.println("Social credits: "+this.socialCredits);
        
    }
}
