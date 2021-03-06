import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Room extends GameObject implements ActionListener {
	SketcHex hex;

	int roomStuckTime = 0;
	int roomsroomnumber;
	boolean unspawnedhorde;
	Color color;
	Color darkdarkblue = new Color(0, 0, 50);
	int randomfunint1 = new Random().nextInt(255);
	int randomfunint2 = new Random().nextInt(255);
	int randomfunint3 = new Random().nextInt(255);
	Color randomfun = new Color(randomfunint1, randomfunint2, randomfunint3);
	int randomfunint11 = new Random().nextInt(255);
	int randomfunint22 = new Random().nextInt(255);
	int randomfunint33 = new Random().nextInt(255);
	Color randomfun2 = new Color(randomfunint11, randomfunint22, randomfunint33);
	int randomfunint111 = new Random().nextInt(255);
	int randomfunint222 = new Random().nextInt(255);
	int randomfunint333 = new Random().nextInt(255);
	Color randomfun3 = new Color(randomfunint111, randomfunint222, randomfunint333);
	int randomfunint1111 = new Random().nextInt(255);
	int randomfunint2222 = new Random().nextInt(255);
	int randomfunint3333 = new Random().nextInt(255);
	Color randomfun4 = new Color(randomfunint1111, randomfunint2222, randomfunint3333);
	int randomfunint11112 = new Random().nextInt(255);
	int randomfunint22223 = new Random().nextInt(255);
	int randomfunint33334 = new Random().nextInt(255);
	Color randomfun5 = new Color(randomfunint11112, randomfunint22223, randomfunint33334);
	int randomfunint111123 = new Random().nextInt(255);
	int randomfunint222234 = new Random().nextInt(255);
	int randomfunint333345 = new Random().nextInt(255);
	Color randomfun6 = new Color(randomfunint111123, randomfunint222234, randomfunint333345);
	int randomfunint1111234 = new Random().nextInt(255);
	int randomfunint2222345 = new Random().nextInt(255);
	int randomfunint3333456 = new Random().nextInt(255);
	Color randomfun7 = new Color(randomfunint1111234, randomfunint2222345, randomfunint3333456);
	// *
	int level = 1;
	int levelupper = 0;
	int leveluppermultiplier = 1;
	int leveluppermultipliercounter = 0;
	SpawningItem xenomorpheousSubstance;
	int roomImage = 10;
	Color aCopy;

	public Room(int x, int y, int width, int height, int roomsroomnumber, boolean unspawnedhorde, Color color,
			SketcHex hex) {
		super(x, y, width, height);
		this.hex = hex;
		this.roomsroomnumber = roomsroomnumber;
		this.unspawnedhorde = unspawnedhorde;
		this.color = color;

	}

	public void update() {
		super.update();

		// moving to the next room right
		if (hex.flynn.x >= 1000) {
			roomSwitch(true);
		} else if (hex.flynn.x <= 0) {
			roomSwitch(false);
		}

	}

	@SuppressWarnings("static-access")
	private void roomSwitch(boolean isRight) {
		Room r00m;
		int itemwidth = 80;
		int itemheight = 80;
		int randomItemX = new Random().nextInt(HordeRunner.width - (HordeRunner.width / 5) - itemwidth);
		int randomItemY = new Random().nextInt(HordeRunner.height - (HordeRunner.height / 5) - itemheight);
		hex.flynn.x += isRight ? -HordeRunner.width + 5 : HordeRunner.width - 5;
		hex.flynnroomnumber += isRight ? 1 : -1;
		hex.roomcolors.add(color);
		Color a = randomColor();
		aCopy = a;
		// *
		hex.roomColor = a;

		if (hex.megahead.getRoom(hex.flynnroomnumber) == null) {
			levelupper++;
			if ((levelupper >= level) && (levelupper % 2 == 0)) {
				int apoint = level;
				level += levelupper / 2;
				int bpoint = level;
				System.out.println("Level Upper is: " + levelupper);
				if (apoint != bpoint) {
					// System.out.println(
					// "Level Up! (Now Level " + level + "!). Health is up too!
					// Now at " +
					// hex.flynn.health + ".");
					hex.flynn.health += (5 * level);
					JOptionPane.showMessageDialog(null, "Level Up! (Now Level " + level
							+ "!). Health and bullets are up too! Now at " + hex.flynn.health + ".");

				}
				levelupper = 0;
			}
			r00m = new Room(0, 0, HordeRunner.width, HordeRunner.height, hex.flynnroomnumber, true, a, hex);
			hex.megahead.addObject(r00m);
			if (isRight) {
				hex.megahead.addRoom(r00m, true);
				hex.hordeAdder = level;
			} else {
				hex.megahead.addRoom(r00m, false);
				hex.hordeAdder = level;
			}
			hex.enteredNewRoom(isRight, true);
			xenomorpheousSubstance = new SpawningItem(randomItemX, randomItemY, itemwidth, itemheight, "type unset",
					hex);
			if (xenomorpheousSubstance.x < HordeRunner.width / 5) {
				xenomorpheousSubstance.x += HordeRunner.width / 5;
			} else if (xenomorpheousSubstance.x > HordeRunner.width - (HordeRunner.width / 5)) {
				xenomorpheousSubstance.x -= HordeRunner.width - (HordeRunner.width / 5);
			}
			if (xenomorpheousSubstance.y < HordeRunner.height / 5) {
				xenomorpheousSubstance.y += HordeRunner.height / 5;
			} else if (xenomorpheousSubstance.y > HordeRunner.height - (HordeRunner.height / 5)) {
				xenomorpheousSubstance.y -= HordeRunner.height - (HordeRunner.height / 5);
			}
			hex.megahead.addObject(xenomorpheousSubstance);
		} else {
			r00m = hex.megahead.getRoom(hex.flynnroomnumber);
			hex.enteredNewRoom(isRight, false);
		}

		hex.onScreenRoom = r00m;
	}

	public int levelShower() {
		return level;

	}

	public Color randomColor() {
		Color roomColorSetter;
		int randomNum = new Random().nextInt(8);
		if (randomNum == 0) {
			roomColorSetter = randomfun;
		} else if (randomNum == 1) {
			roomColorSetter = randomfun7;
		} else if (randomNum == 2) {
			roomColorSetter = randomfun6;
		} else if (randomNum == 3) {
			roomColorSetter = randomfun5;
		} else if (randomNum == 4) {
			roomColorSetter = darkdarkblue;
		} else if (randomNum == 5) {
			roomColorSetter = randomfun4;
		} else if (randomNum == 6) {
			roomColorSetter = randomfun2;
		} else if (randomNum == 7) {
			roomColorSetter = randomfun3;
		} else {
			roomColorSetter = Color.yellow;

		}
		return roomColorSetter;
	}

	// *
	public void draw(Graphics g) {
		g.setColor(hex.onScreenRoom.color);
		// *
		g.fillRect(0, 0, 1000, 1000);
		if (aCopy.equals(randomfun)) {
			g.drawImage(SketcHex.fireplace, 0, 0, HordeRunner.width, HordeRunner.height, null);
		}
		// THE ROOMS DRAW HERE
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((hex.flynn.x == HordeRunner.width) || (hex.flynn.x == 0)) {
			roomStuckTime++;
			if (roomStuckTime == 2) {
				roomStuckTime = 0;
				hex.flynn.x += HordeRunner.width / 5;
			} else {
				JOptionPane.showMessageDialog(null, "Moving in: " + (4 - roomStuckTime) + ".");
			}
		}
	}

}
