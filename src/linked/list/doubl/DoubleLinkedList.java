package linked.list.doubl;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;


    //----------------------------------Insert Operations--------------------------------------//

    public void insertFirst(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNext(null);
        newNode.setPrevious(null);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }
    }

    public void insertLast(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNext(null);
        newNode.setPrevious(null);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }


    public void insertAtIndex(T data, int index){
       int size = getSize();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of range");

        if (index == 0) {
            insertFirst(data);
        } else if (index == size) {
            insertLast(data);
        } else{
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNext(null);
        newNode.setPrevious(null);
        Node<T> tempNode = this.head;
        for (int i = 1; i < index; i ++)
            tempNode = tempNode.getNext();
        tempNode.getNext().setPrevious(newNode);
        newNode.setNext(tempNode.getNext());
        newNode.setPrevious(tempNode);
        tempNode.setNext(newNode);
    }
}
    //--------------------------------------- Delete Operations----------------------------------//

    public void deleteFirst(){
        if (this.head == null)
            throw new IllegalStateException("The list is empty");
        this.head = this.head.getNext();
        this.head.setPrevious(null);

        if (this.head != null) {
            this.head.setPrevious(null);
        } else {
            this.tail = null;
        }
    }

    public void deleteLast() {
        if (this.head == null)
            throw new IllegalStateException("the list is empty");
        if (this.tail.getPrevious() == null) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
        }
    }

    public void deleteAtIndex(int index) {
        int size = getSize();
        if (this.head == null)
            throw new IllegalStateException("The list is empty");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");
        Node<T> tempNode = this.head;
        if (index == 0)
            deleteFirst();
        else if (index == size - 1)
            deleteLast();
        else {
            for (int i = 0; i < index; i++)
                tempNode = tempNode.getNext();
            tempNode.getPrevious().setNext(tempNode.getNext());
            tempNode.getNext().setPrevious(tempNode.getPrevious());
        }
    }

    // --------------------------------Get Operations-----------------------------------------//

    public T getFirst(){
        if (this.head == null)
            throw new IndexOutOfBoundsException("The list is empty");
        return this.head.getData();
    }

    public T getLast(){
        if (this.head == null)
            throw new IndexOutOfBoundsException("The list is empty");
        return this.tail.getData();
    }

    public  T getAtIndex(int index) {
        if (this.head == null)
            throw new IndexOutOfBoundsException("The list is empty");
        if (index < 0 || index >= getSize())
            throw new IndexOutOfBoundsException("The index is out of range");
        Node<T> tempNode = this.head;
        if (index == 0)
            return getFirst();
        else if (index == getSize() - 1)
            return getLast();
        else {
            int counter = 0;
            while (counter < index) {
                tempNode = tempNode.getNext();
                counter++;
            }
        }
        return tempNode.getData();
    }

    //---------------------------Set Operations------------------------------------//

    public void setFirst(T data){
        if (this.head == null)
            throw new IllegalStateException("The list must be initialized");
        this.head.setData(data);
    }

    public void setLast(T data){
        if (this.head == null)
            throw new IllegalStateException("The list must be initialized");
        Node<T> tempNode = this.head;
        for (int i = 1; i < getSize(); i++)
            tempNode = tempNode.getNext();
        tempNode.setData(data);
    }

    public void setAtIndex(T data, int index){
        if (this.head == null)
            throw new IllegalStateException("The list must be initialized");
        if (index < 0 || index >= getSize())
            throw new IndexOutOfBoundsException("The index is out of range");
        Node<T> tempNode = this.head;
        for (int i = 0; i < index;  i++)
            tempNode = tempNode.getNext();
        tempNode.setData(data);

    }
    // ----------------------------Other Operations------------------------//

    public boolean isEmpty(){
        return this.head == null;
    }

    private int getSize() {
        return this.head == null ? 0 : calculateSize();
    }

    // ----------------------------Size Operations------------------------//
    private int calculateSize() {
        Node<T> tempNode = this.head;
        int counter = 1;
        while (tempNode.getNext() != null){
            tempNode = tempNode.getNext();
            counter++;
        }
        return counter;
    }


}
