import java.util.Random;
import java.util.Scanner;

public class GatorTester {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Welcome to the gator arena!");
    System.out.println("You can name your gator, choose your color, and " +
    "battle an enemy gator!");
    Gator enemy = new Gator(enemyName(), enemyColor());
    System.out.println("Your opponent is: " + enemy.getName() + ", the notorious "
    + enemy.getColor() + " gator!");
    System.out.print("What is your gator's name?: ");
    String name = keyboard.nextLine();
    Gator player = new Gator(name);
    System.out.print("What color is your gator?: ");
    player.setColor(keyboard.nextLine());
    System.out.println("Okay " + player.getName() + ", go get him!\n");
    playGame(player, enemy);
    System.out.println("\nGood game!");
  }

  public static String enemyName(){
    String[] names = {"Billy the Biter", "Chomper the Champion",
                      "Garry the Gator Fighter", "Samuel the Slayer",
                      "Toothy Tommy the Terrible"};
    return (names[new Random().nextInt(5)]);
  }

  public static String enemyColor(){
    String[] colors = {"red", "black", "orange", "white", "purple", "blue"};
    return (colors[new Random().nextInt(5)]);
  }

  public static boolean resolveAction(Gator player, Gator enemy, String action){
      String[] actions = {"attack", "defend", "magic attack", "magic defend"};
      String enemyAction = actions[new Random().nextInt(4)];
      if(action.equals("attack")){
        if(!enemyAction.equals("defend") || !enemyAction.equals("magic defend")){
          System.out.println("You hit the enemy!");
          enemy.loseHitpoints(2);
        } else {
          System.out.println("The enemy blocks!");
        }//if-else for resolving attack
        enemyRetaliation(player, enemy, enemyAction);
      } else if(action.equals("defend")) {
        if(!enemyAction.equals("magic attack")){
          System.out.println("You don't take any damage!");
        } else {
          if(enemy.getMana() >= 5) {
            System.out.println("A magic attack breaks your defenses!");
            player.loseHitpoints(4);
            enemy.loseMana(5);
          } else {
            System.out.println("The enemy doesn't have enough mana!");
          }//if-else for resolving mana cost of an enemy attack
        }//if-else for resolving defense
      } else if (action.equals("magic attack")){
        if(!enemyAction.equals("magic defend")){
          if(player.getMana() >= 5){
            System.out.println("You hit the enemy!");
            enemy.loseHitpoints(4);
          } else {
            System.out.println("You don't have enough mana!");
          }//if-else resolving mana cost of player attack
        } else {
          System.out.println("The enemy blocks your magic attack!");
          enemy.loseMana(5);
        }//if-else for resolving player magic attack
        player.loseMana(5);
        enemyRetaliation(player, enemy, enemyAction);
      } else if (action.equals("magic defend")){
          System.out.println("You don't take any damage!");
          player.loseMana(5);
      } else {
        System.out.println("You stumble! Enter a proper move!");
        enemyRetaliation(player, enemy, enemyAction);
      }//if-else for all responses
      System.out.println("\nThe enemy has " + enemy.getHitpoints() + " hitpoints and "
                          + enemy.getMana() + " mana!");
      if(player.getHitpoints() == 0 || enemy.getHitpoints() == 0){
        return false;
      } else {
        return true;
      }
  }

  public static void enemyRetaliation(Gator player, Gator enemy, String enemyAction){
    if(enemyAction.equals("attack") || enemyAction.equals("magic attack")){
      System.out.println("The enemy hits you with a(n) " + enemyAction + "!");
      if(enemyAction.equals("attack")){
        player.loseHitpoints(2);
      } else {
        if(enemy.getMana() >= 5){
          player.loseHitpoints(4);
        } else {
          System.out.println("The enemy is out of mana, so his attack failed!");
        }
        enemy.loseMana(5);
      }//if-else for damage of enemy attack
    }//if-else for enemy retaliation
  }

  public static void playGame(Gator player, Gator enemy){
    Scanner keyboard = new Scanner(System.in);
    boolean playing = true;
    while(playing){
      System.out.println("You have " + player.getHitpoints() + " hitpoints and " +
                         player.getMana() + " mana!\n");
      System.out.print("What would you like to do next? (Attack, Defend, Magic Attack (5 mana), Magic Defend (5 mana)): ");
      String action = keyboard.nextLine();
      System.out.println();
      playing = resolveAction(player, enemy, action.toLowerCase());
    }
    System.out.println("You have " + player.getHitpoints() + " hitpoints and " +
                       player.getMana() + " mana!\n");
    if(player.getHitpoints() == enemy.getHitpoints()){
      System.out.println(player.getName() + " tied with " + enemy.getName() + "!");
    } else if (player.getHitpoints() <= 0){
      System.out.println("The winner is: " + enemy.getName() + ", the notorious "
                          + enemy.getColor() + " gator!");
    } else {
      System.out.println("The winner is: " + player.getName() + ", the "
                          + player.getColor() + " gator!");
    }
  }

}
