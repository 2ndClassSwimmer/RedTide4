import java.io.*;
import java.util.*;

public class ShipboardNavigation {
	
	//While conditions of do while loops in navigation methods are somehow being ignored 
	
	int navChoice = 0;
	boolean inNav = true;
	int gearLevel = 0;
	int gearType = 2;
	int compResponse = 0;
	boolean back = false;
	String gearName = "";
	String space = "Quarterdeck";
	
	Scanner keyboard = new Scanner(System.in);
	Random randNum = new Random();
	
	public String getSpace()
	{
		return space;
	}
	
	public void setSpace(String changeSpace)
	{
		space = changeSpace;
	}
	
	public void ShipboardNav(Player playerObject)
	{
		if (playerObject.getCommand().equals("XRS Vigilence (OP-07)") || playerObject.getCommand().equals("XRS Interceptor (FF-36)") || playerObject.getCommand().equals("XRS Dauntless (CN-53)") || playerObject.getCommand().equals("XRS Vengence (DV-19)") || playerObject.getCommand().equals("XRS Ravager (AP-57)") || playerObject.getCommand().equals("XRS Dreadnaught (BS-12)") || playerObject.getCommand().equals("XRS Carrier (CV-61)"))
		{
			do
			{
				
				switch (space)
				{
				case "Radar":
					navChoice = 0;
					do
					{
						System.out.println("Location: Radar\n2: Aft ATD (Quarters)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 2:
							System.out.println("");
							space = "Quarters";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
					//****************
				case "Quarters":
					navChoice=0;
					do
					{
					System.out.println("Location: Crew Quarters\n5: Access Quarters\n8: Forward ATD (Radar)\n2: Aft ATD (Armory)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 5:
							System.out.println("");
							do
							{
								System.out.println("QUARTERS\n1. Recover Health\n2: Access Service Record\n3: Save Updated Service Record\n4: Abort Mission\n5: Disengage Interface");
								navChoice=keyboard.nextInt();
								switch(navChoice)
								{
								case 1:
									System.out.println("");
									playerObject.setHealth(playerObject.getLevel()*100/2);
									playerObject.displayHealth();
									break;
								case 2:
									System.out.println("");
									System.out.println("Retreiving service profile...");
									System.out.println("");
									
									playerObject.displayPlayer();
									break;
								case 3:
									ObjectOutputStream objectOut = null;
									
									try{
										objectOut = new ObjectOutputStream(new FileOutputStream("player.dat"));
									
										objectOut.writeObject(playerObject);
										objectOut.close();
									
										System.out.println("\nService profile updated...");
									} 
									catch(Exception e)
									{
										System.out.println(e);
									}
									
									Player playerFileObject = null;
									
									ObjectInputStream objectIn = null;
									
									break;
								case 4:
									System.out.println("");
									Quit quit1 = new Quit();
									quit1.quit();
									break;
								case 5:
									System.out.println("");
									navChoice=10;
									break;
									default: System.out.println("Invalid parameter");
								}
							}while (navChoice < 10);
							break;
						case 8:
							System.out.println("");
							space = "Radar";
							break;
						case 2:
							System.out.println("");
							space = "Armory";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
				case "Armory":
					do
					{
						System.out.println("Location: Armory\n5: Access Armory\n1: Ladder Second Deck (Comms)\n2: Aft ATD (Quarterdeck)\n7: Ladder 01 Level (Gunner Stations)\n8: Forward ATD (Quarters)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 1:
							System.out.println("");
							space = "Comms";
							break;
						case 2:
							System.out.println("");
							space = "Quarterdeck";
							break;
						case 5:
							System.out.println("");
							navChoice=0;
							do
							{
								back = false;
								System.out.println("ARMORY\n1: Armor\n2: Weapons\n3: Disengage Interface");
								navChoice = keyboard.nextInt();
								switch (navChoice)
								{
								case 1:
									System.out.println("");
									do
									{
										System.out.println("Available Armor\n1: Flexible Light Armor\n2: Ceramic Plate Armor\n3: Kinetic Shield Generator\n4: Back");
										navChoice = keyboard.nextInt();
										switch(navChoice)
										{
										case 1:
											System.out.println("");
											gearType = 0;
											gearName = "Flexible Light Armor";
											gearLevel = 1;
											break;
										case 2:
											System.out.println("");
											gearType = 0;
											gearName = "Ceramic Plate Armor";
											gearLevel = 2;
											break;
										case 3:
											System.out.println("");
											gearType = 0;
											gearName = "Kinetic Shield Generator";
											gearLevel = 3;
											break;
										case 4:
											System.out.println("");
											break;
										default:
											System.out.println("\nInvalid parameter\n");
											navChoice = 0;
										}
									}while (navChoice==0);
									
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
										System.out.println("Available Weapons\n1: Pulse Laser\n2: Pulse Carbine\n3: Pulse Rifle\n4: Back");
										navChoice = keyboard.nextInt();
										switch(navChoice)
										{
										case 1:
											System.out.println("");
											gearType = 1;
											gearName = "Pulse Laser";
											gearLevel = 1;
											break;
										case 2:
											System.out.println("");
											gearType = 1;
											gearName = "Pulse Carbine";
											gearLevel = 2;
											break;
										case 3:
											System.out.println("");
											gearType = 1;
											gearName = "Pulse Rifle";
											gearLevel = 3;
											break;
										case 4:
											System.out.println("");
											break;
										default:
											System.out.println("\nInvalid parameter\n");
											navChoice = 0;
										}
									}while (navChoice==0);
									
									if (gearType < 2)
									{
										Gear gear2 = new Gear(gearName, gearType, gearLevel);
										gear2.displayGear();	
									}
									break;
								case 3:
									navChoice=10;
									System.out.println("");
									break;
								default:
									System.out.println("\nInvalid parameter\n");
									navChoice = 0;
								}
							}while (navChoice < 10);
							break;
						case 7:
							System.out.println("");
							space = "Gunnery Station";
							break;
						case 8:
							System.out.println("");
							space = "Quarters";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0 || navChoice == 5);
					break;
				case "Gunnery Station":
					navChoice=0;
					do
					{
						System.out.println("Location: Gunnery Stations\n1: Ladder Main Deck (Armory)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 1:
							System.out.println("");
							space = "Armory";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
				case "Comms":
					navChoice=0;
					do
					{
						System.out.println("Location: Communitcations\n7: Ladder Main Deck (Armory)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 7:
							System.out.println("");
							space = "Armory";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
				case "Quarterdeck":
					navChoice=0;
					do
					{
						System.out.println("Location: Quarterdeck\n5: Request permission to go ashore\n2: Aft ATD (CCS)\n7: Ladder 01 Level (Bridge)\n8: Forward ATD (Armory)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 5:
							System.out.println("");
							Locations loc1 = new Locations();
							loc1.loc(playerObject);
							break;
						case 8:
							System.out.println("");
							space = "Armory";
							break;
						case 7:
							System.out.println("");
							space = "Bridge";
							break;
						case 2:
							System.out.println("");
							space = "CCS";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
				case "Bridge":
					navChoice=0;
					do
					{
						System.out.println("Location: Bridge\n5: Access Bridge\n1: Ladder Main Deck (Quarterdeck)\n2: Aft ATD (CIC)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 1:
							System.out.println("");
							space = "Quarterdeck";
							break;
						case 2:
							System.out.println("");
							space = "CIC";
							break;
						case 5:
							System.out.println("");
							do
							{
								System.out.println("Bridge Interface\n1: Deploy " + playerObject.getCommand() + "\n2: Access Service Record\n3: Save Updated Service Record\n4: Load Service Record\n5: Disengage Interface\n6: Abort Mission");
								navChoice=keyboard.nextInt();
								
								switch (navChoice)
								{
								case 1:
									WorldNav worldNav1 = new WorldNav();
									worldNav1.worldNav(playerObject);
									break;
								case 2:
									playerObject.displayPlayer();
									break;
								case 3:
									System.out.println("");
									File ioFile = new File("data.txt");
									
									PrintWriter outStream = null;
									Scanner inStream = null;
									
									try{
										outStream = new PrintWriter(ioFile);
										
										outStream.equals(playerObject.getName());
										outStream.equals(playerObject.getCurrency());
										outStream.equals(playerObject.getLevel());
										outStream.equals(playerObject.getCommand());
										outStream.equals(playerObject.getLoc());
									
										System.out.println("Updating Service Profile...");
									}
									catch(IOException e)
									{
										System.out.println("Error!");
									}
									break;
								case 4:
									Quit quit1 = new Quit();
									quit1.quit();
									break;
								case 5:
									System.out.println("");
									navChoice=10;
									break;
								case 6:
									Quit quit2 = new Quit();
									quit2.quit();
									break;
									default:
								}
							}while(navChoice < 10);
							break;
						default:
							System.out.println("\nInvalid Parameter\n");
							navChoice=0;
						}
					}while (navChoice == 0 || navChoice ==5);
					break;
				case "CIC":
					navChoice=0;
					do
					{
						System.out.println("Location: Combat Information Center\n8: Forward ATD (Bridge)\n1: Ladder Main Deck (CCS)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 8:
							System.out.println("");
							space = "Bridge";
							break;
						case 1:
							System.out.println("");
							space = "CCS";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
				case "CCS":
					navChoice=0;
					do
					{
						System.out.println("Location: Central Control Station\n8: Forward ATD (Quarterdeck)\n7: Ladder 01 Level (CIC)\n2: Aft ATD (Engine Room)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 8:
							System.out.println("");
							space = "Quarterdeck";
							break;
						case 7:
							System.out.println("");
							space = "CIC";
							break;
						case 2:
							System.out.println("");
							space = "Engine Room";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
				case "Engine Room":
					navChoice=0;
					do
					{
						System.out.println("Location: Engine Room\n8: Forward ATD (CCS)");
						navChoice = keyboard.nextInt();
						switch (navChoice)
						{
						case 8:
							System.out.println("");
							space = "CCS";
							break;
						default:
							System.out.println("Invalid parameter.");
							navChoice=0;
						}
					}while (navChoice == 0);
					break;
				}
				
			}while (inNav = true);
		}// end of Vigilence
		
	}
}
