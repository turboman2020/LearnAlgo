package CodeInterviews.src.LinkList.Problem06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Solution01 {

    public static void main(String [] args){
        List<Node> linkList = new LinkedList<Node>() {{
            add(new Node(5, null));
            add(new Node(4, null));
            add(new Node(3, null));
            add(new Node(2, null));
            add(new Node(1, null));
        }};
        for (int i = 0; i + 1 < linkList.size(); i++) {
            linkList.get(i).next = linkList.get(i+1);
        }
        reverseLinkList2(linkList.get(0));

    }
    public static void reverseLinkList(Node head){
        //递归方法
        if(head == null) return ;
        if(head.getNext() != null) {
            reverseLinkList(head.next);

        }
        System.out.println(head.getValue());
    }

    public static void reverseLinkList2(Node head){
        //用栈数据结构
        Stack<Node> stack = new Stack<>();
        while (head != null){
            stack.add(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().value);
        }

    }
}
