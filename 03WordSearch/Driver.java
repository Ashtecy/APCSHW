import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[]args)throws FileNotFoundException{
	WordGrid A = new WordGrid(10,10);
	
	File text = new File("Words.txt");
	Scanner in = new Scanner(text);
	
	ArrayList<String> wordsAll = new ArrayList<String>();
	while(in.hasNextLine()){
	    wordsAll.add(in.nextLine());
	}
	for(int i=0;i<wordsAll.size();i++){
	    wordsAll.set(i,wordsAll.get(i).toUpperCase());
	}
        
	System.out.println(A.toString());
	A.createSearch(wordsAll);
	
    }
}
