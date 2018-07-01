/*
Borrowed from edu4java.com
6/30/18
*/

package com.edu4java.minitennis7;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;


@SuppressWarnings("serial")
public class Game extends JPanel {

	private int x = 0;
	private int y = 0;

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	Versus versus = new Versus(this);
	private Game game;

	//Game() listens to key actions to move the racquets
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
				versus.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				versus.keyPressed(e);

			}
		});
		setFocusable(true);
		Sound.BACK.loop();
	}
	//moves ball and both racquets
	/*
	 public void setScore1(String score1){
	 	x++;
	 	score1.setText(x);
	 	if (x == 5){
	 		game.gameOver();
	 	}
	 }
	 public void setScore2(String score2){
	 	y++;
	 	score2.setText(y);
		if (y == 5){
	 		game.gameOver();
	 	}
	 }
	 */
	private void move() {
		ball.move();
		racquet.move();
		versus.move();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		versus.paint(g2d);
	}
 	// ends game when run
	public void gameOver() {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	//creates frame
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
/*
		TextField score1 = new TextField();
			score1.setBounds(20, 195, 20, 10);
		TextField score2 = new TextField();
			score2.setBounds(280, 195, 20,10);
			*/
		frame.add(game);
		//frame.add(score1);
		//frame.add(score2);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
