package com.shivakumar.algorithms.dp.bitmask;

public class BitmaskSet {
    int set;
    final int size;
    BitmaskSet (int n){
        size = n;
    }
    public void display(){
        StringBuilder s = new StringBuilder("{ ");
        for(int i=0;i<size;i++){
            if((1<<i &set) >0){
                s.append(i+1+" ");
            }
        }
        s.append(" }");
        System.out.println(s);
    }

    public boolean add(int ele){
        if(ele>size)
            return false;
        set|= 1<<(ele-1);
        return true;
    }
    public boolean remove(int ele){
        if(ele>size)
            return false;
        if((1<<(ele-1) &set) >0)
            set^= 1<<(ele-1);
        return true;
    }

    public static void main(String[] args) {
        BitmaskSet set1 = new BitmaskSet(15);
        set1.display();
        set1.add(1);
        set1.add(2);
        set1.add(15);
        set1.display();
        set1.remove(2);
        set1.display();
    }
}
