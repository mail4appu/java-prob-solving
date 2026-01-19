package Arrays;

import java.util.Arrays;

/**
 * @author vapparao
 *
 *(size-1)-i is the trick and  simply swapping the elements
 * if we do swapping of half of the elements. i.e enough
 * anyhow other half is being swapped by first half;
 * so half no of iterations are enough
 *
 */
public class ReverseArray {

	public static void main(String[] args) {
		int a[] = {13, 45, 1, 4, 56, 78};
		int size=a.length;
		//reverse
		for(int i=0;i<size/2;i++)
        {
        int temp=a[i];
        a[i]=a[(size-1)-i];
        a[(size-1)-i]=temp;
        }
		
		//print
		System.out.println("reversed array is*************"+ Arrays.toString(a));
	}
}
