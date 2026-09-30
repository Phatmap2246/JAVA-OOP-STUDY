package chapter1_begin;
import java.util.Scanner;

public class Bai1{
    public static String printname(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your name: ");
        String name = sc.nextLine();
        sc.close();
        return name;
    }
    public static Boolean isPrime(int a){
        if (a == 2 || a == 3) {
            return true;
        }
        if (a<2 || a%2==0 || a%3==0 ) {
            return false;
        }
        for(int i = 5; i*i <= a; i+=6 ){
                if(a%i==0) return false;
        }
        return true;
        
    }
}

