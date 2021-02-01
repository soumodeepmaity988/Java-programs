package com.company;
import java.util.Scanner;
class Node{
    int data;
    Node left;
    Node right;
}
class BST{
    public Node createNode(int data){
        Node node=new Node();
        node.data=data;
        node.left=null;
        node.right=null;
        return node;
    }
    public Node insert_data(Node root,int data){
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
    public int height(Node root){
        if(root==null){
            return 0;
        }else{
            return Math.max(1+height(root.left),1+height(root.right));
        }
    }
    public void inorderTraversal(Node root){
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
        Node root=null;
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