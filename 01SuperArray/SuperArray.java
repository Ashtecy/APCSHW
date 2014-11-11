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

    public void add(int index,Object e){
	if (currentSize==A.length){
	    resize(currentSize*2);
	}
	if (index>currentSize-1){
	    add(e);
	}else if (index<0){
	    System.out.println("Error");
	}else{
	    for(int i=currentSize;i>index;i--){
		A[i]=A[i-1];
	    }
	    A[index]=e;
	    currentSize++;
	}
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
	if (index<currentSize && index>=0){
	    return A[index];
	}else{
	    return "Error";
	}
    }
    
    public Object set(int index,Object e){
	Object ret;
	if (index<currentSize){
	    ret=A[index];
	    A[index]=e;
	}else{
	    ret=null;
	    System.out.println("error");
	}
	return ret;
    }

    public Object remove(int index){
	Object ret;
	if (4*currentSize==A.length){
	    resize(currentSize/2);
	}
	if (index<0||index>=currentSize){
	    System.out.println("error");
	    ret=null;
	}else {
	    ret=A[index];
	    for(int i=currentSize-1;i>=index;i--){
		A[i]=A[i-1];
	    }
	}
	return ret;
    }
	
}
