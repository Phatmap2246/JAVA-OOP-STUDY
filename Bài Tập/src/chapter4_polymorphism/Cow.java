package chapter4_polymorphism;
import java.util.Random;
public class Cow extends Cattle {
    @Override 
    public void makeSound(){
        System.out.println("Moo Mooo");
    }

    @Override 
    public float createMilk(){
        if(this.getCattleGender() == 0)return 0;
        Random rand = new Random();
        return rand.nextFloat(21);
    }
}
