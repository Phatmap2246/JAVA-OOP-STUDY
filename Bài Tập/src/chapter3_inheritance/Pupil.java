package chapter3_inheritance;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Pupil extends Person {
    private String pupilID;
    private String schoolName;
    private String className;
    private float gpa;
    private int conduct;

    private static final ArrayList<String> conductList = new ArrayList<>(Arrays.asList("Low","Average","Good","Excellent")); // Blocked list
    // Constructors

    public Pupil(){
        super();
        this.pupilID = "";
        this.schoolName = "";
        this.className = "";
        this.gpa = 0;
        this.conduct = 0;
    }

    public Pupil(String fullName, MyDate birthdate, int gender, Address address, String pupilID, String schoolName, String className, float gpa, int conduct){
        super(fullName,birthdate,gender,address);
        this.pupilID = pupilID;
        this.schoolName = schoolName;
        this.className = className;
        
        this.gpa = gpa;
        if (!this.isValidGPA()) {
            System.out.println("[!] Invalid GPA! Resetting GPA to 0. ");
            this.gpa = 0;
        }

        this.conduct = conduct;
        if (!this.isValidConduct()) {
            System.out.println("[!] Invalid Conduct! Resetting Conduct to 0 (Low). ");
            this.conduct = 0;
        }
    }

    //Input & Print

    public void inputPupil(){
        System.out.println("--- ENTER PUPIL INFORMATION ---");
        super.inputPerson();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter Pupil ID: ");
        this.pupilID = sc.nextLine();

        System.out.print("Please enter Pupil School name: ");
        this.schoolName = sc.nextLine();

        System.out.print("Please enter Pupil Class name: ");
        this.className = sc.nextLine();

        while (true) {
            System.out.print("Please enter Pupil GPA: ");
            this.gpa = sc.nextFloat();
            if (this.isValidGPA()) {
                break;
            }
            System.out.println("[!] Invalid GPA! Please enter Pupil GPA again.");
        }

        while (true) {
            System.out.println("--- Conduct List ---");
            for(int i = 0; i<conductList.size();i++){
                System.out.print(i+". "+conductList.get(i)+", ");
            }
            System.out.print("Please enter Pupil conduct: ");
            this.conduct = sc.nextInt();

            if (this.isValidConduct()) {
                break;
            }

            System.out.println("[!] Invalid Conduct! Please enter pupil again.");
        }
        sc.nextLine();
        
    }

    public void printPupil(){
        System.out.println("--- PRINT PUPIL INFORMATION ---");
        super.printPersonInformation();

        System.out.println("Pupil ID: "+this.pupilID);
        System.out.println("Pupil school name: "+this.schoolName);
        System.out.println("Pupil class name: "+this.className);
        System.out.println("Pupil GPA: "+this.gpa);
        System.out.println("Pupil conduct: "+this.getConductName());
        System.out.println("Pupil academic ranking: "+this.getAcademicRanking());
        if (this.isEligibleForReward()) {
            System.out.println("Pupil Eligible ForReward !");
        }
    }

    
    private boolean isValidGPA(){
        return (this.gpa >=0 && this.gpa<=10);
    }
    private boolean isValidConduct(){
        return (this.conduct >=0 && this.conduct<=3);
    }

    //Get

    public String getConductName(){
        return conductList.get(this.conduct);
    }

    public String getPupilID(){
        return this.pupilID;
    }

    public String getPupilSchoolName(){
        return this.schoolName;
    }

    public String getPupilClassName(){
        return this.className;
    }

    public float getPupilGPA(){
        return this.gpa;
    }

    public int getPupilConduct(){
        return this.conduct;
    }

    // Set

    public void setPuilID(String newPupilID){
        this.pupilID = newPupilID;
    }

    public void setPupilSchoolName(String newSchoolName){
        this.schoolName = newSchoolName;
    }

    public void setPupilClassName(String newClassName){
        this.className = newClassName;
    }

    public void setPupilGPA(float newGPA){
        float oldGPA = this.gpa;
        this.gpa = newGPA;
        if (!this.isValidGPA()) {
            System.out.println("[!] Update GPA Failed! Resetting pupil old GPA.");
            this.gpa = oldGPA;
        }
    }

    public void setPupilConduct(int newConduct){
        int oldConduct = this.conduct;
        this.conduct = newConduct;
        if (!this.isValidConduct()) {
            System.out.println("[!] Update Conduct Failed! Resetting pupil old Conduct.");
            this.conduct = oldConduct;
        }
    }

    // Bonus
    public String getAcademicRanking(){
        if (this.gpa < 5) {
            return "Average";
        }
        else if (this.gpa < 8) {
            return "Good";
        }
        return "Excellent";
    }

    public boolean isEligibleForReward(){
        return (this.gpa >=8.0 && this.conduct == 3);
    }
}
