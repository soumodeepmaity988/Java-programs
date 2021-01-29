package com.company;

class Buffer{
    int value;
    boolean state=false;

    public synchronized void put(int val){
        if(state){
            try{
                wait();

            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        value=val;
        state=true;
        System.out.print("inserted value is "+val+" and ");
        notify();
    }
    public synchronized int get(){
        if(!state){
            try{
                Thread.sleep(500);
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("The value I get "+value+"----->Press ctrl+c to Stop ");
        state=false;
        notify();
        return value;
    }
}





 class Multithreading_3{
    public static void main(String[] args){

        Buffer buffer=new Buffer();
        new Producer(buffer);
        new Consumer(buffer);
    }
}
class Consumer implements Runnable{
    Buffer buffer;
    Consumer(Buffer buffer){
        //Required code
        this.buffer =buffer;
        new Thread(this,"consumer").start();
    }
    public void run(){

        int val;
        while(true){
            val= buffer.get();
        }
    }
}
class Producer implements Runnable{
    Buffer buffer;
    Producer(Buffer buffer){
        //Required code
        this.buffer =buffer;
        new Thread(this,"producer").start();
    }
    public void run(){
        //Required code
        int val=0;
        while(true){
            buffer.put(val++);
        }
    }
}