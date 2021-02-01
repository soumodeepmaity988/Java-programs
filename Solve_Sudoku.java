package com.company;

import java.util.Scanner;

class Main2{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value of n and m");
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        System.out.println("Enter values of array elements: ");
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        System.out.println("The matrix is: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        solveSuduku(arr,0,0);
        scanner.close();
    }
    public static void solveSuduku(int[][]board,int i,int j){

        if(i==9){
            System.out.println("Solved sudoku is: ");
            display(board);
            return;
        }
        int ni=0;
        int nj=0;

        if(j==board[0].length-1){
            //System.out.println("=========================");
            //display(board);
            ni=i+1;
            nj=0;
        }else{
            ni=i;
            nj=j+1;
        }
        if(board[i][j]!=0){
            solveSuduku(board,ni,nj);
        }else{
            for(int po=1;po<=9;po++){
                if(isValid(board, i, j, po)){
                    board[i][j]=po;
                    solveSuduku(board,ni,nj);
                    board[i][j]=0;
                }
            }
        }

    }
    public static boolean isValid(int[][]board,int i,int j,int po){
        for(int x=0;x<board[0].length;x++){
            if(board[i][x]==po){
                return false;
            }
        }
        for(int x=0;x<board[0].length;x++){
            if(board[x][j]==po){
                return false;
            }
        }
        int si=(i/3)*3;
        int sj=(j/3)*3;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if(board[si+x][sj+y]==po){
                    return false;
                }
            }
        }
        return true;
    }
    public static void display(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}

//3 0 6 5 0 8 4 0 0
//5 2 0 0 0 0 0 0 0
//0 8 7 0 0 0 0 3 1
//0 0 3 0 1 0 0 8 0
//9 0 0 8 6 3 0 0 5
//0 5 0 0 9 0 6 0 0
//1 3 0 0 0 0 2 5 0
//0 0 0 0 0 0 0 7 4
//0 0 5 2 0 6 3 0 0

//3 1 6 5 7 8 4 9 2
//5 2 9 1 3 4 7 6 8
//4 8 7 6 2 9 5 3 1
//2 6 3 4 1 5 9 8 7
//9 7 4 8 6 3 1 2 5
//8 5 1 7 9 2 6 4 3
//1 3 8 9 4 7 2 5 6
//6 9 2 3 5 1 8 7 4
//7 4 5 2 8 6 3 1 9