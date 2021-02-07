package com.company;

import java.util.Scanner;

class Main4{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[]arr1=new int[n];
        int[] arr2=new int[m];
        for(int i=0;i<n;i++){
            arr1[i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            arr2[i]=scanner.nextInt();
        }
        System.out.println("Enter the sum value : ");
        int sum=scanner.nextInt();
        int A=0,B=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int abs=Math.abs(arr1[i]+arr2[j]-sum);
                if(abs<result){
                    result=abs;
                    A=arr1[i];
                    B=arr2[j];
                }
            }
        }
        System.out.println(A+" "+B);
        scanner.close();
    }
}