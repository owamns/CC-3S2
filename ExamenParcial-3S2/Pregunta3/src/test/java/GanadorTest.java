import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GanadorTest {

    private SOS game;

    //Por defecto no hay ganador
    @Test
    public void testStartGameWinner(){
        game = new SOS(3, 'S');
        Assertions.assertEquals(null, game.getWinner());
    }

    //fila ganadora juego simple
    @Test
    public void testWinnerPlayerWithRows(){
        game = new SOS(3, 'S');
        game.makePlay(0, 0, SOS.Box.LETTER_S); //blue
        game.makePlay(0, 1, SOS.Box.LETTER_O); //red
        game.makePlay(0, 2, SOS.Box.LETTER_S); //win blue
        Assertions.assertEquals(SOS.GameState.BLUE_WON, game.getGameState());
    }

    //columna ganadora juego simple
    @Test
    public void testWinnerPlayerWithColumns(){
        game = new SOS(3, 'S');
        game.makePlay(0, 0, SOS.Box.LETTER_S); //blue
        game.makePlay(1, 0, SOS.Box.LETTER_O); //red
        game.makePlay(2, 0, SOS.Box.LETTER_S); //win blue
        Assertions.assertEquals(SOS.GameState.BLUE_WON, game.getGameState());
    }

    //Diagonal principal ganadora juego simple
    @Test
    public void testWinnerPlayerWithMainDiagonal(){
        game = new SOS(3, 'S');
        game.makePlay(0, 0, SOS.Box.LETTER_S); //blue
        game.makePlay(1, 1, SOS.Box.LETTER_O); //red
        game.makePlay(2, 2, SOS.Box.LETTER_S); //win blue
        Assertions.assertEquals(SOS.GameState.BLUE_WON, game.getGameState());
    }

    //Diagonal secundaria ganadora juego simple
    @Test
    public void testWinnerPlayerWithSecondaryDiagonal(){
        game = new SOS(3, 'S');
        game.makePlay(2, 0, SOS.Box.LETTER_S); //blue
        game.makePlay(1, 1, SOS.Box.LETTER_O); //red
        game.makePlay(0, 2, SOS.Box.LETTER_S); //win blue
        Assertions.assertEquals(SOS.GameState.BLUE_WON, game.getGameState());
    }

    //ganador juego general
    @Test
    public void testWinnerGeneralGame(){
        game = new SOS(3,'G');
        for (int i=0; i<game.getSquaresPerSide(); i++){
            for (int j=0; j<game.getSquaresPerSide(); j++){
                if(i==2 && j==1){
                    game.makePlay(i, j, SOS.Box.LETTER_O); //win blue with 1 point
                }
                else {
                    game.makePlay(i, j, SOS.Box.LETTER_S);
                }
            }
        }
        Assertions.assertEquals(SOS.GameState.BLUE_WON, game.getGameState());
    }

}