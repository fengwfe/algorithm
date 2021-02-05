package com.fuwu.good.dataStructure;

/**
 * 链表实现队列
 * @param <E>
 */
public class LinkedListQueue<E> {
    Node<E> first;
    Node<E> last;
    int size;
    public void enqueue(E e){
        Node<E> oldLast = last;
        last = new Node<>(e);
        if(isEmpty()){
            first = last;
        }else{
            oldLast.next = last;
        }
        size++;
    }
    public E dequeue(){
        if(isEmpty()){
            return null;
        }
        E e = first.value;
        first = first.next;
        if(null == first){
            last = null;
        }
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
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
