import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	//private ID id;

	public int HEALTH = 100;
	private ID id;
	
	public HUD(ID id){
		this.id = id;	
	}
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	public void render(Graphics g){
	
		if (id == ID.Player){
			g.setColor(Color.gray);
			g.fillRect(15, 15, 200, 32);
			
			g.setColor(Color.green);
			g.fillRect(15, 15, HEALTH*2, 32);
			
			g.setColor(Color.white);
			g.drawRect(15, 15, 200, 32);
		}
		if (id == ID.Player2){
			g.setColor(Color.gray);
			g.fillRect(575, 15, 200, 32);
			
			g.setColor(Color.green);
			g.fillRect(575, 15, HEALTH*2, 32);
			
			g.setColor(Color.white);
			g.drawRect(575, 15, 200, 32);
		}
		
	}
}
