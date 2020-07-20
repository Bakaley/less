package MapImplement;

import CollectionImplement.MyCollectionImplement;

import java.util.*;

public class MyMap implements Map {

    private final static int NUM_BUCKETS = 2;
    private Record[] data = new Record[NUM_BUCKETS];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public Object get(Object key) {
        int index = Math.abs(key.hashCode() % NUM_BUCKETS);
        Record current = data[index];
        while (current != null){
            if(current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int index = Math.abs(key.hashCode()) % NUM_BUCKETS;
        Record last = data [index];
        data[index] = new Record(last, (String)key, (String)value);
        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        Record previos = null;
        int index = Math.abs(key.hashCode() % NUM_BUCKETS);
        Record current = data[index];
        while (current != null){
            if(current.key.equals(key)){
                if(previos == null) current = current.next;
                else {
                    previos.next = current.next;
                }
            }

            previos = current;
            current = current.next;
        }
        size--;
        return null;
    }

    @Override
    public void putAll(Map m) {
        Iterator iterator = m.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry)iterator.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        data = new Record[NUM_BUCKETS];
        size = 0;
    }

    @Override
    public Set keySet() {
        MyCollectionImplement collection = new MyCollectionImplement();
        for (Record r : data) {
            while (r!= null) {
                collection.add(r.key);
                r = r.next;
            }
        }
        return collection;
    }

    @Override
    public Collection values() {
        MyCollectionImplement collection = new MyCollectionImplement();
        for (Record r : data) {
            while (r!= null) {
                collection.add(r.value);
                r = r.next;
            }
        }
        return collection;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }


    private class Record {
        Record next;
        String key;
        String value;

        public Record(Record next, String key, String value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        int index = 0;
        for (Record r : data) {
            while (r!= null) {
                string.append(r.key + "=");
                string.append(r.value);
                if(index == values().size()-1)  return string.append("}").toString();
                else string.append(", ");
                r = r.next;
                index ++;
            }
        }
       return "{}";
    }
}
