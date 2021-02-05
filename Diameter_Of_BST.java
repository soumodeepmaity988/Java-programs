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
    public Node createNode(int data){
        return new Node(data);
    }
    public Node insertNode(Node root,int data){
        if(root==null){
            return createNode(data);
        }else{
            if(data<root.data){
                root.left=insertNode(root.left,data);
            }else{
                root.right=insertNode(root.right,data);
            }
        }
        return root;
    }
    //    public int height(Node node){
//        if(node==null){
//            return -1;
//        }
//        int lh=height(node.left);
//        int rh=height(node.right);
//        int th=Math.max(lh,rh)+1;
//        return th;
//    }
    public int solve(Node root,Res res){
        if(root==null){
            return 0;
        }else{
            int l=solve(root.left,res);
            int r= solve(root.right,res);
            int temp=Math.max(l,r)+1;
            int ans=Math.max(temp,1+l+r);
            res.result=Math.max(res.result,ans);
            return temp;
        }
    }
    //    public  int diameter(Node node){
//        if(node==null){
//            return 0;
//        }
//        int ld=diameter(node.left);
//        int rd=diameter(node.right);
//        int f=height(node.left)+height(node.right)+2;
//        int dia=Math.max(f,Math.max(ld,rd));
//        return dia;
//    }
    public void display(Node head){
        if(head!=null){
            display(head.left);
            System.out.print(head.data+" ");
            display(head.right);
        }
    }
}
class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of nodes in a tree: ");
        int n=scanner.nextInt();
        Tree tree=new Tree();
        Node head=null;
        System.out.println("Enter the numbers: ");
        for(int i=0;i<n;i++){
            int data=scanner.nextInt();
            head=tree.insertNode(head,data);
        }
        tree.display(head);
        System.out.println();
        Res res=new Res();
        int height=tree.solve(head,res);
        System.out.println("Diameter of the tree is: "+res.result);
        scanner.close();
    }
}
class Res{
    int result=Integer.MIN_VALUE;
}