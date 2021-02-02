package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node3{
    int data;
    Node3 left;
    Node3 right;
}

class Tree{
    public Node3 createRoot(int data){
        Node3 newNode=new Node3();
        newNode.data=data;
        newNode.left=null;
        newNode.right=null;
        return newNode;
    }
    public Node3 insertNode(Node3 head,int data){
        if(head==null){
            head=createRoot(data);
        }else{
            if(data<head.data){
                head.left=insertNode(head.left,data);
            }else{
                head.right=insertNode(head.right,data);
            }
        }
        return head;
    }
    public void printTree(Node3 head){
        if (head!=null){
                printTree(head.left);
                System.out.print(head.data+ " ");
                printTree(head.right);
        }
    }
    public void levelOrderTraversal(Node3 head){
        Queue<Node3> array=new LinkedList<>();
        array.add(head);
        while(!array.isEmpty()){
            Node3 temp=array.poll();
            if(temp!=null){
                System.out.print(temp.data+" ");
                array.add(temp.left);
                array.add(temp.right);
            }
        }
    }
}

class LevelOrderTraversal{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n=scanner.nextInt();
        Tree bst=new Tree();
        Node3 root=null;
        System.out.println("Enter the nodes: ");
        for(int i=0;i<n;i++){
            int data=scanner.nextInt();
            root=bst.insertNode(root,data);
        }
        bst.printTree(root);
        System.out.println();
        bst.levelOrderTraversal(root);
        scanner.close();
    }
}