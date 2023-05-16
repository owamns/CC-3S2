import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovimientoTest {
    private SOS game;
    Throwable exception;

    //Posicion row no valido para un tablero 3x3
    @Test
    public void testMoveXInvalidPosition(){
        game = new SOS(3, 'S');
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.makePlay(4,0, SOS.Box.LETTER_S);
        });
        Assertions.assertEquals("El argumento debe estar dentro de los limited del tablero", exception.getMessage());
    }

    //Posicion column no valido para un tablero 3x3
    @Test
    public void testMoveYInvalidPosition(){
        game = new SOS(3, 'S');
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.makePlay(0, 4, SOS.Box.LETTER_S);
        });
        Assertions.assertEquals("El argumento debe estar dentro de los limited del tablero", exception.getMessage());
    }

    //Movimiento en un lugar ocupado en un tablero 3x3
    @Test
    public void testMoveOccupiedPosition(){
        game = new SOS(3, 'S');
        game.makePlay(0,0, SOS.Box.LETTER_O);
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.makePlay(0, 0, SOS.Box.LETTER_S);
        });
        Assertions.assertEquals("Casilla ocupado", exception.getMessage());
    }

}