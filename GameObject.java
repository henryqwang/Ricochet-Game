import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	//'Protected': only accessible among subclasses that inherits (extends) this class
	//No need to initialize variables x and y in subclasses, already initialized here
	protected int x, y; 
	protected ID id;
	protected int velX, velY;

	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}

	//Every game object must define
	//1.'tick' method: what to do
	//2.'render' method: what to show
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	//Getter & Setter Methods
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setID(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getVelX(){
		return velX;
	}
	public int getVelY(){
		return velY;
	}



}
