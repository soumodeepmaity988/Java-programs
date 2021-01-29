package com.company;

class TArray{
    private final int[] array;
    private int index=0;
    //Required properties and Constructor
    public TArray(int size){
        array =new int[size];
    }
    public synchronized void add(int a){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println(e);
        }
        array[index]=a;


        System.out.print(Thread.currentThread().getName()+" insert "+a+" in arr["+index+"]\n");
        index++;
    }
    public void print(){
        System.out.println();
        System.out.println("The array is: ");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

class WriteThread implements Runnable{
    //Required properties and Constructor
    int val;
    TArray tArray;
    Thread thread;
    String name;

    public WriteThread(String name,int val,TArray ta){
        this.tArray =ta;
        this.name=name;
        this.val=val;
        thread =new Thread(this,name);
        thread.start();
    }
    public void run(){
        for(int i=0;i<3;i++)
            tArray.add(i+val);
    }
}

class Multithreading_2{
    public static void main(String[] args){
        //Required code
        TArray targetArray=new TArray(6);
        targetArray.print();

        WriteThread writeThread1=new WriteThread("Thread-1 ",10,targetArray);
        WriteThread writeThread2=new WriteThread("Thread-2 ",100,targetArray);

        try{
            writeThread1.thread.join();
            writeThread2.thread.join();
        }catch(InterruptedException e){
            System.out.println(e);
        }
        targetArray.print();
    }
}