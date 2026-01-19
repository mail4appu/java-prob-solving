package problems;

public class FindDuplicates {
    public static void main(String[] args) {
        int arr[] = {1, 6, 15, 1, 15, 6, 6, 6, 7, 7,12, 13, 13};
        System.out.println(Integer.hashCode(1));
        int arr_size = arr.length;

        System.out.println("The repeating elements are: ");
        printRepeating( arr, arr_size);
    }

    static void printRepeating(int arr[], int n)
    {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++)
        {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < n; i++)
        {
            if ((arr[i]/n) > 1)
                System.out.println(i +" ");
        }
    }
}
