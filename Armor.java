/**
 *  Defines the Armor class.
 *
 *  @author  Edward Hu, Oliver Dong, David Yang
 *  @version May 25, 2015
 *  @author  Period: 6
 *  @author  Assignment: ARPEGGIO

 */
public class Armor
{
    String armorName = "";

    /**
     * of the form ABCDEF, where A is elemental resistance, BCD is static damage block, and EF is percentage reduction
     * 
     */
    int stat = 0; // of the form ABCDEF, where A is elemental resistance, BCD is
                  // static damage block, and EF is percentage reduction


    public Armor( String name, int stat )
    {
        armorName = name;
        this.stat = stat;
    }


    /**
     * Gets the name of this piece of armor
     * @return the name
     */
    public String getArmorName()
    {
        return armorName;
    }

    /**
     * Gets the stat of this piece of armor
     * @return the stat
     */
    public int getArmorStat()
    {
        return stat;
    }

    /**
     * Gets the element of this piece of armor
     * @return the element
     */
    public int getArmorElement()
    {
        return stat / 100000;
    }

    /**
     * Gets the static block of this piece of armor
     * @return the block value
     */
    public int getStaticBlock()
    {
        return ( stat % 100000 - stat % 100 ) / 100;
    }

    /**
     * Gets the percentage block of this piece of armor
     * @return the % block
     */
    public double getPercBlock()
    {
        return stat % 100;
    }

    
    /**
     * adds bonus blocking attributes based on the protagonist defense stats
     * @param defStat the amount of protagonist defense stat
     */
    public void addDefStat(int defStat)
    {
        stat += defStat/2;
        stat += defStat * 100;
    }
    
    /**
     * calculates damage values
     * @param d incoming damage
     * @return the actual damage dealt to HP
     */
    public double mitigate( double d )
    {
        if ( ( d - getStaticBlock() ) * ( 1.0 - ( getPercBlock() / 100.0 ) ) > 0 )
        {
            return ( d - getStaticBlock() )
                * ( 1.0 - ( getPercBlock() / 100.0 ) );
        }
        else
        {
            return 0;
        }

    }
    
    /** 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other)
    {
        return other.toString().equals( toString() );
    }


    /** 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return getArmorName() + '\n' + "Damage Block: " + getStaticBlock()
            + '\n' + "Damage Mitigation: " + getPercBlock() + "%";
    }



}
