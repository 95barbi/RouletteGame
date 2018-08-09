package client;

public class Player
{

    private String name;

    private int balance;

    public Player()
    {
    }

    public Player(String name, int balance)
    {
	super();
	this.name = name;
	this.balance = balance;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public int getBalance()
    {
	return balance;
    }

    public void setBalance(int balance)
    {
	this.balance = balance;
    }

    public void increaseBalance(int num)
    {
	this.balance += num;
    }

    public void decreaseBalance(int num)
    {
	this.balance -= num;
    }

}
