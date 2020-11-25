package rouletteconsolegame;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class RouletteConsoleGame {
	private static int rouletteNumber;
	private static String betValue;
	private static String outcome;
	private static String player1;
	private static String player2;
	private static double winAmount;
	private static double betAmount;
	private static String bet;
	private static ArrayList<Integer> evenList = new ArrayList<Integer>(13);
	private static ArrayList<Integer> oddList = new ArrayList<Integer>(13);
	private static ArrayList<Integer> onetothirtysixList = new ArrayList<Integer>(13);
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random randomNum = new Random();
		rouletteNumber = randomNum.nextInt(37);
		outcome="LOSE";
	    Scanner input = new Scanner(System.in);
	    char response = 'y';
	    int resultArr[] = new int[36];
		
        File file = new File("input.txt");
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        player1=list.get(0);
        player2=list.get(1);
        
        while (response == 'y' || response == 'Y')
        {
			System.out.print("Enter your bet number: ");
			betValue=in.nextLine();
			System.out.print("Enter your bet amount: ");
			betAmount=in.nextDouble();
			
			if(betValue.length()==1 || betValue.length()==2 && (Integer.parseInt(betValue))>0 && (Integer.parseInt(betValue))<37){
				betValue="ONE";
				bet=betValue;
			}else if(betValue=="ODD"||betValue=="odd") {
				betValue="ODD";			
				bet=betValue;
			}else if(betValue=="EVEN"||betValue=="even") {
				betValue="EVEN";
				bet=betValue;
			}else {
				System.out.println("Invalid bet!!!");
				
			}
			
			switch(betValue) {
				case "ONE":{
					oneToThirtySix();
					for(int items : oddList) {
						if(rouletteNumber==items) {
							outcome="WIN";
							winAmount=36*betAmount;							
						}else {
							outcome="LOSE";						
						}
					}
					break;
				}
				case "ODD":{
					evenNumbers();
					for(int items : oddList) {
						if(rouletteNumber==items) {
							outcome="WIN";
							winAmount=2*betAmount;							
						}else {
							outcome="LOSE";						
						}
					}
					break;
				}
				case "EVEN":{
					oddNumbers();
					for(int items : evenList) {
						if(rouletteNumber==items) {
							outcome="WIN";
							winAmount=2*betAmount;							
						}else {
							outcome="LOSE";						
						}
					}
					break;
				}
				default:{
					outcome="LOSE";
					winAmount=0.0;
				}
			}
			
			System.out.printf("\nNumber: %d\n", rouletteNumber);		
			System.out.println("Player\t\t Bet\t Outcome\t Winnings");		
			System.out.println(player1 +"\t"+ bet +"\t"+ outcome +"\t\t"+ winAmount);	
			System.out.println(player2 +"\t\t"+ bet +"\t"+ outcome +"\t\t"+ winAmount);	
	           System.out.print("\nWould you like to play another game? (y/n) ");
	           response = input.next().charAt(0); 
	       }
	}
	
	public static void evenNumbers() {
		for(int n=1;n<=36;n++) {
			if((n%2==0)) {
				evenList.add(n);
			}
		}
	}

	public static void oddNumbers() {
		for(int n=1;n<=36;n++) {
			if((n%2!=0)) {
				oddList.add(n);
			}
		}
	}
	
	public static void oneToThirtySix() {
		for(int n=1;n<=36;n++) {
			onetothirtysixList.add(n);
		}
	}
}
