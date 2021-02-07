package com.company;

import java.util.Arrays;
import java.util.Scanner;

class Main5{
    public static boolean[] bool;
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        bool= new boolean[n + m];
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        for(int i=0;i<n;i++){
            arr1[i]=scanner.nextInt();
        }
        Arrays.sort(arr1);
        for(int i=0;i<m;i++){
            arr2[i]=scanner.nextInt();
        }
        Arrays.sort(arr2);
        System.out.println("Enter the sum: ");
        int sum=scanner.nextInt();
        int[] arr3;
        arr3=marge(arr1,arr2);
        for(int i=0;i<n+m;i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n+m;i++){
            System.out.print(bool[i]+" ");
        }
        System.out.println();
        closest_pair(arr3,sum);
        scanner.close();
    }

    public static void closest_pair(int[] arr,int sum){
        int i=0;
        int j=arr.length-1;
        int result=Integer.MAX_VALUE;
        int A=0,B=0;
        while(i<j){
            int abs=(Math.abs(arr[i]+arr[j]-sum));
            if(abs<result&& bool[i] && !bool[j]){
                result=abs;
                A=arr[i];
                B=arr[j];
            }
            if(arr[i]+arr[j]<sum){
                i++;
            }else{
                j--;
            }
        }
        System.out.println(result+" -> "+A+" ->"+B);
    }

    public static int[] marge(int[] arr1,int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[] arr3 = new int[n + m];
        int i = 0, j = 0,k=0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr3[k]=arr1[i];
                bool[k]=true;
                i++;
            }else{
                arr3[k]=arr2[j];
                bool[k]=false;
                j++;
            }
            k++;
        }
        while(i<n){
            arr3[k]=arr1[i];
            bool[k]=true;
            i++;
            k++;
        }
        while(j<m){
            arr3[k]=arr2[j];
            bool[k]=false;
            j++;
            k++;
        }
        return arr3;
    }
}