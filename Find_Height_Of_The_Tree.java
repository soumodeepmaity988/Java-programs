package com.company;
import java.util.Scanner;
class Node2{
    int data;
    Node2 left;
    Node2 right;
}
class BST{
    public Node2 createNode(int data){
        Node2 node=new Node2();
        node.data=data;
        node.left=null;
        node.right=null;
        return node;
    }
    public Node2 insert_data(Node2 root,int data){
        if(root==null){
            return root=createNode(data);
        }
        if(data<root.data){
            root.left=insert_data(root.left,data);
        }else{
            root.right=insert_data(root.right,data);
        }
        return root;
    }
    public int height(Node2 root){
        if(root==null){
            return 0;
        }else{
            return Math.max(1+height(root.left),1+height(root.right));
        }
    }
    public void inorderTraversal(Node2 root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
        }

    }
}
class Main1{
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n=scanner.nextInt();
        BST bst=new BST();
        Node2 root=null;
        System.out.println("Enter the nodes: ");
        for(int i=0;i<n;i++){
            int data=scanner.nextInt();
            root=bst.insert_data(root,data);
        }
        bst.inorderTraversal(root);
        System.out.println();
        assert root != null;
        int result=bst.height(root);
        System.out.println("The height of the tree is "+result);
        scanner.close();
    }
}