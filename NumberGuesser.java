import java.util.Scanner;

public class NumberGuesser {

	public static int num;
	public static int guess;
	public static int lives;
	public static int games;
	public static int wins;
	public static Scanner s;

	public static void main(String[] args) {
		System.out.println("Welcome to the number guesser!");
		System.out.println("In this game, you will try to guess a number from 1 to 10 using hints from the computer. You only get 5 guesses, so be careful!");
		System.out.println("Enter -1 to stop the game at any time.");
		System.out.println();
		games = 1;
		play();


	}


	public static void play() {
		num = (int) (Math.random() * 10) + 1 ;
		guess = -1; //is this line necessary? 
		lives = 5;
		s = new Scanner(System.in);
		System.out.println("GAME #" + games + ":");

		while ((lives > 0) && (guess != num)) {
			ask();
		} 

		if (guess == num) {

			play();

		} else {
			System.out.println("You lost the game.");
			System.out.println();
			games++;
		}

	} 
	public static void ask() {
		try {
			while (lives > 0)  {
				System.out.println("Guess a number between 1 and 10.");
				System.out.println("You have " + lives + " guesses remaining");
				System.out.println("Make your guess:");

				guess = s.nextInt();

				if (guess == -1){

					System.out.println("You have stopped the game. Thank you for playing. You played " + (games - 1) + " games in total and won " + wins + " of them. ");
					s.close();
					System.exit(0);
				}

				if (!(guess >=1 && guess <= 10)){
					System.out.println("You must enter a number between 1 and 10.");
					System.out.println();
					System.out.println("Guess a number between 1 and 10.");
					System.out.println("You have " + lives + " guesses remaining");
					System.out.println("Make your guess:");
					guess = s.nextInt();
				}

				if (guess == num) {
					System.out.println("Correct!");
					System.out.println("You won the game!");
					System.out.println();
					games++;
					wins++;
					break;

				} else if (guess > num){
					System.out.println("your guess was too high.");
					lives--;
					System.out.println();

				} else {
					System.out.println("your guess was too low.");
					lives--;
					System.out.println();
				}
			}
		} catch (Exception e) {
			s = new Scanner(System.in);
			System.out.println("You must enter a number between 1 and 10.");
			System.out.println();
			ask();
		}



	}

}
