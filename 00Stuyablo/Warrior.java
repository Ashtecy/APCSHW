import java.util.Random;
public class Warrior extends Adventurer{
    
    private int rage;

    public Warrior(String s){
	super(s,25,8,8,8);
	rage = 0;
    }

    public Warrior(){
	this("Bevan");
    }

    public void setRage(int rage){
	this.rage=rage;
    }
        
    public String getStats(){
	return "Warrior"+"\n"
	    +super.getStats()+"\n"
	    +"Rage: "+rage; 
    }
    
    public void attack(Adventurer other){
	System.out.println(this.getName() + " attacks " + other.getName());
	if (hit(other)){
	    Random rand = new Random();
	    int damage = rand.nextInt(this.getStr()/2)+2;
	    other.setHP(other.getHP()-damage);
	    System.out.println("And deals "+damage+" points of damage");
	    rage+=damage;
	}else{
	    System.out.println("But misses");
	}
    }
    public void specialAttack(Adventurer other){
	if (rage>=10){
	    System.out.println(this.getName()+" charges foward to bash "+other.getName());
	    if (hit(other)){
		Random rand = new Random();
		int damage = rand.nextInt(this.getStr()-8)+8;
		other.setHP(other.getHP()-damage);
		System.out.println("And deals "+damage+" points of damage");
	    }else{
		System.out.println("But misses");
	    }  
	    rage-=10;
	}else{
	    System.out.println(this.getName()+" does not poessess enough rage to bash "+other.getName());
	    System.out.println("Instead");
	    attack(other);
	}
    }
}
