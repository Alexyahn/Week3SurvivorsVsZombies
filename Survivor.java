package groupproject;

public class Survivor extends Character {

   // Survivor types
   protected static final String CHILD = "Child";
   protected static final String TEACHER = "Teacher";
   protected static final String SOLDIER = "Soldier";

   // Instance variables
   private String sType;


   public Survivor(String sType, int health, int attack) {
       super(Character.SURVIVOR, health, attack);

       // Set Survivor type
       this.sType = sType;
   }

   // Returns a string representation of this Survivor's health

   @Override
   public String toString() {
       return sType;
   }
}