package groupproject;

public class Zombie extends Character {

   // Zombie types
   protected static final String COMMON_INFECTED = "CommonInfected";
   protected static final String TANK = "Tank";

   // Instance variables
   private String zType;

   public Zombie(String zType, int health, int attack) {
       super(Character.ZOMBIE, health, attack);

       // Set zombie type
       this.zType = zType;
   }

   // Returns a string representation of this Zombie's health
   
   @Override
   public String toString() {
       return zType;
   }
}