package chapter4_polymorphism;
import java.util.ArrayList;
import java.util.Arrays;
public abstract class Cattle {
    protected String cattleID;
    protected int cattleGender;
    protected int cattleFeeling;

    protected final ArrayList<String> genderList = new ArrayList<>(Arrays.asList("Male","Female"));

    //Constructors
    public Cattle(){
        this.cattleID = "";
        this.cattleGender = 0;
        this.cattleFeeling = 0;
    }
    
    public Cattle(String cattleID, int cattleGender){
        this.cattleID = cattleID;
        this.cattleGender =  cattleGender;
        if(!this.isValidGender()){
            System.out.println("[!] Invalid gender, Resetting to Male (0).");
            this.cattleGender = 0;
        }
    }

    private boolean isValidGender(){
        return this.cattleGender>=0 && this.cattleGender <=1;
    }

    public abstract void makeSound();
    public  abstract float createMilk();

}
