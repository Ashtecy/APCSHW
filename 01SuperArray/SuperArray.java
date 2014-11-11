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
	if (currentSize==A.length){
	    resize(currentSize*2);
	}
	currentSize++;
	A[currentSize-1]=e;;
    }

    public void resize(int newCapacity){
	Object[] B = new Object[newCapacity];
	for(int i=0;i<currentSize;i++){
	    B[i]=A[i];
	}
	A=B;
    }
    
    public void clear(){
	Object[] B = new Object[10];
	A=B;
	currentSize=0;
    }
	
    public Object get(int index){
	if (index<currentSize){
	    return A[index];
	}else{
	    return "Error";
	}
    }
    
    public void set(int index, Object e){
	if (index<currentSize){
	    A[index]=e;
	}else{
	    System.out.println("error");
	}
    }
}

