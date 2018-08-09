package com.example.demo.modified;

import java.util.Random;
import java.util.Scanner;

public class RouletteGameApplication
{

    public static void main(String[] args)
    {
	Scanner input = new Scanner(System.in);
	System.out.println("Welcome to the Java Roulette Game...");

	// Setting up variables to be updated in the loop to be printed after
	// game.
	String confirmationCashout = "";
	String confirmationRestart = "";
	String bet = "";
	String answer = "";
	int winStreak = 0;
	int gamble = 0;
	int payout = 0;
	int randomNum = 0;
	int money = 1000;
	int rounds = 1;
	boolean cashout = false;
	Random rand = new Random();

	CASHOUT_BREAK_OUT: while (money > 0)
	{

	    payout = 0;
	    System.out.println("Round " + rounds + ".");

	    System.out.println("You have $" + money + ".");
	    System.out.println("What would you like to do?");
	    System.out.println("Commands: | bet | money | cashout | help | restart |");
	    answer = input.next();
	    while (!(answer.equals("bet")) && !(answer.equals("money")) && !(answer.equals("cashout"))
		    && !(answer.equals("restart")) && !(answer.equals("help")))
	    {
		System.out.println("Invalid choice, type 'help' to view the commands.");
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.println("Commands: | bet | money | cashout | help | restart |");
		answer = input.next();
	    }

	    while (answer.equals("money"))
	    {
		System.out.println("Your balance is at $" + money + ".");
		System.out.println("What would you like to do?");
		System.out.println("Commands: | bet | money | cashout | help | restart |");
		answer = input.next();
	    }

	    while (answer.equals("cashout"))
	    {
		System.out.println("Are you sure you want to cashout $" + money + "? Y/N.");
		confirmationCashout = input.next();
		while (!(confirmationCashout.equals("y")) && !(confirmationCashout.equals("n")))
		{
		    System.out.println("Please input either 'y' (yes) or 'n' (no). ");
		    System.out.println("Are you sure you want to cashout $" + money + "? Y/N.");
		    confirmationCashout = input.next();
		}
		if (confirmationCashout.equals("y"))
		{
		    System.out
			    .println(
				    "You have cashed out $" + money + " with a " + winStreak + " win streak within "
					    + rounds + " rounds.");
		    break CASHOUT_BREAK_OUT;
		}
		if (confirmationCashout.equals("n"))
		{
		    System.out.println("What would you like to do?");
		    System.out.println("Commands: | bet | money | cashout | help | restart |");
		    answer = input.next();
		}
	    }

	    while (answer.equals("restart"))
	    {
		System.out.println("Are you sure you want to RESTART?");
		System.out.println("YOUR progress will be DELETED. Y/N.");
		confirmationRestart = input.next();
		if (!(confirmationRestart.equals("y")) && !(confirmationRestart.equals("n")))
		{
		    System.out.println("Please pick either Y/N.");
		    System.out.println("Are you sure you want to RESTART?");
		    confirmationRestart = input.next();
		}
		if (confirmationRestart.equals("y"))
		{
		    System.out.println("Restarting...");
		    money = 1000;
		    winStreak = 0;
		    rounds = 1;
		    System.out.println("What would you like to do?");
		    System.out.println("Commands: | bet | money | cashout | help | restart |");
		    answer = input.next();
		}
		if (confirmationRestart.equals("n"))
		{
		    System.out.println("What would you like to do?");
		    System.out.println("Commands: | bet | money | cashout | help | restart |");
		    answer = input.next();
		}
	    }
	    while (answer.equals("help"))
	    {
		System.out
			.println(
				"You start off with $1000, and your goal is to cash out with as much money as possible.");
		System.out
			.println(
				"Each time you cash out, your money will get sent to the high scores if it is within the top 5.");
		System.out.println("If your money goes to $0 or below, you will lose.");
		System.out.println("WARNING: Cashing out will reset the game.");
		System.out.println("You will be able to see the commands at any time, by typing 'commands'.");
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("| This game is based on real-life roulette tables.             |");
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("| Bet                    | Pays | Probability Win | House Edge |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Red                    | 1    | 47.37%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Black                  | 1    | 47.37%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Odd                    | 1    | 47.37%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("|Even                    | 1    | 47.37%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| 1 to 18                | 1    | 47.37%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| 19 to 36               | 1    | 47.37%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| 1 to 12                | 2    | 31.58%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| 13 to 24               | 2    | 31.58%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| 25 to 36               | 2    | 31.58%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Six line (6 numbers)   | 5    | 15.79%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| First five (5 numbers) | 6    | 13.16           | 7.89%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Corner (4 numbers)     | 8    | 10.53%          | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Street (3 numbers)     | 11   | 7.895           | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Split (2 numbers)      | 17   | 5.26%           | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out.println("| Any one number         | 35   | 2.62%           | 5.26%      |");
		System.out.println("+------------------------+------+-----------------+------------+");
		System.out
			.println(
				"You should probably familiarize yourself with the layout of a roulette table"
					+ "before playing this command-line version of the game.");
		System.out.println("SCROLL up for full instructions.");
		System.out.println("What would you like to do?");
		try
		{
		    Thread.sleep(5000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Commands: | bet | money | cashout | help | restart |");
		answer = input.next();
	    }

	    try
	    {
		Thread.sleep(1000);
	    }
	    catch (InterruptedException ex)
	    {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("+--------------------------------------------------------------+");
	    System.out.println("| This game is based on real-life roulette tables.             |");
	    System.out.println("+--------------------------------------------------------------+");
	    System.out.println("| Bet                    | Pays | Probability Win | House Edge |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Red                    | 1    | 47.37%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Black                  | 1    | 47.37%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Odd                    | 1    | 47.37%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("|Even                    | 1    | 47.37%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| 1 to 18                | 1    | 47.37%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| 19 to 36               | 1    | 47.37%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| 1 to 12                | 2    | 31.58%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| 13 to 24               | 2    | 31.58%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| 25 to 36               | 2    | 31.58%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Six line (6 numbers)   | 5    | 15.79%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| First five (5 numbers) | 6    | 13.16           | 7.89%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Corner (4 numbers)     | 8    | 10.53%          | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Street (3 numbers)     | 11   | 7.895           | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Split (2 numbers)      | 17   | 5.26%           | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("| Any one number         | 35   | 2.62%           | 5.26%      |");
	    System.out.println("+------------------------+------+-----------------+------------+");
	    System.out.println("");
	    System.out.println("");
	    System.out.println("Commands: | red     | black     | odd    | even   |   any | 1to18 | 19to36 |");
	    System.out.println("          | sixline | firstfive | corner | street | split | 1to12 | 13to24 | 25to36 |");
	    System.out.println("");
	    System.out.println("What would you like to bet on?");
	    // Validation check - Checks if user has input an invalid bet.
	    bet = input.next();
	    while (!(bet.equals("red")) && !(bet.equals("black")) && !(bet.equals("even")) && !(bet.equals("odd"))
		    && !(bet.equals("1to18")) && !(bet.equals("19to36")) && !(bet.equals("1to12"))
		    && !(bet.equals("13to24")) && !(bet.equals("25to36")) && !(bet.equals("sixline"))
		    && !(bet.equals("firstfive")) && !(bet.equals("corner")) && !(bet.equals("street"))
		    && !(bet.equals("split")) && !(bet.equals("any")))
	    {
		System.out.println("Invalid choice, check the table to view what you can bet on.");
		try
		{
		    Thread.sleep(500);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("");
		System.out.println("Commands: | red     | black     | odd    | even   |   any | 1to18 | 19to36 |");
		System.out
			.println(
				"          | sixline | firstfive | corner | street | split | 1to12 | 13to24 | 25to36 |");
		System.out.println("");
		System.out.println("What would you like to bet on?");
		bet = input.nextLine();
	    }

	    System.out.println("How much money are you going to chip in?");
	    gamble = input.nextInt();
	    while (gamble > money)
	    {
		System.out.println("Nice try, you're betting more than you can handle...");
		try
		{
		    Thread.sleep(2500);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("How much money are you going to chip in?");
		gamble = input.nextInt();
	    }
	    if (bet.equals("red") || bet.equals("black") || bet.equals("even") || bet.equals("odd")
		    || bet.equals("1to18") || bet.equals("19to36"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble;
		if (randomNum < 4738)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 47.37%!");
		}
		if (randomNum > 4738)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 52.63%!");
		}
	    }
	    else if (bet.equals("1to12") || bet.equals("13to24") || bet.equals("25to36"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble * 2;
		if (randomNum < 3158)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 31.58%!");
		}
		if (randomNum > 3158)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 68.42%!");
		}
	    }
	    else if (bet.equals("sixline"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble * 5;
		if (randomNum < 1579)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 15.79%!");
		}
		if (randomNum > 1579)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 84.21%%!");
		}
	    }
	    else if (bet.equals("firstfive"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble * 6;
		if (randomNum < 1316)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 13.16%!");
		}
		if (randomNum > 1316)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 86.84%%!");
		}
	    }
	    else if (bet.equals("corner"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble * 8;
		if (randomNum < 1316)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 10.53%!");
		}
		if (randomNum > 1316)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 89.47%%!");
		}
	    }
	    else if (bet.equals("street"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble * 11;
		if (randomNum < 789)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 7.895%!");
		}
		if (randomNum > 789)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 92.105%!");
		}
	    }
	    else if (bet.equals("split"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble * 17;
		if (randomNum < 526)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 5.26%!");
		}
		if (randomNum > 526)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 94.74%!");
		}
	    }
	    else if (bet.equals("any"))
	    {
		randomNum = rand.nextInt(10000) + 1;
		System.out.println("Betting $" + gamble + " on " + bet + "...");
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		System.out.println("Spinning...");
		payout += gamble * 35;
		if (randomNum < 262)
		{
		    money += payout;
		    winStreak += 1;
		    System.out.println("You won $" + payout + " with 2.62%!");
		}
		if (randomNum > 262)
		{
		    money -= gamble;
		    winStreak = 0;
		    System.out.println("You lost $" + gamble + " with 97.38%!");
		}
	    }

	    if (money == 0)
	    {
		System.out.println("You've gone broke!");
		System.exit(0);
	    }

	    System.out.println("You are on a " + winStreak + " win streak.");
	    if (winStreak == 3)
	    {
		System.out.println("You have been awarded $500 for your third win streak!");
		System.out.println("$500 has been deposited into your account.");
		money += 500;
	    }
	    rounds += 1;
	    System.out.println("");
	    System.out.println("");
	    try
	    {
		Thread.sleep(2000);
	    }
	    catch (InterruptedException ex)
	    {
		Thread.currentThread().interrupt();
	    }

	}

    }
}
