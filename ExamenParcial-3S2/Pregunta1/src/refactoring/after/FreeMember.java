package refactoring.after;

public class FreeMember implements Member{
    private final String nombre;
    public FreeMember(String nombre){
        this.nombre = nombre;
    }
    @Override
    public void joinTournament() {

    }
}
