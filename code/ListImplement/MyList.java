package ListImplement;

import java.util.*;

public class MyList implements List {

    private Object[] array = new Object[0];

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length==0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(o))  return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MyListIterator(this);
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return array.clone();
    }

    @Override
    public boolean add(Object o) {
        Object[] newArray = new Object[array.length+1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length-1] = o;
        array = newArray;
        return true;
    }

    @Override
    public boolean remove(Object o){
        boolean result = false;
        try {
            Object[] newArray = new Object[array.length - 1];
            for (Object object : array) {
                if (object.equals(o)) {
                    for (int j = 0; j < indexOf(o); j++) {
                        newArray[j] = array[j];
                    }
                    if (indexOf(o) != array.length - 1) {
                        for (int k = indexOf(o); k < array.length - 1; k++) {
                            newArray[k] = array[k + 1];
                        }
                    }
                    result = true;
                }
            }
            if(result)array = newArray.clone();
        } catch (NullPointerException e) {
            System.out.println(array.length);
            System.out.println(this.array);
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection c) {

        for (Object object : c.toArray()) {
            if(!contains(object)) return  false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        if(c == null) throw new NullPointerException();
        Object[] newArray = new Object[array.length + c.toArray().length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int i = 0; i < c.toArray().length; i++) {
            newArray[i+array.length] = c.toArray()[i];
        }
        array = newArray;
        return  true;
    }


    @Override
    public boolean addAll(int index, Collection c) {
        if(c == null) throw new NullPointerException();
        if(index >= 0 && index < array.length) {
            Object[] newArray = new Object[array.length + c.toArray().length];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            for (int i = 0; i < c.toArray().length; i++) {
                newArray[i + index] = c.toArray()[i];
            }
            for (int i = 0; i < array.length - index; i++) {
                newArray[c.size() + index + i] = array[i + index];
            }
                array = newArray;
            return true;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public boolean removeAll(Collection c) {
        if(c == null) throw new NullPointerException();
        for (Object object : c.toArray()) {
            this.remove(object);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c){
        if(c == null) throw new NullPointerException();
        if(array.length == 0 || c.toArray().length ==0) return false;
        MyList newCollection = new MyList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <c.toArray().length; j++) {
                if(array[i].equals(c.toArray()[j])) {
                    newCollection.add(array[i]);
                    break;
                }
            }
        }
        array = newCollection.array.clone();
        return true;
    }


    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= 0 && index < array.length) {
            array[index] = element;
            return true;
        }
        else throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(int index, Object element) {

        if(index >= 0 && index < array.length) {
            Object[] newArray = new Object[array.length + 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            newArray[index] = element;
            for (int i = 0; i < array.length - index; i++) {
                newArray[i+index+1] = array[i+index];
            }
            array = newArray;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object objectToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(objectToFind)) return i;
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        remove(get(index));
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (Object obj :
                array) {
            if(obj.equals(o)) index = indexOf(obj);
        }
        return index;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex < 0 || toIndex < fromIndex) throw new IndexOutOfBoundsException();
        MyList newList = new MyList();
        Object[] newArray = Arrays.copyOfRange(array, fromIndex, toIndex);
        for (Object o : newArray) {
            newList.add(o);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        if(array.length==0)  return "{}";
        else for (int i = 0; i <array.length; i++) {
            if(i == array.length-1) string.append(array[i].toString() + "}");
            else string.append(array[i].toString() + ", ");
        }
        return string.toString();
    }

    private class MyListIterator implements Iterator{

        private Object[] array;
        private int index;

        public MyListIterator (MyList list){
            this.array = list.toArray();
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public Object next() {
            Object result = array[index];
            index++;
            return result;
        }
    }
}
