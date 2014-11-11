public class Driver{
    public static void main(String[]args){
	SuperArray Alpha = new SuperArray();
	SuperArray Beta = new SuperArray(15);
	Alpha.add(1);
	Alpha.add(2);
	Alpha.add(3);
	Alpha.add(4);
	Alpha.add(5);
	Alpha.add(6);
	Alpha.add(7);
	Alpha.add(8);
	Alpha.add(9);
	Alpha.add(10);
	Alpha.add("infinity");
	Alpha.set(5,5);
	System.out.println(Alpha.get(5)+"\n"+Alpha.get(13));
	Alpha.add(1,99);
	System.out.println(Alpha.toString());
    }
}

