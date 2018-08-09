package server;

import java.util.Random;

public class BallGenerator
{
    public RouletteBall generate()
    {

	RouletteBall ball = new RouletteBall();

	// Adds random to a variable then generates a number between 0 - 36.
	Random rand = new Random();
	int ballNumber = rand.nextInt(36);
	ball.setNumber(ballNumber);
	ball.setColour(determineColour(ballNumber));
	ball.setEven(oddOrEven(ballNumber));
	return ball;
    }

    private String determineColour(int numberLandedOn)
    {
	String colour;
	// If the ball number is 0, assign it green.
	if (numberLandedOn == 0)
	{
	    colour = ("green " + numberLandedOn);
	}

	// If the ball number is even, assign it black.
	else if (numberLandedOn % 2 == 0)
	{
	    colour = ("black " + numberLandedOn);
	}

	// If the ball number is odd, assign it red.
	else
	{
	    colour = ("red " + numberLandedOn);

	}
	return colour;
    }

    private boolean oddOrEven(int numberLandedOn)
    {
	boolean even = false;
	if (numberLandedOn == 0)
	{
	    even = true;
	}

	if (numberLandedOn % 2 == 0)
	{
	    even = true;
	}

	if (numberLandedOn % 2 == 1)
	{
	    even = false;
	}
	return even;
    }

}
