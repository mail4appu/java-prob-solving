package Collections_FrmWrk.stacknqueue;

import java.util.Arrays;

/**
 * @author Test
 * Stack is nothing but dynamic array. We should implement the priority called LIFO i.e Last In First Out
 * i.e peek() method should always return the most recent element i.e the last element.
 * pop() means remove. i.e it should always remove the most recent element. I.e the last element.
 * 
 * ie. in pop we simply access the last element and make it null and reduce the size by 1. 
 * 
 * In the arraylist removal method, we always remove at a index and move the elements to the left by one index unless the index 
 * is the last index.
 * 
 * Here in stack, pop is nothing but removal from array which is always at last index. 
 * Hence we don't use System.arrayCopy() as elements are not moved to the left by one index
 * 
 * 
 * Stack===ArrayList
 * push()==Always appends the element at the end of the list. i.e at the index size
 * peek()==Always get the last element in the list
 * pop()==Always removes the last element from the list
 * 
 *
 *
 */
public class MyStack {
	int size=0;
	Object data[];

	public MyStack() {
		this.data=new Object[10];
	}

	public MyStack(int capacity){
		this.data=new Object[capacity];
	}

	/**
	 * This push method is equal to adding elements to custom ArrayList
	 * 
	 * @param obj
	 * @return
	 */
	public boolean push(Object obj){
		ensureCapacity(size+1);
		data[size]=obj;
		size++;
		return true;
	}

	public Object pop(){
		Object temp=data[size-1];
		data[size-1]=null;
		size--;
		return temp;
	}

	public Object peek(){
		return data[size-1];
	}
	
	

	/**
	 * 
	 * Same as custom ArrayList
	 * 
	 * @param minCapacity
	 * 
	 * 
	 * 
	 */
	public void ensureCapacity(int minCapacity){
		System.out.println("min capacity"+minCapacity);
		int oldCapacity=data.length;
		System.out.println("old capacity"+oldCapacity);
		if(minCapacity>oldCapacity){
			int newCapacity=oldCapacity*2+10;
			Arrays.copyOf(data, newCapacity);

		}
	}

}
