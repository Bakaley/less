package CollectionImplement;

import java.util.Collection;
import java.util.Iterator;

public class MyCollectionImplement implements Collection {

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
        return null;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
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
    public boolean removeAll(Collection c) {
        for (Object object : c.toArray()) {
            this.remove(object);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c){

            if(array.length == 0 || c.toArray().length ==0) return false;

            MyCollectionImplement newCollection = new MyCollectionImplement();

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

    public int getIndex(Object objectToFind) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(objectToFind)) return i;
        }
        return -1;
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
}
