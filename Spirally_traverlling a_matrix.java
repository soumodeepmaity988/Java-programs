package com.company;

import java.util.Scanner;

class Main{
    public static void main(String[]args){
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        int minR=0;
        int minC=0;
        int maxR=n-1;
        int maxC=m-1;
        int count=0;
        while((m*n)>count){
            for(int j = minR,i=minR; j<=maxC; j++){
                System.out.println(arr[i][j]);
                count++;
            }
            minR++;
            for(int i=minR,j=maxC;i<=maxR;i++){
                System.out.println(arr[i][j]);
                count++;
            }
            maxC--;
            for(int j=maxC,i=maxR;j>=minC;j--){
                System.out.println(arr[i][j]);
                count++;
            }
            maxR--;
            for(int i=maxR,j=minC;i>=minR;i--){
                System.out.println(arr[i][j]);
                count++;
            }
            minC++;
            System.out.println("count="+count);
        }
        scanner.close();
    }
}