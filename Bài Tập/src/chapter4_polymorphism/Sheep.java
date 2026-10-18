package chapter4_polymorphism;
import java.util.Random;

public class Sheep extends Cattle {
    @Override 
    public void makeSound(){
        System.out.println("Baat baat...");
    }
    
    @Override 
    public float createMilk(){
        Random rand = new Random();
        return rand.nextFloat() * 6; // Sữa từ 0 đến 5 lít
    }
}