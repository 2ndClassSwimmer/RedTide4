import java.io.*;

public class Player extends Character implements Serializable{
	
	String name = "";
	int armor = 0;
	int weapon = 0;
	boolean boarding = false;
	boolean aboard = false;
	String command = "Recruit Training Command";
	String loc = "";
	
	String rankTitle = "";
	String payGrade = "";
	
	private static final long serialVersionUID=199l;

	Player (String initName, String initCommand, String initLoc)
	{
		super (1, 0);
		
		name = initName;
		String command = initCommand;
		String loc = initLoc;

	
		if (level <=5){
			rankTitle = "Astronaut";
		}else if (level >5 && level <=10){
			rankTitle = "Petty Officer 3rd Class";
		}else if (level >10 && level <=15){
			rankTitle = "Petty Officer Second Class";
		}else if (level >15 && level <=20){
			rankTitle = "Petty Officer First Class";
		}else if (level >20 && level <=30){
			rankTitle = "Chief Petty Officer";
		}else if (level >30 && level <=40){
			rankTitle = "Senior Chief";
		}else if (level >40 && level <=50){
			rankTitle = "Master Chief";
		}else if (level >50 && level <=55){
			rankTitle = "Chief Warrant Officer";
		}else if (level >55 && level <=60){
			rankTitle = "Ensign";
		}else if (level >60 && level <=65){
			rankTitle = "Lieutenant";
		}else if (level >65 && level <=70){
			rankTitle = "Lieutenant Commander";
		}else if (level >70 && level <=75){
			rankTitle = "Commander";
		}else if (level >75 && level <=80){
			rankTitle = "Captain";
		}else if (level >80 && level <=85){
			rankTitle = "Rear Admiral";
		}else if (level >85 && level <=90){
			rankTitle = "Vice Admiral";
		}else if (level >90 && level <=99){
			rankTitle = "Admiral";
		}else if (level == 100){
			rankTitle = "Fleet Admiral";
		}
		
		if (level <=50){
			payGrade = "E";
		}else if (level >50 && level <=55){
			payGrade = "W";
		}else if (level >55){
			payGrade = "O";
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String changeName)
	{
		name = changeName;
	}
	
	public int getToNextLevel()
	{
		return toNextLevel;
	}
	
	public void setToNextLevel(int changeToNextLevel)
	{
		toNextLevel = changeToNextLevel;
	}
	
	public int getCurrency()
	{
		return currency;
	}
	
	public void setCurrency(int changeCurrency)
	{
		currency = changeCurrency;
	}
	
	public String getCommand()
	{
		return command;
	}
	
	public void setCommand(String changeCommand)
	{
		command = changeCommand;
	}
	
	public boolean getAboard()
	{
		return aboard;
	}
	
	public void setAboard(boolean changeAboard)
	{
		aboard = changeAboard;
	}
	
	
	public boolean getBoarding()
	{
		return boarding;
	}
	
	public void setBoarding(boolean changeBoarding)
	{
		boarding = changeBoarding;
	}
	
	public String getLoc()
	{
		return loc;
	}
	
	public void setLoc(String changeLoc)
	{
		loc = changeLoc;
	}
	
	public void displayPlayer()
	{
		Character PlayerCharacter = new Character(1, 0);
		
		System.out.println("*****SERVICE PROFILE*****");
		System.out.println("Name: " + name);
		System.out.println("Rank: " + rankTitle + " " + payGrade + level);
		System.out.println("Command: " + command);
		System.out.println("Current location: " + loc);
		System.out.println("Rank advance in: " + toNextLevel + " service credits.");
		System.out.println("Funding: " + currency);
		System.out.println("Physical readiness: " + health + " (" +healthTitle+ ")");
		System.out.println("Combat effective: " + attack + " (" + attackTitle + ")");
		System.out.println("Defensive readiness: " + defense + " (" + defenseTitle + ")");
		System.out.println("EEV (Escape & Evasion): " + evasion + " (" + evasionTitle + ")");
		System.out.println("");
	}
	
	public void displayHealth()
	{
		System.out.println(name + " physical readiness: " + health);
		System.out.println("");
	}
	
	public void displayLevel()
	{
		System.out.println("Rank: " + rankTitle + " " + payGrade + level);
		System.out.println("");
	}
	
	public void displayCurrency()
	{
		System.out.println("Funding: " + currency);
		System.out.println("");
	}
		
}