package week10game1;

public class GameRunner implements Runnable {

	GameBoard gameBoard;
	boolean gameOn = true;
	
	
	public GameRunner(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	@Override
	public void run() {
		while (gameOn){
			gameBoard.tickAll();
			try {
				Thread.sleep(GameBoard.REFRESHRATE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
