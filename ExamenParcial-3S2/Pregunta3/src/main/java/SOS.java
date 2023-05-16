public class SOS {
    public enum Box {EMPTY, LETTER_S, LETTER_O}

    private int squaresPerSide;
    public enum GameState {PLAYING , BLUE_WON, RED_WON, DRAW}
    private Player[] players = new Player[2];

    private Player activePlayer;
    private GameState currentGameState;
    private char gameType;

    private Box[][] grid;

    public SOS(int squaresPerSide, char gameType){
        this.squaresPerSide = squaresPerSide;
        this.gameType = gameType;
        grid = new Box[squaresPerSide][squaresPerSide];
        currentGameState = GameState.PLAYING;
        initBoard();
    }

    public void initBoard(){
        for( int row = 0; row < squaresPerSide; row++ ){
            for ( int column = 0; column < squaresPerSide; column++){
                grid[row][column] = Box.EMPTY;
            }
        }
        players[0] = new Player("BluePlayer");
        players[1] = new Player("RedPlayer");
        activePlayer = players[0];
    }

    public int getSquaresPerSide() { return squaresPerSide; }

    public boolean isPositionInGrid(int row, int column){
        return (row >= 0 && row < squaresPerSide && column >= 0 && column < squaresPerSide);
    }

    public Box getBox(int row, int column){
        if ( isPositionInGrid(row, column) ) return grid[row][column];
        else {
            return null;
        }
    }

    public Player getActivePlayer(){ return activePlayer; }

    public void makePlay(int row, int column, Box chosen){
        if ( !isPositionInGrid(row, column) ){
            throw new IllegalArgumentException("El argumento debe estar dentro de los limited del tablero");
        }
        else if(getBox(row, column)!=Box.EMPTY){
            throw new IllegalArgumentException("Casilla ocupado");
        }
        grid[row][column] = chosen;
        if(howManySOS(row, column, chosen)==0){
            changeActivePlayer();
        }
        else {
            getActivePlayer().increaseScore(howManySOS(row, column, chosen));
        }
        updateGameState(gameType);
    }

    private void updateGameState(char gameType) {
        if(gameType=='S'){
            if(getWinner()!=null){
                currentGameState = (getActivePlayer().getName().equals("BluePlayer")) ? GameState.BLUE_WON : GameState.RED_WON;
            }
            else if(isBoardFull()){
                currentGameState = GameState.DRAW;
            }
        }
        else {
            if(getWinner()!=null && isBoardFull()){
                currentGameState = (getWinner().getName().equals("BluePlayer")) ? GameState.BLUE_WON : GameState.RED_WON;
            }
            else if(isBoardFull() && getWinner()==null){
                currentGameState = GameState.DRAW;
            }
        }
    }

    public GameState getGameState() {
        return currentGameState;
    }

    public void changeActivePlayer(){
        activePlayer = ( getActivePlayer() == players[0] ) ? players[1]:players[0];
    }

    boolean detectSOSWhenS(int row, int column, int[] duple){
        return ( getBox(row + duple[0], column + duple[1]) == Box.LETTER_O && getBox(row + 2 * duple[0], column + 2 * duple[1]) == Box.LETTER_S);
    }

    boolean detectSOSWhenO(int row, int column, int[] duple){
        return ( getBox(row + duple[0], column + duple[1]) == Box.LETTER_S && getBox(row - duple[0], column - duple[1]) == Box.LETTER_S);
    }

    public int howManySOS(int row, int column, Box chosen){
        int[][] around = new int[][]{ {-1,-1} , {0,-1} , {1,-1} , {-1,0} , {1,0} , {-1,1} , {0,1} , {1,1} } ;
        int points = 0;
        if ( chosen == Box.LETTER_S ){
            for( int i = 0; i < 8; i++ ){
                if( detectSOSWhenS(row, column, around[i]) ){
                    points++;
                }
            }
        }
        else if ( chosen == Box.LETTER_O ){
            for( int i = 0; i < 4; i++ ){
                if( detectSOSWhenO(row, column, around[i]) ){
                    points++;
                }
            }
        }
        return points;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < squaresPerSide; row++ ){
            for ( int column = 0; column < squaresPerSide; column++ ){
                if (getBox(row, column) == Box.EMPTY) return false;
            }
        }
        return true;
    }

    public Player getWinner(){
        if ( players[0].getScore() > players[1].getScore()){
            return players[0];
        }
        else if ( players[0].getScore() < players[1].getScore() ){
            return players[1];
        }
        else return null;
    }

    class Player{
        private String name;
        private int score;
        private char letter;

        public Player(String name){
            this.name = name;
            score = 0;
            letter = 'S';
        }
        public int getScore(){
            return score;
        }

        public void increaseScore(int points){
            score += points;
        }

        public String getName(){
            return name;
        }

    }

}
