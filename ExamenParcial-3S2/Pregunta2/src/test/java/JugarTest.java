import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugarTest {
    private static TicTacToe game;
    Throwable exception;

    @BeforeAll
    public static void setUp(){
        game = new TicTacToe();
    }

    //Posicion x no valido - limites del tablero I
    @Test
    public void testMoveXInvalidPosition(){
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.jugar(5, 2);
        });
        Assertions.assertEquals("Movimieto no valido", exception.getMessage());
    }

    //Posicion y no valido - limites del tablero II
    @Test
    public void testMoveYInvalidPosition(){
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.jugar(2, 5);
        });
        Assertions.assertEquals("Movimieto no valido", exception.getMessage());
    }

    //Lugar ocupado
    @Test
    public void testMoveOccupiedPosition(){
        game.jugar(2,2);
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.jugar(2, 2);
        });
        Assertions.assertEquals("Lugar ocupado",exception.getMessage());
    }
}