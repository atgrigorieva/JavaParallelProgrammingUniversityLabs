package ru.spbstu.telematics.java.interface_collection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyListInterface<E> implements List<E>, Iterable<E> {
	
	private Node<E> previous;
	private Node<E> next;
	private Node<E> first;
	private int size;
	
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(Object o) {//Возвращает true, если этот список содержит указанный элемент.
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(o)) return true;
		}
		return false;
	}

	public Iterator<E> iterator() {
		
		Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

           
            public boolean hasNext() {
                return currentIndex < size && first != null;
            }

            
            public E next() {
                return get(currentIndex++);
            }

           
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

	

	public Object[] toArray() {//Возвращает массив, содержащий все элементы в этом списке в правильной последовательности
		Object[] array = new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = getByIndex(i).getT();
		}
		return array;
	}

	public <T> T[] toArray(T[] a) {
		return null;
	}

	public boolean add(E e) {//Добавляет элемент в конец списка и в случае удачного добавления элемента возвращает true
		Node<E> node = new Node<E>(e);
    	if(first == null){
    		first = node;
    	}
    	else{
    		Node temp=first;
    		while (temp.getNext()!=null)
    			temp=temp.getNext();
    		temp.setNext(node);
    	}
    	size++;
    	
    	return true;
	}

	public boolean remove(Object o) {//Удаляет первое вхождение указанного элемента из этого списка, если он присутствует и возвращает true если он удален
		Node<E> node = first;
		if(node.getT().equals(o)){
			first=node.getNext();
			size--;
			return true;
		}
		for(int i=1; i<size(); i++){
			if(node.getT().equals(o)){
				node.getPrevious().setNext(node.getNext());
				size--;
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		return false;
	}

	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		return false;
	}

	public void clear() {
	
		
	}
	private Node<E> getByIndex(int index) {//позволит нам получать элемент очереди по индексу
		Node<E> node = null;
		if (!isEmpty() && (index >= 0 && index < size)) {
			node = first;
			for(int i=1; i<=index; i++){
				node = node.getNext();
			}
		}
		return node;
	}
	public E get(int index) {//Возвращает элемент в указанной позиции в этом списке
		
		E element;
		if (index >= 0 && index < size()) {
			element = getByIndex(index).getT();
		} else throw new IndexOutOfBoundsException();
		return element;
	}

	public E set(int index, E element) {
		return null;
	}

	public void add(int index, E element) {
		
		
	}

	public E remove(int index) {
		return null;
	}

	public int indexOf(Object o) {
		return 0;
	}

	public int lastIndexOf(Object o) {
		return 0;
	}

	public ListIterator<E> listIterator() {
		return null;
	}

	public ListIterator<E> listIterator(int index) {
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}
	
}
