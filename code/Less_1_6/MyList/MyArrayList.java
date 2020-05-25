package Less_1_6.MyList;

public class MyArrayList {

    private int[] array = new int[0];

    MyArrayList () {

    }

    MyArrayList (int[] arrayToCreate){
        if(arrayToCreate.length!=0) this.array = arrayToCreate;
    }

    public void add (int numberToAdd) {
        if(array.length==0){
            array = new int[1];
            array[0] = numberToAdd;
        }
        else {
            int[] newArray = new int[array.length+1];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[newArray.length-1] = numberToAdd;
            array = newArray;
        }
    }

    public int getIndex (int numToFind) {
        if(array.length==0) {
            return -1;
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if(array[i] == numToFind)  return i;
            }
        }
        return -1;
    }

    public int get (int index){
        return array[index];
    }

    public boolean contains (int numToFind) {
        if(array.length==0) {
            return false;
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if(array[i] == numToFind)  return true;
            }
        }
        return false;
    }

    public void add(int[] arrayToAdd){

        if(arrayToAdd.length==0) return;

        else if(array.length==0){
            array = arrayToAdd;
        }

        else {
            int[] newArray = new int[array.length + arrayToAdd.length];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            for (int i = 0; i < arrayToAdd.length; i++) {
                newArray[i+array.length] = arrayToAdd[i];
            }

            array = newArray;
        }
    }

    public void add(MyArrayList arrayToAdd){

        if(arrayToAdd.array.length==0) return;

        else if(array.length==0){
            array = arrayToAdd.array;
        }

        else {
            int[] newArray = new int[array.length + arrayToAdd.array.length];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            for (int i = 0; i < arrayToAdd.array.length; i++) {
                newArray[i+array.length] = arrayToAdd.array[i];
            }

            array = newArray;
        }
    }

    public int getSize (){
        return array.length;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        if(array.length==0)  return "{}";
        else for (int i = 0; i <array.length; i++) {
            if(i == array.length-1) string.append(array[i] + "}");
            else string.append(array[i] + ", ");
        }
        return string.toString();
    }

    public boolean equals (MyArrayList listToCompare){

        if(!(this.getSize() == listToCompare.getSize())) return false;

        else if(this.getSize() == 0 && listToCompare.getSize() == 0) return true;

        else {
            for (int i = 0; i < this.array.length; i++) {
                if(this.array[i] == listToCompare.array[i]);
                else return false;
            }
            return true;
        }
    }

    public void clear(){
        array = new int[0];
    }

    public void sort (){

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
