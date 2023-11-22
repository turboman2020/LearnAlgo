package src.DataStruct.CH01_Tree.utils;

public class Heap {
    public int [] maxHeap;
    int heapSize;

    public Heap(int [] heap){
        maxHeap = heap;
        heapSize = maxHeap.length;

        //堆化操作
        shiftDown(maxHeap);

    }

    public void swap(int[] heap, int m, int n){
        if (m > heap.length || n > heap.length) return ;
        int temp = heap[m];
        heap[m] = heap[n];
        heap[n] = temp;
    }
    public void shiftDown(int [] heap){

        int index = 0;

        while(index  < heap.length / 2){


            int p = index;

            int left = left(index);
            if( left < heap.length && heap[left] > heap[p])
                p = left;

            int right =right(index);
            if( right < heap.length && heap[right] > heap[p])
                p = right;

            swap(heap, index, p);
            index ++;
        }

    }
    public int left(int node){
        return 2 * node + 1;
    }

    public int right(int node){
        return 2 * node + 2;
    }

    public int parent(int node){
        return (node - 1) / 2;
    }


    //插入结点

    public void insertNode(int [] heap, int node){

    }
}
