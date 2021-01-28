package com.company;

import java.util.Arrays;
import java.util.Scanner;

class Merge_Without_Extra_Space{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        for(int i=0;i<n;i++){
            arr1[i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            arr2[i]=scanner.nextInt();
        }
//        for(int i=0;i<n;i++){
//            System.out.print(arr1[i]+" ");
//        }
//        System.out.println();
//        for(int i=0;i<m;i++){
//            System.out.print(arr2[i]+" ");
//        }
//        System.out.println();
        merge(arr1,arr2,n,m);
        StringBuffer str=new StringBuffer();
        for(int i=0;i<n;i++){
            str.append(arr1[i]).append(" ");
        }
        for(int i=0;i<m;i++){
            str.append(arr2[i]).append(" ");
        }
        System.out.println(str);
        scanner.close();
    }
    public static void merge(int arr1[], int arr2[], int m, int n) {
        for (int i=n-1; i>=0; i--)
        {
            /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
            int j, last = arr1[m-1];
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];

            // If there was a greater element
            if (j != m-2 || last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;

            }
        }

    }
}

//4 5
//1 3 5 7
//0 2 6 8 9