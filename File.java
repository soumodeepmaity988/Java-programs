package com.company;

import java.io.FileWriter;
import java.io.IOException;

class Main11{
    public static void main(String[]args)throws IOException{
        String str="Hello my name is Soumodeep maity";
        FileWriter fw=new FileWriter("output.txt");
        for(int i=0;i<str.length();i++){
            fw.write(str.charAt(i));
        }
    }
}
