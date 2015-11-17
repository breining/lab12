package lab12tester;
import java.util.NoSuchElementException;

public class Lab12Tester {

	public static void main(String [] args) {

	    LinkedLab12<String> l1 = new LinkedLab12<>();
	    
	    System.out.println("\nTesting empty lists.");
	    System.out.println(l1);
	    l1.reverse();
	    System.out.println(l1);
	    try {
	        l1.moveFirstToLast();
	    }
	    catch (NoSuchElementException e) {
	        System.out.println(e.getMessage());
	    }
	    try {
	        l1.moveLastToFirst();
	    }
	    catch (NoSuchElementException e) {
	        System.out.println(e.getMessage());
	    }
	    
	    System.out.println("\nTesting a list of length one.");
	    l1.add("one");
	    l1.moveFirstToLast();
	    System.out.println(l1);
	    l1.moveLastToFirst();
	    System.out.println(l1);
	    l1.reverse();
	    System.out.println(l1);
	    
	    System.out.println("\nTesting a list of length two.");
	    l1.add("two");
	    l1.moveFirstToLast();
	    System.out.println(l1);
	    l1.reverse();
	    System.out.println(l1);
	    l1.moveLastToFirst();
	    System.out.println(l1);

        System.out.println("\nTesting lists longer than length two.");	    
	    l1.add("three");
	    l1.add("four");
	    l1.add("five");
	    System.out.println(l1);
	    l1.moveFirstToLast();
	    System.out.println(l1);	    
        l1.add("six");
	    System.out.println(l1);
	    l1.moveLastToFirst();
	    System.out.println(l1);
	    l1.swap(1, 4);
	    System.out.println(l1);
	    l1.swap(0, 5);
	    System.out.println(l1);
	    l1.swap(3, 3);
	    System.out.println(l1);
	    l1.swap(4, 1);
	    System.out.println(l1);
	    try {
	        l1.swap(2, 8);
	    }
	    catch (IndexOutOfBoundsException e) {
	        System.out.println("Properly caught bad indices.");
	    }   
	    l1.reverse();
	    System.out.println(l1);
	}
}