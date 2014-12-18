public class Sorts{
    
     public String toString(int[]A){
	String printA="[";
	for(int i=0;i<currentSize;i++){
	    printA+=" "+A[i];
	}
	printA+=" ]";
	return printA;
     }

    public static void bubble(int[]A){
	int c=0;
	for (int j=A.length;j>0;j--){
	    for(int i=0;i<j-1;i++){
		if (A[i]>A[i+1]){
		    c=A[i]+A[i+1];
		    A[i]=c-A[i];
		    A[i+1]=c-A[i+1];
		}
	    }
		



	}
    }
}
		    
	
