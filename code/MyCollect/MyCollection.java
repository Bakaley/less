package MyCollect;

public class MyCollection {

    private Object[] array = new Object[0];

    public void add (Object objectToAdd) {
        if(array.length==0){
            array = new Object[1];
            array[0] = objectToAdd;
        }
        else {
            Object[] newArray = new Object[array.length+1];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[newArray.length-1] = objectToAdd;
            array = newArray;
        }
    }

    public boolean isEmpty(){
        if(array.length==0) return true;
        return false;
    }

    public boolean contains (Object objectToFind) {
        if(array.length==0) {
            return false;
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if(array[i].equals(objectToFind))  return true;
            }
        }
        return false;
    }

    private boolean removeSingle (Object objectToRemove) {

        boolean result = false;

        if(array.length==0) {
            return false;
        }
        else {

            try {
                Object[] newArray = new Object[array.length - 1];
                for (Object object : array) {
                    if (object.equals(objectToRemove)) {
                        for (int j = 0; j < getIndex(objectToRemove); j++) {
                            newArray[j] = array[j];
                        }
                        if (getIndex(objectToRemove) != array.length - 1) {
                            for (int k = getIndex(objectToRemove); k < array.length - 1; k++) {
                                newArray[k] = array[k + 1];
                            }
                        }
                        result = true;
                    }
                }
                if(result)array = newArray.clone();
            }catch (NullPointerException e) {
                System.out.println(array.length);
                System.out.println(this.array);
            }
        }
        return result;
    }

    public boolean remove (Object objectToRemove){
        if(!this.contains(objectToRemove)) return  false;
        while (this.contains(objectToRemove)) removeSingle(objectToRemove);
        return true;
    }

    public void add(MyCollection collectionToAdd){

        if(collectionToAdd.array.length==0) return;

        else if(array.length==0){
            array = collectionToAdd.array;
        }

        else {
            Object[] newArray = new Object[array.length + collectionToAdd.array.length];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            for (int i = 0; i < collectionToAdd.array.length; i++) {
                newArray[i+array.length] = collectionToAdd.array[i];
            }

            array = newArray;
        }
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

    public void clear(){
        array = new Object[0];
    }

    //оставить только элементы, которые встретились в обоих коллекциях
    public boolean retain(MyCollection collectionToReatain){

        if(array.length == 0 || collectionToReatain.array.length ==0) return false;

        MyCollection newCollection = new MyCollection();

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < collectionToReatain.array.length; j++) {

                if(array[i].equals(collectionToReatain.array[j])) {
                    newCollection.add(array[i]);
                    break;
                }
            }
        }

        array = newCollection.array.clone();
        return true;
    }

    public int getIndex(Object objectToFind) {
        if(array.length==0) {
            return -1;
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if(array[i].equals(objectToFind)) return i;
            }
        }
        return -1;
    }

    public Object get (int index){
        return array[index];
    }

    public boolean remove (MyCollection collectionToRemove) {
        if(array.length == 0 || collectionToRemove.array.length ==0) return false;
        for (Object object : collectionToRemove.array) {
            this.remove(object);
        }
        return true;
    }

    public boolean contains (MyCollection collectionToCheck){
        if(array.length == 0 && collectionToCheck.array.length == 0) return true;
        else if(array.length == 0 || collectionToCheck.array.length ==0) return false;
        else {
            for (Object object : collectionToCheck.array) {
               if(!contains(object)) return  false;
            }
            return true;
        }
    }
}
