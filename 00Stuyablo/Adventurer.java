import java.util.Random;
public abstract class Adventurer{
  
    private String name;
    private int HP,Str,Int,Dex;
    
    public Adventurer(String n,int startHP,int startStr,int startInt,int startDex){
	name = n;
	HP = startHP;
	Str = startStr;
	Int = startInt;
	Dex = startDex;
    }
    public Adventurer(String n){
	this(n,20,9,9,9);
    }
    
    public Adventurer(){
	this("Wane",20,9,9,9);
    }
  
    public String getStats(){
	return getName()+"\n"
	    +"HP: "+getHP()+"\n"
	    +"Str: "+getStr()+"\n"
	    +"Int: "+getInt()+"\n"
	    +"Dex: "+getDex();
    }

    public String getName(){
	return name;
    }
    public void setName(String name){
	this.name=name;
    }

    public int getHP(){
	return HP;
    }
    public void setHP(int HP){
	this.HP=HP;
    }

    public int getStr(){
	return Str;
    }
    public int getInt(){
	return Int;
    }
    public int getDex(){
	return Dex;
    }
    
    public void setStr(int Str){
	this.Str=Str;
    }
    public void setInt(int Int){
	this.Int=Int;
    }
    public void setDex(int Dex){
	this.Dex=Dex;
    }

    public boolean hit(Adventurer other){
	Random rand = new Random();
	double chance = (double)this.getDex()/(this.getDex()+other.getDex())+.3;
	return rand.nextDouble()<=chance;
    }   

    public abstract void attack(Adventurer other);
    
    public abstract void specialAttack(Adventurer other);
    
    
}
