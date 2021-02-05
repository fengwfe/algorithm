package com.fuwu.good.dataStructure;

/**
 * 链表实现Stack
 * @param <E>
 */
public class LinkedListStack<E> {
    Node<E> first;
    int size = 0;

    public void push(E e){
        Node<E> oldFirst = first;
        first = new Node<>(e);
        first.next = oldFirst;
        size++;

    }
    public E pop(){
        if(isEmpty()){
            return null;
        }
        E e = first.value;
        first = first.next;
        size--;
        return e;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
