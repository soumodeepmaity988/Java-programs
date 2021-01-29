package com.company;

import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }

}
class  LinkedList{
    public Node push(Node head,Node newNode){
        if(head==null){
            head=newNode;
        }else{
            Node temp=head;
            head=newNode;
            newNode.next=temp;
        }
        return head;
    }
    public Node reverseList(Node head){
        Node next=null;
        Node prev=null;
        Node current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return head;
    }
    public void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}

class Reverse_a_linked_list{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        LinkedList linkedList=new LinkedList();
        Node head=null;
        //Node node=new Node(1);
        head=linkedList.push(head,new Node(1));
        head=linkedList.push(head,new Node(2));
        head=linkedList.push(head,new Node(3));
        head=linkedList.push(head,new Node(4));
        head=linkedList.push(head,new Node(5));
        linkedList.printList(head);
        head=linkedList.reverseList(head);
        System.out.println();
        linkedList.printList(head);
        scanner.close();
    }
}