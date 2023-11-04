package datastructures;

import java.util.Stack;

public class Stacks {

    private Node top;
    private int height;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }

    }

    public Stacks(int val){
        Node newNode = new Node(val);
        top = newNode;
        height = 1;

    }

    /**
     * Add data to front
     **/
    public void prependNode(int value){
        Node newValue = new Node(value);
        Node temp = top;
        if(height!=0){
            top=newValue;
            top.next = temp;
        }
        else{
            top = newValue;
        }
        height++;

    }

    public static void main(String[] args){
//        Stacks stack = new Stacks(1);

        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack.peek());
        System.out.println(stack.search(40));
        System.out.println(stack.pop());






    }


}
