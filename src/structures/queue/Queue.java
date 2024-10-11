package structures.queue;

public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    //---------------------------------------Add an element to the Queue-------------------------------//

    public void enQueue (T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNext(null);
        if (this.tail == null) {
            this.tail = newNode;
            this.head = newNode;
            size++;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
            size++;

        }

    }
    //--------------------------------Get and remove the last element-----------------------------//

    public T deQueue(){
        if (this.head == null)
            throw new IllegalStateException("The structures.queue is empty");
        else{
            Node <T> tempNode = this.head;
            Node <T> returnNode;
            while (tempNode.getNext().getNext() != null)
                tempNode = tempNode.getNext();
            returnNode = tempNode.getNext();
            tempNode.setNext(null);
            size--;
            return returnNode.getData();
        }
    }

    //-----------------------------------Get the first element----------------------------//

    public T front(){
        if (this.tail == null)
            throw new IllegalStateException("The structures.linked.list is empty");
        return this.tail.getData();
    }

    //-----------------------------------Return the size------------------------------------------//

    public int getSize(){
        return this.size;
    }

}
