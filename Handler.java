import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	//Handles process of each of the objects
	//Loops through all objects currently in LL, individually update them, and render them to screen
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i<object.size(); i++){
			//Let's say we have: Handler h = new Handler();
			//Then every call to h.tick will call individual .tick() in every gameObject 
			GameObject tempObject = object.get(i); //The i'th element of LL
			
			tempObject.tick();
		}
	}
	public void render(Graphics g){
		for(int i = 0; i<object.size(); i++){
			GameObject tempObject = object.get(i); //The ith element of LL
			
			tempObject.render(g);
		}
	}
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
