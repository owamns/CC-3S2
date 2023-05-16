import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpateTest {

    private SOS game;

    //Condicion de empate simple game
    @Test
    public void testDrawGame(){
        game = new SOS(3,'S');
        for (int i=0; i<game.getSquaresPerSide(); i++){
            for (int j=0; j<game.getSquaresPerSide(); j++){
                game.makePlay(i, j, SOS.Box.LETTER_S);
            }
        }
        Assertions.assertEquals(SOS.GameState.DRAW, game.getGameState());
    }
}