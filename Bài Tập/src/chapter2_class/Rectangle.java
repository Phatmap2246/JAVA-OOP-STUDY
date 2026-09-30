package chapter2_class;
import java.util.Scanner;
import java.util.ArrayList;

public class Rectangle {
    private float length;
    private float width;

    // Constructors
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    // Input & Print
    public void inputRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        System.out.print("Please enter length: ");
        this.length = sc.nextFloat();
        System.out.print("Please enter width: ");
        this.width = sc.nextFloat();
        System.out.println("=========================");
    }

    public void printRectangle() {
        System.out.println("=========================");
        System.out.println("Length: " + this.length);
        System.out.println("Width: " + this.width);
        System.out.println("Perimeter (Chu vi): " + this.getPerimeter());
        System.out.println("Area (Dien tich): " + this.getArea());
        System.out.println("=========================");
    }

    // Calculations
    public float getPerimeter() {
        return (this.length + this.width) * 2.0f;
    }

    public float getArea() {
        return this.length * this.width;
    }

    // Getters & Setters
    public float getLength() { return this.length; }
    public float getWidth() { return this.width; }
    public void setLength(float length) { this.length = length; }
    public void setWidth(float width) { this.width = width; }

    // Menu Rectangle Class
    public static void rectangleMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Rectangle> list = new ArrayList<>();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to Rectangle class menu !!!");
            System.out.println("Option 1: Create a new rectangle.");
            System.out.println("Option 2: Print all rectangles (with Area & Perimeter).");
            System.out.println("Option 3: Adjust rectangle (by index).");
            System.out.println("Option 4: Delete rectangle (by index).");
            System.out.println("Option 5: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    Rectangle rect = new Rectangle();
                    rect.inputRectangle();
                    list.add(rect);
                    System.out.println("Rectangle added successfully.");
                    break;
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any rectangle.");
                        break;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Rectangle #" + i + ":");
                        list.get(i).printRectangle();
                    }
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any rectangle.");
                        break;
                    }
                    System.out.print("Enter index to adjust (0 to " + (list.size() - 1) + "): ");
                    int idxEdit = sc.nextInt();
                    if (idxEdit >= 0 && idxEdit < list.size()) {
                        list.get(idxEdit).inputRectangle();
                        System.out.println("Adjusted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any rectangle.");
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