package stack;

public class ArrayStack<T> {
    Object[] elementsArray;
    int size;
    int capacity;

    public ArrayStack(){
        this.capacity = 10;
        this.size = 0;
        this.elementsArray = new Object[this.capacity];
    }

    public void push(T value){
        if (size == capacity)
            reSize();
        this.elementsArray[size] = value;
    }
    @SuppressWarnings("unchecked")
    public T pop(){
        T returnedValue = (T) this.elementsArray[size - 1];
        this.elementsArray[size - 1] = null;
        return returnedValue;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) this.elementsArray[size - 1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void reSize() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(this.elementsArray, 0, newArray, 0, size);
        this.elementsArray = newArray;
    }

}
