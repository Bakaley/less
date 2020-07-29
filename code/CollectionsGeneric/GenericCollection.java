package CollectionsGeneric;

import IteratorImplementations.ArrayListIterable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class GenericCollection <E> implements Collection <E> {


    private Object[] array = {};

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new GenericIterator<>();
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        return (E[]) array;
    }

    @Override
    public boolean add(E o) {
        Object[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = o;
        array = newArray;
        return true;
    }


    public int getIndex(Object objectToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(objectToFind)) return i;
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        try {
            Object[] newArray = new Object[array.length - 1];
            for (Object object : array) {
                if (object.equals(o)) {
                    for (int j = 0; j < getIndex(o); j++) {
                        newArray[j] = array[j];
                    }
                    if (getIndex(o) != array.length - 1) {
                        for (int k = getIndex(o); k < array.length - 1; k++) {
                            newArray[k] = array[k + 1];
                        }
                    }
                    result = true;
                }
            }
            if (result) array = newArray.clone();
        } catch (NullPointerException e) {
            System.out.println(array.length);
            System.out.println(this.array);
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        if (array.length == 0) return "{}";
        else for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) string.append(array[i].toString() + "}");
            else string.append(array[i].toString() + ", ");
        }
        return string.toString();
    }


    private class GenericIterator <E> implements Iterator<E>{

        private Object[] array;
        private int index;

        public GenericIterator (){
            this.array = GenericCollection.this.array;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public E next() {
            Object result = array[index];
            index++;
            return (E) result;
        }
    }
}
