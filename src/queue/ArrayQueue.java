package queue;

public class ArrayQueue<T> {
    Object[] elementsArray;
    int size;
    int capacity;

    public ArrayQueue(){
        this.size = 0;
        this.capacity = 10;
        this.elementsArray = new Object[capacity];
    }

    public void EnQueue(T value){
        if (this.capacity == this.size)
            reSize();
        for (int i = size -1; i >= 0; i--)
            this.elementsArray[i+1] = this.elementsArray[i];
        this.elementsArray[0] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T DeQueue(){
        if (size == 0)
            throw new IllegalStateException("The queue is empty");
        T tempData = (T) this.elementsArray[size-1];
        this.elementsArray[size - 1] = null;
        size--;
        return tempData;
    }

    @SuppressWarnings("unchecked")
    public T front(){
        if (size == 0)
            throw new IllegalStateException("The queue is empty");
        return (T) this.elementsArray[size-1];

    }

    private void reSize() {
        Object[] tempArray = new Object[capacity *2];
        System.arraycopy(this.elementsArray, 0, tempArray, 0, size);
        this.elementsArray = tempArray;
    }

    public int size(){
        return this.size;
    }


}
