package lab12tester;
import java.util.NoSuchElementException;

public class LinkedLab12<E> {

    private class Node {
        
        private E data;
        private Node next;
        private Node previous;
        
        public Node(E data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
        
        public Node(E data) {
            this(data, null, null);
        }
        
        public Node() {
            this(null, null, null);
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedLab12() {
        head = new Node();
        tail = head;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    private Node getNodeBefore(int index) {
        Node current = head;
        for (int i=0; i<index; i++)
            current = current.next;
        return current;
    }

	public boolean contains(Object obj) {
	    Node current = head.next;
	    while (current != null) {
	        if (current.data.equals(obj))
	            return true;
	        current = current.next;
	    }
	    return false;
	}
    
    public int indexOf(Object obj) {
        Node current = head.next;
        int index = 0;
        while (current != null) {
            if (current.data.equals(obj))
                return index;
            current = current.next;
            index++;
        }
        throw new NoSuchElementException();
    }
    
    public E get(int index) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
        return getNodeBefore(index).next.data;
    }

	public void add(E element) {
	    tail.next = new Node(element);
	    tail = tail.next;
	    size++;
	}

	public void add(int index, E element) {
	    if (index < 0 || index > size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    Node previous = getNodeBefore(index);
	    Node current = new Node(element, previous.next, previous);
	    previous.next = current;
	    if (tail == previous)
	        tail = current;
	    size++;
	}

	public void remove(int index) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    Node previous = getNodeBefore(index);
	    previous.next = previous.next.next;
	    if (previous.next == null)
	        tail = previous;
	    size--;
	}

	public void set(int index, E element) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    getNodeBefore(index).next.data = element;
	}
	
	public void clear() {
	    head.next = null;
	    tail = head;
	    size = 0;
	}
	
	public boolean isEmpty() {
	    return size == 0;
	}
	
	public void moveFirstToLast()throws NoSuchElementException{
           try{
            Node node = head;
            head = head.next;
            node.next = null;
            tail.next = node;
            tail = node;
           }
           catch(NullPointerException e){}

	}
	
	public void moveLastToFirst()throws NoSuchElementException{ 
            
            try{
               
                Node beforeTail = head;
            while (beforeTail.next.next != null){
                beforeTail = beforeTail.next;
            }
            beforeTail.next = null;
            tail.next = head;
            head = tail;
            tail = beforeTail;
            }
            catch(NullPointerException e){}
            
	}
	
	public void swap(int i, int j)throws IndexOutOfBoundsException{
            Node node1;
            Node node2;
            Node temp;
            
            node1 = getNodeBefore(i);
            node2 = getNodeBefore(j);
            
            temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
            
            temp = node1.previous;
            node1.previous = node2.previous;
            node2.previous = temp;
            
	}
	
	public void reverse(){
            Node start = head;
            Node temp;
            while(start != null){
                temp = start.next;
                start.next = start.previous;
                start.previous = temp;
                if(start.previous == null){
                head = start;
            }
                start = start.previous;
            }
	}
	
    /**
     *
     * @return
     */
    @Override
	public String toString(){
	    if (size == 0) return "[ ]";
	    StringBuilder sb = new StringBuilder("[");
                Node current = head.next;
	    while (current != null) {
	        sb.append(current.data.toString() + ", ");
	        current = current.next;
	    }
	    sb.setLength(sb.length() - 2);
	    sb.append("]\t");
	    return sb.toString();
	}
}