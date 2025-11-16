/*
    https://pokemondb.net/pokedex/roselia
   *Класс покемона Roselia
    Реализован
*/

public class Roselia extends Budew {
    private final double HP = 50;
    private final double ATT = 60;
    private final double DEF = 45;
    private final double SP_ATT = 100;
    private final double SP_DEF = 80;
    private final double SPEED = 65;
    
    public Roselia(String name, int level) {
        super(name, level);
        super.setStats(HP, ATT, DEF, SP_ATT, SP_DEF, SPEED);

        // Атаки Facade, ShadowBall наследуются

        RazorLeaf att3 = new RazorLeaf();
        super.addMove(att3);
    }
}
