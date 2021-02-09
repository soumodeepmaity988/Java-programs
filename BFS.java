package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph{
    private final int V;
    private final LinkedList<Integer>[] adj;

    Graph(int v){
        this.V=v;
        adj=new LinkedList[v];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
    }
    void addEdge(int v,int w){
        adj[v].add(w);
    }
    void BFS(int s){
        boolean[] visited=new boolean[V];
        LinkedList<Integer> queue=new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while(!queue.isEmpty()){
            s=queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i=adj[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }


    public static void main(String[]args){
        Scanner scanner =new Scanner(System.in);
        System.out.println("How many nodes in the graph: ");
        int n=scanner.nextInt();
        Graph graph=new Graph(n);
        System.out.println("Enter how many edges: ");
        int m=scanner.nextInt();
        System.out.println("Enter the edges: ");
        for(int i=0;i<m;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            graph.addEdge(x,y);
        }
        System.out.println("Enter the starting vertex: ");
        graph.BFS(scanner.nextInt());
        scanner.close();
    }
}