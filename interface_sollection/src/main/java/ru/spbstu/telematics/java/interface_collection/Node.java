package ru.spbstu.telematics.java.interface_collection;

public class Node<T> {
	private Node next;
    private Node previous;
    private T t;    

    public Node(T t) {
        this.next = null;
        this.previous = null;
        this.t=t;
    }

    public Node(Node previous) {
        this.next = null;
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    public boolean equals(Object obj) {
    	return t.equals(obj);
    }
}
