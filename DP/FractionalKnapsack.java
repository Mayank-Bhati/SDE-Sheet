package DP;

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] arr = {new Item(60,10),new Item(100,20), new Item(120,30)};
        System.out.println(fractionalKnapsack(50,arr,arr.length));
    }
    static double fractionalKnapsack(int W, Item arr[], int n) {
        double out = 0;
        MyComparator mc = new MyComparator();
        Arrays.sort(arr,mc);
        for(Item i : arr){
            if(i.weight <= W){
                out += i.value;
                W -= i.weight;
            }
            else if(W > 0){
                out += ((double) W/i.weight)*(i.value);
                W = 0;
            }
            else
                return out;
        }
        return out;
    }
    static class MyComparator implements Comparator<Item>{

        @Override
        public int compare(Item o1, Item o2) {
            double r1 = (double) o1.value / (double) o1.weight;
            double r2 = (double) o2.value / (double) o2.weight;
            if(r1 < r2)
                return 1;
            else if(r1 > r2)
                return -1;
            else
                return 0;
        }
    }
   static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
}
