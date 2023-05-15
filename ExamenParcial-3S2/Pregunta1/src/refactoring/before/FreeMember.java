package refactoring.before;

public class FreeMember extends Member {
    public FreeMember(String nombre) {
        super(nombre);
    }
    @Override
    public void joinTournament() {
        System.out.println(".....");
    }
    //Este método rompe LSP
    @Override
    public void organizeTournament() {
        System.out.println("... ");
    }
}