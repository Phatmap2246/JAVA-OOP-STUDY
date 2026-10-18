package chapter4_polymorphism;
import java.util.Random;

public class Goat extends Cattle {
    @Override 
    public void makeSound(){
        System.out.println("Bee bee...");
    }
    
    @Override 
    public float createMilk(){
        Random rand = new Random();
        return rand.nextFloat() * 11; // Sữa từ 0 đến 10 lít
    }
}