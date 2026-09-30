package chapter3_inheritance;
import java.util.Scanner;
public class Address {
    private String homeAddress;
    private String street;
    private String quarter;
    private String ward;
    private String city;
    private String country;

    // Method
    public Address(){
        this.homeAddress = "";
        this.street = "";
        this.quarter = "";
        this.ward = "";
        this.country = "";
    }
    public Address(String homeAddress,String street ,String quarter, String ward, String city, String country){
        this.homeAddress = homeAddress;
        this.street = street;
        this.quarter = quarter;
        this.ward = ward;
        this.city = city;
        this.country = country;
    }

    public void inputAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        System.out.print("Please enter your home address: ");
            this.homeAddress = sc.nextLine();
        System.out.print("Please enter your street name: ");
            this.street = sc.nextLine();
        System.out.print("Please enter your quarter: ");
            this.quarter = sc.nextLine();
        System.out.print("Please enter your ward: ");
            this.ward = sc.nextLine();
        System.out.print("Please enter your city: ");
            this.city = sc.nextLine();    
        System.out.print("Please enter your country: ");
            this.country = sc.nextLine();
    }
    public void printAddress(){
        System.out.println("Your address: "+this.homeAddress +", "+this.street+" street, "+this.quarter+" quarter, "+this.ward+" ward, "+this.city+" city, "+this.country+".");
    }
    // Setter, Getter
    public String getHomeAdress(){
        return this.homeAddress;
    }

    public String getStreet(){
        return this.street;
    }

    public String getQuarter(){
        return this.quarter;
    }

    public String getWard(){
        return this.ward;
    }

    public String getCity(){
        return this.city;
    }

    public String getCountry(){
        return this.country;
    }

    public String getFullAddress(){
        return "Your address: "+this.homeAddress +", "+this.street+" street, "+this.quarter+" quarter, "+this.ward+" ward, "+this.city+" city, "+this.country+".";
    }

    public void setHomeAdress(String homeAddress){
        this.homeAddress = homeAddress;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public void setQuarter(String quarter){
        this.quarter = quarter;
    }
    public void setWard(String ward){
        this.ward = ward;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setCountry (String country){
        this.country = country;
    }
}
