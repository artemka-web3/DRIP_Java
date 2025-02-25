package drip;

import java.util.Arrays;

public class DynamicLongArrayImpl implements DynamicLongArray {

    private long[] array;
    private int size;

    public DynamicLongArrayImpl() {
        array = new long[10];  // Инициализация начального размера
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseCapacity() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public boolean add(int e) {
        // Проверяем, нужно ли увеличивать размер массива
        if (size == array.length) {
            increaseCapacity();
        }

        array[size++] = e;  // Добавляем элемент в конец массива
        return true;
    }

    @Override
    public boolean containsAll(DynamicLongArray c) {
        return false;
    }

    @Override
    public boolean addAll(DynamicLongArray c) {
        return false;
    }

    @Override
    public boolean addAll(int index, DynamicLongArray c) {
        return false;
    }

    @Override
    public boolean removeAll(DynamicLongArray c) {
        return false;
    }

    @Override
    public boolean retainAll(DynamicLongArray c) {
        return false;
    }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
        return (int) array[index];
    }

    @Override
    public int set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }
        int oldValue = (int) array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }

        // Проверяем, нужно ли увеличивать размер массива
        if (size == array.length) {
            increaseCapacity();
        }

        // Сдвигаем элементы вправо, начиная с конца массива
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
        size++;
    }


    private void decreaseCapacity() {
        array = Arrays.copyOf(array, array.length / 2);
    }

    @Override
    public long remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
        }

        long removedElement = array[index];
        for(int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;

        if (size <= array.length / 4) {
            decreaseCapacity();
        }

        return removedElement;
    }

    @Override
    public void indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                System.out.println(i);
            }
        }
    }

    @Override
    public int lastIndexOf(int element) {
        int index = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == element) {
                index = i;
            }
        }
        return index;
    }


}
