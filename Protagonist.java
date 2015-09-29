
/**
 *  Defines the main character, as the player that is playing the game. 
 *  Holds the weapons, armor, and stats of the protagonist.
 *
 *  @author  Edward Hu, Oliver Dong, David Yang
 *  @version May 25, 2015
 *  @author  Period: 6
 *  @author  Assignment: ARPEGGIO

 */
public class Protagonist
{
    private double HP;

    private Weapon myWeapon;

    private String myName;

    private static Armor myArmor;

    private int[] myStats;

    private Inventory myInventory;

    private int playerClass;

    private int experience = 0;

    public static int level = 0;

    private int foobar = 0;

    private boolean inFight = false;

    boolean dead = false;

    public static boolean bossLife1 = true;

    /**
     * Constructs the protagonist
     * @param name the player's name
     */
    public Protagonist( String name )
    {
        if ( name.equals( "" ) )
        {
            setMyName( "The-one-who-must-not-be-named" );
        }
        else
        {
            setMyName( name );
        }
        myStats = new int[7];
        for ( int i = 0; i < myStats.length; i++ )
        {
            myStats[i] = 1;
        }
        myInventory = new Inventory();
        setMyWeapon( null );
        setMyArmor( null );
        HP = Game.MAXHP;
    }


    /**
     * for testing purposes only
     * @return the test int
     */
    public int test()
    {
        foobar += 100;
        return foobar;
    }


    /**
     * Sets the player class
     * @param playerClass the int referring to the class to be set
     */
    public void setPlayerClass( int playerClass )
    {
        this.playerClass = playerClass;
        lvlUp();
    }


    /**
     * Gets the player class
     * @return the playerclass
     */
    public int getPlayerClass()
    {
        return playerClass;
    }


    /**
     * gets the current Armor of the protagonist
     * @return the armor
     */
    public static Armor getMyArmor()
    {
        return myArmor;
    }


    /**
     * sets the current Armor of the protagonist
     * @param myArmor armor to be set
     */
    public void setMyArmor( Armor myArmor )
    {
        if ( myArmor != null )
        {
            myArmor.addDefStat( getDef() );
        }
        this.myArmor = myArmor;
    }


    /**
     * gets the current Armor of the protagonist
     * @return the armor 
     */
    public Weapon getMyWeapon()
    {
        return myWeapon;
    }


    /**
     * sets the current weapon of the protagonist
     * @param myWeapon the weapon to be set
     */
    public void setMyWeapon( Weapon myWeapon )
    {
        this.myWeapon = myWeapon;
    }


    /**
     * gets the protagonist's list of weapons and armor
     * @return his inventory
     */
    public Inventory getMyInventory()
    {
        return myInventory;
    }


    /**
     * Gets protagonist name
     * @return the name 
     */
    public String getMyName()
    {
        return myName;
    }


    /**
     * Gives the protagonist the chosen name
     * @param myName name chosen
     */
    public void setMyName( String myName )
    {
        this.myName = myName;
    }


    /**
     * 
     * Exp getter
     * 
     * @return Experience stat
     */

    public int getExperience()
    {
        return experience;
    }


    /**
     * These are all Stat getters
     * 
     * @return Strength stat
     */

    public int getStr()
    {
        return myStats[1];
    }


    /**
     * These are all Stat getters
     * 
     * @return Skill stat
     */
    public int getSkill()
    {
        return myStats[2];
    }


    /**
     * These are all Stat getters. For now, speed does nothing.
     * 
     * @return Speed stat
     */
    public int getSpd()
    {
        return myStats[3];
    }


    /**
     * These are all Stat getters
     * 
     * @return Agility stat
     */
    public int getAgi()
    {
        return myStats[3];
    }


    /**
     * These are all Stat getters
     * 
     * @return Defense stat
     */
    public int getDef()
    {
        return myStats[4];
    }


    /**
     * These are all Stat getters
     * 
     * @return HP stat
     */
    public double getHP()
    {
        if ( HP == Game.MAXHP )
            return HP + myStats[5] * 10;
        else
            return HP;
    }


    /**
     * These are all Stat getters
     * 
     * @return max HP stat
     */
    public double getMaxHP()
    {
        return Game.MAXHP + myStats[5] * 10;
    }


    /**
     * These are all Stat getters
     * 
     * @return Luck stat
     */
    public int getLuck()
    {
        return myStats[6];
    }


    /**
     * @param HP
     *            The HP to set.
     */
    public void setHP( double hP )
    {
        HP = hP;
    }


    /**
     * These are Level up methods. This method adds experience.
     * 
     * @param gainFactor
     *            1 is large, 2 is normal, 3 is small, 4 is insignificant, 5 is
     *            1.
     * 
     */
    public String addExp( int gainFactor )
    {
        String output = "";
        switch ( gainFactor )
        {
            case 1:
                experience += ( level * 100 ) / 2;
                // System.out.println( "You gain " + ( level * 100 ) / 3
                // + " experience! You now have " + experience + " out of "
                // + level * 100 + " experience!" );
                output += "You gain " + ( level * 100 ) / 2
                    + " experience! You now have " + experience + " out of "
                    + level * 100 + " experience!";
                break;

            case 2:
                experience += ( level * 100 ) / 3;
                // System.out.println( "You gain " + ( level * 100 ) / 6
                // + " experience! You now have " + experience + " out of "
                // + level * 100 + " experience!" );
                output += "You gain " + ( level * 100 ) / 3
                    + " experience! You now have " + experience + " out of "
                    + level * 100 + " experience!";
                break;

            case 3:
                experience += ( level * 100 ) / 6;
                // System.out.println( "You gain " + ( level * 100 ) / 12
                // + " experience! You now have " + experience + " out of "
                // + level * 100 + " experience!" );
                output += "You gain " + ( level * 100 ) / 6
                    + " experience! You now have " + experience + " out of "
                    + level * 100 + " experience!";
                break;

            case 4:
                experience += ( level * 100 ) / 12;
//                 System.out.println( "You gain " + ( level * 100 ) / 12
//                 + " experience! You now have " + experience + " out of "
//                 + level * 100 + " experience!" );
                output += "You gain " + ( level * 100 ) / 12
                    + " experience! You now have " + experience + " out of "
                    + level * 100 + " experience!";
                break;

            case 5:
                experience += 1;
//                 System.out.println( "You gain " + 1 + " experience! "
//                 + "You now have " + experience + " out of " + level * 100
//                 + " experience!" );
                output += "You gain " + 1 + " experience! " + "You now have "
                    + experience + " out of " + level * 100 + " experience!";
                break;
        }
      return output;
    }


    /**
     * 
     * Checks if the protagonist has leveled up
     * 
     * @return whether or not you leveled up
     */
    public boolean isLvlUp()
    {
        if ( experience >= ( level * 100 ) )
        {
            experience = experience - level * 100;
            return true;
        }
        return false;
    }


    /**
     * This method levels up your character.
     * 
     */
    public String lvlUp()
    {
        String output = "";
        output += "\n~<{{ YOU HAVE EARNED AN ARBITRARY INCREASE IN POWER!one!one!! }}>~";
        output += "\nYOU ARE NOW LEVEL " + ( level + 1 ) + "!!";
        level++;
        // Knight
        if ( playerClass == 1 )
        {
            myStats[1] += 2;
            // System.out.println( "Your Lifting/Strength increases by 2!" );
            output += "\nYour Lifting/Strength increases by 2!";
            myStats[2] += 2;
            // System.out.println( "Your Eyesight/Skill increases by 2!" );
            output += "\nYour Eyesight/Skill increases by 2!";
            myStats[4] += 3;
            // System.out.println( "Your Calluses/Defense increases by 3!" );
            output += "\nYour Calluses/Defense increases by 3!";
            myStats[5] += 3;
            // System.out.println( "Your Fatness/HP increases by 30!" );
            output += "\nYour Fatness/HP increases by 30!";
            if ( Math.random() > 0.5 )
            {
                myStats[6] += 1;
                // System.out.println( "RNGeesus blesses you with fortune!" );
                output += "\nRNGeesus blesses you with fortune!";
            }
        }
        // Rogue
        else if ( playerClass == 2 )
        {
            myStats[1] += 1;
            // System.out.println( "Your Lifting/Strength increases by 1!" );
            output += "\nYour Lifting/Strength increases by 1!";
            myStats[2] += 3;
            // System.out.println( "Your Eyesight/Skill increases by 3!" );
            output += "\nYour Eyesight/Skill increases by 3!";
            myStats[3] += 4;
            // System.out.println( "Your Ninja Factor/Agility increases by 4!"
            // );
            output += "\nYour Ninja Factor/Agility increases by 4!";
            myStats[5] += 2;
            // System.out.println( "Your Fatness/HP increases by 20!" );
            output += "\nYour Fatness/HP increases by 20!";
            if ( Math.random() > 0.3 )
            {
                myStats[6] += 1;
                // System.out.println( "RNGeesus blesses you with fortune!" );
                output += "\nRNGeesus blesses you with fortune!";
            }
        }
        // Berserker
        else if ( playerClass == 3 )
        {
            myStats[1] += 5;
            // System.out.println( "Your Lifting/Strength increases by 5!" );
            output += "\nYour Lifting/Strength increases by 5!";
            myStats[3] += 2;
            // System.out.println( "Your Ninja Factor/Agility increases by 2!"
            // );
            output += "\nYour Ninja Factor/Agility increases by 2!";
            myStats[5] += 3;
            // System.out.println( "Your Fatness/HP increases by 30!" );
            output += "\nYour Fatness/HP increases by 30!";
            if ( Math.random() > 0.5 )
            {
                myStats[6] += 1;
                // System.out.println( "RNGeesus blesses you with fortune!" );
                output += "\nRNGeesus blesses you with fortune!";
            }
        }
        setHP(getMaxHP());
        return output;
    }


    /**
     * Gets the array of stats
     * 
     * @return the array of stats
     */
    public int[] getStatArray()
    {
        return myStats;
    }


    /**
     * Determines if the current player is fighting or not
     * @return if fighting
     */
    public boolean isInFight()
    {
        return inFight;
    }


    /**
     * Sets the protagonist to be fighting or not
     * @param inFight the state of the protagonist
     */
    public void setInFight( boolean inFight )
    {
        this.inFight = inFight;
    }
}
