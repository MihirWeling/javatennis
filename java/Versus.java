/*
Borrowed from edu4java.com
6/30/18
*/

package com.edu4java.minitennis7;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Versus {

	private static final int Y = 360;
	private static final int WITH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game game;


	public Versus(Game game) {
		this.game = game;
	}
	// racquet 1 movement
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WITH)
			x = x + xa;
	}
	//paints racquet 1
	public void paint(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, Y, WITH, HEIGHT);
	}
	//keys for racquet 1
	public void keyReleased(KeyEvent e) {
		xa = 0
		;
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_D)
			xa = 1;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WITH, HEIGHT);
	}

	public int getLowY() {
		return Y-10;
	}
}
