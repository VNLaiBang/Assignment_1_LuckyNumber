import java.util.Scanner;
import java.lang.Math;

public class LuckyNumber {
  public static Scanner read = new Scanner(System.in);

  /**
   * @return Generate a random value from 0 to 100
   */
  public static int getRandomNumber(int maximum) {
    return (int) (Math.random() * (maximum + 1));
  }

  /**
   * @return true if player want to replay else false
   */
  public static boolean replay() {
    System.out.print("Replay? ");
    String answer = read.next();
    return (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
  }

  /**
   * @param number - Winning number
   * @implNote Allow to launch game
   * @return Number of guesses
   */
  public static int play(int number) {
    System.out.println("There is a number in my head!");

    /* Input a number from keyboard */
    System.out.print("Can you guess? ");
    int guess = read.nextInt();

    int i = 1; /* Times guess */
    while (guess != number) {
      if (guess > number) {
        System.out.print("Lower! Another? ");
      } else if (guess < number) {
        System.out.print("Higher! Another? ");
      }
      guess = read.nextInt();
      i++;
    }
    System.out.println("Congratulation! It takes " + i + " guess times");
    return i;
  }

  public static void report(int total_games, int total_guess, int best_game) {
    System.out.println("\n------- Report -------");
    System.out.println("Total games: " + total_games);
    System.out.println("Total guess: " + total_guess);
    System.out.println("Best game: " + best_game + " guess");
    System.out.println("Guess average: " + ((float) total_guess / (float) total_games));
  }

  public static void main(String[] args) {
    /* Initialize variable */
    boolean answer; /* Answer of player */

    int maximum = 100; /* generate the max from 0 to 1000 */
    int best_game = maximum;
    int total_guess = 0;
    int total_games = 0;

    do {
      /* Generate a random number */
      int number = getRandomNumber(maximum);

      int launch = play(number);

      if (best_game > launch) {
        best_game = launch; /* Minimum count in every games */
      }

      total_guess += launch; /* Total count */
      answer = replay(); /* Ask player if he/she want to replay */
      total_games++;
    } while (answer);

    report(total_games, total_guess, best_game);
    System.out.println("Thank you for playing this game! Have a good day!");
    read.close();
  }
}
