package chapter2_class;
import java.util.Scanner;
import java.util.ArrayList;
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
        this.list = existingList;
    }

    // 1. Add a new student
    public void addOneStudent_ArrayList(){
        Student newStudent = new Student();
        newStudent.inputStudent();
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
        int foundIndex = -1;
        for(int i = 0 ;i <this.list.size();i++){
            if (this.list.get(i).getStudentID().equalsIgnoreCase(id)) {
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
        for(int i = 0 ;i<this.list.size();i++){
            if (this.list.get(i).getStudentID().equalsIgnoreCase(id)) {
                return this.list.get(i);
            }
        }
        return null;
    }

    //5. Update student's information by ID
    public boolean updateStudentByID_ArrayList(String id){
        Student target = this.searchStudentByID_ArrayList(id);
        if (target == null) {
            return false;
        }
        int choice = -1;
        /*while (choice !=0) {
            System.out.println("1. Update student ID. ");
            System.out.println("2. Update student Name.");
        }*/
       return true;
    }

}
