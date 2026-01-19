package Collections_FrmWrk.ArrayList;

import java.util.Arrays;


/**
 * @author Test
 * 
 * The trick in implementing ArrayList is 
 * the size should be large enough to add the next element
 * 
 * i.e when we are adding an object, capacity of the array (length of the array) should be atliest of size equal to current capacity of the array+1;
 * 
 * When we copy the entire array to new location then use Arrays.copyOf**
 * 
 * when we shift elements of the array by one index left or right we use Systme.arrayCopy()***
 * 
 * 
 * ArrayList's add method always appends at the end of the list. i.e adds the element at the index callex size
 *
 */
public class MyArrayList {

	private int size;
	private Object[] data;

	public MyArrayList() {
		this(10);
	}

	public MyArrayList(int capacity){
		this.data= new Object[capacity];
	}
	
	public boolean add(Object obj){
		ensureCapacity(size+1);
		data[size]=obj;
		size++;
		return true;
		
	}
	
	
	public boolean add(int index, Object obj){
		if(index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		ensureCapacity(size+1);
		System.arraycopy(data, index, data, index+1, size-index);
		data[index]=obj;
		size++;
		return true;
		
	}
	
	public boolean remove(int index){
		if(index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		System.arraycopy(data, index+1, data, index, size-index-1);
		data[size-1]=null;
		size--;
		return true;
	}
	
	
	public void ensureCapacity(int minCapacity){
		
		int oldCapacity= data.length;// This is capacity(Actual Array length) not the size of the ArrayList
        if(minCapacity>oldCapacity){
        	int newCapacity=oldCapacity*3/2+1;
        	if(newCapacity<minCapacity){
        		newCapacity=minCapacity;
        	}
        	//When we move to new array or new location use Arrays.copyof
        	data=Arrays.copyOf(data, newCapacity);
        }
	}
	
	
	public int size(){
		return size;
	}
	
	public Object get(int index){
		if(index>size-1){
			throw new ArrayIndexOutOfBoundsException();
		}
		return data[index];
		
	}

}
