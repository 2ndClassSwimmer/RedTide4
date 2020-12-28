import java.util.*;

public class Enemy extends Character {
	String type = "";
	int compResponse=0;
	
	Random randNum=new Random();
	
	Enemy (String initType)
	{
		super (1, 0);
		type = initType;
		
		if (type.equals("Mugger")){
			level=1;
		}else if (type.equals("Drug Runner")) {
			level=2;
		}else if (type.equals("Gun Runner")) {
			level=3;
		}else if (type.equals("Human Trafficker")) {
			level=4;
		}else if (type.equals("Mercenary")) {
			level=5;
		}else if (type.equals("Pirate")) {
			level=6;
		}else if (type.equals("CSA Trooper")) {
			level=7;
		}else if (type.equals("CSA Ranger")) {
			level=8;
		}else if (type.equals("CSA Commando")) {
			level=9;
		}else if (type.equals("Red Tide Shock Trooper")||type.equals("Red Tide Commando")) {
			level=10;
		}
		
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String changeType)
	{
		type = changeType;
	}
	
	public void displayEnemy()
	{	
		
		System.out.println("*****THREAT ASSESSMENT*****");
		System.out.println("Type: " + type);
		System.out.println("Threat classification: Category " + level);
		System.out.println("Physical readiness: " + health + " (" + healthTitle + ")");
		System.out.println("Combat effective: " + attack + " (" + attackTitle + ")");
		System.out.println("Defensive readiness: " + defense + " (" + defenseTitle + ")");
		System.out.println("EEV (Escape & Evasion): " + evasion + " (" + evasionTitle + ")");
		System.out.println("");
	}//end of displayEnemy
	
	public void displayEnemyHealth() 
	{	
		System.out.println(type + " physical readiness: " + health);
		System.out.println("");
	}
	
}
