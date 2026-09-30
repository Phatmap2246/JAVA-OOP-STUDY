package chapter3_inheritance;

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
}
