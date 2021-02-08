package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Main8{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        String str =scanner.next();
        ArrayList<String> arrayList=getKPC(str);
        System.out.println(arrayList);
        scanner.close();
    }

    public static String[] codes={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str){
        if(str.length()==0){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch =str.charAt(0);
        String ros=str.substring(1);

        ArrayList<String> rres=getKPC(ros);
        ArrayList<String> mres=new ArrayList<>();

        String codeforch=codes[ch-'0'];
        for(int i=0;i<codeforch.length();i++){
            char chcode=codeforch.charAt(i);
            for(String rstr:rres){
                mres.add(chcode+rstr);
            }
        }
        return mres;
    }
}
