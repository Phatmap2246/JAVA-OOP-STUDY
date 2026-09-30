package chapter2_class;
import java.util.Scanner;
import java.util.ArrayList;

public class Circle {
    private float radius;

    // Constructors
    public Circle() {
        this.radius = 0;
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    // Input & Print
    public void inputCircle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        System.out.print("Please enter radius: ");
        this.radius = sc.nextFloat();
        System.out.println("=========================");
    }

    public void printCircle() {
        System.out.println("=========================");
        System.out.println("Radius: " + this.radius);
        System.out.println("Circumference (Chu vi): " + this.getCircumference());
        System.out.println("Area (Dien tich): " + this.getArea());
        System.out.println("=========================");
    }

    // Calculations (Sử dụng hằng số Math.PI của Java)
    public float getCircumference() {
        return (float) (2 * Math.PI * this.radius);
    }

    public float getArea() {
        return (float) (Math.PI * this.radius * this.radius);
    }

    // Getter & Setter
    public float getRadius() { return this.radius; }
    public void setRadius(float radius) { this.radius = radius; }

    // Menu Circle Class
    public static void circleMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Circle> list = new ArrayList<>();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to Circle class menu !!!");
            System.out.println("Option 1: Create a new circle.");
            System.out.println("Option 2: Print all circles.");
            System.out.println("Option 3: Adjust circle radius (by index).");
            System.out.println("Option 4: Delete circle (by index).");
            System.out.println("Option 5: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    Circle c = new Circle();
                    c.inputCircle();
                    list.add(c);
                    System.out.println("Circle added successfully.");
                    break;
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any circle.");
                        break;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Circle #" + i + ":");
                        list.get(i).printCircle();
                    }
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any circle.");
                        break;
                    }
                    System.out.print("Enter index to adjust (0 to " + (list.size() - 1) + "): ");
                    int idxEdit = sc.nextInt();
                    if (idxEdit >= 0 && idxEdit < list.size()) {
                        list.get(idxEdit).inputCircle();
                        System.out.println("Adjusted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any circle.");
                        break;
                    }
                    System.out.print("Enter index to delete (0 to " + (list.size() - 1) + "): ");
                    int idxDel = sc.nextInt();
                    if (idxDel >= 0 && idxDel < list.size()) {
                        list.remove(idxDel);
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 5:
                    System.out.println("Thanks and see you again.");
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}