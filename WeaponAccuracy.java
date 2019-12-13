//
//Group: Devin, Ratna, Alex, Samantha, Logan 
//Zombie War Project
//
package groupproject;

import java.util.Random;


public class WeaponAccuracy {

    private int accuracyVal = 0;
    
    public boolean isAccurate() {

        Random r = new Random();
        //creates new random object
        
        int randVal = r.nextInt(100) + 1;
        //int variable is given an int value between 1 and 100
        
        switch (Weapon.getType()) {
        //gets weapon accuracy based on weapon type and assigns it to accuracyVal int variable
            
            case ("Shotgun"):
                accuracyVal = Shotgun.getAccuracy();
                break;
                
            case ("SubmachineGun"):
                accuracyVal = SubmachineGun.getAccuracy();
                break;
                
            case ("Pistol"):
                accuracyVal = Pistol.getAccuracy();
                break;
                
            case ("AssaultRifle"):
                accuracyVal = AssaultRifle.getAccuracy();
                break;
                
            case ("FryingPan"):
                accuracyVal = FryingPan.getAccuracy();
                break;
                
            case ("Crowbar"):
                accuracyVal = Crowbar.getAccuracy();
                break;
                
            case ("Axe"):
                accuracyVal = Axe.getAccuracy();
                break;
        }

        if (randVal <= accuracyVal) {            //if random value is below or equal to accuracy value of designated weapon returns true and prints hit
            System.out.println("Hit");
            return true;
        } else {
            System.out.println("Miss");         //if random value is greater than accuracy value returns false and prints miss
            return false;
        }

    }
}
