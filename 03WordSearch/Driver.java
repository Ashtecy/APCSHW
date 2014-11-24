import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[]args)throws FileNotFoundException{
	WordGrid A = new WordGrid(10,10);
	File text = new File("Words.txt");
	Scanner in = new Scanner(text);
	ArrayList<String> words = new ArrayList<String>();
	while(in.hasNextLine()){
	    words.add(in.nextLine());
	}
	for(int i=0;i<words.size();i++){
	    System.out.println(words.get(i));
	}






    }
}
