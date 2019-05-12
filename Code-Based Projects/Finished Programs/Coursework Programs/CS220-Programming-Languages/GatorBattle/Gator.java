public class Gator{

  private String name;
  private String color;
  private int hitpoints;
  private int mana;

  public Gator(String name, String color){
    this.name = name;
    this.color = color;
    hitpoints = 10;
    mana = 10;
  }//constructor

  public Gator(String name){
    this.name = name;
    color = "green";
    hitpoints = 10;
    mana = 10;
  }

  public String getName(){return name;}
  public String getColor(){return color;}
  public int getHitpoints(){return hitpoints;}
  public int getMana(){return mana;}

  public void setColor(String c){color = c;}

  public void loseHitpoints(int l){
    if(l > hitpoints || hitpoints == 0){
      hitpoints = 0;
    } else {
      hitpoints -= l;
    }
  }

  public void loseMana(int l){
    if(l > mana || mana == 0){
      mana = 0;
    } else {
      mana -= l;
    }
  }

}
