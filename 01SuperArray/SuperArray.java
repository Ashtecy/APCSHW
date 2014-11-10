public class SuperArray{
    
    Object[] A;
    int currentSize;
    
    public SuperArray(int size){
	currentSize=0;
	A=new Object[size];
    }

    public SuperArray(){
	this(10);
    }

    public String toString(){
	String printA="[";
	for(int i=0;i<currentSize;i++){
	    printA+=" "+A[i];
	}
	printA+=" ]";
	return printA;
    }

    public int size(){
	return currentSize;
    }

    public void add(Object e){
	if (currentSize+2==A.length){
	    Object[] B = new Object[currentSize+10];
	    for(int i=0;i<currentSize;i++){
		B[i]=A[i];
	    }
	    
	}
	currentSize++;
	A[currentSize-1]=e;
    }
	
}
