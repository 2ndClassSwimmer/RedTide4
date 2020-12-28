import java.util.*;

public class Interface {
	
	int menuChoice = 0;
	int gearType=2;
	int gearLevel=0;
	int compResponse=0;
	int enemyLevel=0;
	
	String type="";
	String gearName="";
	
	Random randNum = new Random();
	Scanner keyboard = new Scanner(System.in);
	
	public void store(Player playerObject)
	{
		System.out.println("");
		do
		{
			playerObject.displayCurrency();
			System.out.println("Available Inventory\n1: Armor\n2: Weapons\n3: Disengage Interface");
			menuChoice = keyboard.nextInt();
			
			playerObject.displayCurrency();
			
			switch (menuChoice)
			{
			case 1:
				System.out.println("");
				do
				{
					System.out.println("Available Armor\n1: Flexible Light Armor (25cr)\n2: Ceramic Plate Armor (50cr)\n3: Kinetic Shield Generator (100cr)\n4: Back");
					menuChoice = keyboard.nextInt();
					
					switch(menuChoice)
					{
					case 1:
						if (playerObject.getCurrency()>=25)
						{
							System.out.println("");
							gearType = 0;
							gearName = "Flexible Light Armor";
							gearLevel = 1;
							playerObject.setCurrency(playerObject.getCurrency()-25);
							playerObject.displayCurrency();
						}else System.out.println("Insufficient Funds");
						break;
					case 2:
						if (playerObject.getCurrency()>=50)
						{
							System.out.println("");
							gearType = 0;
							gearName = "Ceramic Plate Armor";
							gearLevel = 2;
							playerObject.setCurrency(playerObject.getCurrency()-50);
							playerObject.displayCurrency();
						}else System.out.println("Insufficient Funds");
						break;
					case 3:
						if (playerObject.getCurrency()>=100)
						{
							System.out.println("");
							gearType = 0;
							gearName = "Kinetic Shield Generator";
							gearLevel = 3;
							playerObject.setCurrency(playerObject.getCurrency()-100);
							playerObject.displayCurrency();
						}else System.out.println("Insufficient Funds");
						break;
					case 4:
						System.out.println("");
						break;
					default:
						System.out.println("\nInvalid parameter\n");
						menuChoice = 0;
					}
				}while (menuChoice==0);
				
				if (gearType < 2)
				{
					Gear gear1 = new Gear(gearName, gearType, gearLevel);
					gear1.displayGear();
				}
				break;
			case 2:
				System.out.println("");
				do
				{
					System.out.println("Available Weapons\n1: Pulse Laser (25cr)\n2: Pulse Carbine (50cr)\n3: Pulse Rifle (100cr)\n4: Back");
					menuChoice = keyboard.nextInt();
					switch(menuChoice)
					{
					case 1:
						if (playerObject.getCurrency()>=25)
						{
							System.out.println("");
							gearType = 1;
							gearName = "Pulse Laser";
							gearLevel = 1;
							playerObject.setCurrency(playerObject.getCurrency()-25);
							playerObject.displayCurrency();
						}else System.out.println("Insufficient Funds");
						break;
					case 2:
						if (playerObject.getCurrency()>=50)
						{
							gearType = 1;
							gearName = "Pulse Carbine";
							gearLevel = 2;
							playerObject.setCurrency(playerObject.getCurrency()-50);
							playerObject.displayCurrency();
						}else System.out.println("Insufficient Funds");
						System.out.println("");
						break;
					case 3:
						if (playerObject.getCurrency()>=100)
						{
							System.out.println("");
							gearType = 1;
							gearName = "Pulse Rifle";
							gearLevel = 3;
							playerObject.setCurrency(playerObject.getCurrency()-100);
							playerObject.displayCurrency();
						}else System.out.println("Insufficient Funds");
						break;
					case 4:
						System.out.println("");
						break;
					default:
						System.out.println("\nInvalid parameter\n");
						menuChoice = 0;
					}
				}while (menuChoice==0);
				
				if (gearType < 2)
				{
					Gear gear2 = new Gear(gearName, gearType, gearLevel);
					gear2.displayGear();	
				}
				break;
			case 3:
				menuChoice=10;
				System.out.println("");
				break;
			default:
				System.out.println("\nInvalid parameter\n");
				menuChoice = 0;
			}
		}while (menuChoice < 10);
	}//end of store method
	
	//Medical facilities-------------------------------------------------------------------------------------------------------------------------------
	
	//small ship - quarters
	//large ship - med bay
	//navsta - naval hospital
	
	//general - clinic
	
	public void clinic(Player playerObject)
	{
		do
		{
			System.out.println("Clinic Interface");
			playerObject.displayCurrency();
			System.out.println("1: Check physical readiness\n2: Purchase Medkit (50cr)\n3: Recover health (100cr)\n4: Disengage Interface");
			menuChoice=keyboard.nextInt();
			switch (menuChoice)
			{
			case 1:
				playerObject.displayHealth();
				break;
			case 2:
				if (playerObject.getCurrency()>=50)
				{
					playerObject.setCurrency(playerObject.getCurrency()-50);
					playerObject.displayCurrency();
				}else System.out.println("Insufficient Funds");
				break;
			case 3:
				if (playerObject.getCurrency()>=100 && playerObject.getHealth()<playerObject.getLevel()*100/2)
				{
					playerObject.setHealth(playerObject.getLevel()*100/2);
					playerObject.setCurrency(playerObject.getCurrency()-100);
					playerObject.displayHealth();
					playerObject.displayCurrency();
				}else if (playerObject.getCurrency()<100 && playerObject.getHealth()==playerObject.getLevel()*100/2){
					System.out.println("Your physical readiness is optimal, and you have insufficient funds. Quit wasting our time!");
				}else if (playerObject.getCurrency()<100){ 
					System.out.println("Insufficient Funds");
				}else if (playerObject.getHealth()==playerObject.getLevel()*100/2){
					System.out.println("Physical readiness is optimal.");
				}
				break;
			case 4:
				break;
				default: System.out.println("Invalid Parameter");
				menuChoice=0;
			}
		}while (menuChoice == 0);
	}//end of clinic method
	
	//Dock locations-------------------------------------------------------------------------------------------------------------------------------
	
	public void pier(Player playerObject)
	{
		do
		{
			System.out.println("1: Berth 1\n2: Berth 2\n3: Leave peir");
			menuChoice = keyboard.nextInt();
			switch (menuChoice)
			{
			case 1:
				compResponse=randNum.nextInt(4)+1;
				if (compResponse==1)
				{
					type = "Skiff";
				}else if (compResponse==2){
					type = "Freighter";
				}else if (compResponse==3){
					type = "Super Freighter";
				}else type = "Cruise Liner";
				
				System.out.println(type + "\n1: Search vessel for illicit cargo\n2: Verify crew manifest\n3: Leave berth");
				menuChoice=keyboard.nextInt();
				switch (menuChoice)
				{
				case 1:
					//likelihood that illicit cargo found
					compResponse=randNum.nextInt(10);
					if (compResponse < 2)
					{
						//drugs
						compResponse=randNum.nextInt(3);
						if (compResponse==0)
						{
							System.out.println(playerObject.getName() + " found a crate filled with illicit drugs!\nThreat detected...\n");
							type="Drug Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else if (compResponse==1){
							//weapons
							System.out.println(playerObject.getName() + " found a weapons cache!\nThreat detected...\n");
							type="Gun Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else{
							//trafficking victims
							System.out.println(playerObject.getName() + " found trafficking victims!\nThreat detected...\n");
							type="Human Trafficker";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}
					}else System.out.println(playerObject.getName() + "'s search turned up nothing.");
					break;
				case 2:
					//likelihood that discrepancy found
					compResponse=randNum.nextInt(10);
					if (compResponse < 5)
					{
						System.out.println(playerObject.getName() + " found a discrepency on the crew manifest.\nSearching crew...\nSuspicious individual located...\nThreat detected...");
						if (compResponse < 2)
						{
							type="Drug Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else if (compResponse==3){
							type="Gun Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else{
							type="Human Trafficker";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}
					}else System.out.println("Crew manifest verified.");
					break;
				case 3:
					break;
					default: System.out.println("Invalid Parameter");
					menuChoice=0;
				}
				break;
			case 2:
				compResponse=randNum.nextInt(4)+1;
				if (compResponse==1)
				{
					type = "Skiff";
				}else if (compResponse==2){
					type = "Freighter";
				}else if (compResponse==3){
					type = "Super Freighter";
				}else type = "Cruise Liner";
				
				System.out.println(type + "\n1: Search vessel for illicit cargo\n2: Verify crew manifest\n3: Leave berth");
				menuChoice=keyboard.nextInt();
				switch (menuChoice)
				{
				case 1:
					//likelihood that illicit cargo found
					compResponse=randNum.nextInt(10);
					if (compResponse < 2)
					{
						//drugs
						compResponse=randNum.nextInt(3);
						if (compResponse==0)
						{
							System.out.println(playerObject.getName() + " found a crate filled with illicit drugs!\nThreat detected...\n");
							type="Drug Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else if (compResponse==1){
							//weapons
							System.out.println(playerObject.getName() + " found a weapons cache!\nThreat detected...\n");
							type="Gun Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else{
							//trafficking victims
							System.out.println(playerObject.getName() + " found trafficking victims!\nThreat detected...\n");
							type="Human Trafficker";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}
					}else System.out.println(playerObject.getName() + "'s search turned up nothing.");
					break;
				case 2:
					//likelihood that discrepancy found
					compResponse=randNum.nextInt(10);
					if (compResponse < 5)
					{
						System.out.println(playerObject.getName() + " found a discrepency on the crew manifest.\nSearching crew...\nSuspicious individual located...\nThreat detected...");
						if (compResponse < 2)
						{
							type="Drug Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else if (compResponse==3){
							type="Gun Runner";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else{
							type="Human Trafficker";
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}
					}else System.out.println("Crew manifest verified.");
					break;
				case 3:
					break;
					default: System.out.println("Invalid Parameter");
					menuChoice=0;
				}
				break;
			case 3:
				break;
				default: System.out.println("Invalid Parameter");
				menuChoice=0;
			}
		}while (menuChoice == 0);
	}//end of pier method
	
	public void warehouse(Player playerObject)
	{	
		do
		{
			System.out.println("1: Search warehouse for illicit cargo\n2: Leave warehouse");
			menuChoice =keyboard.nextInt();
			switch (menuChoice)
			{
			case 1:
				//likelihood that illicit cargo found
				compResponse=randNum.nextInt(10);
				if (compResponse < 2)
				{
					//drugs
					compResponse=randNum.nextInt(2);
					if (compResponse==0)
					{
						System.out.println(playerObject.getName() + " found a crate filled with illicit drugs!\nThreat detected...\n");
						type="Drug Runner";
						Enemy enemyObject = new Enemy(type);
						
						enemyObject.displayEnemy();
						
						Combat indivCombat1 = new Combat();
						indivCombat1.indivCombat(playerObject, enemyObject);
					}else{
						//weapons
						System.out.println(playerObject.getName() + " found a weapons cache!\nThreat detected...\n");
						type="Gun Runner";
						Enemy enemyObject = new Enemy(type);
						
						enemyObject.displayEnemy();
						
						Combat indivCombat1 = new Combat();
						indivCombat1.indivCombat(playerObject, enemyObject);
					}
				}else System.out.println(playerObject.getName() + "'s search turned up nothing.");
				break;
			case 2:
				break;
				default: System.out.println("Invalid Parameter");
			}
		}while (menuChoice==0);
	}

}
