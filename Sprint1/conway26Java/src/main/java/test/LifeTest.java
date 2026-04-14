package main.java.test;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import conway.domain.ILife;
import conway.domain.Life;

public class LifeTest {

    private ILife life; // Uso la classe concreta per accedere a getNeighborsNum
    private final int SIZE = 5;

    @Before
    public void setup() {
        // Inizializziamo una griglia 5x5
        life = new Life(SIZE, SIZE);
        
        // Impostiamo una configurazione di test (3 celle vive attorno a 1,1)
        // Cella (0,0), (0,1) e (2,1) sono vive
        life.getGrid().setCell(0, 0, true);
        life.getGrid().setCell(0, 1, true);
        life.getGrid().setCell(2, 1, true);
        
        System.out.println("LifeTest | setup");
    }

    @After
    public void down() {
        System.out.println("LifeTest | down");
    }

    @Test
    public void testCountNeighbors() {
        // La cella (1,1) ha 3 vicini vivi in base al setup
        int neighbors = life.getNeighborsNum(1, 1);
        assertEquals("Il conteggio dei vicini per (1,1) dovrebbe essere 3", 3, neighbors);
    }
    
    @Test
    public void testSurvivalRule() {
        // Testiamo se una cella con 3 vicini nasce/sopravvive
        life.nextGen();
        // La cella (1,1) era morta, ma con 3 vicini deve nascere
        assertEquals("La cella (1,1) dovrebbe nascere nella prossima generazione", 
				true, life.getGrid().getCellStatus(1, 1));
	}

    @Test
    public void testShow() {
        // Verifica visiva dello stato
        System.out.println("Visualizzazione griglia di test:");
        life.show();
    }
}