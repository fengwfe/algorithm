package c1;

public class ArrayStack<E> {
    Object[] data = new Object[1];
    int size;
    public void push(E e){
        if(data.length == size){
            resize(size *  2);
        }
        data[size++] = e;
    }
    public E pop(){
        if(isEmpty()){
          return null;
        }
        if(size == data.length /  4){
            resize(data.length / 2);
        }
        return (E)data[--size];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void resize(int targetSize){
       Object[] newData = new Object[targetSize];
       int N = targetSize > data.length ? data.length : targetSize;
       for(int i = 0; i < N; i++){
           newData[i] = data[i];
       }
       data = newData;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
