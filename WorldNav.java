import java.util.*;

public class WorldNav {
	
	//WorldNav method repeats infinitely even though it should stop after a choice is made, couldn't break out of WorldNav and back into ShipNav even though Combat method can so I had to call ShipNav at end of WorldNav... i guess it works.
	
	public void worldNav(Player playerObject)
	{
		int menuChoice = 0;
		int compResponse = 0;
		boolean inWorldNav = true;
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			System.out.println("Ship's Navigation Interface\nSelect a destination to chart course:\n1. Naval Station Hai Phong\n2. Sigma-Pax 426\n3. Alphard Star System\n4. Disengage Interface");
			menuChoice = keyboard.nextInt();
			System.out.println("");
			
			Random randNum = new Random();
			compResponse = randNum.nextInt(3);
			
			switch(menuChoice)
			{
			case 1:
				if (playerObject.getLoc().equals("Naval Station Hai Phong"))
				{
					System.out.println("Currently moored at Naval Station Hai Phong, Pier 7, Berth 3.\n");
					menuChoice = 0;
				}else
				{
					System.out.println("Charting course to Naval Station Hai Phong...\nDocking at Naval Station Hai Phong, Pier 7, Berth 3.\n");
					playerObject.setLoc("Naval Station Hai Phong");	
				}
				break;
			case 2:
				if (playerObject.getLoc().equals("Sigma-Pax 426"))
				{
					System.out.println("Currently anchored in orbit, Sigma-Pax 426\n");
					menuChoice = 0;
				}else
				{
					System.out.println("Charting course to Sigma-Pax 426\nAnchoring in orbit...\n");
					playerObject.setLoc("Sigma-Pax 426");	
				}
				break;
			case 3:
				if (playerObject.getLoc().equals("Alphard Star System"))
				{
					System.out.println("Currently stationed planetside, EV932, Alphard Star System\n");
					menuChoice = 0;
				}else
				{
					System.out.println("Charting course to Alphard Star System\nWarning, entering contested territory...\nLocal eXoRepublic Naval forces engaged in system wide naval warfare...\nTracking multiple hostile contacts...\nReceiving XRS distress signal, location: EV932\n Anchoring in orbit, EV932...");
					playerObject.setLoc("Alphard Star System");	
				}
				break;
			case 4:
				break;
				default: System.out.println("Invalid Parameter\n");
				menuChoice = 0;
			}
			
		} while (menuChoice == 0);
		
		ShipboardNavigation shipNav = new ShipboardNavigation();
		shipNav.setSpace("Bridge");
		shipNav.ShipboardNav(playerObject);
	}
}
