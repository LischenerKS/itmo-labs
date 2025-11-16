/*
    https://pokemondb.net/pokedex/rampardos
   *Класс покемона Rampardos
    Реализован
*/

public final class Rampardos extends Cranidos {
    private final double HP = 97;
    private final double ATT = 165;
    private final double DEF = 60;
    private final double SP_ATT = 65;
    private final double SP_DEF = 50;
    private final double SPEED = 58;

    public Rampardos(String name, int level) {
        super(name, level);
        super.setStats(HP, ATT, DEF, SP_ATT, SP_DEF, SPEED);

        FocusBlast att4 = new FocusBlast();
        super.addMove(att4);
    }
}
