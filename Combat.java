import java.util.*;

public class Combat {
	
	public static void indivCombat(Player playerObject, Enemy enemyObject)
	{
		boolean inCombat = true;
		int combatChoice = 0;
		int compResponse = 0;
		int damage = 0;
		int defense = 0;
		int evadeChance = 0;
		int exp = 0;
		int loot=0;
		
		Scanner keyboard = new Scanner(System.in);
		
		Random randNum = new Random();
		
		System.out.println(enemyObject.getType() + " is engaging!");
		
		//do while inCombat is true
		do
		{
			System.out.println("1. Attack\n2. Defend\n3. Retreat");
			combatChoice = keyboard.nextInt();
			
			//player's turn
			switch(combatChoice)
			{
			case 1:
				damage = playerObject.getAttack() - randNum.nextInt(enemyObject.getDefense()) + 1;
				if (damage<0)
					damage = 0;
				evadeChance = randNum.nextInt(100);
				if (evadeChance <= enemyObject.getEvasion())
				{
					System.out.println(enemyObject.getType() + " evaded attack!");
					damage = 0;
				}
				if (enemyObject.getHealth()<damage)
					enemyObject.setHealth(0);
				else
					//playerObject.setHealth
					enemyObject.setHealth(enemyObject.getHealth() - damage);
				System.out.println(playerObject.getName() +"'s attack damage: "+damage);
				enemyObject.displayEnemyHealth();
				break;
			case 2:
				defense = playerObject.getLevel()*100/2 * 2/10;
				if (playerObject.getHealth() + defense > playerObject.getLevel()*100/2)
					playerObject.setHealth(playerObject.getLevel()*100/2);
				else
					playerObject.setHealth(playerObject.getHealth() + defense);
				System.out.println("Defense: " + defense);
				playerObject.displayHealth();
				break;
			case 3:
				compResponse = randNum.nextInt(2);
				switch (compResponse)
				{
				case 0:
					System.out.println(playerObject.getName()+" has escaped " + enemyObject.getType() + "!");
					inCombat=false;
				case 1:
					System.out.println("Escape attempt failed!");
				}
			}
			
			//*******************************
			//enemy health check has to be here or else the enemy can still take a turn with 0 health and if it heals it won't have 0 health anymore by time we run the check so it can die and resurect itself on its turn.
			if (enemyObject.getHealth() == 0)
			{
				compResponse = randNum.nextInt(3);
				switch(compResponse)
				{
				case 0:
					String type = enemyObject.getType();
					System.out.println(type.toUpperCase() + " IS NEUTRALIZED!");
					break;
				case 1:
					System.out.println("TANGO DOWN!");
					break;
				case 2:
					System.out.println("ALL CLEAR!");
				}
				
				
				exp = enemyObject.getLevel()*100;
				System.out.println("+"+exp+" EXP!");
				if (playerObject.getToNextLevel()-exp > 0)
				playerObject.setToNextLevel(playerObject.getToNextLevel()-exp);
				else playerObject.setToNextLevel(0);
				if (playerObject.getToNextLevel()==0)
				{
					
					playerObject.setLevel(playerObject.getLevel()+1);
					playerObject.setToNextLevel(playerObject.getLevel()*500/2);
					System.out.println("LEVEL UP!");
					playerObject.displayLevel();
				}
				loot = randNum.nextInt(10)+2*10;
				System.out.println("+"+loot+" Republic Credits!");
				System.out.println("");
				playerObject.setCurrency(playerObject.getCurrency() + loot);
				playerObject.displayPlayer();
				inCombat=false;
				//RESOLVED "totally didn't work the enemy can still take a turn and heal after it's killed. Combat still ends, but it displays the enemy's post death turn and health going back up to 10"
			}
			//*******************************
			
			//computer's turn
			//if enemy has less than full health but more than 20% of full health it may attack or defend with a 1/10 chance of choosing to defend
			else
			{
				if (enemyObject.getHealth() > (enemyObject.getLevel()*100/2)-(enemyObject.getLevel()*100/2*8/10) && enemyObject.getHealth()<enemyObject.getLevel()*100/2)
				{
					compResponse = randNum.nextInt(10);
					if (compResponse == 1)
					{
						defense = (enemyObject.getLevel()*100/2)*2/10;
						if (enemyObject.getHealth() + defense > enemyObject.getLevel()*100/2)
							enemyObject.setHealth(enemyObject.getLevel()*100/2);
						else
							enemyObject.setHealth(enemyObject.getHealth() + defense);
						System.out.println("Defense: " + defense);
						enemyObject.displayEnemy();
					}
					else
					{
						damage = enemyObject.getAttack() - randNum.nextInt(playerObject.getDefense()) + 1;
						if (damage<0)
							damage = 0;
						evadeChance = randNum.nextInt(100);
						if (evadeChance <= enemyObject.getEvasion())
						{
							System.out.println(playerObject.getName() + " evaded attack!");
							damage = 0;
						}
						if (playerObject.getHealth()<damage)
							playerObject.setHealth(0);
						else
							playerObject.setHealth(playerObject.getHealth() - damage);
						System.out.println(enemyObject.getType()+"'s attack damage: "+damage);
						playerObject.displayHealth();
					}		
				}
				//if enemy has 20% of full health or less it may attack, defend, or retreat with a 1/10 chance of retreat and a 2/10 chance of defend
				else if (enemyObject.getHealth() <= (enemyObject.getLevel()*100/2)*2/10)
				{
					compResponse = randNum.nextInt(10);
					if (compResponse == 1 || compResponse == 2)
					{
						defense = (enemyObject.getLevel()*100/2)*2/10;
						if (enemyObject.getHealth() + defense > enemyObject.getLevel()*100/2)
							enemyObject.setHealth(enemyObject.getLevel()*100/2);
						else
							enemyObject.setHealth(enemyObject.getHealth() + defense);
						System.out.println("Defense: " + defense);
						enemyObject.displayEnemy();
					}
					else if (compResponse == 0)
					{
						//when enemy attempts escape player may choose to pursue enemy or not
						System.out.println(enemyObject.getType() + " is trying to escape!\n1. Pursue " + enemyObject.getType() + "\n2. Stand down");
						combatChoice = keyboard.nextInt();
						switch (combatChoice)
						{
						case 1:
							//if player's evasion is +10 or more than enemy's evasion: enemy can never escape
							if (playerObject.getEvasion()>=enemyObject.getEvasion()+10)
							{
							System.out.println("Escape attempt failed!");
							}
							//if enemy's evasion is +10 or more than player's evasion: enemy can always escape
							else if (enemyObject.getEvasion()>=playerObject.getEvasion()+10)
							{
								System.out.println("Enemy Escaped!");
								inCombat = false;
							}
							//if enemy/player evasion within range of 10 of each other the larger is subtracted from the smaller and the difference determines the likelihood of escape with a bias toward the larger evasion score 
							else
							{
								
								compResponse = randNum.nextInt(10);
								//player has greater evasion: enemy evasion subtracted from player's if random number between 1&10 is <= difference enemy does not escape
								if (playerObject.getEvasion()>enemyObject.getEvasion())
								{
									if (compResponse >= playerObject.getEvasion()-enemyObject.getEvasion())
									{
									System.out.println("Escape attempt failed!");
									}
									else 
									{
										System.out.println("Enemy Escaped!");
										inCombat=false;
									}
								}
								//enemy has greater evasion: player evasion subtracted from enemy's - if random number is >= difference the enemy does escape
								else if (playerObject.getEvasion()<enemyObject.getEvasion())
								{
									if (compResponse >= enemyObject.getEvasion()-playerObject.getEvasion())
									{
										System.out.println("Enemy Escaped!");
										inCombat=false;
									}
									else
									{
									System.out.println("Escape attempt failed!");
									}
								}
								else if (playerObject.getEvasion()==enemyObject.getEvasion())
									{
										if (compResponse <= 4)
										{
											System.out.println("Enemy Escaped!");
											inCombat=false;
										}
										else
										{
											System.out.println("Escape attempt failed!");
										}
									}
							}
							break;
						case 2:
							inCombat = false;
						}
					}
					else
					{
						damage = enemyObject.getAttack() - randNum.nextInt(playerObject.getDefense()) + 1;
						if (damage<0)
							damage = 0;
						evadeChance = randNum.nextInt(100);
						if (evadeChance <= enemyObject.getEvasion())
						{
							System.out.println(playerObject.getName() + " evaded attack!");
							damage = 0;
						}
						if (playerObject.getHealth()<damage)
							playerObject.setHealth(0);
						else
							playerObject.setHealth(playerObject.getHealth() - damage);
						System.out.println(enemyObject.getType()+"'s attack damage: "+damage);
						playerObject.displayHealth();
					}		
				}
				//otherwise when enemy is at full health it may only attack
				//I should add the option for it to try to escape if it is substantially lower level than the player
				else
				{
					damage = enemyObject.getAttack() - randNum.nextInt(playerObject.getDefense()) + 1;
					if (damage<0)
						damage = 0;
					evadeChance = randNum.nextInt(100);
					if (evadeChance <= enemyObject.getEvasion())
					{
						System.out.println(playerObject.getName() + " evaded attack!");
						damage = 0;
					}
					if (playerObject.getHealth()<damage)
						playerObject.setHealth(0);
					else
						playerObject.setHealth(playerObject.getHealth() - damage);
					System.out.println(enemyObject.getType()+"'s attack damage: "+damage);
					playerObject.displayHealth();
				}
			}
			
			//player health check
			if (playerObject.getHealth() == 0)
			{
				compResponse=randNum.nextInt(3);
				switch(compResponse)
				{
				case 1:
					System.out.println("TROOPER DOWN!");
					break;
				case 2:
					String type = enemyObject.getType();
					String playerName = playerObject.getName();
					System.out.println(type.toUpperCase() + " FRAGGED " + playerName.toUpperCase() + "!");
					break;
				case 3:
					System.out.println("Fall back to Hell and regroup Sailor!");
				}
				
				exp = playerObject.getLevel()*50;
				if (playerObject.getToNextLevel()+exp > playerObject.getLevel()*500/2)
				playerObject.setToNextLevel(playerObject.getLevel()*500/2);
				else playerObject.setToNextLevel(playerObject.getToNextLevel()+exp);
				playerObject.setHealth(playerObject.getLevel()*100/2);
				playerObject.displayPlayer();
				
				inCombat=false;	
			}
			
		}while (inCombat==true);
	}
		
		//TRAINING COMBAT-------------------------------------------------------------------------------------------------------------------------------------
		
		public static void trainingCombat(Player playerObject)
		{
			boolean inCombat = true;
			int combatChoice = 0;
			int compResponse = 0;
			int damage = 0;
			int defense = 0;
			int evadeChance = 0;
			int exp = 0;
			int enemyLevel = 0;
			String enemyType = "";
			
			Scanner keyboard = new Scanner(System.in);
			
			Random randNum = new Random();
			
			do
			{
				System.out.println("Fleet Training Command\nChoose enemy level: 1-4");
				combatChoice=keyboard.nextInt();
				switch (combatChoice)
				{
				case 1:
					enemyType = "Mugger";
					enemyLevel = 1;
					break;
				case 2:
					enemyType = "Drug Runner";
					enemyLevel = 2;
					break;
				case 3:
					enemyType = "Gun Runner";
					enemyLevel = 3;
					break;
				case 4:
					enemyType = "Human Trafficker";
					enemyLevel = 4;
					break;
					default: System.out.println("Invalid Parameter");
					combatChoice=0;
				}
			}while(combatChoice==0);
			
			Enemy enemyObject = new Enemy(enemyType);
			
			System.out.println(enemyObject.getType() + " is engaging!");
			
			//do while inCombat is true
			do
			{
				System.out.println("1. Attack\n2. Defend\n3. EEV");
				combatChoice = keyboard.nextInt();
				
				//player's turn
				switch(combatChoice)
				{
				case 1:
					damage = playerObject.getAttack() - randNum.nextInt(enemyObject.getDefense()) + 1;
					if (damage<0)
						damage = 0;
					evadeChance = randNum.nextInt(100);
					if (evadeChance <= enemyObject.getEvasion())
					{
						System.out.println(enemyObject.getType() + " evaded attack!");
						damage = 0;
					}
					if (enemyObject.getHealth()<damage)
						enemyObject.setHealth(0);
					else
						enemyObject.setHealth(enemyObject.getHealth() - damage);
					System.out.println("Damage: "+damage);
					enemyObject.displayEnemy();
					break;
				case 2:
					defense = playerObject.getLevel()*100/2 * 2/10;
					if (playerObject.getHealth() + defense > playerObject.getLevel()*100/2)
						playerObject.setHealth(playerObject.getLevel()*100/2);
					else
						playerObject.setHealth(playerObject.getHealth() + defense);
					System.out.println("Defense: " + defense);
					playerObject.displayPlayer();
					break;
				case 3:
					compResponse = randNum.nextInt(2);
					switch (compResponse)
					{
					case 0:
						System.out.println(playerObject.getName()+" has escaped " + enemyObject.getType() + "!");
						inCombat=false;
					case 1:
						System.out.println("Escape attempt failed!");
					}
				}
				
				//*******************************
				//enemy health check has to be here or else the enemy can still take a turn with 0 health and if it heals it won't have 0 health anymore by time we run the check so it can die and resurect itself on its turn.
				if (enemyObject.getHealth() == 0)
				{
					compResponse = randNum.nextInt(3);
					switch(compResponse)
					{
					case 0:
						String type = enemyObject.getType();
						System.out.println(type.toUpperCase() + " IS NEUTRALIZED!");
						break;
					case 1:
						System.out.println("TANGO DOWN!");
						break;
					case 2:
						System.out.println("ALL CLEAR!");
					}
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Training combat only grants 25% of normal experience, does not grant money, and resets health.
					exp = enemyObject.getLevel()*25;
					if (playerObject.getToNextLevel()-exp > 0)
					playerObject.setToNextLevel(playerObject.getToNextLevel()-exp);
					else playerObject.setToNextLevel(0);
					if (playerObject.getToNextLevel()==0)
					{
						playerObject.setLevel(playerObject.getLevel()+1);
						playerObject.setToNextLevel(playerObject.getLevel()*500/2);
					}
					playerObject.setHealth(playerObject.getLevel()*100/2);
					playerObject.displayPlayer();
					inCombat=false;
					//totally didn't work the enemy can still take a turn and heal after it's killed. Combat still ends, but it displays the enemy's post death turn and healt going back up to 10
				}
				//*******************************
				
				//computer's turn
				//if enemy has less than full health but more than 20% of full health it may attack or defend with a 1/10 chance of choosing to defend
				else
				{
					if (enemyObject.getHealth() > (enemyObject.getLevel()*100/2)-(enemyObject.getLevel()*100/2*8/10) && enemyObject.getHealth()<enemyObject.getLevel()*100/2)
					{
						compResponse = randNum.nextInt(10);
						if (compResponse == 1)
						{
							defense = (enemyObject.getLevel()*100/2)*2/10;
							if (enemyObject.getHealth() + defense > enemyObject.getLevel()*100/2)
								enemyObject.setHealth(enemyObject.getLevel()*100/2);
							else
								enemyObject.setHealth(enemyObject.getHealth() + defense);
							System.out.println("Defense: " + defense);
							enemyObject.displayEnemy();
						}
						else
						{
							damage = enemyObject.getAttack() - randNum.nextInt(playerObject.getDefense()) + 1;
							if (damage<0)
								damage = 0;
							evadeChance = randNum.nextInt(100);
							if (evadeChance <= enemyObject.getEvasion())
							{
								System.out.println(playerObject.getName() + " evaded attack!");
								damage = 0;
							}
							if (playerObject.getHealth()<damage)
								playerObject.setHealth(0);
							else
								playerObject.setHealth(playerObject.getHealth() - damage);
							System.out.println(enemyObject.getType()+"'s attack damage: "+damage);
							playerObject.displayHealth();
						}		
					}
					//if enemy has 20% of full health or less it may attack, defend, or retreat with a 1/10 chance of retreat and a 2/10 chance of defend
					else if (enemyObject.getHealth() <= (enemyObject.getLevel()*100/2)*2/10)
					{
						compResponse = randNum.nextInt(10);
						if (compResponse == 1 || compResponse == 2)
						{
							defense = (enemyObject.getLevel()*100/2)*2/10;
							if (enemyObject.getHealth() + defense > enemyObject.getLevel()*100/2)
								enemyObject.setHealth(enemyObject.getLevel()*100/2);
							else
								enemyObject.setHealth(enemyObject.getHealth() + defense);
							System.out.println("Defense: " + defense);
							enemyObject.displayEnemy();
						}
						else if (compResponse == 0)
						{
							//when enemy attempts escape player may choose to pursue enemy or not
							System.out.println(enemyObject.getType() + " is trying to escape!\n1. Pursue " + enemyObject.getType() + "\n2. Stand down");
							combatChoice = keyboard.nextInt();
							switch (combatChoice)
							{
							case 1:
								//if player's evasion is +10 or more than enemy's evasion: enemy can never escape
								if (playerObject.getEvasion()>=enemyObject.getEvasion()+10)
								{
								System.out.println("Escape attempt failed!");
								}
								//if enemy's evasion is +10 or more than player's evasion: enemy can always escape
								else if (enemyObject.getEvasion()>=playerObject.getEvasion()+10)
								{
									System.out.println("Enemy Escaped!");
									inCombat = false;
								}
								//if enemy/player evasion within range of 10 of each other the larger is subtracted from the smaller and the difference determines the likelihood of escape with a bias toward the larger evasion score 
								else
								{
									
									compResponse = randNum.nextInt(10);
									//player has greater evasion: enemy evasion subtracted from player's if random number between 1&10 is <= difference enemy does not escape
									if (playerObject.getEvasion()>enemyObject.getEvasion())
									{
										if (compResponse >= playerObject.getEvasion()-enemyObject.getEvasion())
										{
										System.out.println("Escape attempt failed!");
										}
										else 
										{
											System.out.println("Enemy Escaped!");
											inCombat=false;
										}
									}
									//enemy has greater evasion: player evasion subtracted from enemy's - if random number is >= difference the enemy does escape
									else if (playerObject.getEvasion()<enemyObject.getEvasion())
									{
										if (compResponse >= enemyObject.getEvasion()-playerObject.getEvasion())
										{
											System.out.println("Enemy Escaped!");
											inCombat=false;
										}
										else
										{
										System.out.println("Escape attempt failed!");
										}
									}
									else if (playerObject.getEvasion()==enemyObject.getEvasion())
										{
											if (compResponse <= 4)
											{
												System.out.println("Enemy Escaped!");
												inCombat=false;
											}
											else
											{
												System.out.println("Escape attempt failed!");
											}
										}
								}
								break;
							case 2:
								inCombat = false;
							}
						}
						else
						{
							damage = enemyObject.getAttack() - randNum.nextInt(playerObject.getDefense()) + 1;
							if (damage<0)
								damage = 0;
							evadeChance = randNum.nextInt(100);
							if (evadeChance <= enemyObject.getEvasion())
							{
								System.out.println(playerObject.getName() + " evaded attack!");
								damage = 0;
							}
							if (playerObject.getHealth()<damage)
								playerObject.setHealth(0);
							else
								playerObject.setHealth(playerObject.getHealth() - damage);
							System.out.println(enemyObject.getType()+"'s attack damage: "+damage);
							playerObject.displayHealth();
						}		
					}
					//otherwise when enemy is at full health it may only attack
					//I should add the option for it to try to escape if it is substantially lower level than the player
					else
					{
						damage = enemyObject.getAttack() - randNum.nextInt(playerObject.getDefense()) + 1;
						if (damage<0)
							damage = 0;
						evadeChance = randNum.nextInt(100);
						if (evadeChance <= enemyObject.getEvasion())
						{
							System.out.println(playerObject.getName() + " evaded attack!");
							damage = 0;
						}
						if (playerObject.getHealth()<damage)
							playerObject.setHealth(0);
						else
							playerObject.setHealth(playerObject.getHealth() - damage);
						System.out.println(enemyObject.getType()+"'s attack damage: "+damage);
						playerObject.displayHealth();
					}
				}
				
				//player health check
				//>>>>>>>>>>>>>>>>>>>>>>>>>>>>Training combat does not deduct experience for loosing and resets health after loss.
				if (playerObject.getHealth() == 0)
				{
					compResponse=randNum.nextInt(3);
					switch(compResponse)
					{
					case 1:
						System.out.println("TROOPER DOWN!");
						break;
					case 2:
						String type = enemyObject.getType();
						String playerName = playerObject.getName();
						System.out.println(type.toUpperCase() + " FRAGGED " + playerName.toUpperCase() + "!");
						break;
					case 3:
						System.out.println("Fall back to Hell and regroup Sailor!");
					}
					
					playerObject.setHealth(playerObject.getLevel()*100/2);
					
					inCombat=false;	
				}
				
			}while (inCombat==true);
		}
}
