package com.company;

class CounterThread implements Runnable{
    int COUNT =0;
    Thread thread;
    private boolean running=true;

    public CounterThread(int p){
        thread =new Thread(this);
        thread.setPriority(p);
    }
    public void run(){
        while(running) COUNT++;
    }
    public void start(){
        thread.start();
        System.out.print(thread);
        System.out.println();
    }
    public void stop(){
        running=false;
        thread.stop();
        if(thread.getName().equals("Thread-0")){
            System.out.println("Stopping of counterThread1--> "+ thread);
        }else if (thread.getName().equals("Thread-1")){
            System.out.println("Stopping of counterThread2--> "+ thread);
        }else{
            System.out.println("Stopping of counterThread3--> "+ thread);
        }

    }
}

public class Multithreading_1{
    public static void main(String[] args){
        CounterThread counterThread1=new CounterThread(1);
        CounterThread counterThread2=new CounterThread(5);
        CounterThread counterThread3=new CounterThread(9);

        System.out.print("Starting of counterThread1--> ");
        counterThread1.start();
        System.out.print("Starting of counterThread2--> ");
        counterThread2.start();
        System.out.print("Starting of counterThread3--> ");
        counterThread3.start();
        System.out.println();

        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println(e);
        }

        counterThread1.stop();
        counterThread2.stop();
        counterThread3.stop();

        System.out.println("\ncount FOR counterThread1: "+counterThread1.COUNT);

        System.out.println("count FOR counterThread2: "+counterThread2.COUNT);

        System.out.println("count FOR counterThread3: "+counterThread3.COUNT);


        double total= counterThread1.COUNT + counterThread2.COUNT + counterThread3.COUNT;

        double per1=(counterThread1.COUNT /total)*100;

        double per2=(counterThread2.COUNT /total)*100;

        double per3=(counterThread3.COUNT /total)*100;



        System.out.println("\nUtilization of cpu for counterThread1: "+per1);

        System.out.println("Utilization of cpu for counterThread2: "+per2);

        System.out.println("Utilization of cpu for counterThread3: "+per3);
    }
}


