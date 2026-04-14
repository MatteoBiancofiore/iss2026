package conway.domain;

public class Cell implements ICell {
    private int row;
    private int col;
    private boolean status;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.status = false;
    }

    public Cell() {
    	this.row = 0;
		this.col = 0;
		this.status = false;
	}

	@Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void switchCellState() {
        this.status = !this.status;
    }

	@Override
	public boolean isAlive() {
		return status;
	}
}