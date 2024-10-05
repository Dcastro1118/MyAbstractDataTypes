package list;

public class MyArrayList<T> {
    Object[] elementsArray;
    int size;
    int capacity;

    public MyArrayList(Class<T> t){
        this.capacity = 10;
        this.elementsArray = new Object[capacity];
        this.size = 0;
    }

    public void add(T value) {
        if (size == capacity)
            resize();
        elementsArray[size] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");
        return (T) this.elementsArray[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");

        for (int i = index; i < size - 1; i++)
            elementsArray[i] = elementsArray[i + 1];
        elementsArray[size - 1] = null;
        size--;
        }

    private void resize() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(this.elementsArray, 0, newArray, 0, size);
        this.elementsArray = newArray;
    }

    public boolean contains(T value){
        for (int i = 0; i < size; i++){
            if (this.elementsArray[i].equals(value))
                return true;
        }
        return false;
    }

    public void insertAt(int index, T value){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index out of range");
        if (size == capacity)
            resize();
        if (index == size)
            add(value);
        else {
            for (int i = size - 1; i >= index; i--)
                this.elementsArray[i + 1] = this.elementsArray[i];
            this.elementsArray[index] = value;
        }
    }

    public void set(int index, T value){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of range");
        this.elementsArray[index] = value;
    }


    public int size(){
        return size;
    }

    public void clear(){
        for (int i = 0; i < size; i++){
            this.elementsArray[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
