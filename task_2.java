import java.util.Arrays;

public class task_2 {
    public static void main(String[] args) {

        int array[] = {12,56,8,0,-99,56,8,8,1,2,0};
        PyramidSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void PyramidSort(int array[])
    {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            Heapify(array, n, i);
  
        for (int i=n-1; i>=0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            Heapify(array, i, 0);
        }
    }

   
     public static void Heapify(int array[], int n, int i)
    {
        int maxElement = i; 
        int leftElement = 2*i + 1; 
        int rightElement = 2*i + 2; 

        if (leftElement < n && array[leftElement] > array[maxElement])
        {
            maxElement = leftElement;
        }
          
        if (rightElement < n && array[rightElement] > array[maxElement])
            maxElement = rightElement;
       
        if (maxElement != i)
        {
            int temp = array[i];
            array[i] = array[maxElement];
            array[maxElement] = temp;

            Heapify(array, n, maxElement);
        }
    }

    

}

