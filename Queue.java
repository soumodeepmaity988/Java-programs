package com.company;

import java.util.Scanner;

class Queue{
    int front,rear,capacity,size;
    int[]array;
    public Queue(int capacity){
        this.capacity=capacity;
        this.front=this.size=0;
        this.rear=capacity-1;
        this.array=new int[this.capacity];
    }
    boolean isEmpty(Queue queue){
        return (queue.size==0);
    }
    boolean isFull(Queue queue){
        return (queue.size==queue.capacity);
    }
    void Enqueue(int item){
       if(isFull(this)) {
           return ;
       }
       this.rear=(this.rear+1)%this.capacity;
       this.array[this.rear]=item;
       this.size=this.size+1;
       System.out.println(item+" is Enqueued in the Queue.");
    }
    void Dequeue(){
        if(isEmpty(this)){
            return ;
        }
        int item=this.array[this.front];
        this.front=(this.front+1)%this.capacity;
        this.size=this.size-1;
        System.out.println(item+" is Dequeued from the Queue.");
    }
    int front(Queue queue){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }
    int rear(Queue queue){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }
}
class QueueMain{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of elements in the Queue: ");
        int n=scanner.nextInt();
        System.out.println("Enter the elements in the queue: ");
        Queue queue=new Queue(n);
        for(int i=0;i<n;i++){
            int data=scanner.nextInt();
            queue.Enqueue(data);
        }
        System.out.println("Front element of the queue is: "+queue.front(queue));
        System.out.println("Rear element of the queue is: "+queue.rear(queue));
        queue.Dequeue();
        System.out.println("Front element of the queue is: "+queue.front(queue));
        System.out.println("Rear element of the queue is: "+queue.rear(queue));
        scanner.close();
    }
}