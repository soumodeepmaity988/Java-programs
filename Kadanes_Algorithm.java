package com.company;

import java.util.*;
class Kadanes_Algorithm{
    public static List<Integer> list=new ArrayList<>();
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int n=scanner.nextInt();
        System.out.println("Enter the elements: ");
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("The array elements is: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int count=kadansAlgorithm(arr);
        System.out.println(count);
//         System.out.println("elements are: ");
//         for(int i=0;i<list.size();i++){
//             System.out.print(list.get(i)+" ");
//         }
//         System.out.println();
        scanner.close();
    }

    private static int kadansAlgorithm(int[] arr) {

        int n=arr.length;
        int meh=0;
        int msf=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            meh=meh+arr[i];
            if(meh<arr[i]){
                meh=arr[i];
            }
            if(msf<meh){
                msf=meh;
                //list.add(arr[i]);
            }
        }
        return msf;

    }
}
