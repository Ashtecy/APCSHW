public class OrderedSuperArray extends SuperArray{
    
    public void add(String e){
	int c=0;
	if (currentSize==0){
	    super.add(e);
	}else{
	    for (int i=0;i<currentSize;i++){
		if (e.compareTo(A[i])<0 && c==0){
		    super.add(i,e);
		    c=1;
		}
	    }
	}
    }

    public void insertionSort(){
	int j=2;
	for(int i=1;i<;i++){
	    if A[i].compareTo()
    }
}