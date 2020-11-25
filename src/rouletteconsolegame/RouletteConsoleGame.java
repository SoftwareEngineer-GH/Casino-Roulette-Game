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
	private static double winAmount;
	private static double betAmount;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random randomNum = new Random();
		rouletteNumber = randomNum.nextInt(37);
		
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
        
		System.out.print("Enter your bet number: ");
		betValue=in.nextLine();
		System.out.print("Enter your bet amount: ");
		betAmount=in.nextDouble();
		
		System.out.printf("\nNumber: %d\n", rouletteNumber);		
		System.out.println("Player\t\t Bet\t Outcome\t Winnings");		
		System.out.println(player1 +"\t"+ betValue +"\t"+ outcome +"\t\t"+ winAmount);
	}

}
