import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DisjointSet {
    List <Integer> parent, rank, size ;

    public DisjointSet(int n){
        parent = new ArrayList<Integer>(n+1);
        rank =  new ArrayList<Integer>(Collections.nCopies(n+1,0));
        size = new ArrayList<Integer>(Collections.nCopies(n+1,1));
        for(int i =0; i<n+1;i++){
            parent.add(i);
        }
    }

    public int findParent(int u){
        if(parent.get(u).intValue() == u) return  u ;
        int p = findParent(parent.get(u));
        parent.set(u,p);
        return  p;
    }

    public void unionByRank(int u, int v){
        int pu, pv;

        pu = findParent(u);
        pv = findParent(v);

        if( pu == pv) return;
        if( rank.get(pu).intValue() > rank.get(pv).intValue()) {
            parent.set(v,pu);
        } else if(rank.get(pv).intValue() > rank.get(pu).intValue()){
            parent.set(u,pv);
        } else {
            parent.set(u,pv);
            rank.set(v, rank.get(v).intValue()+1);
        }
    }

    public void unionBySize(int u, int v){
        int pu, pv;
        pu = findParent(u);
        pv = findParent(v);

        if( pu == pv) return;

        if(size.get(pu).intValue() > size.get(pv).intValue()){
            size.set(pu, size.get(pu).intValue()+size.get(pv).intValue());
            parent.set(v,pu);
        }else{
            size.set(pv, size.get(pu).intValue()+size.get(pv).intValue());
            parent.set(u,pv);
        }

    }


    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7) ;
        DisjointSet ds2 = new DisjointSet(7) ;

        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        if (ds.findParent(3) == ds.findParent(7)) System.out.println("same parent");
        else System.out.println("Not same parent");
        ds.unionBySize(3,7);
        if (ds.findParent(3) == ds.findParent(7)) System.out.println("same parent");
        else System.out.println("Not same parent");

        System.out.println("\n----DS2----\n");

        ds2.unionByRank(1,2);
        ds2.unionByRank(2,3);
        ds2.unionByRank(4,5);
        ds2.unionByRank(6,7);
        ds2.unionByRank(5,6);
        if (ds2.findParent(3) == ds2.findParent(7)) System.out.println("same parent");
        else System.out.println("Not same parent");
        ds2.unionByRank(3,7);
        if (ds2.findParent(3) == ds2.findParent(7)) System.out.println("same parent");
        else System.out.println("Not same parent");
        System.out.println(ds.size);
        System.out.println(ds2.rank);
    }

    public static class ReverseSortArray {
        public static void main(String[] args) {
            int[] nums = new int[]{1,2,3,6,5};
            nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
            for(int i=0;i<nums.length;i++){
                System.out.println(nums[i]);
            }
        }
    }
}
