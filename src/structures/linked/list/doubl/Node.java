package structures.linked.list.doubl;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }
}