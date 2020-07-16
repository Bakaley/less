package BinaryTreeImplement;

import java.util.*;

public class MyBinaryTree implements Set {

    private Node root;


    @Override
    public int size() {
        if(root == null) return 0;
       return NodeSize(root);
    }

    private int NodeSize (Node node) {
        {
            if (node == null)
                return 0;
            else
                return(NodeSize(node.left) + 1 + NodeSize(node.right));
        }
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
        Object[] objects = new Object[NodeSize(root)];
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

    public boolean add(Object[] os) {

        for (Object o :
                os) {
            add(o);
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

    private Node deleteNode(Node node, Integer data) {

        if(node == null) return node;
        if(size() == 1 && root.data == data){
            root = null;
            return root;
        }
        if(data < node.data) {
            node.left = deleteNode(node.left, data);
        } else if(data > node.data) {
            node.right = deleteNode(node.right, data);
        } else {
            if (node.left == null) {
                if (node == root){
                    root = node.right;
                    return null;
                }
                return node.right;
            }
            else if (node.right == null) {
                if (node == root){
                    root = node.left;
                    return null;
                }
                return node.left;
            }
            node.data = minValue(node.right);
            node.right = deleteNode(node.right, node.data);
        }

        return node;
    }

    private int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
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

        if(root == null || c.toArray().length ==0) return false;

        MyBinaryTree newCollection = new MyBinaryTree();
        Object[] objects = toArray();

        for (int i = 0; i < objects.length; i++) {

            for (int j = 0; j <c.toArray().length; j++) {

                if(objects[i].equals(c.toArray()[j])) {
                    newCollection.add(objects[i]);
                    break;
                }
            }
        }
        root = newCollection.root;
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
