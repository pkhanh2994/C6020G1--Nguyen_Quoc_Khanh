package listinjava.bai_tap;

import java.util.Arrays;

public class MyList1<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList1() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList1(int capacity) {
        elements = new Object[capacity];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = element;
    }

    public void addIndex(int index, E element) {
        checkIndex(index);
        ensureCapa();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
            elements[index] = element;
            size++;

    }

    public E remove(int index) {
        checkIndex(index);
        E element = (E) elements[index];
        for (int j = index; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    public int size() {
        return this.size;
    }

    public E[] clone() {
        E[] temp = (E[]) (new Object[size]);
        temp = (E[]) Arrays.copyOf(elements, temp.length);
        elements = temp;
        return (E[]) temp;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i]))
                return i;
        }
        return -1;
    }

    public void ensureCapacity(int mintCapacity) {
        if (mintCapacity < elements.length) {
            int newSize1 = mintCapacity;
            elements = Arrays.copyOf(elements, newSize1);
        }
    }
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }


}



