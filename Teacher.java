package groupproject;

public class Teacher extends Survivor {

   private static final int HEALTH = 50;
   private static final int ATTACK = 5;

   // No-arg constructor

   public Teacher() {
       super(Survivor.TEACHER, HEALTH, ATTACK);
   }
}
