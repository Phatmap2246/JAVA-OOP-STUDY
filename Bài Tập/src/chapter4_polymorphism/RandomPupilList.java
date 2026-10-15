package chapter4_polymorphism;
import chapter3_inheritance.Pupil;
import java.util.Scanner;
import java.util.ArrayList;
public class RandomPupilList {
    private ArrayList<Pupil> list;

    // Constructors
    public RandomPupilList(){
        this.list = new ArrayList<>();
    }

    //Methods
    public void inputRandomPupilList(Scanner sc){
        int n= -1, choice =-1;
        while (true) {
            System.out.print("Please enter the number of Students: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                if (n > 0) break;
            } 
            else {
                sc.nextLine();
            }
            System.out.println("Your number is invalid, please enter again!");
        }
        while(n!=0){
            System.out.println("  Student " );
            System.out.println("Choose student type:");
            System.out.println("1. Pupil (regular)");
            System.out.println("2. OfficialPupil");
            System.out.println("3. TransferPupil");
            System.out.print("Your choice: ");
            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice >= 1 && choice <= 3) break;
                } else {
                    sc.nextLine();
                }
                System.out.print("Invalid choice, please enter 1-3: ");
            }
            
            Pupil p = null;  
            
            switch (choice) {
                case 1:
                    p = new Pupil();
                    break;
                case 2:
                    p = new OfficialPupil();
                    break;
                case 3:
                    p = new TransferPupil();
                    break;
            }
            p.input(sc);
            list.add(p);
        }
    }

    public void printRandomPupilList(){
        for(int i = 0; i<list.size();i++){
            System.out.println(" Student " + (i + 1));
            list.get(i).print();
        }
    }
}
