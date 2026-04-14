package conway.domain;

public interface IGrid {
	
	public int getRowsNum();
	public int getColsNum();
	public ICell getCell(int row, int col);
	public void setCell(int row, int col, boolean status);	
	public boolean getCellStatus(int row, int col);
	public void clear();
	void resetGrid();
	
}
