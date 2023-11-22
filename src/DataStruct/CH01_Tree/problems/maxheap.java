package src.DataStruct.CH01_Tree.problems;

import src.DataStruct.CH01_Tree.utils.Heap;

import java.util.Arrays;

public class maxheap {
    public static void  main(String [] args){
        int [] nums = {8,9,7,1,4,3,5,2,6};

        Heap heap = new Heap(nums);

        System.out.println(Arrays.toString(heap.maxHeap));
    }
}
