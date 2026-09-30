package chapter1_begin;
import java.util.Scanner;
import java.util.Random; // For creating random numbers
import java.util.ArrayList; // For ArrayList
public class Chuong1_NguyenDucPhat_3125720022 {
    public static void printName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your name: ");
        String name = sc.nextLine();
        System.out.print("Input your age: ");
        int age = sc.nextInt();

        System.out.println("Hello "+ name+", your age is "+ age);
        sc.close();
    }
/*Viết chương trình nhập 2 số nguyên, xuất tổng, hiệu, tích, thương. */
    public static void calculateNumbers (){
        int a,b,choose;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please press your first number: ");
        a = sc.nextInt();
        System.out.print("Please press your second number: ");
        b = sc.nextInt();
        while (true) {
            System.out.println("==============================");
            System.out.println("Option 1: Add ");
            System.out.println("Option 2: Minus ");
            System.out.println("Option 3: Mul ");
            System.out.println("Option 4: Div ");
            System.out.println("Option 5: Exit ");
            System.out.print("Please choose your option: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println(a + "+" + b + " = " + (a+b));
                    break;
                case 2:
                    System.out.println(a + "-" + b + " = " + (a-b));
                    break;
                case 3:
                    System.out.println(a + "*" + b + " = " + (a*b));
                    break;
                case 4:
                    System.out.println(a + "/" + b + " = " + (a/b) + " and mod " + (a%b));
                    break;
                case 5:
                    System.out.println("Thank you and see you later !");
                    sc.close();
                    return;
                default:
                    break;
            }

        }
    }

/*Viết chương trình nhập chiều dài, chiều rộng hình chữ nhật, xuất chu vi, diện tích
của hình chữ nhật đó. */

public static void calculateRetangle(){
    double lenght,width;
    String option;
    Scanner sc = new Scanner(System.in);
    System.out.print("Please press your lenght: ");
        lenght = sc.nextDouble();
    System.out.print("Please press your width: ");
        width = sc.nextDouble();
    while (true) {
        System.out.println("==============================");
            System.out.println("Option 1: Perimeter ");
            System.out.println("Option 2: Square ");
            System.out.println("Option 3: Exit ");
            System.out.print("Please choose your option: ");
            option = sc.next();
            switch (option) {
                case "1":
                    System.out.println("Perimeter of retangle with L = "+lenght+" and W = "+width+" is "+((width+lenght)*2));
                    break;
                case "2":
                    System.out.println("Square of retangle with L = "+lenght+" and W = "+width+" is "+(lenght*width));
                    break;
                case "3":
                    System.out.println("Thank you and see you later !");
                    sc.close();
                    return;
                default:
                    break;
            }
    }
}

/*Viết chương trình nhập bán kính hình tròn, xuất chu vi, diện tích của hình tròn đó.*/
public static void calculateCircle(){
    float r = 0;
    int option = 0;
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.print("Please press your r: ");
        r = sc.nextFloat();
        if (r>0) {
            break;
        }
        System.out.print("Your r must be higher than 0 !");
    }
    while (true) {
        System.out.println("==============================");
            System.out.println("Option 1: Perimeter ");
            System.out.println("Option 2: Square ");
            System.out.println("Option 3: Exit ");
            System.out.print("Please press your option: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Perimeter of Circle with r = " + r + " is " +(2*r*Math.PI));
                    break;
                case 2:
                    System.out.println("Square of Circle with r = " + r + " is " +(r*r*Math.PI));
                    break;
                case 3:
                    System.out.println("Thank you and see you later !");
                    sc.close();
                    return;
                default:
                    break;
            }
    }   

    

}

/*Viết chương trình nhập số nguyên N, kiểm tra và xuất kết quả N là số chẵn/lẻ */

public static void checkNumbers(){
    Scanner sc = new Scanner(System.in);
    int numb = 0;
    System.out.print("Please press your number: ");
        numb = sc.nextInt();
    
    if (numb == 0 || numb % 2 != 0) {
        System.out.println("Your number " + numb + " is Even!");
        sc.close();
        return;
    }
    System.out.println("Your number " + numb + " is Odd!");
    sc.close();
    return;
}

/*Viết chương trình nhập số nguyên N, kiểm tra và xuất kết quả N là số âm/zero/
dương*/
public static void checkNeZePos(){
    Scanner sc = new Scanner(System.in);
    int numb;
    System.out.print("Please press your number: ");
        numb = sc.nextInt();
    if (numb<0) {
        System.out.println("Your number "+numb+" is a Negative number");
    }
    else if (numb == 0) {
        System.out.println("Your number "+numb+" is Zero");
    }
    else{
        System.out.println("Your number "+numb+" is a Positive number");
    }
    sc.close();
    return;
}

/*Viết chương trình nhập số tự nhiên N, kiểm tra và xuất kết quả N là số nguyên tố
hay không. */
public static boolean isPrime(int a){
    if (a == 2 || a ==3) {
        return true;
    }
    if (a<2 || a%2==0 || a%3==0) {
        return false;
    }
    for(int i = 5; i*i<=a;i+=6){
        if (a%i==0) {
            return false;
        }
    }
    return true;
}

public static void checkPrimeNumber(){
    Scanner sc = new Scanner(System.in);
    int numb;
    System.out.print("Please press your number: ");
        numb = sc.nextInt();
    if (isPrime(numb)){
        System.out.println("Your number "+numb+" is a Prime number!");
    }
    else{
        System.out.println("Your number "+numb+" isn't a Prime number!");
    }
    sc.close();
}

/*Viết chương trình nhập số tự nhiên N, xuất kết quả :
a. Các số tự nhiên <=N và tổng của chúng
b. Các số tự nhiên chẵn <=N và tổng của chúng
c. Các số tự nhiên lẻ <=N và tổng của chúng
d. Các số tự nhiên là số nguyên tố <=N và tổng của chúng
e. N số nguyên tố đầu tiên */
public static void listAllAndAdd(int a, int sum){
    System.out.println("Your option is 1");
    System.out.print("All numbers less than or equal "+a+" are: ");
    for(int i = 0; i<=a;i++){
        System.out.print(i+", ");
        sum+=i;
    }
    System.out.println("Add all them together equal: "+sum);
}
public static void listAllOddAndAdd(int a, int sum){
    System.out.println("Your option is 2");
    System.out.print("All Even numbers less than or equal "+a+" are: ");
    for(int i = 0;i<=a;i++){
        if (i%2==0) {
            System.out.print(i+", ");
            sum+=i;
        }
    }
    System.out.println("Add all them together equal: "+sum);
}
public static void listAllEvenAndAdd(int a, int sum){
    System.out.println("Your option is 3");
    System.out.print("All Odd numbers less than or equal "+a+" are: ");
    for(int i = 0;i<=a;i++){
        if (i%2!=0) {
            System.out.print(i+", ");
            sum+=i;
        }
    }
    System.out.println("Add all them together equal: "+sum);
}
public static void listAllPrimeAndAdd(int a, int sum){
    System.out.println("Your option is 3");
    System.out.print("All Prime numbers less than or equal "+a+" are: ");
    for(int i = 0;i<=a;i++){
        if (isPrime(i)) {
            System.out.print(i+", ");
            sum+=i;
        }
    }
    System.out.println("Add all them together equal: "+sum);
}
public static void process7(){
    Scanner sc = new Scanner(System.in);
    int numb = 0, sum =0, option = 0;
    System.out.print("Please press your number: ");
        numb = sc.nextInt();
    while (true) {
        System.out.println("=======================");
        System.out.println("Your number is "+numb);
        System.out.println("Option 1: List all numbers less than or equal "+numb+" and Add all them together.");
        System.out.println("Option 2: List all Even numbers less than or equal "+numb+" and Add all them together.");
        System.out.println("Option 3: List all Odd numbers less than or equal "+numb+" and Add all them together.");
        System.out.println("Option 4: List all Prime numbers less than or equal "+numb+" and Add all them together.");
        System.out.println("Option 5: Exit process");
        System.out.print("Please press your option: ");
            option = sc.nextInt();
        switch (option) {
            case 1:
                listAllAndAdd(numb, sum);
                break;
            case 2:
                listAllOddAndAdd(numb, sum);
                break;
            case 3:
                listAllEvenAndAdd(numb, sum);
                break;
            case 4:
                listAllPrimeAndAdd(numb, sum);
                break;
            case 5:
                System.out.println("Thank you and see you later!");
                sc.close();
                return;
            default:
                break;
        }
    }
}

/*Viết chương trình nhập số tự nhiên N, nhập N phần tử của mảng a, xuất kết quả :
a. b. c. d. e. f. g. Các phần tử của mảng a và tổng của chúng
Các phần tử chẵn của mảng a và tổng của chúng
Các phần tử lẻ của mảng a và tổng của chúng
Các phần tử là số nguyên tố của mảng a và tổng của chúng
Thêm 1 phần tử mới vào mảng
Xoá phần tử thứ k của mảng a
nhập 1 số x, kiểm tra x có trong mảng a không, nếu có thì trả về vị trí của
x trong mảng a */
public static void inputYourSelf(int n, int[]a){
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i<n;i++){
        System.out.print("Please press the value at "+i+" index: ");
        a[i] = sc.nextInt();
    }
}
public static void createRandomNumbersArray(int n, int[] array){
    Random rand = new Random();
    for (int i =0;i<n;i++){
        array[i] = rand.nextInt(100);
    }
}
public static void printArray(int n, int[] a){
    System.out.print("Your array: ");
    for (int i =0;i<n-1;i++){
        System.out.print(a[i]+", ");
    }
    System.out.println(a[n-1]);
}
public static void listAllAndAddArr(int n, int[]a, int sum){
    System.out.print("Your array: ");
    for(int i =0;i<n;i++){
        System.out.print(a[i]+", ");
        sum+=a[i];
    }
    System.out.println("Add all them together equal: "+sum);
}
public static void listAllEvenAndAddArr(int n, int[]a, int sum){
    System.out.print("All Even numbers in your array: ");
    for(int i =0;i<n;i++){
        if (a[i]%2==0) {
            System.out.print(a[i]+", ");
            sum+=a[i];
        }
    }
    System.out.println("Add all them together equal: "+sum);
}
public static void listAllOddAndAddArr(int n, int[]a, int sum){
    System.out.print("All Odd numbers in your array: ");
    for(int i =0;i<n;i++){
        if (a[i]%2!=0) {
            System.out.print(a[i]+", ");
            sum+=a[i];
        }
    }
    System.out.println("Add all them together equal: "+sum);
}
public static void listAllPrimeAndAddArr(int n, int[]a, int sum){
    System.out.print("All Prime numbers in your array: ");
    for(int i =0;i<n;i++){
        if (isPrime(a[i])) {
            System.out.print(a[i]+", ");
            sum+=a[i];
        }
    }
    System.out.println("Add all them together equal: "+sum);
}
public static int[] addANewNumberArr(int n, int[] a, int numb){
    int[]temp = new int[n];
    for(int i = 0;i<n-1;i++){
        temp[i] = a[i];
    }
    temp[n-1] = numb;
    return temp;
}
public static int[] deleteKIndexNumberArr(int n, int k, int[] a){
    int[] temp = new int[n-1];
    for(int i=0;i<k;i++){
        temp[i] = a[i];
    }
    for(int i = k+1;i<n;i++){
        temp[i-1] = a[i];
    }
    return temp;
}
public static void checkAndFindIndexArr(int n, int[] a, int x){
    int found=0;
    for(int i = 0; i<n;i++){
        if (a[i] ==x) {
            System.out.println("The number "+x+" is in your array and it's index is: "+i);
            found++;
        }
    }
    if (found==0) {
        System.out.println("The number "+x+" isn't in your array");
    }
}
public static int[] addNumberKIndex(int n, int[] a){
    Scanner sc = new Scanner(System.in);
    if (a.length ==0) {
        System.out.println("Your array is Empty!");
        System.out.print("Please press the first value: ");
        a[0] = sc.nextInt();
        return a;
    }
    int k=0,numb=0;
    int[] temp = new int[n];
    while (true) {
        System.out.print("Please press your Index: ");
            k = sc.nextInt();
        if (k>=0 && k<n) {
            System.out.print("Please press value of the K index: ");
                numb = sc.nextInt();
            for(int i = 0; i<k;i++){
                temp[i] = a[i];
            }
            for(int i = k+1;i<n;i++){
                temp[i] = a[i-1];
            }
            temp[k] = numb;
            return temp;
        }
        System.out.println("Please press the Index higher or equal 0 and less or equal "+(n-1));
    }
}
public static int deleteNumberArray(int n, int[]a){
    if (a.length ==0){
        System.out.println("Your array is Empty!");
        return n;
    }
    Scanner sc = new Scanner(System.in);
    int numb, found=0;
    System.out.println("Please press your number: ");
        numb = sc.nextInt();
    int index = 0;
    while (index <n) {
        if (a[index] == numb) {
            for(int i = index;i<n-1;i++){
                a[i] = a[i+1];
            }
            n--;
            found++;
        }
        else{index++;}
        
    }
    if (found==0) {
        System.out.println("The number "+numb+" isn't in your array.");
    }
    return n;

}
public static void process8(){
    Scanner sc = new Scanner(System.in);
    int n = 0, option = 0, x = 0, k = 0,sum =0, numb = 0; int[] a = null;
    while (true) {
        System.out.print("Please press the lenght of your array: ");
        n = sc.nextInt();
        if (n>0) {
            a = new int[n];
            break;
        }
        System.out.println("Please press the higher length !");
        System.out.println("================================");
    }
    while (true) {
        System.out.println("Option 1: Input by yourself. ");
        System.out.println("Option 2: Auto input. ");
        System.out.println("Option 3: Exit");
        System.out.print("Please press your Input option: ");
        option = sc.nextInt();
        if (option == 1) {
            inputYourSelf(n, a);
            break;
        }
        else if (option == 2) {
            createRandomNumbersArray(n, a);
            break;
        }
        else if (option ==3) {
            System.out.println("Thank you and see you later !");
            sc.close();
            return;
        }
        System.out.println("Please press the option again !");
        System.out.println("================================");
    }
    printArray(n, a);
    while (true) {
        System.out.println("================================");
        System.out.println("Option 1: List all your array and Add them together.");
        System.out.println("Option 2: List all Even numbers in your array and Add them together.");
        System.out.println("Option 3: List all Odd numbers in your array and Add them together.");
        System.out.println("Option 4: List all Prime numbers in your array and Add them together.");
        System.out.println("Option 5: Add a new number in your array.");
        System.out.println("Option 6: Delete a number at the k index in your array.");
        System.out.println("Option 7: Add a number at the k index in your array.");
        System.out.println("Option 8: Delete numbers in your array.");
        System.out.println("Option 9: Check if number x is in your array and return that index.");
        System.out.println("Option 10: Exit the process.");
        System.out.print("Please press your option: ");
            option = sc.nextInt();
        System.out.println("================================");
        switch (option) {
            case 1:
                listAllAndAddArr(n, a, sum);
                break;
            case 2:
                listAllEvenAndAddArr(n, a, sum);
                break;
            case 3:
                listAllOddAndAddArr(n, a, sum);
                break;
            case 4:
                listAllPrimeAndAddArr(n,a,sum);
                break;
            case 5:
                System.out.print("Please press your new number: ");
                numb = sc.nextInt();
                n++;
                a = addANewNumberArr(n, a, numb);
                printArray(n, a);
                break;
            case 6:
                while (true) {
                    System.out.print("Please press the index which you want to delete: ");
                    k = sc.nextInt();
                    if (k>=0 && k<=n-1) {
                        break;
                    }
                    System.out.println("Please press the index less or equal "+(n-1)+" and better or equal 0 !");
                    System.out.println("================================");
                }
                a = deleteKIndexNumberArr(n, k, a);
                n--;
                printArray(n, a);
                break;
            case 7:
                n++;
                a = addNumberKIndex(n, a);
                printArray(n, a);
                break;
            case 8:
                n = deleteNumberArray(n, a);
                printArray(n, a);
                break;
            case 9:
                System.out.print("Please press your number which you want to find: ");
                    x = sc.nextInt();
                checkAndFindIndexArr(n, a, x);
                break;
                
            case 10:
                System.out.println("Thank you and see you later !");
                sc.close();
                return;
            default:
                break;
        }
    }
}

/*Viết chương trình nhập chuỗi s, xuất kết quả:
a. Độ dài của s
b. Xoá bỏ khoảng trắng thừa của s
c. Đếm số từ của s và xuất mỗi từ nằm trên 1 dòng
d. nhập số tự nhiên k, xuất k ký tự bên trái của s, k kí tự bên phải của s
e. nhập số tự nhiên k, n, xuất n kí tự của s kể từ vị trí k */
public  static void cleanSpace(String str){
    String lines[] = str.split("\n");
    for(String line : lines){
        line = line.strip().replaceAll("\\s+", " ");
        System.out.println(line);
    }
}
public static String inputString(){
    System.out.println("Wellcome to Input Machine!");
    Scanner sc = new Scanner(System.in);
    StringBuilder fullText = new StringBuilder(); // use StringBuilder to justify easier.
    String line;
    System.out.println("Please press your idea (press Enter for a blank line to Stop) !");
    while (true) {
        line = "";
        line = sc.nextLine();
        if (line.isEmpty()) {
            break;
        }
        fullText.append(line).append("\n");
    }
    return fullText.toString();

}

public static void countWordsAndPrintLine(String str){
    String[] lineArray = str.split("\n");
    String cleanedLine="";
    int countWords=0, lineNumb=1;
    for(String line:lineArray){
        cleanedLine = line.strip().replaceAll("\\s+", " ");
        countWords = cleanedLine.split(" ").length;
        System.out.println("Line "+lineNumb+": "+cleanedLine+" || has "+countWords+" Words");
        lineNumb++;
    }
    
}

public static void inputKAndPrintKLetterRL(String str){
    Scanner sc = new Scanner(System.in);
    String strCleaned = str.strip().replaceAll("\\s+", " ");
    if (strCleaned.isEmpty()) {
        System.out.println("Your text is Empty !");
        return;
    }
    int k=0;
    while (true) {
        System.out.println("Please press your k: ");
            k = sc.nextInt();
        if (k<(strCleaned.length()/2)) {
            break;
        }
        System.out.println("Please press k less than "+ (strCleaned.length()/2));
        System.out.println("=====================");
    }
    int beg = 0, end= strCleaned.length()-1;
    while (k!=0) {
        System.out.println("left: "+strCleaned.charAt(beg)+" || right: "+strCleaned.charAt(end));
        beg++;
        end--;
        k--;
    }
}

public static void inputNKAndPrintN(String str){
    String strCleaned = str.strip().replaceAll("\\s+", " ");
    if (strCleaned.isEmpty()) {
        System.out.println("Your text is Empty !");
        return;
    }
    int n=0,k=0;
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.print("Please press your k: ");
        k = sc.nextInt();
        if (k>=0 && k<strCleaned.length())break;
        System.out.println("Please press k better or equal 0 and less than "+strCleaned.length());
        System.out.println("=====================");
    }
    while (true) {
        System.out.print("Please press your n: ");
        n = sc.nextInt();
        if (n>0 && n<=(strCleaned.length()-k))break;
        System.out.println("Please press n better 0 and less or equal "+(strCleaned.length()-k));
        System.out.println("=====================");
    }
    while(n!=0){
        System.out.print(strCleaned.charAt(k));
        k++;
        n--;
    }
    System.out.println();
}

public static void process9(){
    Scanner sc = new Scanner(System.in);
    String str;
    int option=0;
    str = inputString();
    while (true) {
        System.out.println("================================");
        System.out.println("Option 1: Show the lenght of your String. ");
        System.out.println("Option 2: Delete the extra space. ");
        System.out.println("Option 3: Count words of your String and print words on each row");
        System.out.println("Option 4: Press number k then print the k letters from the left and right of your String ");
        System.out.println("Option 5: Press number k and n then print n letters from the k index ");
        System.out.println("Option 6: Exit the process");
        System.out.print("Please press your option: ");
            option = sc.nextInt();
        System.out.println("================================");
        switch (option) {
            case 1:
                System.out.println("The lenght of String is "+str.length());
                break;
            case 2:
                cleanSpace(str);
                System.out.println("Your text is cleaned successfully!");
                break;
            case 3:
                countWordsAndPrintLine(str);
                break;
            case 4:
                inputKAndPrintKLetterRL(str);
                break;
            case 5:
                inputNKAndPrintN(str);
                break;
            case 6:
                System.out.println("Thank you and see you later !");
                sc.close();
                return;
            default:
                break;
        }


    }
}
public static void inputYourSelfList (int n,ArrayList <Integer> a){
    Scanner sc = new Scanner(System.in);
    for(int i = 0;i<n;i++){
    System.out.print("Please input the value of "+i+" index: ");
    a.add(sc.nextInt());
    System.out.println();
    }
}
public static void createRandomArrayList(int n, ArrayList<Integer> a){
    Random rand = new Random();
    for(int i = 0;i<n;i++){
        a.add(rand.nextInt(100));
    }
}
public static void printArrayList(ArrayList <Integer> a){
    if (a.isEmpty()) {
        System.out.println("Your array is empty !");
        return;
    }
    System.out.println("Your array: "+a);
}
public static void printAllAndSumList(ArrayList<Integer> a){
    if (a.isEmpty()) {
        System.out.println("Your array is empty!");
        return;
    }
    int sum =0;
    for(int numb: a){
        sum+=numb;
    }
    printArrayList(a);
    System.out.println("Sum your array is: "+sum);
}
public static  void printEvenAndSumList(ArrayList<Integer>a){
    if (a.isEmpty()) {
        System.out.println("Your array is Empty!");
        return;
    }
    int sum =0;
    System.out.print("All Even numbers in your array: ");
    for(int numb :a){
        if (numb%2==0) {
            System.out.print(numb+", ");
            sum+=numb;
        }
    }
    System.out.println("And Add them together equal: "+sum);
}
public static void printOddAndSumList(ArrayList<Integer> a){
    if (a.isEmpty()) {
        System.out.println("Your array is Empty!");
        return;
    }
    int sum=0;
    System.out.print("All Odd numbers in your array: ");
    for(int numb:a){
        if (numb%2!=0) {
            System.out.print(numb +", ");
            sum+=numb;
        }
    }
    System.out.println("And Add them together equal: "+sum);
}
public static void printPrimeAndSumList(ArrayList<Integer> a){
    if (a.isEmpty()) {
        System.out.println("Your array is Empty!");
        return;
    }
    int sum=0;
    System.out.print("All Prime numbers in your array: ");
    for(int numb:a){
        if (isPrime(numb)) {
            System.out.print(numb +", ");
            sum+=numb;
        }
    }
    System.out.println("And Add them together equal: "+sum);
}
public static void addNewNumber(ArrayList<Integer> a){
    Scanner sc = new Scanner(System.in);
    int numb =0;
    System.out.print("Please press your new number: ");
        numb = sc.nextInt();
    a.add(numb);
    printArrayList(a);
}
public static void deleteKIndexList(ArrayList<Integer> a){
    Scanner sc = new Scanner(System.in);
    if (a.isEmpty()) {
        System.out.println("Your array is Empty!");
        return;
    }
    int k =0;
    while (true) {
        System.out.print("Please prees your Index: ");
            k = sc.nextInt();
        if (k>=0 && k<a.size()) {
            a.remove(k);
            printArrayList(a);
            return;
        }
        System.out.println("Please press the Index than or equal 0 and less or equal "+(a.size()-1));
        System.out.println("=========================");
    }  
}
public static void findXAndIndex(ArrayList <Integer> a){
    if (a.isEmpty()) {
        System.out.println("Your array is Empty!");
        return;
    }
    Scanner sc = new Scanner(System.in);
    boolean found = false;
    System.out.print("Please press your number x: ");
        int x = sc.nextInt();

    for(int i = 0;i<a.size();i++){
        if (a.get(i) == x) {
            found = true;
            System.out.println("The number "+x+" is in your array and it's index is "+i);
        }
    }
    if (!found) {
        System.out.println("The number "+x+" isn't in your array.");
    }
}
/*Process 8 using ArrayList*/
public static void process8ArrayList(){
    Scanner sc = new Scanner(System.in);
    int n=0, option =0;
    ArrayList<Integer> a = new ArrayList<>();
    while (true) {
        System.out.print("Please press the lenght of your array: ");
        n = sc.nextInt();
        if (n>0) {
            break;
        }
        System.out.print("Please press higher lenght !");
        System.out.print("============================");
    }
    while (true) {
        System.out.println("Option 1: Input by yourself.");
        System.out.println("Option 2: Auto input.");
        System.out.println("Option 3: Exit.");
        System.out.print("Please press your option: ");
        option = sc.nextInt();
        if (option ==1) {
            inputYourSelfList(n, a);
            break;
        }
        else if (option ==2) {
            createRandomArrayList(n,a);
            break;
        }
        else if(option ==3){
            System.out.println("Thank you and see you later.");
            sc.close();
            return;
        }
    }
    printArrayList(a);
    while (true) {
        System.out.println("================================");
        System.out.println("Option 1: List all your array and Add them together.");
        System.out.println("Option 2: List all Even numbers in your array and Add them together.");
        System.out.println("Option 3: List all Odd numbers in your array and Add them together.");
        System.out.println("Option 4: List all Prime numbers in your array and Add them together.");
        System.out.println("Option 5: Add a new number in your array.");
        System.out.println("Option 6: Delete a number at the k index in your array.");
        System.out.println("Option 7: Check if number x is in your array and return that index.");
        System.out.println("Option 8: Exit the process.");
        System.out.print("Please press your option: ");
            option = sc.nextInt();
        System.out.println("================================");
        switch (option) {
            case 1:
                printAllAndSumList(a);
                break;
            case 2:
                printEvenAndSumList(a);
                break;
            case 3:
                printOddAndSumList(a);
                break;
            case 4:
                printPrimeAndSumList(a);
                break;
            case 5:
                addNewNumber(a);
                break;
            case 6:
                deleteKIndexList(a);
                break;
            case 7:
                findXAndIndex(a);
                break;
            case 8:
                System.out.println("Thank you and see you later. ");
                sc.close();
                return;
            default:
                break;
        }
    }
}
}

