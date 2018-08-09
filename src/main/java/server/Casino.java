package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import client.Player;

public class Casino extends Thread
{

    private int bankBalance;

    private Player player;

    private Socket socket;

    private String odds;

    private List<String> commands;

    private List<String> bets;

    public Casino(Socket socket, Player player)
    {
	this.socket = socket;
	this.player = player;

	commands = Arrays.asList("bet", "money", "cashout", "help");
	bets = Arrays
		.asList(
			"red",
			"black",
			"odd",
			"even",
			"any",
			"1to18",
			"19to36",
			"sixline",
			"firstfive",
			"corner",
			"street",
			"split",
			"1to12",
			"13to24",
			"25to36");

	try
	{
	    odds = new String(Files.readAllBytes(Paths.get("src/main/resources/odds.txt")));
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
    }

    public int getBankBalance()
    {
	return bankBalance;
    }

    public void setBankBalance(int bankBalance)
    {
	this.bankBalance = bankBalance;
    }

    public Socket getSocket()
    {
	return socket;
    }

    public void setSocket(Socket socket)
    {
	this.socket = socket;
    }

    public Player getPlayer()
    {
	return player;
    }

    @Override
    public void run()
    {
	try
	{
	    Random rand = new Random();
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    out.println("eddig----------szerver-----------------");

	    int spinnedNumber = 0;
	    int payout = 0;
	    int rounds = 0;
	    int roundsWon = 0;
	    int gamble = 0;
	    String command = "";
	    String bet;
	    boolean won = false;

	    out.println("Round " + rounds + ".");
	    out.println("You have $" + player.getBalance() + ".");
	    out.println("\n");
	    out.println(odds);
	    out.println("What would you like to do?");
	    out.println(commands);

	    Scanner input = new Scanner(socket.getInputStream());

	    CASHOUT_BREAK_OUT: while (player.getBalance() > 0)
	    {
		command = input.nextLine();

		while (!commands.contains(command))
		{
		    out.println("Invalid choice, type 'help' to view the commands, what would you like to do?");
		    out.println(commands);
		    command = input.next();
		}

		while (command.equals("money"))
		{
		    out.println("Your balance is at $" + player.getBalance() + ".");
		    out.println("What would you like to do?");
		    out.println(commands);
		    command = input.next();
		}

		while (command.equals("cashout"))
		{
		    out
			    .println(
				    "You have cashed out $" + player.getBalance() + " with " + roundsWon
					    + " won games from " + rounds + " rounds.");
		    out.println("");
		    break CASHOUT_BREAK_OUT;

		}

		while (command.equals("help"))
		{
		    out.println(odds);
		    out.println("What would you like to do?");
		    out.println(commands);
		    command = input.next();
		}

		out.println("What would you like to bet on?");
		out.println(bets);
		bet = input.next();

		while (!bets.contains(bet))
		{
		    out.println("Invalid choice, check the table to view what you can bet on.");
		    out.println(bets);
		    out.println("What would you like to bet on?");
		    bet = input.nextLine();
		}

		out.println("How much money are you going to chip in?");
		gamble = input.nextInt();
		while (gamble > player.getBalance())
		{
		    out.println("Nice try, you're betting more than you can handle...");
		    out.println("How much money are you going to chip in?");
		    gamble = input.nextInt();
		}

		spinnedNumber = rand.nextInt(10000) + 1;
		out.println("Betting $" + gamble + " on " + bet + "...");

		if (bet.equals("red") || bet.equals("black") || bet.equals("even") || bet.equals("odd")
			|| bet.equals("1to18") || bet.equals("19to36"))
		{
		    payout += gamble;
		    if (spinnedNumber < 4738)
		    {
			won = true;
		    }
		}
		else if (bet.equals("1to12") || bet.equals("13to24") || bet.equals("25to36"))
		{
		    payout += gamble * 2;
		    if (spinnedNumber < 315)
		    {
			won = true;
		    }
		}
		else if (bet.equals("sixline"))
		{
		    payout += gamble * 5;
		    if (spinnedNumber < 1579)
		    {
			won = true;
		    }
		}
		else if (bet.equals("firstfive"))
		{
		    payout += gamble * 6;
		    if (spinnedNumber < 1316)
		    {
			won = true;
		    }
		}
		else if (bet.equals("corner"))
		{
		    payout += gamble * 8;
		    if (spinnedNumber < 1316)
		    {
			won = true;
		    }
		}
		else if (bet.equals("street"))
		{
		    payout += gamble * 11;
		    if (spinnedNumber < 789)
		    {
			won = true;
		    }
		}
		else if (bet.equals("split"))
		{
		    payout += gamble * 17;
		    if (spinnedNumber < 526)
		    {
			won = true;
		    }
		}
		else if (bet.equals("any"))
		{
		    payout += gamble * 35;
		    if (spinnedNumber < 262)
		    {
			won = true;
		    }
		}

		if (won)
		{
		    player.increaseBalance(payout);
		    roundsWon += 1;
		    out.println("You won $" + payout + "!");
		}
		else
		{
		    player.decreaseBalance(gamble);
		    out.println("You lost $" + gamble + "!");
		}

		out.println("What would you like to do?");
		out.println(commands);

		if (player.getBalance() == 0)
		{
		    out.println("You've gone broke!");
		    System.exit(0);
		}

		rounds += 1;
	    }
	}
	catch (

	IOException e)
	{
	    e.printStackTrace();
	}

    }

    private void log(String message)
    {
	System.out.println(message);
    }

}
