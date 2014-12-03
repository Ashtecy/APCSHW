public class SuperArray{
    
    String[] A;
    int currentSize;
    
    public SuperArray(int size){
	currentSize=0;
	A=new String[size];
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

    public void add(String e){
	if (currentSize==A.length){
	    resize(currentSize*2);
	}
	currentSize++;
	A[currentSize-1]=e;;
    }

    public void add(int index,String e){
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
	String[] B = new String[newCapacity];
	for(int i=0;i<currentSize;i++){
	    B[i]=A[i];
	}
	A=B;
    }
    
    public void clear(){
	String[] B = new String[10];
	A=B;
	currentSize=0;
    }
	
    public String get(int index){
	if (index<currentSize && index>=0){
	    return A[index];
	}else{
	    return "Error";
	}
    }
    
    public String set(int index,String e){
	String ret;
	if (index<currentSize){
	    ret=A[index];
	    A[index]=e;
	}else{
	    ret=null;
	    System.out.println("error");
	}
	return ret;
    }

    public String remove(int index){
	String ret;
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
