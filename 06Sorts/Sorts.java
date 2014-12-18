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

    public static int[] copyArray(int[]A){
	int[]B=new int[A.length];
	for(int i=0;i<A.length;i++){
	    B[i]=A[i];
	}
	return B;
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
	    int tracker = A[i];
	    int j;
	    for(j=i-1;(j>=0) && (tracker<A[j]);j--){
		A[j+1]=A[j];
	    }
	    A[j+1]=tracker;
	}
    }

    public static void selectionSort(int[]A){
	for(int i=0;i<A.length-1;i++){
	    int tracker = i;
	    for(int j=i+1;j<A.length;j++){
		if(A[j]<A[tracker]){
		    tracker=j;
		}
	    }
	    swap(A,tracker,i);
	}
    }
    

}
		    
	
