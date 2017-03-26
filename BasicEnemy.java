import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	
	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		velX = 3;
		velY = 3;
	}
	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,16,16);
	}
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0|| y >= Game.HEIGHT - 32*1.5){
			velY *= -1;
		}
		if(x <= 0||x >= Game.WIDTH -16){
			velX *= -1;
		}
		handler.addOject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.03f, handler));
		
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
		
		
	}
	
	

}
