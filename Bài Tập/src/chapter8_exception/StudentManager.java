package chapter8_exception;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> list;

    public StudentManager(){
        list = new ArrayList<>();
    }

    public void addStudent(Student student) throws DuplicateIDException{
        for(Student s:list){
            if (s.getId().equalsIgnoreCase(student.getId())) {
                throw new DuplicateIDException("[!] Lỗi: Mã sinh viên "+student.getId()+" đã tồn tại!");
            }
        }
        list.add(student);
        System.out.println("[+] Đã thêm sinh viên: "+student.getName()+" thành công!");
    }

    public Student findStudent(String id) throws StudentNotFoundException{
        for(Student s : list){
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        throw new StudentNotFoundException("[!] Lỗi: không tìm thấy sinh viên có mã: "+id);
    }

    public double calculateAverageGpa(){
        if (list.isEmpty()) {
            throw new ArithmeticException("[!] Lỗi: Danh sách rỗng, không thể tính điểm trung bình!");
        }
        double sum = 0;
        for(Student s:list){
            sum+=s.getGpa();
        }
        return sum/list.size();
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("[!] Danh sách sinh viên đang trống!");
            return;
        }
        System.out.println("--- DANH SÁCH SINH VIÊN ---");
        for (Student s : list) {
            System.out.println(s.toString());
        }
    }
}
