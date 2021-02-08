import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        ArrayList<String> result=getMazePaths(1,1,n,m);
        System.out.println(result);
        scanner.close();
    }
    public static ArrayList<String> getMazePaths(int sr,int sc,int dr,int dc){
        if(sr==dr&&sc==dc){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> hpaths=new ArrayList<>();
        ArrayList<String> vpaths=new ArrayList<>();
        if(sc<dc){
            hpaths=getMazePaths(sr,sc+1,dr,dc);
        }
        if(sr<dr){
            vpaths=getMazePaths(sr+1,sc,dr,dc);
        }
        ArrayList<String> paths=new ArrayList<>();
        for(String hpath:hpaths){
            paths.add("h"+hpath);
        }
        for(String vpaht:vpaths){
            paths.add("v"+vpaht);
        }
        return paths;
    }
}