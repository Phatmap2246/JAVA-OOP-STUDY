package chapter4_polymorphism;
import java.util.Random;
public class Sheep extends Cattle {
    @Override 
    public void makeSound(){
        System.out.println("Baat baat...");
    }
    @Override 
    public float createMilk(){
        if (this.getCattleGender()==0) return 0;
        Random rand = new Random();
        return rand.nextFloat(6);
    }
    
}
