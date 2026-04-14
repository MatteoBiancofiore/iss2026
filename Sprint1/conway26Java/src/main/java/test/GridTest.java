package main.java.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import conway.domain.Grid;
import conway.domain.IGrid;

public class GridTest {

    private final int DIM = 5;
    private IGrid g;

    @Before
    public void setup() {
        g = new Grid(DIM, DIM);
    }

    @After
    public void down() {
        g = null;
    }

    @Test
    public void testGridInitialization() {
        // Verifica che le dimensioni siano corrette
        assertEquals("Il numero di righe dovrebbe essere " + DIM, DIM, g.getRowsNum());
        assertEquals("Il numero di colonne dovrebbe essere " + DIM, DIM, g.getColsNum());
    }

    @Test
    public void testGridAllDead() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                assertFalse("La cella ["+i+"]["+j+"] dovrebbe essere morta", g.getCellStatus(i, j));
            }
        }
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetCellOutOfBoundsNegativo() {
        // Questo test passerà se viene lanciata l'eccezione
        g.getCell(-1, -1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetCellOutOfBoundsOltreLimite() {
        // Testiamo il limite superiore (DIM è 5, quindi l'indice 5 è fuori)
        g.getCell(DIM, DIM);
    }

    @Test
    public void testSetAndGetStatus() {
        g.setCell(2, 2, true);
        assertTrue("La cella (2,2) dovrebbe essere viva", g.getCellStatus(2, 2));
        
        g.clear();
        assertFalse("Dopo clear(), la cella (2,2) dovrebbe essere morta", g.getCellStatus(2, 2));
    }
}