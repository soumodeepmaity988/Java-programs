import java.util.Scanner;

class Main{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n=scanner.nextInt();
        int count=0;
        int rsbm=n & -n;
        while(rsbm!=0){
            System.out.println(Integer.toBinaryString(n));
            n=n-rsbm;
            rsbm=n & -n;
            count++;
        }
        System.out.println(count);

        scanner.close();
    }
}