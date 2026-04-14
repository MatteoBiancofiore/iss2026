package main.java.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import conway.domain.Cell;
import conway.domain.ICell;

public class CellTest {
    private ICell c;
    
    @Before
    public void setup() {
        c = new Cell();
    }

    @After
    public void down() {
        c = null;
    }

    @Test
    public void testInitialState() {
        // Verifica che una cella appena creata sia morta di default
        // (Assumendo che il tuo costruttore Cell() imposti false)
        assertFalse("La cella dovrebbe essere morta all'inizializzazione", c.isAlive());
    }
    
    @Test
    public void testSetAlive() {
        c.setStatus(true);
        assertTrue("La cella dovrebbe essere viva dopo setStatus(true)", c.isAlive());
    }
    
    @Test
    public void testSetDead() {
        c.setStatus(true); // La portiamo a viva
        c.setStatus(false); // La uccidiamo
        assertFalse("La cella dovrebbe essere morta dopo setStatus(false)", c.isAlive());
    }

    @Test
    public void testConstructorWithParam() {
        ICell aliveCell = new Cell();
        assertTrue("La cella creata con status true dovrebbe essere viva", aliveCell.isAlive());
    }
}