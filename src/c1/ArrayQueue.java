package c1;

public class ArrayQueue<E> {

    Object[] data = new Object[1];
    int first;
    int last;
    int size;
    public ArrayQueue(int capacity){
        data = new Object[capacity];
    }
    public void enqueue(E e){
//        if(size == data.length){
//            resize(data.length * 2);
//        }
        if(last < data.length){
            data[last] = e;
        }else{
            data[0] = e;
            last =  0;
        }
        last++;
        size++;
    }
    public E dequeue(){
        if(isEmpty()){
            return null;
        }
//        if(size == data.length / 4){
//            resize(data.length / 2);
//        }
        E e =null;
        if(first < data.length){
            e = (E)data[first];
            data[first] = null;
        }else{
            e = (E)data[0];
            data[0] = null;
            first = 0;
        }
        first++;
        size--;
        return e;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void resize(int targetSize){
        Object[] newData = new Object[targetSize];
        int i = 0;
        int start = first  == data.length ? 0  : first;
        while(i < size){
            newData[i] = data[start];
            start = start + 1 == data.length ? 0 : start + 1;
            i++;
        }
        data = newData;
        first = 0;
        last = size ;
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(7);
        queue.enqueue(11);
        queue.enqueue(22);
        queue.enqueue(33);
        queue.enqueue(44);
        queue.enqueue(55);
        queue.enqueue(66);
        queue.enqueue(77);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("==========================");
        queue.enqueue(88);
        queue.enqueue(99);
        queue.enqueue(100);
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }

    }
}
