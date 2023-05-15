package refactoring.after;

public abstract class TournamentOrganizer implements Member{
    private final String nombre;
    public TournamentOrganizer(String nombre){
        this.nombre = nombre;
    }

    public abstract void organizeTournament();
}
