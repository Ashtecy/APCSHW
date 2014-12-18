import java.util.*;

public class Sorts{
    
    public static int[] randArray(int size){
	int[]A=new int[size];
	for(int i=0;i<A.length;i++){
	    Random rand= new Random();
	    A[i]=rand.nextInt(30);
	}
	return A;
    }
    
    public static String toString(int[]A){
	String printA="[";
	for(int i:A){
	    printA+=" "+i;
	}
	printA+=" ]";
	return printA;
	}
    
    public static void swap(int[]A,int index1,int index2){
	int tracker = A[index1];
	A[index1]=A[index2];
	A[index2]=tracker;
    }

    public static void bubbleSort(int[]A){
	for (int j=A.length;j>0;j--){
	    for(int i=0;i<j-1;i++){
		    if (A[i]>A[i+1]){
			swap(A,i,i+1);
		    }
	    }	    
	}
    }

    public static void insertionSort(int[]A){
	for(int i=1;i<A.length;i++){
	}
    }


    public static void selectionSort(int[]A){
    }
    

}
		    
	
