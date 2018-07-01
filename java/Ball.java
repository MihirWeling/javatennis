/*
Borrowed from edu4java.com
6/30/18
*/

package com.edu4java.minitennis7;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;
import java.awt.Color;

public class Ball {
	private static final int DIAMETER = 30;

	int x = 150;
	int y = 100;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}
	//movement of the ball and making sure ball doesn't go through edge border
	void move() {
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = 1;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -1;
		else if (y + ya < 0)
			//game.setScore1(score1);
			game.gameOver();
		else if (y + ya > game.getHeight() - DIAMETER)
			//game.setScore2(score2);
			game.gameOver();
		else if (collision()){
			ya = 1;
			y = game.racquet.getTopY() - DIAMETER;
		}
		else if (collide()){
			ya = -1;
			y = game.versus.getLowY() - DIAMETER;
		} else
			changeDirection = false;

		if (changeDirection)
			Sound.BALL.play();
		x = x + xa;
		y = y + ya;
	}
	//finds if ball collides with a racquet
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	private boolean collide() {
		return game.versus.getBounds().intersects(getBounds());

	}
	//paints ball
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
