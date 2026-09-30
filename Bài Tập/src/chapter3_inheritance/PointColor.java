package chapter3_inheritance;
import java.util.Scanner;

import chapter2_class.Point;

import java.util.ArrayList;
import java.util.Arrays;
public class PointColor extends Point{
    private  int color;
    public  ArrayList<String> sampleColor = new ArrayList<>(Arrays.asList(
    "White", "Black", "Red", "Green", "Blue", 
    "Yellow", "Orange", "Purple", "Pink", "Brown", 
    "Gray", "Cyan", "Magenta", "Gold", "Silver"
    ));
    //Method
    public PointColor(){
        super();
        this.color = -1;
    }
    public PointColor(float x, float y, int color){
        super(x,y);
        this.color = color;
    }

    // Input, Print
    public void inputColorPoint(){
        super.inputPoint();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("Sample colors: ");
            for(int i =1 ;i <=sampleColor.size();i++){
                System.out.println(i +" "+ sampleColor.get(i-1));
            }
            System.out.print("Please choose your point color: ");
                this.color = sc.nextInt();
            if (this.color >=1 && this.color <=sampleColor.size()) {
                break;
            }
            System.out.println("Please choose AGAIN your point color !!! ");
        }
        System.out.println("Add your point color successfully !");
        System.out.println("=============================");
    }
    public void printColorPoint(){
        System.out.println("================================");
        super.printPoint();
        System.out.println("Color: "+sampleColor.get(this.color-1));
    }
    // Setter/ Getter
    public int getColorPoint(){
        return this.color;
    }
    public String getColorName(){
        return sampleColor.get(this.color -1);
    }
    public void setColorPoint(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("Sample colors: ");
            for(int i =1 ;i <=sampleColor.size();i++){
                System.out.println(i +" "+ sampleColor.get(i-1));
            }
            System.out.print("Please choose your point color: ");
                this.color = sc.nextInt();
            if (this.color >=1 && this.color <=sampleColor.size()) {
                break;
            }
            System.out.println("Please choose AGAIN your point color !!! ");
        }
        System.out.println("Adjusted your point color successfully !");
        System.out.println("=============================");
    }
    public static void PointColorMenu(){
        int subChoice = -1;
        Scanner sc = new Scanner(System.in);
        ArrayList<PointColor> list = new ArrayList<>();
        while (true) {
            System.out.println("!!! Welcom to Point Color menu !!!");
            System.out.println("Option 1: Create a new color point.");
            System.out.println("Option 2: Print all your color point.");
            System.out.println("Option 3: Adjust your point's color. (By point ordinal number)");
            System.out.println("Option 4: Delete your color point. (By point ordinal number)");
            System.out.println("Option 5: Back the main menu.");
            System.out.print("Please enter your option: ");
                subChoice = sc.nextInt();
            switch (subChoice) {
                case 1:
                    PointColor p = new PointColor();
                    p.inputColorPoint();
                    list.add(p);
                    System.out.println("Add your color point successfully");
                    break;
                
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any color point !");
                        break;
                    }
                    System.out.println("Your color points: ");
                    for(PointColor c : list){
                        c.printColorPoint();
                    }    
                    break;
                case 3: 
                    if (list.isEmpty()) {
                        System.out.println("You don't have any color point !");
                        break;
                    }
                    int ordinalNumber = -1;
                    while (true) {
                        System.out.println("=============================");
                        System.out.print("Please enter your point ordinal number: ");
                            ordinalNumber = sc.nextInt();
                        if (ordinalNumber>=0 && ordinalNumber <list.size()) {
                            break;
                        }
                        System.out.println("Please enter your point ordinal number AGAIN.");
                    }
                    list.get(ordinalNumber).setColorPoint();
                    break;
                case 4: 
                    if (list.isEmpty()) {
                        System.out.println("You don't have any color point !");
                        break;
                    }
                    int ordinalDelete = -1;
                    while (true) {
                        System.out.println("=============================");
                        System.out.print("Please enter your point ordinal number: ");
                            ordinalDelete = sc.nextInt();
                        if (ordinalDelete>=0 && ordinalDelete <list.size()) {
                            break;
                        }
                        System.out.println("Please enter your point ordinal number AGAIN.");
                    }
                    list.remove(ordinalDelete);
                    System.out.println("Delete your color point successfully.");
                    break;
                case 5: 
                    System.out.println("Thank you and see you again.");
                    return;
                default:
                    break;
            }
        }
            
        
    }
}


