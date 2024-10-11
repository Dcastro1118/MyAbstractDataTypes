package structures.stack;

public class ArrayStack<T> {
    Object[] elementsArray;
    int top;
    int capacity;

    public ArrayStack(){
        top = -1;
        this.capacity = 10;
        this.elementsArray = new Object[this.capacity];
    }

    public void push(T value){
        if ((top + 1) == capacity)
            reSize();
        this.top++;
        this.elementsArray[top] = value;
    }
    @SuppressWarnings("unchecked")
    public T pop(){
        if (isEmpty())
            throw new IllegalStateException("The structures.linked.list is empty");
        T returnedValue = (T) this.elementsArray[top];
        this.elementsArray[top] = null;
        top--;
        return returnedValue;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if (isEmpty())
            throw new IllegalStateException("The structures.linked.list is empty");
        return (T) this.elementsArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    private void reSize() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(this.elementsArray, 0, newArray, 0, top+1);
        this.elementsArray = newArray;
    }

}
