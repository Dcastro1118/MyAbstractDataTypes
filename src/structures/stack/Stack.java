package structures.stack;

public class Stack<T> {

    private Node<T> top;
    private int size = 0;

    public void push(T data) {
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNext(this.top);
        this.top = newNode;
        size++;

    }

    public T pop() {
        if (this.top == null)
            throw new IllegalStateException("Stack is empty");
        Node<T> deletedNode = this.top;
        this.top = this.top.getNext();
        size--;
        return deletedNode.getData();
    }

    public T peek() {
        if (this.top == null)
            throw new IllegalStateException("Stack is empty");
        return this.top.getData();
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int getSize() {
        return size;
    }
}