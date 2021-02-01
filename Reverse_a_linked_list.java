package com.company;

import java.util.Scanner;
class Node1 {
    int data;
    Node1 next;
    Node1(int data){
        this.data=data;
        this.next=null;
    }

}
class  LinkedList{
    public Node1 push(Node1 head, Node1 newNode){
        if(head==null){
            head=newNode;
        }else{
            Node1 temp=head;
            head=newNode;
            newNode.next=temp;
        }
        return head;
    }
    public Node1 reverseList(Node1 head){
        Node1 next=null;
        Node1 prev=null;
        Node1 current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return head;
    }
    public void printList(Node1 head){
        Node1 temp=head;
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
        Node1 head=null;
        //Node node=new Node(1);
        head=linkedList.push(head,new Node1(1));
        head=linkedList.push(head,new Node1(2));
        head=linkedList.push(head,new Node1(3));
        head=linkedList.push(head,new Node1(4));
        head=linkedList.push(head,new Node1(5));
        linkedList.printList(head);
        head=linkedList.reverseList(head);
        System.out.println();
        linkedList.printList(head);
        scanner.close();
    }
}