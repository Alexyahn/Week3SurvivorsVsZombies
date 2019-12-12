package groupproject;

import java.util.Random;

public class ZombieWar {

   private static final int MAX = 10;
   private static final Random random = new Random();

   // Instance variables
   private Character[] survivors;
   private Character[] zombies;
   private int childNum;
   private int teacherNum;
   private int soldierNum;
   private int cInfectedNum;
   private int tankNum;


   // No-arg constructor

   public ZombieWar() {
       // Create survivors and zombies
       // Get random number of Children
       childNum = random.nextInt(MAX);

       // Get random number of Teacher
       teacherNum = random.nextInt(MAX);

       // Get random number of Soldier
       soldierNum = random.nextInt(MAX);

       // Get random number of CommonInfected
       cInfectedNum = random.nextInt(MAX);

       // Get random number of Tanks
       tankNum = random.nextInt(MAX);

       // Create an array of (childNum, teacherNum, and soldierNum) of Survivor
       getSurvivor();

       // Create an array of (cInfectedNum and tankNum) of Zombie
       getZombie();

       // Print number of survivors and zombies
       print();
   }

   /**
   * Creates a Survivor array consisting of childNum number of
   * Child, teacherNum number of Teacher and soldierNum number of Soldier
   */
   private void getSurvivor() {
       survivors = new Survivor[childNum + teacherNum + soldierNum];
       int i = 0;

       // Add Child objects
       for (i = 0; i < childNum; i++) {
           survivors[i] = new Child();
		}

       // Add Teacher objects
       for (; i < childNum + teacherNum; i++) {
           survivors[i] = new Teacher();
		}

       // Add Soldier objects
       for (; i < childNum + teacherNum + soldierNum; i++) {
           survivors[i] = new Soldier();
		}
   }

   /**
   * Createss a Zombie array consisting of cInfectedNum number of
   * CommonInfected and tankNum number of Tank
   */
   private void getZombie() {
       zombies = new Zombie[cInfectedNum + tankNum];
       int i = 0;

       // Add CommonInfected objects
       for (i = 0; i < cInfectedNum; i++) {
           zombies[i] = new CommonInfected();
		}

       // Add Tank objects
       for (; i < cInfectedNum + tankNum; i++) {
           zombies[i] = new Tank();
		}
   }


   // Prints the initial number of survivors and zombies
   
   private void print() {
       // Print number of survivors and zombies
       System.out.println("We have " + survivors.length + " survivors trying to make it to safety (" + childNum
               + " children, " + teacherNum + " teachers, " + soldierNum + " soldiers)");
       System.out.println("But there are " + zombies.length + " zombies waiting for them (" + cInfectedNum
               + " common infected, " + tankNum + " tanks)");
   }


   // Returns a character number.

   private int getCharacterIndex(Character c, int index) {
       if (c instanceof CommonInfected) {
           return (index % cInfectedNum);
		}
       else if (c instanceof Tank) {
           return (index % tankNum);
		}
       else if (c instanceof Child) {
           return (index % childNum);
		}
       else if (c instanceof Teacher) {
           return (index % teacherNum);
		}
       else if (c instanceof Soldier) {
           return (index % soldierNum);
		}
       else {
           return -1;
		}
   }


   // Returns the number of characters in the array that are alive


   private static int safeCount(Character[] characters) {
       int safe = 0;
       for (Character c : characters) {
           // Check if c is not dead
           if (!c.isDead()) {
               safe += 1;
			}
       }

       // Return number of characters that are alive
       return safe;
   }

   
   // Simulates each attacker
   private void attack(Character[] attacker, Character[] attackee) {
       for (int i = 0; i < attacker.length; i++) {
           // Get attacker i
           Character c1 = attacker[i];

           for (int j = 0; j < attackee.length; j++) {
               // Get attackee j
               Character c2 = attackee[j];

               // Check if c1 is not dead
               if (!c1.isDead() && !c2.isDead()) {
                   c1.attack(c2); // Simulate c1 attacks c2

                   // Check if c2 is dead
                   if (c2.isDead()) {
                       System.out.println("\t" + c1 + " " + getCharacterIndex(c1, i) + " killed " + c2 + " " + getCharacterIndex(c2, j));
					}
               }
           }
       }
   }

   /**
   * Simulates a war between zombies and survivors. War stops
   * when either all of the zombies or the survivors are dead. It returns the
   * number of survivors that made it to safety.
   */
   public void war() {
       while ((safeCount(survivors) > 0) && (safeCount(zombies) > 0)) {
           // Make each survivor attack every zombie
           attack(survivors, zombies);

           // Make each zombie attack every survivor
           attack(zombies, survivors);
       }

       // Print number of survivors that made to safety.
       warResult();
   }

 
   // Displays whether there are any survivors
   
   private void warResult() {
       // Get number of survivors alive
       int survivorCount = safeCount(survivors);
       if (survivorCount == 0) {
           System.out.println("None of the survivors made it.");
		}
       else {
           System.out.println("It seems " + survivorCount + " have made it to safety.");
		}
   }
   
   //for getting a random weapon 
   private static Weapon randomWeapon() {
        Random rand = new Random();
        int weaponType = rand.nextInt(7);
        switch (weaponType) {
            case 0: 
                return new FryingPan();
            case 1:
                return new SubmachineGun();
            case 2:
                return new AssaultRifle();
            case 3:
                return new Pistol();
            case 4:
                return new Axe();
            case 5:
                return new Crowbar();
            default:
                return new Shotgun();
        }
    }    
}