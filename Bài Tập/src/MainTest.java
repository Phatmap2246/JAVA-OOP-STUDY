import chapter4_polymorphism.*;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) { // Đã sửa thành main
        Scanner sc = new Scanner(System.in);
        
        // Khởi tạo đối tượng đại diện cho cả đàn
        Cow cows = new Cow();
        Sheep sheeps = new Sheep();
        Goat goats = new Goat();
        FarmManger manager = new FarmManger();
        
        // 1. Nhập dữ liệu
        manager.inputCattle(cows, sheeps, goats, sc);
        
        // 2. Câu a: Gia súc kêu
        manager.makeAllSound(cows, sheeps, goats);
        
        // 3. Câu b: Thống kê sinh sản & sữa
        manager.simulateBreedingAndMilking(cows, sheeps, goats);
        
        sc.close();
    }   
}