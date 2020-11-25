package rouletteconsolegame;
import java.util.Random;
import java.util.Scanner;

public class RouletteConsoleGame {
	private static int rouletteNumber;
	private static String betValue;
	private static String outcome;
	private static String player;
	private static double winAmount;
	private static double betAmount;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random randomNum = new Random();
		rouletteNumber = randomNum.nextInt(37);
		
		System.out.print("Enter your bet number: ");
		betValue=in.nextLine();
		System.out.print("Enter your bet amount: ");
		betAmount=in.nextDouble();
		
		System.out.printf("\nNumber: %d\n", rouletteNumber);		
		System.out.println("Bet\t Outcome\t Winnings");		
		System.out.println(betValue +"\t"+ outcome +"\t\t"+ winAmount);
	}

}
