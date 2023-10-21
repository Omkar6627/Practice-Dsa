import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q15 {
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = Arrays.copyOfRange(arr, left, left + n1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, mid + 1 + n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int currSize;
        int leftStart;

        for (currSize = 1; currSize < n ; currSize = 2 * currSize) {
            for (leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
                int mid = Math.min(leftStart + currSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);

                merge(arr, leftStart, mid, rightEnd);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s= new Scanner (System.in);
        int n= s.nextInt();
        int []x= new int [n];
        for(int i=0;i<n;i++)
        {         x[i]=s.nextInt();
        }


        mergeSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
//bubble


public class Solution {

    public static void main(String[] args) {
         Scanner s= new Scanner (System.in);
        int n= s.nextInt();
        int []x= new int [n];
        for(int i=0;i<n;i++)
        {         x[i]=s.nextInt();
        }   for(int i=0;i<n-1;i++){   int temp=0;
            for(int j=0;j<n-1;j++){
                if(x[j]>x[j+1]) {
                    temp=x[j];
                    x[j]=x[j+1];
                    x[j+1]=temp;
                }}  }
        for(int i=0;i<n;i++){
            System.out.print(x[i]+" ");
        }

    }
}//insertion

public class Solution {

    public static void main(String[] args) {
         Scanner s= new Scanner (System.in);
        int n= s.nextInt();
        int[]x= new int[n];
        for(int i=0;i<n;i++)
        { x[i]=s.nextInt();}
        for(int i=1;i<n;i++)
        { int  key=x[i];
            int j=i-1;
            while(j>=0&&x[j]>key)
            {x[j+1]=x[j];
                j--;}
            x[j+1]=key;

        }

        for(int a=0;a<n;a++)
            System.out.print(x[a]+" ");
    }
}
//selection


public class Solution {

    public static void main(String[] args) {
        Scanner s= new Scanner (System.in);
        int n= s.nextInt();
        int []x= new int [n];
        for(int i=0;i<n;i++)
        {         x[i]=s.nextInt();
        }   for(int i=0;i<n-1;i++){   int min=i;
            for(int j=i+1;j<n;j++){
                if(x[min]>x[j]) {
                    min=j;}}
            int tmp= x[i];
            x[i]=x[min];
            x[min]=tmp;
        }
        for(int i=0;i<n;i++){
            System.out.print(x[i]+" ");
        }

    }
}
//binary search
import java.io.*;
        import java.util.*;

public class Solution {
    static int bs(int []x,int k){
        int low =0;
        int high =x.length-1;

        while(low<=high){
            int mid =(low+high)/2;
            if(x[mid]==k)
            {    return mid;
            }
            else if(x[mid]<k){
                low =mid+1;}
            else
            { high= mid-1;}

        }
        return -1;
    }

    public static void main(String[] args) {
          Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        int []x= new int [n];
        for(int i=0;i<n;i++){
            x[i]= s.nextInt();
        }
        int k= s.nextInt();
        int ans= bs(x,k);
        System.out.print(ans);
    }
}