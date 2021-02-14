import java.util.Scanner;

class Main{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n=scanner.nextInt();

        int rsbm=n & -n;

        System.out.println(Integer.toBinaryString(rsbm));

        scanner.close();
    }
}