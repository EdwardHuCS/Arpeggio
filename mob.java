/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Edward
 *  @version May 25, 2015
 *  @author  Period: TODO
 *  @author  Assignment: ARPEGGIO
 *
 *  @author  Sources: TODO
 */
public class mob
{
    public  String mobName = "";

    public Weapon mobWeapon;

    public  Armor mobArmor;

    public  double mobHP;


    /**
     * Makes a new monster (mobile)
     * @param name monster's name
     * @param HP monster's hit points
     * @param myWeap monster's current weapon
     * @param myArmor monster's current armor
     */
    public mob( String name, double HP, Weapon myWeap, Armor myArmor )
    {
        mobHP = HP;
        mobName = name;
        mobWeapon = myWeap;
        mobArmor = myArmor;
    }


    /**
     * Gets the mob's name.
     * @return the mob's current name
     */
    public  String getMobName()
    {
        return mobName;
    }


    /**
     * Sets the mob's name. 
     * @param newName the name to be set
     */
    public  void setMobName( String newName )
    {
        mobName = newName;
    }


    /**
     * Gets the mob's armor.
     * @return the mob's current armor
     */
    public  Armor getMobArmor()
    {
        return mobArmor;
    }


    /**
     * Sets the mob's armor. 
     * @param newArmor the armor to be set
     */
    public  void setMobArmor( Armor newArmor )
    {
        mobArmor = newArmor;
    }


    /**
     * Gets the mob's weapon.
     * @return the mob's current weapon
     */
    public  Weapon getMobWeapon()
    {
        return mobWeapon;
    }


    /**
     * Sets the mob's weapon. 
     * @param newWeapon the weapon to be set
     */
    public  void setMobWeapon( Weapon newWeapon )
    {
        mobWeapon = newWeapon;
    }


    /**
     * Gets the mob's HP.
     * @return the mob's current hp
     */
    public  double getMobHP()
    {
        return mobHP;
    }


    /**
     * Sets the mob's HP.
     * @param newHP the HP to be set
     */
    public  void setMobHP( double newHP )
    {
        mobHP = newHP;
    }
}
