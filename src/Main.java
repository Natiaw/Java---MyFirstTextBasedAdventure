import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player variables
        int health = 100;
        int attackDamage = 35;
        int numHealthPotions = 3; //que o character começa
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //percentage

        boolean running = true; //condition to a while loop

        System.out.println("Welcome to the dungeon");

        GAME: //label the while loop so the program iterates back

        while(running) {
            System.out.println("-------------------------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth); //generates a random number between 0 and the maxEnemyHealth
            String enemy = enemies[rand.nextInt(enemies.length)]; //random integer according to the max length of the array
            System.out.println("\t#   " + enemy + " has appeared!  #\n"); //\t é tab

            while(enemyHealth > 0) {
                System.out.println("\t Your HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt; //takes the health from the enemy
                    health -= damageTaken; //and from us

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t You recieve " + damageTaken + " in retaliation!");

                    if(health <=0) {
                        System.out.println("\t>You've taken too much damage");
                        break;
                    }

                } else if (input.equals("2")){
                    if(numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;

                        System.out.println("You've taken a Health Potion, healing yourself for: " + healthPotionHealAmount + "."
                        + "\n\t> You know have " + health + "HP."
                        + "\n\t> You have " + numHealthPotions + " health potions left\n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                    }

                }else if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME; //ignore everything after this point and go back to the beginning

                } else {
                    System.out.println("\tInvalid command!");

                }
            }

            if(health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle");
                break; //the while running loop
            }
            System.out.println("-------------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. #" );
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " health portion(s). # ");
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();
            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command! Press 1 or 2");
                input = in.nextLine();
            }

            if(input.equals("1")) {
                System.out.println("You decided to continue on your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon successful from your adventure!");
                break;
            }

        }
        System.out.println("################################");
        System.out.println("#Thanks for playing my game! :D# \n#Be welcome anytime back!      #");
        System.out.println("################################");


    }
}