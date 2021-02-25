package com.company;

class Box{
    int length;
    int height;
    int width;
    Box(){
       this.length=0;
       this.height=0;
       this.width=0;
    }
    Box(int height){
        this.height=height;
    }
    Box(int length,int height,int width){
        this.length=length;
        this.height=height;
        this.width=width;
    }
    public void print(){
        System.out.println("length of the box is-> "+this.length);
        System.out.println("height of the box is-> "+this.height);
        System.out.println("width of the box is-> "+this.width);
        System.out.println("=====================================");
    }
}
class Main{
    public static void main(String[]args){
        Box b1=new Box();
        b1.length=12;
        b1.height=23;
        b1.width=11;
        Box b2=new Box(11);
        b2.length=10;
        b2.width=15;
        Box b3=new Box(3,2,6);
        b1.print();
        b2.print();
        b3.print();

    }
}