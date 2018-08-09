package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import client.Player;

public class Casino extends Thread
{

    private int capital;

    private List<Player> players;

    private Socket socket;

    public Casino()
    {
    }

    public Casino(Socket socket)
    {
	this.socket = socket;
    }

    public Casino(int capital, List<Player> players, Socket socket)
    {
	super();
	this.capital = capital;
	this.players = players;
	this.socket = socket;
    }

    public int getCapital()
    {
	return capital;
    }

    public void setCapital(int capital)
    {
	this.capital = capital;
    }

    public Socket getSocket()
    {
	return socket;
    }

    public void setSocket(Socket socket)
    {
	this.socket = socket;
    }

    public List<Player> getPlayers()
    {
	return players;
    }

    public void setPlayers(List<Player> players)
    {
	this.players = players;
    }

    public void addPlayer(Player player)
    {
	players.add(player);
    }

    public void removePlayer(Player player)
    {
	for (Player p : players)
	{
	    if (p.getName().equals(player.getName()))
	    {
		players.remove(p);
	    }
	}
    }

    @Override
    public void run()
    {
	try
	{
	    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

	    out.println("Enter a line with only a period to quit\n");

	    while (true)
	    {
		String input = in.readLine();
		if (input == null || input.equals("."))
		{
		    break;
		}
		out.println(input.toUpperCase());
	    }
	}
	catch (IOException e)
	{
	    log("Error handling client# " + e);
	}
	finally
	{
	    try
	    {
		socket.close();
	    }
	    catch (IOException e)
	    {
		log("Couldn't close a socket, what's going on?");
	    }
	    log("Connection with client# closed");
	}
    }

    private void log(String message)
    {
	System.out.println(message);
    }

}
