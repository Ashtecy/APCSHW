import java.util.Random;
public class Monk extends Adventurer{
    
    private int qi;
    
    public Monk(String s){
	super(s,25,8,8,8);
	qi = this.getDex()+this.getStr();
    }
    public Monk(){
	this("Kobold");
    }

    public String getStats(){
	return "Monk"+"\n"
	    +super.getStats()+"\n"
	    +"Qi: "+qi;
    }

    
    public void attack(Adventurer other){
	System.out.println(this.getName() + " attacks " + other.getName());
	if (hit(other)){
	    Random rand = new Random();
	    int damage = rand.nextInt(this.getStr()/2)+2;
	    other.setHP(other.getHP()-damage);
	    System.out.println("And deals "+damage+" points of damage");
	    qi+=3;
		}else{
	    System.out.println("But misses");
	   qi--;
	};
    }

    public void specialAttack(Adventurer other){
	if (qi>=7){
	    System.out.println(this.getName()+" release a resonating strike at "+other.getName());
	    if (hit(other)){
		Random rand = new Random();
		int damage = rand.nextInt((this.getStr()+this.getDex())/2);
		other.setHP(other.getHP()-damage);
		System.out.println("And deals "+damage+" points of damage");
		
	    }
	}
    }
}
