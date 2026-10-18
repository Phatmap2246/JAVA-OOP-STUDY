package chapter4_polymorphism;
import java.util.Scanner;
import java.util.Random;

public class FarmManger {
    
    public FarmManger() {
    }

    // 1. Nhập số lượng gia súc ban đầu
    public void inputCattle(Cow cow, Sheep sheep, Goat goat, Scanner sc) {
        System.out.println("=== INPUT INITIAL CATTLE ===");
        
        // Nhập Bò
        System.out.print("Enter number of Cows: ");
        int numCows = sc.nextInt();
        if (numCows > 0) {
            System.out.print("Enter number of Male Cows: ");
            cow.male = sc.nextInt();
            cow.female = numCows - cow.male;
        }

        // Nhập Cừu
        System.out.print("Enter number of Sheep: ");
        int numSheep = sc.nextInt();
        if (numSheep > 0) {
            System.out.print("Enter number of Male Sheep: ");
            sheep.male = sc.nextInt();
            sheep.female = numSheep - sheep.male;
        }

        // Nhập Dê
        System.out.print("Enter number of Goats: ");
        int numGoats = sc.nextInt();
        if (numGoats > 0) {
            System.out.print("Enter number of Male Goats: ");
            goat.male = sc.nextInt();
            goat.female = numGoats - goat.male;
        }
    }

    // 2. Câu a: Tất cả gia súc đều đói, in ra tiếng kêu
    public void makeAllSound(Cow cow, Sheep sheep, Goat goat) {
        System.out.println("\n=== CATTLE ARE HUNGRY (Sounds) ===");
        if (cow.male + cow.female > 0) {
            System.out.print("Cows sound: ");
            cow.makeSound();
        }
        if (sheep.male + sheep.female > 0) {
            System.out.print("Sheep sound: ");
            sheep.makeSound();
        }
        if (goat.male + goat.female > 0) {
            System.out.print("Goats sound: ");
            goat.makeSound();
        }
    }
    
    // 3. Câu b: Thống kê sau 1 lứa sinh và 1 lược cho sữa
    public void simulateBreedingAndMilking(Cow cow, Sheep sheep, Goat goat) {
        System.out.println("\n=== BREEDING & MILKING SIMULATION ===");
        Random rand = new Random();
        
        // --- QUÁ TRÌNH SINH SẢN ---
        // Giả sử mỗi con cái sinh ngẫu nhiên từ 1 đến 2 con
        int newCows = 0, newSheep = 0, newGoats = 0;
        
        for (int i = 0; i < cow.female; i++) {
            newCows += 1 + rand.nextInt(2); // 1 hoặc 2 con
        }
        for (int i = 0; i < sheep.female; i++) {
            newSheep += 1 + rand.nextInt(2);
        }
        for (int i = 0; i < goat.female; i++) {
            newGoats += 1 + rand.nextInt(2);
        }
        
        // Cập nhật số lượng con cái (giả sử con non đều là cái để tính sữa luôn)
        cow.female += newCows;
        sheep.female += newSheep;
        goat.female += newGoats;
        
        System.out.println("After 1 breeding season:");
        System.out.println("- Cows born: " + newCows);
        System.out.println("- Sheep born: " + newSheep);
        System.out.println("- Goats born: " + newGoats);

        // --- QUÁ TRÌNH LẤY SỮA ---
        float totalMilkCow = 0, totalMilkSheep = 0, totalMilkGoat = 0;
        
        for (int i = 0; i < cow.female; i++) {
            totalMilkCow += cow.createMilk();
        }
        for (int i = 0; i < sheep.female; i++) {
            totalMilkSheep += sheep.createMilk();
        }
        for (int i = 0; i < goat.female; i++) {
            totalMilkGoat += goat.createMilk();
        }

        System.out.println("\n=== MILKING STATISTICS ===");
        System.out.printf("- Milk from Cows: %.2f liters\n", totalMilkCow);
        System.out.printf("- Milk from Sheep: %.2f liters\n", totalMilkSheep);
        System.out.printf("- Milk from Goats: %.2f liters\n", totalMilkGoat);
        System.out.printf("=> TOTAL MILK: %.2f liters\n", (totalMilkCow + totalMilkSheep + totalMilkGoat));
        
        System.out.println("\n=== FINAL CATTLE COUNT ===");
        System.out.println("- Total Cows: " + (cow.male + cow.female) + " (Male: " + cow.male + ", Female: " + cow.female + ")");
        System.out.println("- Total Sheep: " + (sheep.male + sheep.female) + " (Male: " + sheep.male + ", Female: " + sheep.female + ")");
        System.out.println("- Total Goats: " + (goat.male + goat.female) + " (Male: " + goat.male + ", Female: " + goat.female + ")");
        System.out.println("=> TOTAL FARM CATTLE: " + (cow.male + cow.female + sheep.male + sheep.female + goat.male + goat.female));
    }
}