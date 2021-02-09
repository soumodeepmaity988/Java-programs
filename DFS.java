package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph{
    private final int V;
    private final LinkedList<Integer> adj[];
    Graph(int v){
        this.V=v;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
    }
    public void DFSUtil(int v,boolean[] visited){
        visited[v]=true;
        System.out.println(v+" ");
        Iterator<Integer> list=adj[v].listIterator();
        while(list.hasNext()){
            int n=list.next();{
                if(!visited[n]){
                    visited[n]=true;
                    DFSUtil(n,visited);
                }
            }
        }
    }
    public void DFS(int v){
        boolean[] visited =new boolean[V];
        DFSUtil(v,visited);
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
        graph.DFS(scanner.nextInt());
        scanner.close();
    }
}