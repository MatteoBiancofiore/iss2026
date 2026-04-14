package conway.domain;

public interface ICell {
    int getRow();
    int getCol();
    boolean getStatus();
    void setStatus(boolean status);
    void switchCellState();
	boolean isAlive();
}