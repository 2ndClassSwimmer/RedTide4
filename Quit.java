import java.util.Random;

public class Quit {
	
	public void quit ()
	{
		int compResponse=0;
		
		Random randNum = new Random();
		compResponse = randNum.nextInt(3);
		
		switch (compResponse)
		{
			case 0:
				System.out.println("Anchoring in orbit.");
				System.out.println("");
				break;
			case 1:
				System.out.println("Operations suspended until further notice.");
				System.out.println("");
				break;
			case 2:
				System.out.println("Fair winds and following seas...");
				System.out.println("");
		}
		System.exit(0);
	}

}
