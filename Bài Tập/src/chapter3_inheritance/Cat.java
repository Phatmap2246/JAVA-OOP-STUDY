package chapter3_inheritance;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;;
public class Cat extends Animal {
    @Override 
    public void makeSound(){
        System.out.println("Meow Meow...");
    }

    private String catBreed;
    private int catFurColor;
    private String catFavoriteFood;

    private static final ArrayList<String> catFurColorList = new ArrayList<>(Arrays.asList("Black (Đen tuyền)","White (Trắng muốt)","Gray (Xám)","Ginger (Vàng cam/Mướp vàng)","Calico (Tam thể)","Tortoiseshell (Đồi mồi)","Tuxedo (Đen trắng kiểu mặc vest)","Tabby (Vằn/Mướp)","Colorpoint (Màu loang đặc trưng của mèo Xiêm)","Chocolate (Nâu socola)", "Others (Khác)"));
    
    //Constructor
    public Cat(){
        super();
        this.catBreed = "";
        this.catFurColor = 0;
        this.catFavoriteFood = "";
    }

    public Cat(String animalID, String animalName, int animalAge, float animalWeight, int animalGender, String catBreed,
            int catFurColor, String catFavoriteFood) {
        super(animalID, animalName, animalAge, animalWeight, animalGender);
        this.catBreed = catBreed;
        this.catFurColor = catFurColor;
        if (!this.isValidCatFurColor()) {
            this.catFurColor = 0;
            System.out.println("[!] Invalid Cat Fur Color! Resetting cat fur corlor to 0.("+this.getCatFurColorName());
        }
        this.catFavoriteFood = catFavoriteFood;
    }

    // Input & Print

    public void inputCat(){
        System.out.println("--- INPUT CAT INFORMATION ---");
        super.inputAnimal();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter Cat Breed (Giống mèo): ");
        this.catBreed = sc.nextLine();

        while (true) {
            System.out.print("Cat Fur Color List: ");
            for(int i = 0; i<catFurColorList.size();i++){
            System.out.print(i+". "+catFurColorList.get(i)+", ");
            }
            System.out.print("Please enter Cat Fur Color: ");
            this.catFurColor = sc. nextInt();
            if (this.isValidCatFurColor()) {
                break;
            }
            System.out.println("[!] Invalid Cat Fur Color! Please enter cat fur color again.");
        }
        
        System.out.print("Please enter Cat Favorite Food: ");
        this.catFavoriteFood = sc.nextLine();
    }

    public void printCat(){
        System.out.println("--- PRINT CAT INFORMATION ---");
        super.printAnimal();
        System.out.println("Cat breed: "+this.catBreed);
        System.out.println("Cat Fur Color: "+this.getCatFurColorName());
        System.out.println("Cat Favorite Food: "+this.catFavoriteFood);
        this.makeSound();
    }

    private boolean isValidCatFurColor(){
        return (this.catFurColor >=0 && this.catFurColor < catFurColorList.size());
    }

    //Getter
    public String getCatBreed() {
        return catBreed;
    }

    public int getCatFurColor() {
        return catFurColor;
    }

    public String getCatFavoriteFood() {
        return catFavoriteFood;
    }

    public static ArrayList<String> getCatfurcolorlist() {
        return catFurColorList;
    }

    public String getCatFurColorName(){
        return catFurColorList.get(this.catFurColor);
    }

    //Setter
    public void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }

    public void setCatFurColor(int catFurColor) {
        int oldCatFurColor = this.catFurColor;
        this.catFurColor = catFurColor;
        if (!this.isValidCatFurColor()) {
            this.catFurColor = oldCatFurColor;
            System.out.println("[!] Update Cat Fur Color Failed! Resetting cat fur color to the old color.("+this.getCatFurColorName()+")");
        }
    }

    public void setCatFavoriteFood(String catFavoriteFood) {
        this.catFavoriteFood = catFavoriteFood;
    }

// menu 
    public static  void catMenu(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Cat> catList = new ArrayList<>(); 
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=================================");
            System.out.println("      CAT CAFE MANAGEMENT      ");
            System.out.println("=================================");
            System.out.println("1. Add a new Cat (Nhap them meo)");
            System.out.println("2. Display all Cats (Xem danh sach)");
            System.out.println("3. Make all Cats sound (Dan dong ca)");
            System.out.println("0. Exit (Thoat)");
            System.out.print("Your choice: ");
            
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    Cat newCat = new Cat();
                    newCat.inputCat(); // Đã bao gồm gọi super.inputAnimal()
                    catList.add(newCat);
                    System.out.println("[+] Successfully added a new cat!");
                    break;
                    
                case 2:
                    if (catList.isEmpty()) {
                        System.out.println("[!] The cafe has no cats yet!");
                    } else {
                        System.out.println("\n--- CAFE'S CAT LIST ---");
                        for (int i = 0; i < catList.size(); i++) {
                            System.out.println("Cat #" + (i + 1));
                            catList.get(i).printCat();
                            System.out.println("---------------------");
                        }
                    }
                    break;
                    
                case 3:
                    if (catList.isEmpty()) {
                        System.out.println("[!] The cafe has no cats yet!");
                    } else {
                        System.out.println("\n--- MEOW MEOW CHOIR ---");
                        for (Cat c : catList) {
                            // Cần đảm bảo lớp Animal có hàm getAnimalName() để gọi được dòng này
                            System.out.print(c.getAnimalNameString() + " says: "); 
                            c.makeSound(); 
                        }
                    }
                    break;
                    
                case 0:
                    System.out.println("See you again!");
                    break;
                    
                default:
                    System.out.println("[!] Invalid choice! Please select 0-3.");
            }
        }
    }
    
}
