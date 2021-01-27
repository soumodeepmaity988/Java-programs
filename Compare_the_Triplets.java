package com.company;
import java.util.*;


class Compare_the_Triplets{


    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> c=new ArrayList<>();
        c.add(0);
        c.add(0);

        for(int i=0;i<3;i++){

            if(a.get(i)<b.get(i)){
                c.set(1,c.get(1)+1);
            }else if(a.get(i).equals(b.get(i))) {
                c.set(1, c.get(1));
                c.set(0, c.get(0));
            }else{
                    c.set(0,c.get(0)+1);
                }
            }
        return c;

    }

    public static void main(String[] args)  {
        Scanner scanner =new Scanner(System.in);
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        for(int i=0;i<3;i++){
            a.add(scanner.nextInt());
        }
        for(int i=0;i<3;i++){
            b.add(scanner.nextInt());
        }
        List<Integer> c=compareTriplets(a,b);
        for (Integer integer : c) {
            System.out.print(integer + " ");
        }
        System.out.println();
        scanner.close();
    }
}