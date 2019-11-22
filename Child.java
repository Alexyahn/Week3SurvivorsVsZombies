package groupproject;

public class Child extends Survivor {

   private static final int HEALTH = 20;
   private static final int ATTACK = 2;


   // No-arg constructor

   public Child() {
       super(Survivor.CHILD, HEALTH, ATTACK);
   }
}
