package chapter8_exception;

public class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        if (gpa <0 || gpa > 4.0) {
            throw new IllegalArgumentException("Điểm GPA phải nằm trong khoảng 0.0 đến 4.0");
        }
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override 
    public String toString(){
        return "ID: " + id + " | Tên: " + name + " | GPA: " + gpa;
    }
    
}
