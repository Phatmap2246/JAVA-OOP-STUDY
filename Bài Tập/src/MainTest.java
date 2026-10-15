import chapter3_inheritance.Pupil;
import chapter4_polymorphism.TransferPupil;
import chapter4_polymorphism.OfficialPupil;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        while (true) {
            System.out.print("Please enter the number of Students: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                if (n > 0) break;
            } else {
                sc.nextLine();
            }
            System.out.println("Your number is invalid, please enter again!");
        }
        ArrayList<Pupil> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n  Student " + (i + 1) );
            System.out.println("Choose student type:");
            System.out.println("1. Pupil (regular)");
            System.out.println("2. OfficialPupil");
            System.out.println("3. TransferPupil");
            System.out.print("Your choice: ");
            
            int choice = -1;
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
        
        System.out.println("Student List");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(" Student " + (i + 1));
            list.get(i).print();
        }
        
        // count
        int numPupil = 0, numTrans = 0, numOff = 0;
        for(int i = 0 ;i< list.size();i++){
            if (list.get(i) instanceof TransferPupil) {
                numTrans++;
            }
            if(list.get(i) instanceof OfficialPupil){
                numOff++;
            }
        }
        numPupil = list.size() - numOff - numTrans;
        System.out.println("Number of Pupil: "+ numPupil);
        System.out.println("Number of Trans: "+ numTrans);
        System.out.println("Number of Offi: "+ numOff);
        sc.close();
    }
}