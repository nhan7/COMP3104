/*
 * 
 */
package week2;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Tech
 */
public class Week2 {
    
    public static int linearSearch(int [] arr, int item){       
       
        
        for (int i = 0; i < arr.length ; i++) {
            
            if(item == arr[i]) 
                return i;
            
        }
        
        
        return -1;
    }
    
    public static int[] GeneratingRandomArray(int size){
        
             Random rand = new Random();
        
        int [] randNum = new int[size];
        for (int i = 0; i < randNum.length; i++) {
            randNum[i] = i ;
            
        }
        return randNum;
        
    }
    
    public static int binarySearch(int arr [] , int item){
        
        int first = 0;
        int last = arr.length -1 ;
        int mid = 0;
        boolean found = false;
        while (first <= last && !found ) {
            
        
         mid = (first + last) / 2;
            System.out.println("first= " + first + " last= " + last + " mid=" + mid);
         
         if(arr[mid] == item) // we found the match!
         {
             found = true;
             return mid;
         }
         else if (arr[mid] > item)
             last = mid - 1;
         else // arr[mid] < item
             first = mid + 1;
  
        }
        
        return -1;
        
        
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] numbers = new int [] {4, 34, 56, 2, 23, 55, 29, 44, 56, 33,100,2};
       
        // unsorted! ----------------------------------------
        System.out.println("unsorted" + Arrays.toString(numbers));
         long startTime =System.nanoTime();
         int index = linearSearch(numbers, 2);
         System.out.println(index);
         long endTime =System.nanoTime();
         
         System.out.println((endTime-startTime)/1000+ " microSec.");
        
         Arrays.sort(numbers); // the running time of this sort NLogN
         System.out.println("sorted " + Arrays.toString(numbers));
         System.out.println("location is :" + binarySearch(numbers, 340));
         
       //-----------------------------------------------------------------
               
        int [] randomArr = GeneratingRandomArray(1000000);
       // System.out.println(Arrays.toString(randomArr));
       startTime =System.nanoTime();
        System.out.println("index of 1500 is " + linearSearch(randomArr, 999999));
       endTime = System.nanoTime(); 
       System.out.println("running time linear " + (endTime-startTime)/1000+ " microSec.");
      
       Arrays.sort(randomArr);
        startTime =System.nanoTime(); 
        System.out.println("index of 1500 is " + binarySearch(randomArr, 999999));
         endTime = System.nanoTime(); 
               System.out.println("running time binary " + (endTime-startTime)/1000+ " microSec.");

       
    }
    
}
