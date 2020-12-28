
public class Gear {
	
	String name = "";
	int type = 0;
	int level = 0;
	
	public String name()
	{
		return name;
	}
	
	public void setName(String changeName)
	{
		name = changeName;
	}
	
	public int getType()
	{
		return type;
	}
	
	public void setType(int changeType)
	{
		type = changeType;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int changeLevel)
	{
		level = changeLevel;
	}
	
	Gear (String initName, int initType, int initLevel)
	{
		name = initName;
		type = initType;
		level = initLevel;
	}
	
	public void displayGear()
	{
		switch (type)
		{
		case 0:
			System.out.println("Armor issued: " + name);
			break;
		case 1:
			System.out.println("Weapon issued:" + name);
		}
	}
	
	public void modifyPlayer(Player playerObject)
	{
		
	}

}
