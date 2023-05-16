import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {
    private SOS game;

    //Primer turno del jugador Azul juego simple
    @Test
    public void testBluePlayerFirstTurn(){
        game = new SOS(3,'S');
        Assertions.assertEquals("BluePlayer", game.getActivePlayer().getName());
    }

    //Turno del jugador Rojo despues del Azul juego simple
    @Test
    public void testRedPlayerTurnAfterBluePlayer(){
        game = new SOS(3,'S');
        game.makePlay(0,0, SOS.Box.LETTER_S); //Blue player
        Assertions.assertEquals("RedPlayer", game.getActivePlayer().getName());
    }

    //Turno de X despues de O
    @Test
    public void testBluePlayerTurnAfterRedPlayer(){
        game = new SOS(3,'S');
        game.makePlay(0,0, SOS.Box.LETTER_S); //Blue player
        game.makePlay(0,1, SOS.Box.LETTER_S); //Red player
        Assertions.assertEquals("BluePlayer", game.getActivePlayer().getName());
    }

    //Mismo turno al formar SOS
    @Test
    public void testAnotherTurn(){
        game = new SOS(3,'S');
        game.makePlay(0,0, SOS.Box.LETTER_S); //Blue player
        game.makePlay(0,1, SOS.Box.LETTER_O); //red player
        game.makePlay(0,2, SOS.Box.LETTER_S); //Blue player
        Assertions.assertEquals("BluePlayer", game.getActivePlayer().getName());
    }

}