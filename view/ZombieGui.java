package view;

import controller.ZombieController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;
import util.ActionType;


/**
 *
 * @author Ike
 */
public class ZombieGui extends BasicGame{

        /** The container holding this test */
	private static AppGameContainer app;
        /** The current active ZombieGui */
        private static ZombieGui gui;


	/** The message to be displayed */
	private String message = "Zombies are coming!";
	/** The lines to be drawn on the screen */
	private ArrayList lines = new ArrayList();
	/** True if the mouse button is down */
	private boolean buttonDown;
	/** The x position of our controlled stuff */
	private float x;
	/** The y position of our controlled stuff */
	private float y;
	/** The colors */
	private Color[] cols = new Color[] {Color.red, Color.green, Color.blue, Color.white, Color.magenta, Color.cyan};
	/** The current color index */
	private int index;
	/** The input system  being polled */
	private Input input;
	/** The scroll box */
	private int ypos;
	/** True if space is down */
	private boolean space;
	/** True if left shift is down */
	private boolean lshift;
	/** True if right shift is down */
	private boolean rshift;
        /** Has a key been pressed */
        private boolean keyStateReady = true;


	public ZombieGui(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
                ZombieGui.app = (AppGameContainer)gc;
		input = gc.getInput();
		x = 300;
		y = 300;
        }


	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
            g.drawString("left shift down: "+lshift, 100, 240);
            g.drawString("right shift down: "+rshift, 100, 260);
            g.drawString("space down: "+ space, 100, 280);

            g.setColor(Color.white);
            g.drawString(message, 10, 50);
            g.drawString(""+container.getInput().getMouseY(), 10, 400);
            g.drawString("Press SHIFT to attack a zombie. Press SPACE to run.", 10, 90);

            for (int i=0;i<lines.size();i++) {
                Line line = (Line) lines.get(i);
                line.draw(g);
            }
	}


	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
            this.lshift = gc.getInput().isKeyDown(Input.KEY_LSHIFT);
            this.rshift = gc.getInput().isKeyDown(Input.KEY_RSHIFT);
            this.space = gc.getInput().isKeyDown(Input.KEY_SPACE);
            if (controllerLeft[0]) {
                    x -= delta * 0.1f;
            }
            if (controllerRight[0]) {
                    x += delta * 0.1f;
            }
            if (controllerUp[0]) {
                    y -= delta * 0.1f;
            }
            if (controllerDown[0]) {
                    y += delta * 0.1f;
            }
            if (this.space && this.keyStateReady) {
                ZombieController.reactToInput(ActionType.PLAYER_MOVE);
                this.keyStateReady = false;
            }
            if ((this.lshift || this.rshift) && this.keyStateReady) {
                ZombieController.reactToInput(ActionType.PLAYER_ATTACK);
                this.keyStateReady = false;
            }
        }

        /**
	 * @see org.newdawn.slick.BasicGame#keyPressed(int, char)
         * @param key
         * @param c
	 */
        @Override
	public void keyPressed(int key, char c) {
            if (key == Input.KEY_ESCAPE) {
                    System.exit(0);
            }
            if (key == Input.KEY_F1) {
                if (app != null) {
                    try {
                    app.setDisplayMode(600, 600, false);
                    app.reinit();
                    } catch (Exception e) {
                        Log.error(e);
                    }
                }
            }
	}


	/**
	 * @see org.newdawn.slick.BasicGame#keyReleased(int, char)
         * @param key
         * @param c
	 */
        @Override
	public void keyReleased(int key, char c) {
		message = "You pressed key code "+key+" (character = "+c+")";
                this.keyStateReady = true;
	}

	/**
	 * @see org.newdawn.slick.BasicGame#mousePressed(int, int, int)
	 */
	public void mousePressed(int button, int x, int y) {
		if (button == 0) {
			buttonDown = true;
		}

		message = "Mouse pressed "+button+" "+x+","+y;
	}

	/**
	 * @see org.newdawn.slick.BasicGame#mouseReleased(int, int, int)
	 */
	public void mouseReleased(int button, int x, int y) {
		if (button == 0) {
			buttonDown = false;
		}

		message = "Mouse released "+button+" "+x+","+y;
	}

	/**
	 * @see org.newdawn.slick.BasicGame#mouseClicked(int, int, int, int)
	 */
	public void mouseClicked(int button, int x, int y, int clickCount) {
		System.out.println("CLICKED:"+x+","+y+" "+clickCount);
	}

	/**
	 * @see org.newdawn.slick.BasicGame#mouseWheelMoved(int)
	 */
	public void mouseWheelMoved(int change) {
		message = "Mouse wheel moved: "+change;

		if (change < 0) {
			ypos -= 10;
		}
		if (change > 0) {
			ypos += 10;
		}
	}

	/**
	 * @see org.newdawn.slick.BasicGame#mouseMoved(int, int, int, int)
	 */
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		if (buttonDown) {
			lines.add(new Line(oldx,oldy,newx,newy));
		}
	}

        public static void display(String _gameName) {
            try {
                ZombieGui.gui = new ZombieGui(_gameName);
                ZombieGui.app = new AppGameContainer(ZombieGui.gui);
                ZombieGui.app.setDisplayMode(640, 480, false);
                ZombieGui.app.start();
            } catch (SlickException ex) {
                Logger.getLogger(ZombieGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


	/**
	 * A line that has been drawn by the user
	 *
	 * @author kevin
	 */
	private class Line {
		/** The start x position */
		private int oldx;
		/** The start y position */
		private int oldy;
		/** The end x position */
		private int newx;
		/** The end y position */
		private int newy;

		/**
		 * Create a new line
		 *
		 * @param oldx The start x position
		 * @param oldy The start y position
		 * @param newx The end x position
		 * @param newy The end y position
		 */
		public Line(int oldx, int oldy,int newx,int newy) {
			this.oldx = oldx;
			this.oldy = oldy;
			this.newx = newx;
			this.newy = newy;
		}

		/**
		 * Draw the line to the provided graphics context
		 *
		 * @param g The graphics context on which to draw the line
		 */
		public void draw(Graphics g) {
			g.drawLine(oldx, oldy, newx, newy);
		}
	}


}
