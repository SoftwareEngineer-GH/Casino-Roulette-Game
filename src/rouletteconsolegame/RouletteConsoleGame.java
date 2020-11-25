package rouletteconsolegame;
import java.util.Random;

public class RouletteConsoleGame {
	private static int rouletteNumber;
	public static void main(String[] args) {
		Random randomNum = new Random();
		rouletteNumber = randomNum.nextInt(37);
		
		System.out.println(rouletteNumber);
	}

}
