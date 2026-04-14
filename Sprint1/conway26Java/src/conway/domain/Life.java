package conway.domain;

public class Life implements ILife {

	private Grid currentGen;
	private Grid nextGen;

	public Life(int rows, int cols) {
		this.currentGen = new Grid(rows, cols);
		this.nextGen = new Grid(rows, cols);
	}

	public int getNeighborsNum(int row, int col) {
		int res = 0;
		int rows = currentGen.getRowsNum();
		int cols = currentGen.getColsNum();

		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i == row && j == col)
					continue;

				if (i >= 0 && i < rows && j >= 0 && j < cols) {
					if (this.currentGen.getCellStatus(i, j)) {
						res++;
					}
				}
			}
		}
		return res;
	}

	@Override
	public void nextGen() {
		int rows = currentGen.getRowsNum();
		int cols = currentGen.getColsNum();

		// 1. Calcolo il destino di ogni cella basandoti su currentGen
		// e scrivo il risultato in nextGen
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int count = this.getNeighborsNum(i, j);
				boolean isAlive = currentGen.getCellStatus(i, j);

				if (isAlive) {
					// Sopravvivenza: 2 o 3 vicini
					nextGen.setCell(i, j, (count == 2 || count == 3));
				} else {
					// Nascita: esattamente 3 vicini
					nextGen.setCell(i, j, (count == 3));
				}
			}
		}

		// 2. AGGIORNAMENTO: Copia i risultati di nextGen in currentGen
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				currentGen.setCell(i, j, nextGen.getCellStatus(i, j));
			}
		}
	}

	@Override
	public void show() {
		StringBuilder sb = new StringBuilder();
		sb.append("Stato corrente:\n");
		for (int i = 0; i < currentGen.getRowsNum(); i++) {
			for (int j = 0; j < currentGen.getColsNum(); j++) {
				sb.append(currentGen.getCellStatus(i, j) ? "O " : ". ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	@Override
	public Grid getGrid() {
		return this.currentGen;
	}

	@Override
	public void resetGrid() {
		this.currentGen.clear();
		this.nextGen.clear();
	}

	@Override
	public ICell getCell(int row, int col) {
		return this.currentGen.getCell(row, col);
	}
}