
public class Character {
	

	int level = 0;
	int toNextLevel;
	int health = 0;
	int currency = 0;
	int attack = 0;
	int defense = 0;
	int evasion = 0;
	int armor = 0;
	int weapon = 0;
	
	boolean lvlUp=false;
	
	String healthTitle = "";
	String attackTitle = "";
	String defenseTitle = "";
	String evasionTitle = "";
	
	public Character (int initLevel, int initCurrency) {
		
		level = initLevel;
		toNextLevel = level*500/2;
		currency = initCurrency;
		health = level*100/2;
		attack = level*25/2;
		defense = level*10/2;
		evasion = level*8/2;
		
		if (health <=50){
			//above should be 250
			healthTitle = "FNG";
		}else if (health >250 && health <=500){
			healthTitle = "Brawler";
		}else if (health >500 && health <=750){
			healthTitle = "Basic Qualied";
		}else if (health >750 && health <=1000){
			healthTitle = "Operator Qualified";
		}else if (health >1000 && health <=1250){
			healthTitle = "Second Class Operative";
		}else if (health >1250 && health <=1500){
			healthTitle = "First Class Operative";
		}else if (health >1500 && health <=1750){
			healthTitle = "Warfighter";
		}else if (health >1750 && health <=2000){
			healthTitle = "Veteran";
		}else if (health >2000 && health <=2250){
			healthTitle = "Battle Hardened";
		}else if (health >2250 && health <=2500){
			healthTitle = "Shellback";
		}else if (health >2500 && health <=2750){
			healthTitle = "";
		}else if (health >2750 && health <=3000){
			healthTitle = "Salt Dog";
		}else if (health >3000 && health <=3250){
			healthTitle = "\"I've been doing this shit since Captain Cruch was an Ensign.\"";
		}else if (health >3500 && health <=4750){
			healthTitle = "Act of Congress, force retired.";
		}else if (health >4750 && health <=5000){
			healthTitle = "INDOMITABLE";
		}
		
		if (attack <=25){
			attackTitle = "Cannon Fodder";
		}else if (attack >25 && attack <=50){
			attackTitle = "Grunt";
		}else if (attack >475 && attack <=500){
			attackTitle = "Shock Trooper";
		}
		
		if (defense <=25){
			defenseTitle = "Liability";
		}else if (defense >25 && defense <=50){
			defenseTitle = "Bullet Sponge";
		}else if (defense >50 && defense <=75){
			defenseTitle = "Target of Oportunity";
		}else if (defense >75 && defense <=100){
			defenseTitle = "Bullet Resistant";
		}else if (defense >25 && defense <=50){
			defenseTitle = "Bullet Proof";
		}else if (defense >400 && defense <=450){
			defenseTitle = "Hard Target";
		}
		
		if (evasion <=20){
			evasionTitle = "Sitting Duck";
		}else if (evasion >20 && evasion <=40){
			evasionTitle = "\"Floats like lead, stings like a butterfly.\"";
		}else if (evasion >20 && evasion <=40){
			evasionTitle = "Bullet Dodger";
		}else if (evasion >380 && evasion <=400){
			evasionTitle = "Phantom Menace";
		}
		
	}
	
	public void setLvlUp(boolean changeLvlUp)
	{
		lvlUp=true;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int changeLevel)
	{
		level = changeLevel;
	}
	
	public int getToNextLevel()
	{
		return toNextLevel;
	}
	
	public void setToNextLevel(int changeToNextLevel)
	{
		toNextLevel = changeToNextLevel;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public String getHealthTitle()
	{
		return healthTitle;
	}
	
	public void setHealth(int changeHealth)
	{
		health = changeHealth;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public String getAttackTitle()
	{
		return attackTitle;
	}
	
	public void setAttack(int changeAttack)
	{
		attack = changeAttack;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public String getDefenseTitle()
	{
		return defenseTitle;
	}
	
	public void setDefense(int changeDefense)
	{
		defense = changeDefense;
	}
	
	public int getEvasion()
	{
		return evasion;
	}
	
	public String getEvasionTitle()
	{
		return evasionTitle;
	}
	
	public void setEvasion(int changeEvasion)
	{
		evasion = changeEvasion;
	}
	
	public int getCurrency()
	{
		return currency;
	}
	
	public void setCurrency (int changeCurrency)
	{
		currency = changeCurrency;
	}
	
	public int getArmor()
	{
		return armor;
	}
	
	public void setArmor(int changeArmor)
	{
		armor = changeArmor;
	}
	
	public int getWeapon()
	{
		return weapon;
	}
	
	public void setWeapon(int changeWeapon)
	{
		weapon = changeWeapon;
	}

}
