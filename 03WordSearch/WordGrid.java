import static java.lang.Math.*;

public class WordGrid{
    private char data[][];
    
    public WordGrid(int rows,int cols){
	data=new char[cols][rows];
	clear();
    }

    private void clear(){
	for (int i=0;i<data[0].length;i++) {
	    for (int j=0;j<data.length;j++) {
		data[i][j] = '_';
	    }
	}
    }

    public String toString(){
	String grid="";
	for (int i=0;i<data[0].length;i++) {
	    for (int j=0; j<data.length;j++) {
		grid+=data[j][i]+" ";
	    }
	    grid+="\n";
	}
	return grid;
    }

    public boolean addHorizontal(String word,int col,int row){
	if (word.length()<=data.length-col){
	    for(int i=0;i<word.length();i++){
		data[col+i][row]=word.charAt(i);
	    }
	    return true;
	}else{
	    return false;
	}
    }

     public boolean addVertical(String word,int col,int row){
	 if (word.length()<=data[0].length-row){
	    for(int i=0;i<word.length();i++){
		data[col][row+i]=word.charAt(i);
	    }
	    return true;
	}else{
	    return false;
	}
     }

    public boolean addDiagonal (String word,int col,int row){
	if (word.length()<=data.length-col && word.length()<=data[0].length-row){
	    for (int i=0;i<word.length();i++){
		data[col+i][row+i]=word.charAt(i);
	    }
	    return true;
	}else{
	    return false;
	}
    }
}
