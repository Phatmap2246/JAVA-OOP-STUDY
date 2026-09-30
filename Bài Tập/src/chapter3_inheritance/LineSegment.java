package chapter3_inheritance;

import java.util.ArrayList;
import java.util.Scanner;

import chapter2_class.Point;

public class LineSegment {
    private Point point1;
    private Point point2;

    // Constructors

    public LineSegment(){
        this.point1 = new Point();
        this.point2 = new Point();
    }

    public LineSegment(Point point1, Point point2){
        this.point1 = point1;
        this.point2 = point2;
    }

    // Input & Print

    public void inputLine(){
        System.out.println("--- INPUT TWO POINTS ---");
        
        System.out.println("Point 1: ");
        this.point1.inputPoint();

        System.out.println("Point 2: ");
        this.point2.inputPoint();
    }

    public void printLine(){
        System.out.println("--- PRINT TWO POINTS ---");

        System.out.println("Point 1: ");
        this.point1.printPoint();

        System.out.println("Point 2: ");
        this.point2.printPoint();

        System.out.println("Distance: "+this.getDistance());
    }

    public double getDistance(){
        float x1 = this.point1.getX(), x2 = this.point2.getX(), y1 = this.point1.getY(), y2 = this.point2.getY();
        double distance = Math.sqrt((Math.pow((x1-x2),2)+Math.pow((y1-y2), 2)));
        return distance;
    }

    // menu
    public static void lineSegmentMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<LineSegment> lineList = new ArrayList<>(); 
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=================================");
            System.out.println("    LINE SEGMENT MANAGEMENT      ");
            System.out.println("=================================");
            System.out.println("1. Add a new Line Segment (Nhap them doan thang)");
            System.out.println("2. Display all Line Segments (Xem danh sach)");
            System.out.println("3. Find the longest Line Segment (Tim doan thang dai nhat)");
            System.out.println("0. Exit (Thoat)");
            System.out.print("Your choice: ");
            
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("\n[+] ADDING NEW LINE SEGMENT");
                    LineSegment newLine = new LineSegment();
                    newLine.inputLine(); 
                    lineList.add(newLine);
                    System.out.println("[+] Successfully added a new Line Segment!");
                    break;
                    
                case 2:
                    if (lineList.isEmpty()) {
                        System.out.println("[!] The list is currently empty!");
                    } else {
                        System.out.println("\n--- LIST OF ALL LINE SEGMENTS ---");
                        for (int i = 0; i < lineList.size(); i++) {
                            System.out.println("Line Segment #" + (i + 1));
                            lineList.get(i).printLine();
                            System.out.println("--------------------------");
                        }
                    }
                    break;
                    
                case 3:
                    if (lineList.isEmpty()) {
                        System.out.println("[!] The list is currently empty!");
                    } else {
                        System.out.println("\n--- THE LONGEST LINE SEGMENT ---");
                        LineSegment longestLine = lineList.get(0);
                        
                        // Quét mảng tìm đoạn thẳng có distance lớn nhất
                        for (LineSegment line : lineList) {
                            if (line.getDistance() > longestLine.getDistance()) {
                                longestLine = line;
                            }
                        }
                        
                        longestLine.printLine();
                    }
                    break;
                    
                case 0:
                    System.out.println("Exiting Line Segment Menu...");
                    break;
                    
                default:
                    System.out.println("[!] Invalid choice! Please select 0-3.");
            }
        }
    }
}
