package conway.domain;

public class Grid implements IGrid {

    private int rowsNum;
    private int colsNum;
    private ICell[][] cells;

    public Grid(int rows, int cols) {
        this.rowsNum = rows;
        this.colsNum = cols;
        this.cells = new ICell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }

    @Override
    public int getRowsNum() {
        return rowsNum;
    }

    @Override
    public int getColsNum() {
        return colsNum;
    }

    @Override
    public ICell getCell(int row, int col) {
        return cells[row][col];
    }

    @Override
    public void setCell(int row, int col, boolean status) {
        cells[row][col].setStatus(status);
    }

    @Override
    public boolean getCellStatus(int row, int col) {
        return cells[row][col].getStatus();
    }

    @Override
    public void resetGrid() {
        for (int i = 0; i < rowsNum; i++) {
            for (int j = 0; j < colsNum; j++) {
                cells[i][j].setStatus(false);
            }
        }
    }

	@Override
	public void clear() {
		
	}

}