package structures.linked.list.simple;

import structures.stack.Stack;

import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {

    private Node<T> head;

    public SimpleLinkedList() {
        this.head = null;
    }

    // --------------------Insert Operations--------------------//

    public void insertFirst(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.setNext(head);
            this.head = newNode;
        }
    }

    public void insertLast(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> tempNode = this.head;
            while (tempNode.getNext() != null)
                tempNode = tempNode.getNext();
            tempNode.setNext(newNode);
        }
    }

    public void insertAtIndex(T data, int index) {
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        int counter = 0;

        if (this.head == null)
            throw new IllegalStateException("The structures.linked.list must be initialized to do this operation");

        else if (index < 0 || index > getSize())
            throw new IndexOutOfBoundsException("The index is out of range");

        else if (index == 0)
            insertFirst(data);

        else if (index == getSize())
            insertLast(data);

        else {
            Node<T> tempNode = this.head;
            while (counter < index - 1) {
                tempNode = tempNode.getNext();
                counter++;
            }
            newNode.setNext(tempNode.getNext());
            tempNode.setNext(newNode);
        }
    }

    //---------------------------------Delete Operations--------------------------------------//
    public void deleteFirst(){
        if (this.head == null)
            throw new NoSuchElementException("No elements to remove from the structures.linked.list");
        else
            this.head = this.head.getNext();
    }
    public void deleteLast(){
        if (this.head == null)
            throw new NoSuchElementException("No elements to remove from the structures.linked.list");
        else if (this.head.getNext() == null)
            this.head = null;
        else{
            Node<T> tempNode = this.head;
            while(tempNode.getNext().getNext() != null)
                tempNode = tempNode.getNext();
            tempNode.setNext(null);
        }
    }

    public void deleteAtIndex(int index) {
        int counter = 0;
        if (index < 0 || getSize() <= index)
            throw new IndexOutOfBoundsException("The index you are trying to delete doesn't exists");

        if (index == 0)
            this.head = this.head.getNext();
        else if (index == getSize() - 1)
            deleteLast();
        else {
            Node<T> tempNode = this.head;
            while (counter < index - 1){
                tempNode = tempNode.getNext();
                counter++;
            }
            tempNode.setNext(tempNode.getNext().getNext());
        }
    }
    // --------------------------------Get Operations-----------------------------------------//

    public T getFirst(){
        if (this.head == null)
            throw new IndexOutOfBoundsException("The structures.linked.list is empty");
        return this.head.getData();
    }

    public T getLast(){
        if (this.head == null)
            throw new IndexOutOfBoundsException("The structures.linked.list is empty");
        Node<T> tempNode = this.head;
        for (int i = 1; i < getSize(); i++)
            tempNode = tempNode.getNext();
        return tempNode.getData();
    }

    public  T getAtIndex(int index) {
        if (this.head == null)
            throw new IndexOutOfBoundsException("The structures.linked.list is empty");
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


    // ----------------------------Other Operations------------------------//

    public boolean isEmpty(){
        return this.head == null;
    }


    public void reverseListWithStack(){
        Stack<T> stack = new Stack<>();
        Node<T> tempNode = this.head;
        for (int i = 0; i < getSize(); i++){
            stack.push(tempNode.getData());
            tempNode = tempNode.getNext();
        }
        this.head = null;
        for (int i = 0; i < getSize(); i++){
            insertLast(stack.pop());
        }
    }

    public void reverseList(){
        Node<T> prevNode = null;
        Node<T> currentNode = this.head;
        Node<T> nextNode = this.head.getNext();
        for (int i = 0; i < getSize() - 1; i++){  
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.getNext();
        }
        currentNode.setNext(prevNode);
        this.head = currentNode;
    }

    public void printList(Node<T> node) {
        if (node == null) {
            System.out.println("The structures.linked.list is empty");
            return; // Agrega un return para evitar que continúe ejecutándose
        }

        if (node.getNext() != null) {
            System.out.println(node.getData().toString());
            printList(node.getNext());
        } else {
            System.out.println(node.getData().toString());
        }
    }



    //---------------------------Set Operations------------------------------------//

    public void setFirst(T data){
        if (this.head == null)
            throw new IllegalStateException("The structures.linked.list must be initialized");
        this.head.setData(data);
    }

    public void setLast(T data){
        if (this.head == null)
            throw new IllegalStateException("The structures.linked.list must be initialized");
        Node<T> tempNode = this.head;
        for (int i = 1; i < getSize(); i++)
            tempNode = tempNode.getNext();
        tempNode.setData(data);
    }

    public void setAtIndex(T data, int index){
        if (this.head == null)
            throw new IllegalStateException("The structures.linked.list must be initialized");
        if (index < 0 || index >= getSize())
            throw new IndexOutOfBoundsException("The index is out of range");
        Node<T> tempNode = this.head;
        for (int i = 0; i < index;  i++)
            tempNode = tempNode.getNext();
        tempNode.setData(data);

    }


    // --------------------------List Size Operations------------------------------//

    public int getSize() {
        return this.head == null ? 0 : calculateSize();
    }

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
