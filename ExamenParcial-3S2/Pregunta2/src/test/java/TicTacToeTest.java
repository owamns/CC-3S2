import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private static TicTacToe game;
    Throwable exception;

    @BeforeAll
    public static void setup(){
        game = new TicTacToe();
    }
    @Test
    void TestJugar() {
        game.resetGame();
        //Posicion x no valido - limites del tablero I
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.jugar(5, 2);
        });
        Assertions.assertEquals("Movimieto no valido", exception.getMessage());

        //Posicion y no valido - limites del tablero II
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.jugar(2, 5);
        });
        Assertions.assertEquals("Movimieto no valido", exception.getMessage());

        //Lugar ocupado
        game.jugar(2,2);
        exception = assertThrows(IllegalArgumentException.class, () -> {
            game.jugar(2, 2);
        });
        Assertions.assertEquals("Lugar ocupado",exception.getMessage());
    }

    @Test
    void TestProximoJugador(){
        game.resetGame();
        //Primer turno, jugador X
        Assertions.assertEquals('X',game.proximoJugador());

        //Turno de O despues de X
        for (int i=0; i<game.getN(); i++){
            for (int j=0; j<game.getN(); j++){
                game.jugar(i+1,j+1);
            }
        }
        Assertions.assertEquals('O',game.proximoJugador());

        //Turno de X despues de O
        game.resetGame();
        game.jugar(1,1);
        game.jugar(1,2);
        Assertions.assertEquals('X',game.proximoJugador());
    }

    @Test
    void TestEsGanador(){
        game.resetGame();
        //Por defecto no hay ganador
        Assertions.assertEquals(TicTacToe.GameState.PLAYING, game.getGameState());

        //Condicion ganadora I - fila ganadora
        game.jugar(1,1); // X
        game.jugar(2,1); // O
        game.jugar(1,2); // X
        game.jugar(2,2); // O
        game.jugar(1,3); // X
        Assertions.assertEquals(TicTacToe.GameState.X_WON, game.getGameState());

        game.resetGame();

        //Condicion ganadora II - columna ganadora
        game.jugar(1,1); // X
        game.jugar(1,2); // O
        game.jugar(2,1); // X
        game.jugar(2,2); // O
        game.jugar(3,1); // X
        Assertions.assertEquals(TicTacToe.GameState.X_WON, game.getGameState());

        game.resetGame();

        //Condicion ganadora III - diagonal principal ganadora
        game.jugar(1,1); // X
        game.jugar(1,2); // O
        game.jugar(2,2); // X
        game.jugar(2,3); // O
        game.jugar(3,3); // X
        Assertions.assertEquals(TicTacToe.GameState.X_WON, game.getGameState());

        game.resetGame();

        //Condicion ganadora IV - diagonal secundaria ganadora
        game.jugar(3,1); // X
        game.jugar(1,2); // O
        game.jugar(2,2); // X
        game.jugar(2,3); // O
        game.jugar(1,3); // X
        Assertions.assertEquals(TicTacToe.GameState.X_WON, game.getGameState());

    }

    @Test
    void TestEmpate(){

        //Condicion de empate
        game.resetGame();
        game.jugar(1,1); //X
        game.jugar(1,2); //O
        game.jugar(2,2); //X
        game.jugar(1,3); //O
        game.jugar(2,3); //X
        game.jugar(2,1); //O
        game.jugar(3,1); //X
        game.jugar(3,3); //O
        game.jugar(3,2); //X
        Assertions.assertEquals(TicTacToe.GameState.DRAW, game.getGameState());
    }

}