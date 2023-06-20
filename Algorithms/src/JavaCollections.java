import java.util.*;

public class JavaCollections {

    /*

    A framework is a set of pre-written code and guidelines that help developers
    structure and organize their code in a consistent and efficient manner. Frameworks
    provide a basic structure for a specific type of application or programming task,
    and can include modules or libraries for common functionality, such as database access,
    user authentication, and UI elements.

    Before the Collection Framework(or before JDK 1.2) was introduced,
    the standard methods for grouping Java objects (or collections) were
    Arrays or Vectors, or Hashtables. All of these collections had no
    common interface. So it was  difficult for the users to remember
    all the different methods, syntax, and constructors present in
    every collection class Thus Collection was introduced.

    Collection can be thought of as a group of objects arranged in the particular manner.

    Collections Framework :



                          Colectione (Interface)
                           Extends
    |-------------------------|-----------------------------|
    List                     Queue                         Set
    (Interface)             (Interface)                 (Interface)
    |                         |
    |- Arraylist (C)          |- Priority Queue (c)
    | (Implements List)       |  (Implements Queue)
    |                         |
    |- Linked List (C)        |- Deque (I)
    |  (Implements List)        (extends Queue) ---|
    |                                              |
    |- Vectors (C)  (extends) <-- Stack (C)        |
     (Implements List)                         Array Deque
                                              (Implements Deque)






     */



    public static void List(){

    }

    public static void queue(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        System.out.println(q);
        int head = q.poll();
        System.out.println("head: "+ head);
        System.out.println(q);
    }

    public static void Map(){
        //iterating trough hash map
        // reference: https://www.youtube.com/watch?v=TCn5oyhipjs&t=515s

        Map<Integer,String> hMap = new HashMap<Integer,String>();
        hMap.put(1,"a");
        hMap.put(2,"b");
        hMap.put(3,"c");
        hMap.put(4,"d");

        // accesing key value pair
        // method -1, using etry set iterator
        Iterator<Map.Entry<Integer,String>> itr = hMap.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<Integer,String> entry = itr.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // method2 using keyset

        Iterator<Integer> itr2 = hMap.keySet().stream().iterator();

        while (itr2.hasNext()){
            Integer key = itr2.next();
            System.out.println( key + " " +hMap.get(key));
        }

        // method-3 using for each loop on etry set
        for ( Map.Entry<Integer,String> entry:hMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        // method-4 using lambda expression
        hMap.forEach((key,value)->{
            System.out.println( key + " " +value);
        });

        //method-5 loop using stream API
        hMap.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });

        // more details on streaming: https://www.baeldung.com/java-8-streams-introduction

    }

    public static void vector(){

    }


    public static void main(String[] args) {

        //Map();
        queue();
    }
}
