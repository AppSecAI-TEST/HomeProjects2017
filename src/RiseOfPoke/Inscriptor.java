package RiseOfPoke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Inscriptor extends JPanel implements ActionListener, KeyListener {
	Timer gameSpeed;
	ObjectManager book;
	int lordwidth = 100;
	int lordheight = 100;
	Poker lord = new Poker(500 - lordwidth, 500 - lordheight, lordwidth, lordheight, 5 /* health */);

	public Inscriptor() {
		gameSpeed = new Timer(1000 / 120, this);
	}

	

	public void paintComponent(Graphics danna) {
		// if (currentState == MENU_STATE) {
		// drawMenuState(delta);
		// } else if (currentState == GAME_STATE) {
		// drawGameState(delta);
		// } else if (currentState == END_STATE) {
		// drawEndState(delta);
		// }
		drawGameState(danna);
	}

	void drawGameState(Graphics b) {
		b.setColor(Color.darkGray);
		b.fillRect(0, 0, 1000, 1000);
		book.draw(b);
		//show score code
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void startGame() {
		gameSpeed.start();
		book.addObject(lord);
	}

}
