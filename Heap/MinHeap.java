package Heap;
import java.util.ArrayList;
public class MinHeap<T extends Comparable<T>> {
    
    private ArrayList<T> list;

    public MinHeap(){
        list = new ArrayList<>();
    }

    public int parent(int index){
        return (index - 1)/2;
    }

    public int left(int index){
        return index * 2 + 1;
    }

    public int right(int index){
        return index * 2 + 2;
    }

    public void swap(int first,int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public void insert(T value){
        list.add(value);
        upHeap(list.size()-1);
    }

    public void upHeap(int index){
        if(index == 0){
            return;
        }
        int p = parent(index);

        if(list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
            upHeap(p);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Trying to remove in Empty list");
        }

        T temp = list.get(0);
        T last = list.remove(list.size()-1);
       if(!list.isEmpty()){
        list.set(0,last);
        downHeap(0);
       }
        return temp;
    }
    public void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if(list.size() > left && list.get(min).compareTo(list.get(left))>0){
            min = left;
        }
        if(list.size() > right && list.get(min).compareTo(list.get(right))>0){
            min = right;
        }
        if(min!=index){
            swap(index,min);
            downHeap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }

        return data;
    }
}

/*
import Heap.MinHeap;
import java.util.ArrayList;

 class Main {
    public static void main(String[] args) throws Exception{
        MinHeap<Integer> heap = new MinHeap<>();

        heap.insert(10);
        heap.insert(100);
        heap.insert(89);
        heap.insert(43);
        heap.insert(1000);

        ArrayList data = heap.heapSort();
        System.out.println(data);
    }
}
*/
