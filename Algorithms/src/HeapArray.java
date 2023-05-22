import java.util.PriorityQueue;

public class HeapArray {
    private int[] heap ;
    private int length ;

    // constructor to create heap
    public HeapArray(int size) {

        this.heap = new int[size+1];
        this.length = 0;
    }

    // heap peek
    public int peek(){
        return heap[1] ;
    }

    private void swap(int i, int j ){
        int temp ;
        temp = heap[i] ;
        heap[i] = heap[j];
        heap[j] =temp ;
    }

    // heapify method
    private void heapify(){
        for(int i = length; i>1 ; i=i/2){
            if(heap[i] > heap[i/2]) swap(i,i/2);
        }
    }

    public boolean insert(int ele) {
        length++;
        heap[length] = ele;
        heapify();
        return true;
    }

    public boolean delete(){
        heap[1] = heap[length];
        length--;
        heapify();;
        return true;
    }

    public static void main(String[] args) {

        var heap = new HeapArray(20);
        heap.insert(12);
        heap.insert(30);
        heap.insert(1);
        heap.insert(45);
        heap.insert(20);

        for(int i = 0; i<5;i++){
            System.out.println(heap.peek());
            heap.delete();
        }

        //PriorityQueue

    }
}
