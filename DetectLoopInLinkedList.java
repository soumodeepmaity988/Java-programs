package com.company;

import java.util.Scanner;


class Node{
    int data;
    Node next;
}
class LinkedList1{
    public Node createNode(int data){
        Node node=new Node();
        node.data=data;
        node.next=null;
        return node;
    }
    public Node pushNode(int data,Node head){

        if(head==null){
            head=createNode(data);
        }else{
            Node newNode=createNode(data);
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
        return head;
    }
    public int detectLoop(Node head){
        Node p=head,q=head;
        int r=0;
        Node temp=head;
        while(temp.next!=null){
            System.out.println(temp.data);
            if(p.next.next!=null){
                p=p.next.next;
            }else{
                break;
            }
            q= q.next;
            temp=temp.next;
//            System.out.println("====");
//            System.out.println("p.data="+p.data);
//            System.out.println("q.data="+q.data);
//            System.out.println("====");
            if(p.data==q.data){
                r=1;
                break;
            }
        }
        displayTheStartingNodeOfLoop(p,head);
        return r;
    }
    public void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public Node createLoop(Node head,int num){
        Node address;
        Node temp=head;
        for(int i=0;i<num-1;i++){
            temp=temp.next;
        }
        address=temp;
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=address;
        return head;
    }
    public void displayTheStartingNodeOfLoop(Node p,Node head){
        Node q=head;
        do {
            q = q.next;
            p = p.next;
        } while (p.data != q.data);
        System.out.println("Starting Node data of the loop is: "+p.data);
    }
}
class DetectLoopInLinkedList{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of nodes in linkedList: ");
        int n=scanner.nextInt();
        LinkedList1 linkedlist1=new LinkedList1();
        Node head=null;
        for(int i=0;i<n;i++){
            int num=scanner.nextInt();
            head=linkedlist1.pushNode(num,head);
        }
        linkedlist1.display(head);
        System.out.println("Enter the position to create loop: ");
        int pos=scanner.nextInt();
        head=linkedlist1.createLoop(head,pos);
        int result=linkedlist1.detectLoop(head);
        if(result==1){
            System.out.println("The loop is present");
        }else{
            System.out.println("The loop is not present");
        }
        scanner.close();
    }
}