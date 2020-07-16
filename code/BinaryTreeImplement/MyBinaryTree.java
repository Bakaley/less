package BinaryTreeImplement;

import java.util.*;

public class MyBinaryTree implements Set {

    private Node root;

    private int getNodeSize (Node node){
        if (node == null)
            return 0;
        else
            return(getNodeSize(node.left) + 1 + getNodeSize(node.right));
    }


    @Override
    public int size() {
        return getNodeSize(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }


    @Override
    public boolean contains(Object o) {
        Integer data = (Integer) o;
        if(root==null){
           return false;
        }

        return containsIn(data, root);
    }

    private boolean containsIn (Integer dataToFind, Node node){
        if(node.data == dataToFind){
            return true;
        }
        else if (node.data > dataToFind){
            if(node.left == null){
                return false;
            }
            else {
                return containsIn(dataToFind, node.left);
            }
        }
        else if (node.data < dataToFind){
            if(node.right == null){
                return false;
            }
            else {
                return containsIn(dataToFind, node.right);
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(root);
    }

    @Override
    public Object[] toArray() {
        //на столько нерационально, на сколько это физически возможно
        Object[] objects = new Object[getNodeSize(root)];
      Iterator iterator = iterator();
      int index = 0;
      while (iterator.hasNext()){
          objects[index] = iterator.next();
          index++;
      }
      return objects;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Integer data = (Integer) o;
        Node node = new Node (data);

        if(root==null){
            root = node;
        }
        else {
            append(data, root);
        }
        return false;
    }

    private void append (Integer dataToAdd, Node node){
        if(node.data == dataToAdd){
            return;
        }
        else if (node.data > dataToAdd){
            if(node.left == null){
                node.left = new Node (dataToAdd);
                node.left.parent = node;
            }
            else {
                append(dataToAdd, node.left);
            }
        }
        else if (node.data < dataToAdd){
            if(node.right == null){
                node.right = new Node (dataToAdd);
                node.right.parent = node;
            }
            else {
                append(dataToAdd, node.right);
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        deleteNode(root, (Integer)o);
        return true;
    }

    private Node deleteNode(Node root, Integer data) {

        if(root == null) return root;

        if(data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if(data > root.data) {
            root.right = (deleteNode(root.right, data));
        } else {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                Integer minValue = minValue(root.right);
                root.data = (minValue);
                root.right = (deleteNode(root.right, minValue));
            }
        }

        return root;
    }

    private Integer minValue(Node node) {

        if(node.left != null) {
            return minValue(node.left);
        }
        return node.data;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c.toArray()){
            if(!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c.toArray()){
            add(o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object o :
                c.toArray()) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
//
//        if(root == null || c.toArray().length ==0) return false;
//
//        MyBinaryTree newCollection = new MyBinaryTree();
//
//        for (int i = 0; i < array.length; i++) {
//
//            for (int j = 0; j <c.toArray().length; j++) {
//
//                if(array[i].equals(c.toArray()[j])) {
//                    newCollection.add(array[i]);
//                    break;
//                }
//            }
//        }
//        array = newCollection.array.clone();
        return true;

    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public String toString(){
        return "{" +convertNodeToString(root) + "}";
    }

    public String convertNodeToString(Node node){
        if(node==null)
            return "";
        else
            return convertNodeToString(node.left) + " " +node.data + " " +convertNodeToString(node.right);
    }



    private class Node{
        int data;
        Node left;
        Node right;
        Node parent;

        public  Node (int data){
            this.data = data;
        }
    }

    private class TreeIterator implements Iterator{
        private Node next;

        public TreeIterator(Node root) {
            next = root;
            if(next == null)
                return;

            while (next.left != null)
                next = next.left;
        }

        public boolean hasNext(){
            return next != null;
        }

        public Integer next(){
            if(!hasNext()) throw new NoSuchElementException();
            Node node = next;
            //ищем левое дно
            if(next.right != null) {
                next = next.right;
                while (next.left != null)
                    next = next.left;
                return node.data;
            }
            //идём вверх
            for(;;) {
                if(next.parent == null) {
                    next = null;
                    return node.data;
                }
                if(next.parent.left == next) {
                    next = next.parent;
                    return node.data;
                }
                next = next.parent;
            }
        }
    }
}
