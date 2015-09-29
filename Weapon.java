/**
 *  Defines the Weapon class.
 *
 *  @author  Edward Hu, Oliver Dong, David Yang
 *  @version May 25, 2015
 *  @author  Period: 6
 *  @author  Assignment: ARPEGGIO

 */
public class Weapon
{
    String weaponName = "";

    /**
     * of the form ABCDEF, where A is element, BCD is damage, and EF is hit chance
     */
    int stat = 0; 


    public Weapon( String name, int stat )
    {
        weaponName = name;
        this.stat = stat;
    }


    /**
     * Gets the name of the weapon
     * @return the name
     */
    public String getWeaponName()
    {
        return weaponName;
    }

    /**
     * Gets the stat of the weapon
     * @return the stat
     */
    public int getWeaponStat()
    {
        return stat;
    }

    /**
     * Gets the element of the weapon
     * @return the element
     */
    public int getWeaponElement()
    {
        return stat / 100000;
    }

    /**
     * Gets the accuracy of the weapon
     * @return the accuracy
     */
    public double getWeaponHitChance()
    {
        return stat % 100;
    }
    
    
    /**
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other)
    {
        return other.toString().equals( toString() );
    }


    /**
     * Calculates and returns the damage dealt by this weapon
     * @return the damage
     */
    public double getWeaponDamage()
    {
        return ( stat % 100000 - stat % 100 ) / 100;
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return getWeaponName() + '\n' + "Damage: " + getWeaponDamage() + '\n' + "Accuracy: " + getWeaponHitChance() + "%";
    }
}
