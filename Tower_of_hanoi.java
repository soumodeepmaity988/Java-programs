package com.company;

import java.util.Scanner;

class Main6{
    public static void main(String[]args){
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int t1d=scanner.nextInt();
        int t2d=scanner.nextInt();
        int t3d=scanner.nextInt();
        tower_of_hanoi(n,t1d,t3d,t2d);
        scanner.close();
    }
    public static void tower_of_hanoi(int n,int t1id,int t2id,int t3id){
        if(n==0){
            return ;
        }
        tower_of_hanoi(n-1,t1id,t3id,t2id);
        System.out.println(n+" [ "+t1id+" -> "+t2id+" ]");
        tower_of_hanoi(n-1,t3id,t2id,t1id);
    }
}