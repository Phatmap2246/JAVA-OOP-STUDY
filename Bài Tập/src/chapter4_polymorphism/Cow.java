package chapter4_polymorphism;
import java.util.Random;

public class Cow extends Cattle {
    @Override 
    public void makeSound(){
        System.out.println("Moo Mooo");
    }

    @Override 
    public float createMilk(){
        Random rand = new Random();
        return rand.nextFloat() * 21; // Sữa từ 0 đến 20 lít
    }
}