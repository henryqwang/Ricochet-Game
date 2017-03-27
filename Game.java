import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = WIDTH/12*9;

	private Thread thread;
	private boolean running = false;

	private Random r;
	private Handler handler;
	private HUD hud1;
	private HUD hud2;

	public Game(){

		//Handler construction
		handler = new Handler();
		//Make game aware of key presses
		this.addKeyListener(new KeyInput(handler));
		//Build window
		new  Window(WIDTH, HEIGHT, "Evidence of Henry Beating Kim", this);
		//When we construct a game object, it automatically creates a window object while passing an instance of itself as an argument
		
		r = new Random();

		hud1 = new HUD(ID.Player);
		hud2 = new HUD(ID.Player2);
		
		handler.addOject(new Player(WIDTH/2-64,HEIGHT/2-32, ID.Player, handler, hud1));
		handler.addOject(new Player(WIDTH/2+64,HEIGHT/2-32, ID.Player2, handler, hud2));
		
		for(int i = 0; i <20; i++){
			handler.addOject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.BasicEnemy, handler));//location of player is randomly generated
		}



	}
	public synchronized void start(){
		thread = new Thread(this); //This instance of game passed in as thread argument
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		this.requestFocus(); //No need to click on screen
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
			}
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick(){
		handler.tick(); //makes every object inside LL (see handler) tick
		hud1.tick();
		hud2.tick();
		
	}

	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null){
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		
		handler.render(g);
		hud1.render(g);
		hud2.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max){
		if(var >= max){
			return var = max;
		}else if(var <= min){
			return var = min;
		}else{
			return var;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();


	}

}
