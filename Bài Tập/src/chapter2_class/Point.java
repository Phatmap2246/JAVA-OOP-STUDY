package chapter2_class;
import java.util.Scanner;
import java.util.ArrayList;

public class Point {
    private float x;
    private float y;

    // Constructors
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Input & Print
    public void inputPoint() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter x: ");
        this.x = sc.nextFloat();
        System.out.print("Please enter y: ");
        this.y = sc.nextFloat();
    }

    public void printPoint() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }

    // Move point (Di chuyển điểm thêm một khoảng dx, dy)
    public void movePoint(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    // Getters & Setters
    public float getX() { return this.x; }
    public float getY() { return this.y; }
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }

    // Menu Point Class
    public static void pointMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Point> list = new ArrayList<>();
        int subChoice = -1;

        while (true) {
            System.out.println("\n!!! Welcome to Point class menu !!!");
            System.out.println("Option 1: Create a new point.");
            System.out.println("Option 2: Print all points.");
            System.out.println("Option 3: Move a point (by index).");
            System.out.println("Option 4: Delete a point (by index).");
            System.out.println("Option 5: Back to the main menu.");
            System.out.print("Please enter your option: ");
            subChoice = sc.nextInt();
            sc.nextLine(); // Chống trôi lệnh

            switch (subChoice) {
                case 1:
                    Point p = new Point();
                    p.inputPoint();
                    list.add(p);
                    System.out.println("Point added successfully.");
                    break;
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any point.");
                        break;
                    }
                    System.out.println("Your points:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print("Index " + i + ": ");
                        list.get(i).printPoint();
                    }
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any point.");
                        break;
                    }
                    System.out.print("Enter point index to move (0 to " + (list.size() - 1) + "): ");
                    int idxMove = sc.nextInt();
                    if (idxMove >= 0 && idxMove < list.size()) {
                        System.out.print("Enter dx: ");
                        float dx = sc.nextFloat();
                        System.out.print("Enter dy: ");
                        float dy = sc.nextFloat();
                        list.get(idxMove).movePoint(dx, dy);
                        System.out.println("Moved successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("You don't have any point.");
                        break;
                    }
                    System.out.print("Enter point index to delete (0 to " + (list.size() - 1) + "): ");
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