package com.collections.learn;
import java.util.*;

public class One {
	
	public static void main(String [] args) {
		
		ArrayList<Integer> a = new ArrayList<>(1);
		/*here we can give it a size but it dosent matter as arraylist dynamically
		takes care of the size even if it exceeds*/
		a.add(10);
		a.add(56);
		
		ArrayList<Integer> b = new ArrayList<>(List.of(10,210,456,789,20,469));
		//This is another way of inserting data into the list
		
		System.out.println("Get method: "+b.get(5));
		System.out.println("Index of method: "+b.indexOf(210));
		System.out.println("Print all: "+b);
		System.out.println("\n\n");
		/*ways to iterate through arraylist*/
		
		//	* Using for loop
		System.out.println("Using for loop:");
		for(int i=0; i<b.size(); i++)System.out.println(b.get(i));
		
		//	* Using For each loop
		System.out.println("\nUsing for each loop:");
		for(var x:b)System.out.println(x);
		
		//	* Using Lambda
		System.out.println("\nUsing Lambda:");
		b.forEach((x) -> {System.out.println(x);});
		
		//	* Using Iterator
		System.out.println("\nUsing Iterator:");
		Iterator<Integer> b_iterator = b.iterator();
		//Iterator is a refernce to all the elements
		while(b_iterator.hasNext()) {
			System.out.println(b_iterator.next());
			/*Iterator has the reference of the first element 
			 * it gives us options on what to do with the current element
			 * and then it automatically shifts to the next element 
			 * so we only decide what to do with the current item*/
		}
		
		//	* Using ListIterator
		System.out.println("\nUsing List Iterator");
		ListIterator<Integer> Lt = b.listIterator();
		//This is same as iterator except here we can iterate not only forward but also backward and other extra features
		while(Lt.hasNext()) {
			System.out.println(Lt.next());
		}
		
		//	* Using scope reference
		System.out.println("\nUsing scope reference:");
		b.forEach(System.out::println);
	}
}
