package com.company;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node4{
    int data;
    Node4 left;
    Node4 right;
}

class Tree4{
    public Node4 createRoot(int data){
        Node4 newNode=new Node4();
        newNode.data=data;
        newNode.left=null;
        newNode.right=null;
        return newNode;
    }
    public Node4 insertNode(Node4 head,int data){
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
    public void printTree(Node4 head){
        if (head!=null){
            printTree(head.left);
            System.out.print(head.data+ " ");
            printTree(head.right);
        }
    }
    Queue<Node4> array=new LinkedList<>();
    Stack<Node4> stack=new Stack<>();
    ArrayList<Integer> arrayList=new ArrayList<>();
    public void levelOrderTraversal(Node4 head){
        array.add(head);
        while(!array.isEmpty()){
            Node4 temp=array.poll();
            if(temp!=null){
                //System.out.print(temp.data+" ");
                stack.push(temp);
                array.add(temp.right);
                array.add(temp.left);
            }
        }
        while(!stack.isEmpty()){
            arrayList.add(stack.pop().data);
        }
    }
}

class LevelOrderTraversal4{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n=scanner.nextInt();
        Tree4 bst=new Tree4();
        Node4 root=null;
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