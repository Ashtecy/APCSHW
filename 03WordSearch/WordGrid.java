public class WordGrid{
    private char data[][];
    
    public WordGrid(int rows,int cols){
	data=new char[rows][cols];
    }

    private void clear(){
	for (int i = 0; i < data[0].length; i++) {
	    for (int j = 0; j < data.length; j++) {
		data[i][j] = ' ';
	    }
	}
    }

    public String toString(){
	String grid="";
	for (int i = 0; i < data[0].length; i++) {
	    for (int j = 0; j < data.length; j++) {
		grid+=data[i][j]+"\t";
	    }
	    grid+="\n";
	}
	return grid;
    }

    public boolean addHorizontal(String word,int row,int col){
	if (word.length<=data[0].length-col){
	    for()
	
}
