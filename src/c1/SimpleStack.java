package c1;

public class SimpleStack {
    int[] data;
    int size;
    public SimpleStack(int capacity){
        this.data = new int[capacity];
    }
    public void push(int e){
        this.data[size++] = e;
    }
    public int pop(){
        return this.data[--size];
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
