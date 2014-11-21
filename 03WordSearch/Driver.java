public class Driver{
    public static void main(String[]args){
	WordGrid A = new WordGrid(5,5);
	A.addHorizontal("demo",1,1);
	A.addVertical("bane",0,1);
	A.addDiagonal("ayy",1,2);
	System.out.println(A.toString());






    }
}
