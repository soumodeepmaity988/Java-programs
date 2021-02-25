package com.company;

class MyThread implements Runnable{
    @Override
    public void run() {
        for(int i=5;i>0;i--){
            System.out.println(Thread.currentThread().getName()+" --> "+i);
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class Main{
    public static void main(String[]args) throws InterruptedException {
        MyThread MT=new MyThread();
        Thread t1=new Thread(MT);
        Thread t2=new Thread(MT);
        Thread t3=new Thread(MT);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("t1---"+t1.isAlive());
        System.out.println("t2---"+t2.isAlive());
        System.out.println("t3---"+t3.isAlive());
        t1.join();
    }
}