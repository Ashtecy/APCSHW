import java.io.*;
import java.util.*;

public class WordGrid{
    
    private char data[][];
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    
    public WordGrid(int rows,int cols){
	data=new char[cols][rows];
	clear();
    }
    
    private void clear(){
	for (int i=0;i<data[0].length;i++) {
	    for (int j=0;j<data.length;j++) {
		data[j][i] = '_';
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
    
    public boolean addRandom(String word){
	Random  rand = new Random();
	return add(word,rand.nextInt(data.length),rand.nextInt(data[0].length),rand.nextInt(3)-1,rand.nextInt(3)-1);
    }
  
    public boolean add(String word,int row,int col,int dx,int dy){
	if (check(word,row,col,dx,dy)){
	    for(int i=0;i<word.length();i++){
		data[col][row]=word.charAt(i);
		col+=dx;
		row+=dy;
	    }
	    return true;
	}else{
	    return false;
	}
    }

    public boolean check(String word,int row,int col,int dx,int dy){
	if(dx==0 && dy==0 
	   || row<0 || col<0
	   || row+dx*word.length()>=data.length
	   || row+dx*word.length()<0
	   || col+dy*word.length()>=data[0].length
	   || col+dy*word.length()<0){
	    return false;
	}
	for(int i=0;i<word.length();i++){
	    if(data[col][row]!='_'
	       && data[col][row]!=word.charAt(i)){
		return false;
	    }
	    col+=dx;
	    row+=dy;
	}
	return true;
    }

    public void createSearch(ArrayList<String> wordsAll){
	for(int i=0;i<wordsAll.size();i++){
	    int tries=20;
	    do{
		if(addRandom(wordsAll.get(i))){
		    wordsAdded.add(wordsAll.get(i));
		}
		tries--;
	    }while(tries>0 && !wordsAdded.contains(wordsAll.get(i)));
	}
	fill();
	System.out.println(wordsInPuzzle()+"\n"+toString());
    }

    public void fill(){
	String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	Random rand = new Random();
	for (int i=0;i<data[0].length;i++) {
	    for (int j=0;j<data.length;j++) {
		if(data[j][i]==('_')){
		    data[j][i]=chars.charAt(rand.nextInt(chars.length()));
		}
	    }
	}
    }


    public void loadWordsFromFile(String fileName,boolean fillRandomLetters){
    }

    public String wordsInPuzzle(){
	String wip="";
	int lineCounter=4;
	for(int i=0;i<wordsAdded.size();i++){
	    wip+=wordsAdded.get(i)+"\t";
	    lineCounter--;
	    if(lineCounter==0){
		wip+="\n";
		lineCounter=4;
	    }
	}
	return wip;
    }
    
}
