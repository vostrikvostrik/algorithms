package search;

/**
 * User: User
 * Date: 21.09.17
 * Time: 17:28
 */
public class SimpleSearch {



    public static void main(String args[])
    {

        System.out.println("Index of search element = " + LinearSearch.search(new int[]{2,3,4,10,40} , 5, 3));

        ///---------------------------------------------------
        ///---------------------------------------------------
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr,0,n-1,x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);

        ///---------------------------------------------------
        ///---------------------------------------------------

        int arr2[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x2 = 55;

        // Find the index of 'x' using Jump Search
        int index = JumpSearch.jumpSearch(arr2, x2);

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x2 +
                " is at index " + index);
    }
}

class LinearSearch
{
    // This function returns index of element x in arr[]
    static int search(int arr[], int n, int x)
    {
        for (int i = 0; i < n; i++)
        {
            // Return the index of the element if the element
            // is found
            if (arr[i] == x)
                return i;
        }

        // return -1 if the element is not found
        return -1;
    }
}


// Java implementation of recursive Binary Search
// !Only for sorted array
class BinarySearch
{
    // Returns index of x if it is present in arr[l..r], else
    // return -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);

            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

}

class JumpSearch
{
    public static int jumpSearch(int[] arr, int x)
    {
        int n = arr.length;

        // Finding block size to be jumped
        // Math.floor - возвращает наибольшее целое число, меньшее, либо равное указанному числу
        // Math.sqrt -  возвращает квадратный корень числа
        int step = (int)Math.floor(Math.sqrt(n));

        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n)-1] < x)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x)
        {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (arr[prev] == x)
            return prev;

        return -1;
    }

}