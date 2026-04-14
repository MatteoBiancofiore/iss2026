package conway.domain;

public class MainConwayLife {

    public static void main(String[] args) {
        // dimensioni griglia
        int rows = 10;
        int cols = 10;

        ILife life = new Life(rows, cols);

        // Output Device per console
        IOutDev outDev = new IOutDev() {
            @Override
            public void displayGrid(IGrid grid) {
                // Pulizia simulata della console (stampa righe vuote)
                System.out.println("\n".repeat(2)); 
                
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < grid.getRowsNum(); i++) {
                    for (int j = 0; j < grid.getColsNum(); j++) {
                        sb.append(grid.getCellStatus(i, j) ? " O " : " . ");
                    }
                    sb.append("\n");
                }
                System.out.print(sb.toString());
            }
            
        };

        LifeController controller = new LifeController(life, outDev);

        // 5. Setup iniziale: Creiamo un "Blinker" (oscillatore) e un "Glider"
        setupPatterns(life);

        System.out.println("--- Conway's Game of Life: Starting ---");
        controller.onStart();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        controller.onStop();
        System.out.println("\n\n\n--- Simulation Finished ---");
    }

    private static void setupPatterns(ILife life) {
        IGrid grid = life.getGrid();
        
        // Creazione di un "Blinker" alla riga 1
        grid.setCell(1, 2, true);
        grid.setCell(1, 3, true);
        grid.setCell(1, 4, true);

        // Creazione di un "Glider"
        grid.setCell(4, 1, true);
        grid.setCell(5, 2, true);
        grid.setCell(6, 0, true);
        grid.setCell(6, 1, true);
        grid.setCell(6, 2, true);
    }
}