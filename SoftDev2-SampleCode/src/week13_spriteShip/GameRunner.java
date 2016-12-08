package week13_spriteShip;

public class GameRunner implements Runnable {
	boolean gameOn = true;
	GameBoard gameBoard;
	public GameRunner(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	@Override
	public void run() {
		while(gameOn){
			gameBoard.tickAll();
			try {
				Thread.sleep(GameBoard.REFRASHINTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
