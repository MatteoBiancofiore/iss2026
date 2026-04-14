package conway.domain;

public interface ILifeController {

    int getGeneration();
    void onStart();
    void onStop();
    void onClear();
    void switchCellState(int row, int col);

}