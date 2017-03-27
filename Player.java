import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	private final int RANDBOUND = 5;

	Random r = new Random();
	Handler handler;
	//HUD hud;

	public Player(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
		//this.hud = hud;
	}

	@Override
	public Rectangle getBounds() { //return type is rectangle
		// TODO Auto-generated method stub
		return new Rectangle(x,y,32,32);
	}
	public void tick() {
		//With every tick, x = x + velX; y = y + velY;
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 67);
		
		collision();

	}

	private void collision(){
		for(int i = 0; i<handler.object.size(); i++){
			 GameObject tempObject = handler.object.get(i);
			 
			 if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy){
				 //when tempObject is a basic enemy or fast enemy
				 if (getBounds().intersects(tempObject.getBounds())){
					 HUD.HEALTH -= 1;
				 }
			 }
		}
	}

	public void render(Graphics g) {
		if (id == ID.Player){
			g.setColor(Color.white);	
			g.fillRect(x, y, 32, 32);

		}
		if(id == ID.Player2){
			g.setColor(Color.YELLOW);
			g.fillRect(x, y, 32, 32);
		}

	}





}