/*
    https://pokemondb.net/pokedex/roserade
   *Класс покемона Roserade
    Реализован
*/

public final class Roserade extends Roselia {
    private final double HP = 60;
    private final double ATT = 70;
    private final double DEF = 65;
    private final double SP_ATT = 125;
    private final double SP_DEF = 105;
    private final double SPEED = 90;

    public Roserade(String name, int level) {
        super(name, level);
        super.setStats(HP, ATT, DEF, SP_ATT, SP_DEF, SPEED);

        // Атаки Facade, ShadowBall, RazorLeaf наследуются

        DoubleTeam att4 = new DoubleTeam();
        super.addMove(att4);
    }
}
