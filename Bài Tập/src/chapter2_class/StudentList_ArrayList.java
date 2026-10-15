package chapter2_class;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentList_ArrayList {
    private ArrayList<Student> list;
    //constructor
    public StudentList_ArrayList(){
        this.list = new ArrayList<>();
    }

    public StudentList_ArrayList(Student student){
        this.list = new ArrayList<>();
        this.list.add(student);
    }

    public StudentList_ArrayList(ArrayList<Student> existingList){
        this.list = existingList == null ? new ArrayList<>() : new ArrayList<>(existingList);
    }

    // 1. Add a new student
    public void addOneStudent_ArrayList(Scanner sc){
        Student newStudent = new Student();
        newStudent.inputStudent(sc);
        this.list.add(newStudent);
        System.out.println("Added 1 student! Current class size: "+this.list.size());
    }

    // 2. Print all list
    public void printStudentList_ArrayList(){
        if (this.list.isEmpty()) {
            System.out.println("[!] The student list is currently empty");
            return;
        }
        System.out.println("=== STUDENT LIST ( Total: "+this.list.size()+" students) ===");
        for(Student s : this.list){
            s.printStudent();
            System.out.println("Average: "+s.getStudentAverage());
            System.out.println("Rank: ");
            s.rankingStudentV();
        }
    }

    // 3. Delete student by ID
    public boolean deleteStudentByID_ArrayList(String id){
        if (id == null) return false;
        int foundIndex = -1;
        for(int i = 0 ;i <this.list.size();i++){
            Student student = this.list.get(i);
            if (student != null && student.getStudentID() != null
                    && student.getStudentID().equalsIgnoreCase(id.trim())) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) return false;

        this.list.remove(foundIndex);
        return true;
    }

    // 4. Find student by ID
    public Student searchStudentByID_ArrayList(String id){
        if (id == null) return null;
        for (Student student : this.list) {
            if (student != null && student.getStudentID() != null
                    && student.getStudentID().equalsIgnoreCase(id.trim())) {
                return student;
            }
        }
        return null;
    }

    // 5. Update student's information by ID
    public boolean updateStudentByID_ArrayList(String id, Scanner sc) {
        Student target = searchStudentByID_ArrayList(id);
        if (target == null) {
            System.out.println("Student with ID " + id + " not found!");
            return false;
        }
        if (sc == null) return false;

        while (true) {
            System.out.println("\n========== UPDATE STUDENT MENU ==========");
            System.out.println("Current ID: " + target.getStudentID());
            System.out.println("1. Update Student ID");
            System.out.println("2. Update Student Name");
            System.out.println("3. Update Student Class");
            System.out.println("4. Update Student Address");
            System.out.println("5. Update Sub1 Score");
            System.out.println("6. Update Sub2 Score");
            System.out.println("7. Update Sub3 Score");
            System.out.println("8. Update All Information");
            System.out.println("0. Exit");
            System.out.print("Please choose your option: ");
            if (!sc.hasNextLine()) return true;
            String input = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid choice! Please try again.");
                continue;
            }
            if (choice == 0) {
                System.out.println("Exit update menu.");
                return true;
            }
            if (choice < 1 || choice > 8) {
                System.out.println("Invalid choice! Please try again.");
                continue;
            }

            if (choice == 1 || choice == 8) {
                System.out.print("Enter new Student ID: ");
                String newId = sc.nextLine().trim();
                Student duplicate = searchStudentByID_ArrayList(newId);
                if (duplicate != null && duplicate != target) {
                    System.out.println("That student ID is already in use.");
                    continue;
                }
                target.setStudentID(newId);
                if (choice == 1) {
                    System.out.println("Student ID updated successfully!");
                    continue;
                }
            }
            if (choice == 2 || choice == 8) {
                System.out.print("Enter new Student Name: ");
                target.setStudentName(sc.nextLine());
            }
            if (choice == 3 || choice == 8) {
                System.out.print("Enter new Student Class: ");
                target.setStudentClass(sc.nextLine());
            }
            if (choice == 4 || choice == 8) {
                System.out.println("--- Update Address ---");
                System.out.print("Enter new Home Address: ");
                target.getStudentAddress().setHomeAdress(sc.nextLine());
                System.out.print("Enter new Street: ");
                target.getStudentAddress().setStreet(sc.nextLine());
                System.out.print("Enter new Quarter: ");
                target.getStudentAddress().setQuarter(sc.nextLine());
                System.out.print("Enter new Ward: ");
                target.getStudentAddress().setWard(sc.nextLine());
                System.out.print("Enter new City: ");
                target.getStudentAddress().setCity(sc.nextLine());
                System.out.print("Enter new Country: ");
                target.getStudentAddress().setCountry(sc.nextLine());
            }
            if (choice == 5 || choice == 8) {
                System.out.print("Enter new Sub1 Score: ");
                target.setStudentSub1Score(readScore(sc));
            }
            if (choice == 6 || choice == 8) {
                System.out.print("Enter new Sub2 Score: ");
                target.setStudentSub2Score(readScore(sc));
            }
            if (choice == 7 || choice == 8) {
                System.out.print("Enter new Sub3 Score: ");
                target.setStudentSub3Score(readScore(sc));
            }
            System.out.println(choice == 8 ? "All information updated successfully!" : "Student information updated successfully!");
        }
    }

    private float readScore(Scanner sc) {
        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();
            try {
                float score = Float.parseFloat(input);
                if (Float.isFinite(score) && score >= 0 && score <= 100) return score;
            } catch (NumberFormatException ignored) {
                // Prompt again for malformed input.
            }
            System.out.print("Enter a valid score from 0 to 100: ");
        }
        throw new IllegalStateException("No score was provided.");
    }

}
