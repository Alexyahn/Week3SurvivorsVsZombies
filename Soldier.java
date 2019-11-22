package groupproject;

public class Soldier extends Survivor {

   private static final int HEALTH = 100;
   private static final int ATTACK = 10;

   // No-arg constructor

   public Soldier() {
       super(Survivor.SOLDIER, HEALTH, ATTACK);
   }
}
