package groupproject;

public class Tank extends Zombie {

   private static final int HEALTH = 150;
   private static final int ATTACK = 20;

   // No-arg constructor

   public Tank() {
       super(Zombie.TANK, HEALTH, ATTACK);
   }
}