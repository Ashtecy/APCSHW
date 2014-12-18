import java.lang.Object;
import java.util.Scanner;
import java.util.Random;

public class Game2{
   
    public static Adventurer[] partyGeneration(){
	Adventurer[]party=new Adventurer[4];
	System.out.println("A: Default Party\nB: Custom Party");
	Scanner in = new Scanner(System.in);
	String partyChoice=in.nextLine();
	if (partyChoice.equalsIgnoreCase("A")){
	    party=partyGen1();
	}else if (partyChoice.equalsIgnoreCase("B")){
	    party=partyGen2();
	}else{
	    partyGeneration();
	}
	return party;
    }
    
    public static Adventurer[] partyGen1(){
	Adventurer[]party = new Adventurer[4];
	Warrior p0 = new Warrior();
	Wizard p1 = new Wizard();
	Rogue p2 = new Rogue();
	Monk p3 = new Monk();
	party[0]=p0;
	party[1]=p1;
	party[2]=p2;
	party[3]=p3;
	return party;
    }

    public static Adventurer[] partyGen2(){
	Adventurer[]party;
	System.out.println("Choose A Party Size Between 1 and 12\n");
	Scanner in = new Scanner(System.in);
	int partySize=in.nextInt();
	party=new Adventurer[partySize];
	for(int i=0;i<partySize;i++){
	    party[i]=playerGeneration();
	}
	return party;
    }
    
    public static Adventurer playerGeneration(){
	Adventurer player;
	player = setClassType();
	player.setName(setCharName());
	player = statAllocation(player,30);
	return player;	
    }
    
    public static String setCharName(){
	System.out.println("Choose Your Character Name\n");
	Scanner in = new Scanner(System.in);
	String name=in.nextLine();
	if (!name.equals("")){
	    return name;
	}else{
	    return null;
	}
    }

    public static Adventurer setClassType(){
	Adventurer player;
	String classType="";
	Scanner in = new Scanner(System.in);
	while(!classType.equalsIgnoreCase("A")&&!classType.equalsIgnoreCase("B")&&!classType.equalsIgnoreCase("C")&&!classType.equalsIgnoreCase("D")){
	    System.out.println("Choose Your Class\nA: Warrior\nB: Wizard\nC: Rogue\nD: Monk");
	    classType=in.nextLine();
	}
	if (classType.equalsIgnoreCase("A")){
	    player=new Warrior();
	}else if (classType.equalsIgnoreCase("B")){
	    player=new Wizard();
	}else if (classType.equalsIgnoreCase("C")){
	    player=new Rogue();
	}else {
	    player=new Monk();
	}
	return player;
    }

    public static Adventurer statAllocation(Adventurer player,int points){
	System.out.println(points+" unallocated");
	Scanner in = new Scanner(System.in);
	if (points>0){
	    System.out.println("Allocate Points into Strenght:");
	    int alo=in.nextInt();
	    player.setStr(player.getStr()+alo);
	    points-=alo;
	    if (points>0){
		System.out.println("Allocate Points into Intelligence");
		alo=in.nextInt();
		player.setInt(player.getInt()+alo);
		points-=alo;
		if (points>0){
		    System.out.println("Allocate Points into Dexterity");
		    alo=in.nextInt();
		    player.setDex(player.getDex()+alo);
		    points-=alo;
		}
	    }
	}else{
	    return player;
	}
	if (points>0){
	    statAllocation(player,points);
	}
	return player;
    }
        
    public static Adventurer enemyGeneration(int partySize){
	Adventurer opponent;
	opponent = setRClassType();
	opponent = statRAllocation(opponent,partySize);
	opponent.setName("Bork");
	return opponent;
    }

    public static Adventurer setRClassType(){
	Adventurer opponent;
	Random rand = new Random();
	int randClass = rand.nextInt(4);
	if (randClass==0){
	    opponent=new Warrior();
	}else if (randClass==1){
	    opponent=new Wizard();
	}else if (randClass==2){
	    opponent=new Rogue();
	}else {
	    opponent=new Monk();
	}
	return opponent;
    }
    
    public static Adventurer statRAllocation(Adventurer opponent,int scaling){
	Random rand = new Random();
	int points = scaling*40;
	int alo = 0;
	while (points>0){
	    alo=rand.nextInt(3);
	    if (alo==0){
		opponent.setStr(opponent.getStr()+1);
	    }else if (alo==1){
		opponent.setInt(opponent.getInt()+1);
	    }else {
		opponent.setDex(opponent.getDex()+1);
	    }
	    points--;
	}
	return opponent;	
    }
    
    public static void combat(Adventurer[] party,Adventurer opponent){
	System.out.println("\nYour enemy is:\n"+opponent.getStats());
	System.out.println("\nLet the Fight Begin\n");
	int counter=2;
	do{
	    for (int i=0;i<party.length;i++){
		if (party[i].getHP()>0 && opponent.getHP()>0){
		    playerTurn(party[i],opponent);
		    System.out.println("\n");
		}
	    }
	    Adventurer player=aggro(party);
	    System.out.println("\n");
	    if (battleCheck(party,opponent)){
		opponentTurn(opponent,player,counter);
		System.out.println("\n");
	    }
	}while(battleCheck(party,opponent));
	if (partyHealth(party)>0){
	    System.out.println("Victory!\n");
	}else{
	    System.out.println("Defeat!\n");
	}
	for (int i=0;i<party.length;i++){
	    System.out.println(party[i].getStats());
	}
	opponent.getStats();
    }
    
    public static boolean battleCheck(Adventurer[] party,Adventurer opponent){
	int battleHealth=0;
	battleHealth=partyHealth(party)+opponentHealth(opponent);
	return battleHealth!=0;
    }

    public static int partyHealth(Adventurer[] party){
	int battleHealth=0;
	for (int i=0;i<party.length;i++){
	    if (party[i].getHP()>0){
		battleHealth++;
	    }
	}
	return battleHealth;
    }
    
    public static int opponentHealth(Adventurer opponent){
	if (opponent.getHP()<=0){
	    return 0;
	}else{
	    return 1;
	}
    }

    public static void playerTurn(Adventurer player,Adventurer opponent){
	System.out.println(player.getStats());
	System.out.println("\nWhat would you like to do?"+"\n"
			   +"A: Attack " + opponent.getName()+"\n"
			   +"S: Perform a special attack on " + opponent.getName()+"\n"
			   +"G: Give Up"
			   );
	Scanner in = new Scanner(System.in);
	String action = in.nextLine();
	while ((!action.equalsIgnoreCase("A"))&&(!action.equalsIgnoreCase("S"))&&(!action.equalsIgnoreCase("G"))){
	    System.out.println("Invalid Move");
	    action = in.nextLine();
	}
	if (action.equalsIgnoreCase("G")){
	    player.setHP(0);
	}else if (action.equalsIgnoreCase("A")){
	    player.attack(opponent);
	}else {
	    player.specialAttack(opponent);
	}
    }
    public static Adventurer aggro(Adventurer[] party){
	Adventurer player=null;
	for (int i=0;i<party.length;i++){
	    if (party[i].getHP()>0){
	        player=party[0];
	    }
	}
	return player;
    }

    public static void opponentTurn(Adventurer opponent,Adventurer player,int counter){
	if (counter==0){
	    opponent.specialAttack(player);
	    counter=2;
	}else{
	    opponent.attack(player);
	    counter--;
	}
    }

    public static Adventurer[] partyCopy(Adventurer[] party){
	Adventurer[] party2=new Adventurer[party.length];
	for (int i=0;i<party.length;i++){
	    party2[i]=party[i];
	}
	return party2;
    }	
    
    public static void combat2(Adventurer[] party){
	System.out.println("\nWould you like to reenter the Gauntlet?\n(Y/N)");
       	Adventurer[]party2=partyCopy(party);
	Scanner in = new Scanner(System.in);
	String goAgain=in.nextLine();
	if (goAgain.equalsIgnoreCase("y")){
	    Adventurer opponent = enemyGeneration(party.length);
	    combat(party,opponent);
	    combat2(party2);
	}
    }
	    
    public static void main(String[]args){
	System.out.println("Welcome Hero!"+"\n"
			   +"You Are Now Entering The Gauntlet"+"\n"
			   +"Prepare Thyself!"+"\n"+"\n");
	Adventurer[]party;
	party=partyGeneration();
	Adventurer[]party2=partyCopy(party);
	Adventurer opponent;
	opponent=enemyGeneration(party.length);
       	combat(party,opponent);
	combat2(party2);
    }
}
