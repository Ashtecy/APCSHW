public class Driver{
    
    public static void main(String[]args){
	int[]A=Sorts.randArray(10);
       	System.out.println(Sorts.toString(A));

	long startTime,endTime;
	
	startTime=System.currentTimeMillis();
	Sorts.bubbleSort(A);
	endTime=System.currentTimeMillis();
	System.out.println(Sorts.toString(A)+"\n"+(endTime-startTime));




    }
}
