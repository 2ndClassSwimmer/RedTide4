import java.util.*;

public class Locations {
	
	public static void loc(Player playerObject)
	{
		int menuChoice = 0;
		int enemyLevel = 0;
		int compResponse = 0;
		int loc = 1;
		boolean inLocNav = true;
		String type = "";
		
		Scanner keyboard = new Scanner(System.in);
		Random randNum=new Random();
		
		if (playerObject.getLoc().equals("Naval Station Hai Phong"))
		{
			System.out.println("Welcome to Naval Station Hai Phong");
			do
			{
				if (playerObject.getLoc().equals("Naval Station Hai Phong"))
				{
					/*Oh no. This whole switch should probably be in a do while loop, and every single menu in every single case should be in do while loops.
					 * This is probably why I can break out of this whole method with a one do while loop and default back to the class that called this method without
					 * having to call that class again.
					 * This is also probably why breaking out of menus jumps back two level of heirarchy instead of one like it should. It's too big now and making
					 * major method wide modification like adding all the do while loops risks blowing up the whole method. So I'll continue as is with the hope of
					 * fixing it latter after everything is more less workingish.
					 */
					switch (loc)
					{
					case 1:
						System.out.println("Location: Pier\n5: Board " + playerObject.getCommand() + "\n2: Navy Exchange\n3: Fleet Training Command\n4: Naval Station Ferry Terminal");
						menuChoice = keyboard.nextInt();
						
						switch (menuChoice)
						{
						case 5:
							System.out.println("");
							inLocNav=false;
							break;
						case 9:
							System.out.println("");
							break;
						case 2:
							System.out.println("");
							loc=2;
							break;
						case 3:
							System.out.println("");
							loc=3;
							break;
						case 4:
							System.out.println("");
							loc=4;
							break;
							default: System.out.println("Invalid parameter");
						}
						break;
					case 2:
							System.out.println("Location: Navy Exchange\n1: Return to Pier\n5: Access Navy Exchange\n3: Fleet Training Command\n4: Ferry to Hai Phong Station");
							menuChoice = keyboard.nextInt();
							switch (menuChoice)
							{
							case 1:
								System.out.println("");
								loc=1;
								break;
							case 5:
								Interface store1 = new Interface();
								store1.store(playerObject);
								break;
							case 3:
								System.out.println("");
								loc=3;
								break;
							case 4:
								System.out.println("");
								loc=4;
								break;
								default: System.out.println("Invalid parameter");
						}while(menuChoice == 0);
						break;
					case 3:
						System.out.println("Location: Fleet Training Command\n1: Return to Pier\n2: Navy Exchange\n5: Access Fleet Training Command\n4: Ferry to Hai Phong Station");
						menuChoice = keyboard.nextInt();
						switch (menuChoice)
						{
						case 1:
							System.out.println("");
							loc=1;
							break;
						case 2:
							System.out.println("");
							loc=2;
							break;
						case 5:
							System.out.println("");
							//System.out.println("Fleet Training Command\n1: Center for Antiterrorism and Navy Security Forces\n2: Center for Counter-Piracy and Navy Combat Forces\n3: Enlisted Space Warfare Specialist Program (ESWS)\n4: Flight Simulator\n5: Training Range");
							Combat training = new Combat();
							training.trainingCombat(playerObject);
							break;
						case 4:
							System.out.println("");
							loc=4;
							break;
							default: System.out.println("Invalid parameter");
						}
						break;
					case 4:
						System.out.println("Location: Naval Station Ferry Terminal\n1: Return to Pier\n2: Navy Exchange\n3: Fleet Training Command\n5: Ferry to Hai Phong Station");
						menuChoice = keyboard.nextInt();
						switch (menuChoice)
						{
							case 1:
								System.out.println("");
								loc=1;
								break;
							case 2:
								System.out.println("");
								loc=2;
								break;
							case 3:
								System.out.println("");
								loc=3;
								break;
							case 5:
								System.out.println("");
								loc = 1;
								System.out.println("Welcome to Hai Phong Station");
								playerObject.setLoc("Hai Phong Station");
								break;
								default: System.out.println("Invalid parameter");
						}
					}
				}
				
				if ((playerObject.getLoc().equals("Hai Phong Station")))
				{
					switch(loc)
					{
					case 1:
						System.out.println("Location: Hai Phong Station Ferry Terminal\n5: Return to Naval Station\n2: Financial District\n3: Docks");
						menuChoice = keyboard.nextInt();
						
						switch (menuChoice)
						{
						case 5:
							System.out.println("");
							loc=4;
							playerObject.setLoc("Naval Station Hai Phong");
							break;
						case 2:
							System.out.println("");
							loc = 2;
							break;
						case 3:
							System.out.println("");
							loc=3;
							break;
							default: System.out.println("Invalid parameter");
							menuChoice=0;
						}
						break;
					case 2:
						compResponse=randNum.nextInt(10);
						if (compResponse == 0)
						{
							System.out.println("Threat detected...");
							System.out.println("");
							compResponse=randNum.nextInt(10);
							if (compResponse == 1)
							{
								type = "Human Trafficker";
								enemyLevel = 4;
							}else
							{
								type = "Mugger";
								enemyLevel = 1;
							}
							
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}else
						{
							System.out.println("Location: Financial District\n1: Hai Phong Station Ferry Terminal\n5: Enter Financial District\n3: Docks");
							menuChoice=keyboard.nextInt();
							
							switch(menuChoice)
							{
							case 1:
								System.out.println("");
								loc=1;
								break;
							case 5:
								System.out.println("");
								System.out.println("Location\n1: Shop 1\n2: Shop 2\n3: Shop 3\n4: Clinic\n5: Exit Financial District\n6: Skid Row");
								menuChoice=keyboard.nextInt();
								
								switch(menuChoice)
								{
								case 1:
									System.out.println("");
									loc=5;
									break;
								case 2:
									System.out.println("");
									loc=6;
									break;
								case 3:
									System.out.println("");
									loc=7;
									break;
								case 4:
									System.out.println("");
									loc=8;
									break;
								case 5:
									System.out.println("");
									loc=2;
									break;
								case 6:
									System.out.println("");
									loc=9;
									break;
									default: System.out.println("Invalid parameter");
								}
								break;
							case 3:
								System.out.println("");
								loc=3;
								break;
								default: System.out.println("Invalid parameter");
							}
						}
						break;
					case 3:
						System.out.println("Location: Docks\n1: Hai Phong Station Ferry Terminal\n2: Financial District\n5: Access Docks");
						menuChoice = keyboard.nextInt();
						
						switch (menuChoice)
						{
						case 1:
							System.out.println("");
							loc=1;
							break;
						case 2:
							System.out.println("");
							loc = 2;
							break;
						case 5:
							System.out.println("");
							System.out.println("Location: Docks\n1: Warehouse 1\n2: Pier 1\n3: Warehouse 2\n4: Pier 2\n5: Warehouse 3\n6: Pier 3\n7: Exit Docks");
							menuChoice = keyboard.nextInt();
							switch (menuChoice)
							{
							case 1:
								loc=10;
								break;
							case 2:
								loc=11;
								break;
							case 3:
								loc=12;
								break;
							case 4:
								loc=13;
								break;
							case 5:
								loc=14;
								break;
							case 6:
								loc=15;
								break;
							case 7:
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
							break;
							default: System.out.println("Invalid parameter");
							menuChoice=0;
						}
						break;
					//These locations can only be accessed through the menu in loc2
					case 5:
						//shop 1
						do
						{
							System.out.println("Location: Shop 1\n1: Access Shop 1\n2: Leave Shop 1");
							menuChoice = keyboard.nextInt();
							switch (menuChoice)
							{
							case 1:
								Interface store1 = new Interface();
								store1.store(playerObject);
								break;
							case 2:
								loc=2;
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 6:
						//shop 2
						do
						{
							System.out.println("Location Shop: 2\n1: Access Shop 2\n2: Leave Shop 2");
							menuChoice = keyboard.nextInt();
							switch (menuChoice)
							{
							case 1:
								Interface store1 = new Interface();
								store1.store(playerObject);
								break;
							case 2:
								loc=2;
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 7:
						//shop 3
						do
						{
							System.out.println("Location: Shop 3\n1: Access Shop 3\n2: Leave Shop 3");
							menuChoice = keyboard.nextInt();
							switch (menuChoice)
							{
							case 1:
								Interface store1 = new Interface();
								store1.store(playerObject);
								break;
							case 2:
								loc=2;
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 8:
						do
						{
							System.out.println("Location: Hai Phong Station Clinic\n1: Access Clinic\n2: Leave Clinic");
							menuChoice=keyboard.nextInt();
							
							switch (menuChoice)
							{
							case 1:
								Interface clinic1=new Interface();
								clinic1.clinic(playerObject);
								break;
							case 2:
								loc=2;
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice = 0;
							}
						}while (menuChoice==0);
						break;
					case 9:
						compResponse=randNum.nextInt(10);
						if (compResponse > 0)
						{
							System.out.println("Threat detected...");
							System.out.println("");
							
							type = "Mugger";
							enemyLevel = 1;
							
							Enemy enemyObject = new Enemy(type);
							
							enemyObject.displayEnemy();
							
							Combat indivCombat1 = new Combat();
							indivCombat1.indivCombat(playerObject, enemyObject);
						}
						
						System.out.println("1: Return to Financial District\n2: Remain");
						menuChoice=keyboard.nextInt();
						
						if (menuChoice==1)
						{
							loc=2;
						}
						break;
					//These locations can only be accessed through the menu in loc3
					case 10:
						//warehouse 1
						do
						{
							System.out.println("Warehouse 1\n5: Enter Warehouse\n2: Exit Docks");
							menuChoice=keyboard.nextInt();
							switch (menuChoice)
							{
							case 2:
								loc=3;
								break;
							case 5:
								Interface warehouse = new Interface();
								warehouse.warehouse(playerObject);
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 11:
						//peir 1
						do
						{
							System.out.println("Pier 1\n5: Enter Pier\n2: Exit Docks");
							menuChoice=keyboard.nextInt();
							switch (menuChoice)
							{
							case 2:
								loc=3;
								break;
							case 5:
								Interface pier = new Interface();
								pier.pier(playerObject);
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 12:
						//warehouse 2
						do
						{
							System.out.println("Warehouse 2\n5: Enter Warehouse\n2: Exit Docks");
							menuChoice=keyboard.nextInt();
							switch (menuChoice)
							{
							case 2:
								loc=3;
								break;
							case 5:
								Interface warehouse = new Interface();
								warehouse.warehouse(playerObject);
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 13:
						//peir 2
						do
						{
							System.out.println("Pier 2\n5: Enter Pier\n2: Exit Docks");
							menuChoice=keyboard.nextInt();
							switch (menuChoice)
							{
							case 2:
								loc=3;
								break;
							case 5:
								Interface pier = new Interface();
								pier.pier(playerObject);
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 14:
						//warehouse 3
						do
						{
							System.out.println("Warehouse 3\n5: Enter Warehouse\n2: Exit Docks");
							menuChoice=keyboard.nextInt();
							switch (menuChoice)
							{
							case 2:
								loc=3;
								break;
							case 5:
								Interface warehouse = new Interface();
								warehouse.warehouse(playerObject);
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					case 15:
						//peir 3
						do
						{
							System.out.println("Pier 2\n5: Enter Pier\n2: Exit Docks");
							menuChoice=keyboard.nextInt();
							switch (menuChoice)
							{
							case 2:
								loc=3;
								break;
							case 5:
								Interface pier = new Interface();
								pier.pier(playerObject);
								break;
								default: System.out.println("Invalid Parameter");
								menuChoice=0;
							}
						}while (menuChoice==0);
						break;
					}
				}
			}while (inLocNav == true);
		}//end of navsta/hai phong
		
		else if (playerObject.getLoc().equals("Sigma-Pax 426")){
			do
			{
				switch (loc)
				{
				case 1:
					//aegean highlands - lz
					do
					{
						menuChoice=0;
						System.out.println("Location: Aegean Highlands\n5: Board " + playerObject.getCommand() + "\n2: Crimean Wastes (63km 253 degrees East South-East)\n3: Cerberan Salt Flats (37km 20 degrees North North-West)");
						menuChoice=keyboard.nextInt();
						switch (menuChoice)
						{
						case 5:
							inLocNav=false;
							break;
						case 2:
							loc=2;
							break;
						case 3:
							loc=3;
							break;
							default: System.out.println("Invalid Parameter");
							menuChoice=0;
						}
					}while (menuChoice == 0);
					break;
				case 2:
					//crimean wastes - shipwreck
					do
					{
						System.out.println("Location: Crimean Wastes\n1: Aegean Highlands (63km 73 degrees North North-West)\n5: Investigate super freighter wreckage\n3: Cerberan Salt Flats (72km 53 degrees West North-West)");
						menuChoice=keyboard.nextInt();
						switch (menuChoice)
						{
						case 1:
							loc=1;
							break;
						case 5:
							//enemy
							compResponse = randNum.nextInt(10);
							if (compResponse >1)
							{
								//coin toss for which enemy
								compResponse = randNum.nextInt(2);
								if (compResponse == 0)
								{
									type="Mercenary";
									enemyLevel= 5;
								}else{
									type="Pirate";
									enemyLevel=6;
								}
								Enemy enemyObject = new Enemy(type);
								Combat combat = new Combat();
								combat.indivCombat(playerObject, enemyObject);
							}else System.out.println(playerObject.getName() + "'s search turned up nothing of interest.");
							break;
						case 3:
							loc=3;
							break;
							default: System.out.println("Invalid Parameter");
							menuChoice=0;
						}
					}while (menuChoice==0);
					break;
				case 3:
					//cerberan salt flats - settlement
					do
					{
						System.out.println("Location: Cerberan Salt Flats\n1: Aegean Highlands (37km 200 degrees South South-East)\n2: Crimean Wastes (72km 233 degrees East South-East)\n5: Raid Outlaw Settlement");
						menuChoice=keyboard.nextInt();
						switch (menuChoice)
						{
						case 1:
							loc=1;
							break;
						case 2:
							loc=2;
							break;
						case 5:
							//enemy
							compResponse = randNum.nextInt(10);
							if (compResponse >1)
							{
								//coin toss for which enemy
								compResponse = randNum.nextInt(2);
								if (compResponse == 0)
								{
									type="Mercenary";
									enemyLevel= 5;
								}else{
									type="Pirate";
									enemyLevel=6;
								}
								Enemy enemyObject = new Enemy(type);
								Combat combat = new Combat();
								combat.indivCombat(playerObject, enemyObject);
							}else System.out.println("No enemies were encountered during the raid");
							break;
							default: System.out.println("Invalid Parameter");
							menuChoice=0;
						}
					}while (menuChoice==0);
					break;
					default: System.out.println("Invalid Parameter");
					menuChoice=0;
				}
			}while (inLocNav==true);
			
		}//end of sigma-pax
		
		else if (playerObject.getLoc().equals("Alphard Star System")){
			do
			{
				switch (loc)
				{
				case 1:
					//landing zone
					do
					{
						//likelihood of ambush 40%
						compResponse=randNum.nextInt(10);
						if (compResponse>5)
						{
							//dice roll for which enemy 50%
							if (compResponse<8)
							{
								type="CSA Trooper";
								enemyLevel=7;
							}else if (compResponse==8){
								//25%
								type="CSA Ranger";
								enemyLevel=8;
							}
							//25%
							type="CSA Commando";
							enemyLevel=9;
							
							Enemy enemyObject = new Enemy(type);
							System.out.println("Ambush!");
							Combat combat = new Combat();
							combat.indivCombat(playerObject, enemyObject);
						}
						System.out.println("Location: Landing Zone (LZ)\n5: Board " + playerObject.getCommand() + "\n2: Crash Site (0.73km due South)");
						menuChoice=keyboard.nextInt();
						switch (menuChoice)
						{
						case 5:
							inLocNav=false;
							break;
						case 2:
							loc=2;
							break;
							default: System.out.println("Invalid Parameter");
							menuChoice=0;
						}
					}while (menuChoice == 0);
					break;
				case 2:
					//crash site
					do
					{
						System.out.println("Location: Approaching crash site...\n1: Abort mission and return to " + playerObject.getCommand() + " (0.73km due North)\n5: Recon crash site");
						menuChoice=keyboard.nextInt();
						switch (menuChoice)
						{
						case 1:
							//likelihood of ambush 40%
							compResponse=randNum.nextInt(10);
							if (compResponse>5)
							{
								//dice roll for which enemy 50%
								if (compResponse<8)
								{
									type="CSA Trooper";
									enemyLevel=7;
								}else if (compResponse==8){
									//25%
									type="CSA Ranger";
									enemyLevel=8;
								}
								//25%
								type="CSA Commando";
								enemyLevel=9;
								
								Enemy enemyObject = new Enemy(type);
								System.out.println("Ambush!");
								Combat combat = new Combat();
								combat.indivCombat(playerObject, enemyObject);
								loc=1;
							}
							loc=1;
							break;
						case 5:
							//enemy
							compResponse=randNum.nextInt(10);
							if (compResponse>0)
							{
								//dice roll for which enemy 20%
								if (compResponse < 3)
								{
									type="CSA Trooper";
									enemyLevel=7;
								}else if (compResponse > 2 && compResponse < 7){
									//40%
									type="CSA Ranger";
									enemyLevel=8;
								}else if (compResponse > 6){
									//30%
									type="CSA Commando";
									enemyLevel=9;
								}
							}else{
								//10%
								type="Red Tide Shock Trooper";
								enemyLevel=10;
							}
							
							Enemy enemyObject = new Enemy(type);
							
							if (enemyObject.getLevel()<10)
							{
								System.out.println("Visual of crash site aquired.\nCore Systems Alliance Troops are investigating the crash site.\nVisual confirmation of crash survivor.\nStandby...\n...\n" + enemyObject.getType() + " has executed crash survivor!\nMove to engage!");
							}else{
								System.out.println("Visual of crash site aquired.\nCore Systems Alliance Troops are investigating the crash site.\nVisual confirmation of crash survivor.\nStandby...\n...\n\"" + playerObject.getName() + " be advised, an unregistered warship ID'd as the Red Tide is closing rapidly on your location, contact in sixty seconds!\"\n\n\"" + playerObject.getCommand() + ", this is " + playerObject.getName() + ", the Red Tide just straffed the crash site! They wiped out the crash survivors and the CSA Troops!\"\n\"" + playerObject.getName() + " we're tracking multiple contacts on the ground, it looks like they dropped troops, abort mission! Get back to the ship!");
							}
							
							Combat combat = new Combat();
							combat.indivCombat(playerObject, enemyObject);
							do{
								System.out.println("Location: Crash Site\n1: Abort mission and return to " + playerObject.getCommand() + "\n5: Recover black box");
								menuChoice=keyboard.nextInt();
								switch(menuChoice)
								{
								case 1:
									loc=1;
									break;
								case 5:
									compResponse=randNum.nextInt(10);
									if (compResponse==0)
									{
										type="Red Tide Commando";
										Enemy enemy = new Enemy(type);
										Combat combat2 = new Combat();
										combat2.indivCombat(playerObject, enemyObject);
									}
									System.out.println("Black box recovered...\nCongratulations! You've beaten the game!\nReturning to " + playerObject.getCommand());
									loc=1;
									break;
								}
							}while (menuChoice==0);
							
							break;
							default: System.out.println("Invalid Parameter");
							menuChoice=0;
						}
					}while (menuChoice==0);
					break;
					default: System.out.println("Invalid Parameter");
					menuChoice=0;
				}
			}while (inLocNav==true);
			
		}//end of alphard star system
		
	}//end of loc Method
}
