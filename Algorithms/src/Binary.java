import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.Function;

public class Binary {
    static int max = 5;

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> h1 = new LinkedHashMap<>(max,0.75f, true){
            @Override
            protected boolean removeEldestEntry(final Map.Entry<Integer,Integer> eldest){

                return size() >= max;
            }
        };


        LinkedHashSet<Integer> h =  new LinkedHashSet<>();

        h.add(1);
        h.add(2);
        System.out.println(h);
        h.add(3);
        System.out.println(h);
        System.out.println(h.iterator().next());
    }
}
