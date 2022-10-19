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
   */
  public static void play(int number) {
    System.out.println("There is a number in my head!");

    /* Input a number from keyboard */
    System.out.print("Can you guess? ");
    int guess = read.nextInt();

    /* For fun */
    System.out.println(number);

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
  }

  public static void report() {

  }

  public static void main(String[] args) {
    /* Initialize condition to launch game */
    boolean answer = true;
    int i = 1;
    while (answer) {
      int maximum = getRandomNumber(1000);
      System.out.println("Maximum is now: " + maximum);
      int number = getRandomNumber(maximum);
      play(number);
      answer = replay();
      i++;
    }
    System.out.print(i);
    read.close();
  }
}