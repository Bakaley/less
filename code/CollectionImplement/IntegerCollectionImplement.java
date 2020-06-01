package CollectionImplement;

import java.util.Collection;
import java.util.Iterator;


public class IntegerCollectionImplement implements Collection {

    private Integer[] array = new Integer[0];
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

        Integer integer = (Integer) o;

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < integer) {
                low = mid + 1;
            } else if (array[mid] > integer) {
                high = mid - 1;
            } else if (array[mid] == integer) {
                return true;
            }
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
        Integer[] newArray = new Integer[array.length+1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length-1] = (Integer)o;
        array = newArray;
        sort();
        return true;
    }

    @Override
    public boolean remove(Object o){
        boolean result = false;
            Integer[] newArray = new Integer[array.length - 1];
        for (Integer object : array) {
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
        sort();
        return result;
    }

    @Override
    public boolean containsAll(Collection c) {
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {

        return true;
    }

    @Override
    public boolean retainAll(Collection c){
        return true;
    }

    @Override
    public void clear() {
        array = new Integer[0];
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

    private void sort(){

        boolean flag = true;
        int leftBound = 0;
        int rightBound = array.length-1;

        while ((leftBound < rightBound) && flag){

            flag = false;

            for (int i = leftBound; i < rightBound; i++) {
                if(array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = true;
                }
            }

            rightBound--;

            for (int i = rightBound; i > leftBound; i--) {
                if(array[i-1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    flag = true;
                }
            }

            leftBound++;
        }
    }
}
