package groupproject;

public class Character {

   // Character types
   protected static final String ZOMBIE = "Zombie";
   protected static final String SURVIVOR = "Survivor";

   // Instance variables
   private String cType;
   private int health;
   private int attack;

   public Character(String cType, int health, int attack) {
       this.cType = cType;
       this.health = health;
       this.attack = attack;
   }

   /**
   * Updates the health of the Character c when it is attacked by
   * zombie
   */
   public void attack(Character c) {
       // Update health of c
       c.health = c.health - this.attack;
   }

   
    //Character lives or not

   public boolean isDead() {
       return (health <= 0);
   }
}


