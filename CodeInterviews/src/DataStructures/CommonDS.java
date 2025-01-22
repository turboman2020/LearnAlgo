package CodeInterviews.src.DataStructures;

import java.util.*;

public class CommonDS {
    public static void main(String [] args){

        List<Integer> list = Arrays.asList(4,3,5,6,7);

        // 栈的定义与操作
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.peek(); // 查看栈顶元素
//        stack.pop(); //栈顶元素出栈
//        stack.addAll(list);
//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
        //队列的定义与操作
//        Queue<Integer> qe = new LinkedList<>();
//        //在队头添加元素用add 或 offer 方法
//        qe.add(1);
//        qe.add(2);
//        qe.add(3);
//        qe.peek(); // 查看队头元素
//        while (!qe.isEmpty()){
//            System.out.println(qe.poll());
//        }
        // 双端队列(实现单调队列)
        Deque<Integer> dque = new LinkedList<>();
        dque.addLast(10);
        while (!dque.isEmpty() && 10 > dque.peekLast())
            dque.pollLast();
        dque.addLast(100);
        while (!dque.isEmpty() && 10 > dque.peekFirst())
            dque.pollFirst();
        while(!dque.isEmpty())
            System.out.println(dque.pollLast());
        //优先队列
        //比较器的lambda 表达式写法
//        PriorityQueue<Integer> pq1 = new PriorityQueue<>(10,(o1, o2) -> o2 - o1);
//        //比较器的写法2
//        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return  o2 - o1;
//            }
//        });
//
//        pq.offer(1);
//        pq.offer(2);
//        pq.offer(3);
//        pq.offer(4);
//        pq.peek();
//
//        while (!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }





//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            //返回 -1 ， 0， 1 分别表示o1 小于/等于/大于 o2，对应的o1排在o2之前，同位置，之后
//            public int compare(Integer o1, Integer o2) {
//                return o1 -  o2;
//            }
//        });
//
//
//        LinkedList<Integer> stack = new LinkedList<>();
//        Stack<Integer> stack2 = new Stack<>();
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>( new Comparator<>(){
//            @Override
//
//            public int compare(Integer o1, Integer o2) {
//                return o1 -  o2;
//            }
//        });
//
//        System.out.println(list.toString());

    }



}
