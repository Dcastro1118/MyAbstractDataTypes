package structures.set;

public class ArraySet<T> {

    private Object[] elementsArray;
    private int size;
    private int capacity;

    public ArraySet(){
        capacity = 10;
        this.elementsArray = new Object[capacity];
        this.size = 0;
    }

    public boolean isUnique(T value){
        for(Object element : this.elementsArray){
            if (element.equals(value))
                return false;
        }
        return true;
    }

    public boolean add(T value){
        if (isUnique(value)) {
            if (this.capacity == this.size)
                reSize();
            this.elementsArray[size] = value;
            size++;
            return true;
        }
        return false;
    }


    public boolean remove(T value){
        if (size == 0)
            throw new IllegalStateException("The structures.queue is empty");
        for (int i = 0; i < size; i++) {
            if (this.elementsArray[i].equals(value)) {
                this.elementsArray[i] = this.elementsArray[size - 1];
                this.elementsArray[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
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
