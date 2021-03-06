import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class Tree{
    public Node insertNode(Node head,int data){
        if(head==null){
            return new Node(data);
        }
        if(data<head.data){
            head.left=insertNode(head.left,data);
        }else{
            head.right=insertNode(head.right,data);
        }
        return head;
    }
    public void display(Node head){
        if(head!=null){
            display(head.left);
            System.out.print(head.data+" ");
            display(head.right);
        }
    }
    public int level=0;
    public void leftView(Node head,int orderLevel){
        if(head==null){
            return;
        }
        if(level<orderLevel){
            System.out.print(head.data+" ");
            level=orderLevel;
        }
        leftView(head.left,orderLevel+1);
        leftView(head.right,orderLevel+1);
    }
}
class Main{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter how many nodes you want to enter: ");
        int n=scanner.nextInt();
        Tree tree=new Tree();
        Node head=null;
        System.out.println("Enter the numbers: ");
        for(int i=0;i<n;i++){
            int data=scanner.nextInt();
            head=tree.insertNode(head,data);
        }
        System.out.println("InorderTraversal is: ");
        tree.display(head);
        System.out.println();
        System.out.println("Left view of the tree is: ");
        tree.leftView(head,1);
        scanner.close();
    }
}