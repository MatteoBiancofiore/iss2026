package conway.domain;

public interface ILife {

    IGrid getGrid();
    void nextGen();
    void resetGrid();
	ICell getCell(int row, int col);
	int getNeighborsNum(int i, int j);
	void show();

}