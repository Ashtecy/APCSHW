public class Driver{
    
    public static void main(String[]args){
	int[]A=Sorts.randArray(500000);
	int[]B=Sorts.copyArray(A);
	int[]C=Sorts.copyArray(A);
	//System.out.println(Sorts.toString(A));

	long startTime,endTime;
	
	System.out.println("\n"+"Bubble Sort");
	startTime=System.currentTimeMillis();
	Sorts.bubbleSort(A);
	endTime=System.currentTimeMillis();
	//System.out.println(Sorts.toString(A));
	System.out.println((endTime-startTime));

	System.out.println("\n"+"Insertion Sort"+"\n");
	startTime=System.currentTimeMillis();
	Sorts.insertionSort(B);
	endTime=System.currentTimeMillis();
	//System.out.println(Sorts.toString(B));
	System.out.println((endTime-startTime));
	
	System.out.println("\n"+"Selection Sort"+"\n");
	startTime=System.currentTimeMillis();
	Sorts.selectionSort(C);
	endTime=System.currentTimeMillis();
	//System.out.println(Sorts.toString(C));
	System.out.println((endTime-startTime));



    }
}
