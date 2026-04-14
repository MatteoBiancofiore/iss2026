package conway.domain;

public class LifeController implements ILifeController {

	private int updateTime = 500; // default time in ms
	private ILife life;
	private IOutDev outDev;
	private boolean isRunning = false;
	private int generation = 0;
	
	
	public LifeController(ILife life, IOutDev outDev) {
		this.life = life;
		this.outDev = outDev;
	}
	
	@Override
	public int getGeneration() {
		return this.generation;
	}
	
	
	@Override
	public void switchCellState(int row, int col) {
		life.getCell(row, col).switchCellState();
		if(outDev != null)
			outDev.displayGrid(life.getGrid());
	}
	
	protected void startGame() {
		if (isRunning) return; // already running
		isRunning = true;
		this.playGame();
		
	}
	
	protected void stopGame() {
		if (!isRunning) return; // already stopped
		isRunning = false;		
	}
	
	protected void clearGame() {
		if (outDev != null)
			outDev.displayGrid(life.getGrid());
		this.stopGame();
		generation = 0;
		life.resetGrid();
		if (outDev != null)
            outDev.displayGrid(life.getGrid());
	}
	

	protected void playGame() {
		new Thread(() -> {
			while (isRunning) {
				try {
					life.nextGen();
					generation++;
					if (outDev != null)
						outDev.displayGrid(life.getGrid());
					Thread.sleep(updateTime);            	
				}catch(Exception e) {
					Thread.currentThread().interrupt();
					break;
				}
				
				
			}
			
		}).start();
		
	}

	@Override
	public void onStart() {
		this.startGame();		
	}

	@Override
	public void onStop() {
		this.stopGame();
		
	}

	@Override
	public void onClear() {
		this.clearGame();		
	}

	
}