package MyLinkedListImplementation;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList implements Collection {


    private int SIZE = 0;
    private MyNode head = null;

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean isEmpty() {
        return SIZE==0;
    }

    @Override
    public boolean contains(Object o) {

        MyNode tempHead = head;

        while (tempHead != null){
            if(tempHead.data.equals(o)) return  true;
            tempHead = tempHead.next;
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {

        Object[] newArray = new Object[SIZE];
        int index = 0;
        MyNode tempHead = head;
        while (tempHead != null){

            newArray[index] = tempHead.data;
            index++;
            tempHead = tempHead.next;
        }

        return  newArray;
    }

    @Override
    public boolean add(Object o) {

        MyNode node = new MyNode(o, head);
        head = node;

        SIZE++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Данная операция неприменима к односвязному списку");
    }

    public Object pop(){
        if (head == null) throw new IndexOutOfBoundsException("Двусвязный список пуст");
        Object result = head.data;
        head = head.next;

        SIZE--;
        return result;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] array = c.toArray();
        for (Object object :
                array) {
            this.add(object);
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        SIZE = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Данная операция неприменима к односвязному списку");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Данная операция неприменима к односвязному списку");
    }

    @Override
    public boolean containsAll(Collection c) {
        Object[] array = c.toArray();
        for (Object object :
                array) {
            if(!this.contains(object)) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {

        MyNode tempHead = head;
        if(tempHead == null)  return "{}";
        StringBuilder string = new StringBuilder("{");
        while (tempHead != null){

            string.append(tempHead.data);
            if(tempHead.next == null) string.append("}");
            else string.append(", ");
            tempHead = tempHead.next;
        }

        return string.toString();
    }

    private class MyNode {
        private Object data;
        private MyNode next;

        MyNode (Object data, MyNode node){
            this.data = data;
            this.next = node;
        }

    }
}
