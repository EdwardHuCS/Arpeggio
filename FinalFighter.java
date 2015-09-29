import java.util.Random;
import java.util.Scanner;


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
public class FinalFighter
{
    private static double HP = masterProtagonist.p.getHP();

    private static double enemyHP = 100;

    public static double enemyMaxHP = 100;

    public static String enemyType = "grue";

    public static Weapon defaultWeapon = masterProtagonist.p.getMyWeapon();

    public static Armor defaultArmor = masterProtagonist.p.getMyArmor();

    public static Weapon defaultEnemyWeapon = new Weapon( "Friendship hug",
        201099 );

    public static Armor defaultEnemyArmor = new Armor( "Leathery hide", 200000 );

    public static boolean enfeeble = false;

    public static boolean ignite = false;

    private static boolean startingFight = false;

    public static Protagonist p;

    private static int strength = 0;

    private static int skill = 0;

    private static int agility = 0;

    private static int luck = 0;


    /**
     * Constructor for FinalFighter class.
     * 
     * @param opponentHP
     *            amount of HP your foe has.
     * @param enemyWeapon
     *            the kind of weapon your foe has.
     * @param enemyArmor
     *            the kind of armor your foe has.
     * @param isStartingFight
     *            Is this starting fight? (OBSOLETE)
     */
    public FinalFighter(
        double opponentHP,
        Weapon enemyWeapon,
        Armor enemyArmor,
        boolean isStartingFight )
    {
        enemyHP = opponentHP;
        enemyMaxHP = opponentHP;
        defaultEnemyArmor = enemyArmor;
        defaultEnemyWeapon = enemyWeapon;
        startingFight = isStartingFight;
    }


    /**
     * 
     * Instantiates an encounter between the protagonist and a monster.
     * 
     * @param enemytype
     *            name of enemy
     * @param enemyhp
     *            amount of hitpoints enemy has
     * @param enemyarmor
     *            type of armor the enemy wears
     * @param enemyweapon
     *            type of weapon the enemy wields
     * @return String describing the events that passed.
     */
    public static String encounter(
        String enemytype,
        double enemyhp,
        Armor enemyarmor,
        Weapon enemyweapon )
    {
        Console.four.setEnabled( false );
        String output = "";
        FinalFighter myFight = new FinalFighter( enemyHP,
            enemyweapon,
            enemyarmor,
            false );
        enemyType = enemytype;
        defaultEnemyWeapon = enemyweapon;
        defaultEnemyArmor = enemyarmor;

        double enemyMaxHP = enemyHP;
        // You start the encounter.
        output += "\nYou have encountered a " + enemytype + " (" + enemyhp
            + " Hit Points)";
        output += "\nPress Examine to examine enemy. "
            + "\nPress Run to flee (any time during the battle). "
            + "\nPress Fight to begin fight.";
        return output;

    }


    /**
     * 
     * Starts a battle between the current monster (delineated in the
     * FinalFighter constructor) and the protagonist. Iterates attackTurn()
     * until someone dies.
     * 
     * @return String describing the events that passed.
     */
    public static String startCombat()
    {
        String output = "";
        output += "\nFIGHT!\n";
        double enemyMaxHP = enemyHP;
        output += "\nYou ready your weapon.";
        output += "\n Press Continue to Fight";
        Console.four.setEnabled( true );
        return output;
    }


    /**
     * 
     * This method signifies the end of an encounter. It checks to see who died
     * (the protagonist or the enemy) and, if the protagonist won, it returns
     * the amount of experience the protagonist gains based on the amount of
     * overkill he/she did.
     * 
     * @return String describing the events that passed.
     */
    public static String endCombat()
    {
        String output = "";
        if ( HP <= 0 )
        {
            // Protagonist dies. Game over.
            return "You died. Game over.";
        }
        else if ( enemyHP <= 0 )
        {
            // Victory screens! They become more ludicrous the more overkill you
            // do.
            output += "You have won!";
   
            if ( enemyHP == 0 )
            {
                output += "\nYou have triumphed over the " + enemyType + ".";
                masterProtagonist.p.addExp( 35 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 10 )
            {
                output += "\nYou utterly rekt the " + enemyType + ".";
                masterProtagonist.p.addExp( 2 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 5 )
            {
                output += "\nYou annihiliate the " + enemyType + ".";
                masterProtagonist.p.addExp( 35 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 2 )
            {
                output += "\nYou vaporize the " + enemyType
                    + " into fine soot.";
                masterProtagonist.p.addExp( 35 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 )
            {
                output += "\nYou reduce the " + enemyType
                    + " to subatomic particles.";
                masterProtagonist.p.addExp( 45 );
            }
            else
            {
                output += "\nYou break the game, sending the " + enemyType
                    + " straight into the recycling bin.";
                p.addExp( 55 );
            }
        }
        return output;
    }


    /**
     * 
     * Now using 100% more Weapon and Armor class!
     * 
     * This method does one round of attacks; you attack the enemy, and the
     * enemy attacks you. It takes into account weapon and armor strengths, as
     * well as your stats.
     * 
     * @param masterProtagonist
     *            .p.getMyWeapon() your equipped weapon
     * @param defaultEnemyWeapon
     *            your enemy's equipped weapon
     * @param masterProtagonist
     *            .getMyArmor() your equipped armor
     * @param enemyArmor
     *            your enemy's equipped armor
     * @param enemyType
     *            the name of your fearsome foe
     */
    public static String attackTurn()
    {
        double hitChance = masterProtagonist.p.getMyWeapon()
            .getWeaponHitChance();
        double damage = masterProtagonist.p.getMyWeapon().getWeaponDamage();
        double eHitChance = defaultEnemyWeapon.getWeaponHitChance();
        double eDamage = defaultEnemyWeapon.getWeaponDamage();

        boolean blind = false;
        boolean exacerbate = false;
        boolean stun = false;
        boolean terrify = false;
        boolean nullify = false;

        Random hitChanceb = new Random();
        double hitOrNot = hitChanceb.nextInt( 100 ) + luck;
        Random eHitChanceb = new Random();
        int eHitOrNot = eHitChanceb.nextInt( 100 );

        String output = "";

        if ( HP <= 0 )
        {
            // Protagonist dies. Game over.
            masterProtagonist.p.setInFight( false );
            masterProtagonist.p.dead = true;
            return "You died. Game over.";
        }
        else if ( enemyHP <= 0 )
        {
            // Victory screens! They become more ludicrous the more overkill you
            // do.
            output += "\nYou have won!";
            if ( enemyHP == 0 )
            {
                output += "\nYou have triumphed over the " + enemyType + ".";
                output += "\n" + masterProtagonist.p.addExp( 2 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 10 )
            {
                output += "\nYou utterly rekt the " + enemyType + ".";
                output += "\n" + masterProtagonist.p.addExp( 2 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 5 )
            {
                output += "\nYou annihiliate the " + enemyType + ".";
                output += "\n" + masterProtagonist.p.addExp( 3 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 2 )
            {
                output += "\nYou vaporize the " + enemyType
                    + " into fine soot.";
                output += "\n" + masterProtagonist.p.addExp( 3 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 )
            {
                output += "\nYou reduce the " + enemyType
                    + " to subatomic particles.";
                output += "\n" + masterProtagonist.p.addExp( 4 );
            }
            else
            {
                output += "\nYou break the game, sending the " + enemyType
                    + " straight into the recycling bin.";
                masterProtagonist.p.addExp( 5 );
            }
   
            output+="\nYou move on";
            
            
            
            
            
            
            enemyHP = enemyMaxHP;
            masterProtagonist.p.setInFight( false );
            Console.one.setEnabled( false );
            Console.two.setEnabled( false );
            Console.three.setEnabled( false );
            Console.four.setEnabled( false );
            if (masterProtagonist.p.isLvlUp())
            {
                output += "\n" + masterProtagonist.p.lvlUp();
               System.out.println(masterProtagonist.p.level); 
            }
            return output;
        }
        // DIVINE CHECK
        if ( masterProtagonist.p.getMyWeapon().getWeaponElement() == 9 )
        {
            output += "\nYour weapon is blessed by the Gods! ";
            output += "\nIt can never miss and is unaffected by enemy armor!";
            if ( hitOrNot - skill / 2 < hitChance / 5 )
            {
                enemyHP -= ( damage + strength * 5 ) * 3;
                output += "\nYou use your "
                    + masterProtagonist.p.getMyWeapon().getWeaponName()
                    + " to deal " + damage * 3 + " damage to the " + enemyType
                    + "! CRITICAL HIT!!!";
            }
            else
            {
                enemyHP -= damage + strength * 5;
                output += "\nYou use your "
                    + masterProtagonist.p.getMyWeapon().getWeaponName()
                    + " to deal " + damage + " damage to the " + enemyType
                    + "!";
            }
            // ENEMY'S ATTACK TURN
            if ( eHitOrNot < eHitChance )
            {
                if ( eHitOrNot < eHitChance / 5 )
                {
                    if ( defaultEnemyWeapon.getWeaponElement() == masterProtagonist.getMyArmor()
                        .getArmorElement() )
                    {
                        HP -= masterProtagonist.getMyArmor()
                            .mitigate( eDamage * 1.5 );
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor()
                                .mitigate( eDamage * 1.5 )
                            + " damage to you, but it is reduced because your armor resists";
                        output += "\n the element of their attack! CRITICAL HIT!!!";
                    }
                    else
                    {
                        HP -= masterProtagonist.getMyArmor()
                            .mitigate( eDamage * 3 );
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor()
                                .mitigate( eDamage * 3 )
                            + " damage to you! CRITICAL HIT!!!";
                    }
                }
                else
                {
                    if ( defaultEnemyWeapon.getWeaponElement() == masterProtagonist.getMyArmor()
                        .getArmorElement() )
                    {
                        HP -= masterProtagonist.getMyArmor()
                            .mitigate( eDamage * .5 );
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor()
                                .mitigate( eDamage * .5 )
                            + " damage to you, but it is reduced because your armor resists";
                        output += "\n the element of their attack!";
                    }
                    else
                    {
                        HP -= masterProtagonist.getMyArmor().mitigate( eDamage );
                        output += "\nThe " + enemyType + " deals "
                            + masterProtagonist.getMyArmor().mitigate( eDamage )
                            + " damage to you!";
                    }
                }
            }
            return output;
        }
        // NORMAL BATTLE ROUND (NON-DIVINE)
        if ( hitOrNot - skill < hitChance )
        {
            // AIR ELEMENTAL CHECK
            if ( masterProtagonist.p.getMyWeapon().getWeaponElement() == 3 )
            {
                // AIR CRIT (50% chance)
                if ( hitOrNot - skill / 2 < hitChance / 2 )
                {
                    output += "\nThe air element of your weapon grants you increased critical hit chance!";
                    if ( masterProtagonist.p.getMyWeapon().getWeaponElement() == defaultEnemyArmor.getArmorElement() )
                    {
                        enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 );
                        output += "\nYou use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 )
                            + " damage to the "
                            + enemyType
                            + ", but their armor resists the element of your weapon! CRITICAL HIT!!!";
                    }
                    else
                    {
                        enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 3 );

                        output += "\nYou use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 3 )
                            + " damage to the " + enemyType
                            + "! CRITICAL HIT!!!";
                    }
                }
                else
                {
                    output += "\nYour weapon has an air element! It only deals half damage on non-critical hits!";
                    if ( masterProtagonist.p.getMyWeapon().getWeaponElement() == defaultEnemyArmor.getArmorElement() )
                    {
                        enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * .25 );
                        output += "\nYou use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * .25 )
                            + " damage to the "
                            + enemyType
                            + ", but their armor resists the element of your weapon!";
                    }
                    else
                    {
                        enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * .5 );
                        output += "\nYou use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * .5 )
                            + " damage to the " + enemyType + "!";
                    }
                }
            }
            // NON-AIR CRIT (20% chance)
            else if ( hitOrNot - skill / 2 < hitChance / 5 )
            {
                if ( masterProtagonist.p.getMyWeapon().getWeaponElement() == defaultEnemyArmor.getArmorElement() )
                {
                    enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 );
                    output += "\nYou use your "
                        + masterProtagonist.p.getMyWeapon().getWeaponName()
                        + " to deal "
                        + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 )
                        + " damage to the "
                        + enemyType
                        + ", but their armor resists the element of your weapon! CRITICAL HIT!!!";
                }
                else
                {
                    enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 3 );

                    output += "\nYou use your "
                        + masterProtagonist.p.getMyWeapon().getWeaponName()
                        + " to deal "
                        + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * 3 )
                        + " damage to the " + enemyType + "! CRITICAL HIT!!!";
                }
                /*
                 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                 */
                // WEAPON ELEMENTAL CRITICAL EFFECTS
                // DARK
                if ( defaultWeapon.getWeaponElement() == 2 )
                {
                    output += "\nYour enemy is blinded by your "
                        + defaultWeapon.getWeaponName()
                        + "'s dark element! They are blinded!";
                    blind = true;
                }
                // EARTH
                else if ( defaultWeapon.getWeaponElement() == 5 )
                {
                    HP += (int)defaultWeapon.getWeaponDamage() / 3;
                    output += "\nYour " + defaultWeapon.getWeaponName()
                        + " channels the power of the Earth, healing you for "
                        + (int)defaultWeapon.getWeaponDamage() / 3
                        + " hit points! (" + HP + ")";
                }
                // PSYCHO
                else if ( defaultWeapon.getWeaponElement() == 8 )
                {
                    output += "\nYour enemy is terrified by your "
                        + defaultWeapon.getWeaponName() + "!";
                    terrify = true;
                }
            }
            else
            {
                if ( masterProtagonist.p.getMyWeapon().getWeaponElement() == defaultEnemyArmor.getArmorElement() )
                {
                    enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * .5 );
                    output += "\nYou use your "
                        + defaultWeapon.getWeaponName()
                        + " to deal "
                        + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) * .5 )
                        + " damage to the "
                        + enemyType
                        + ", but their armor resists the element of your weapon!";
                }
                else
                {
                    enemyHP -= defaultEnemyArmor.mitigate( ( damage + strength * 5 ) );
                    output += "\nYou use your "
                        + defaultWeapon.getWeaponName()
                        + " to deal "
                        + defaultEnemyArmor.mitigate( ( damage + strength * 5 ) )
                        + " damage to the " + enemyType + "!";
                }
            }
            /*
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             */
            // OTHER WEAPON ELEMENTAL EFFECTS
            // WATER
            if ( defaultWeapon.getWeaponElement() == 4 && !enfeeble )
            {
                output += "\nYour enemy is numbened by your "
                    + defaultWeapon.getWeaponName()
                    + "'s water element! They deal 10% less damage, and cannot crit!";
                enfeeble = true;
            }
            // FIRE
            if ( defaultWeapon.getWeaponElement() == 6 && !ignite )
            {
                output += "\nYou set your enemy ablaze!";
                ignite = true;
            }
            if ( ignite )
            {
                if ( defaultEnemyArmor.getArmorElement() == 6 )
                {
                    output += "\nYour "
                        + defaultWeapon.getWeaponName()
                        + " would have done extra burn damage if their armor didn't resist fire!";
                }
                else
                {
                    output += "\nYour enemy takes "
                        + defaultEnemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 )
                        + " fire damage from your "
                        + defaultWeapon.getWeaponName()
                        + "'s fire element! BURN, BABY, BURN!!";
                    enemyHP -= defaultEnemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 );
                }
            }
            // // EXPLOSIVE
            if ( defaultWeapon.getWeaponElement() == 7
                && hitChanceb.nextInt( 100 ) + luck <= 25 )
            {
                output += "\nBOOM!";
                output += "\nYour enemy is stunned from your "
                    + defaultWeapon.getWeaponName() + "'s explosion!";
                stun = true;
            }
        }
        else
        {
            output += "\nYour " + defaultWeapon.getWeaponName() + " missed!!";
            // FIRE
            if ( ignite )
            {
                if ( defaultEnemyArmor.getArmorElement() == 6 )
                {
                    output += "\nYour "
                        + defaultWeapon.getWeaponName()
                        + " would have done extra burn damage if their armor didn't resist fire!";
                }
                else
                {
                    output += "\nYour enemy takes "
                        + defaultEnemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 )
                        + " fire damage from your "
                        + defaultWeapon.getWeaponName() + "'s fire element!";
                    enemyHP -= defaultEnemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 );
                }
            }
        }
        /*
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * ~~~~~~~~~~
         */
        // ENEMY'S ATTACK

        // ELEMENTAL CHECKS

        if ( stun )
        {
            output += "\nYour enemy is dazed!";
        }
        else if ( terrify )
        {
            output += "\nThe " + enemyType + " shudders in fear!";
        }
        else
        {
            if ( blind )
            {
                eHitOrNot /= 2;
            }
            if ( eHitOrNot + agility < eHitChance )
            {
                // WATER NUMBING EFFECT
                if ( enfeeble )
                {
                    if ( defaultEnemyWeapon.getWeaponElement() == masterProtagonist.getMyArmor()
                        .getArmorElement() )
                    {
                        HP -= masterProtagonist.getMyArmor()
                            .mitigate( eDamage * .5 ) * 0.9;
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor()
                                .mitigate( eDamage * .5 )
                            * 0.9
                            + " damage to you, but it is reduced because your armor resists";
                        output += "\nthe element of their attack and because they are numbened from your water attack!";
                    }
                    else
                    {
                        HP -= masterProtagonist.getMyArmor().mitigate( eDamage ) * 0.9;
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor().mitigate( eDamage )
                            * 0.9
                            + " damage to you, but it is reduced because they are numbened from your water attack!";
                    }
                }
                else if ( eHitOrNot + agility < eHitChance / 5 )
                {
                    if ( defaultEnemyWeapon.getWeaponElement() == masterProtagonist.getMyArmor()
                        .getArmorElement() )
                    {
                        HP -= masterProtagonist.getMyArmor()
                            .mitigate( eDamage * 1.5 );
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor()
                                .mitigate( eDamage * 1.5 )
                            + " damage to you, but it is reduced because your armor resists";
                        output += "\nthe element of their attack! CRITICAL HIT!!!";
                    }
                    else
                    {
                        HP -= masterProtagonist.getMyArmor()
                            .mitigate( eDamage * 3 );
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor()
                                .mitigate( eDamage * 3 )
                            + " damage to you! CRITICAL HIT!!!";
                    }
                }
                else if ( eHitOrNot + agility < eHitChance )
                {
                    if ( defaultEnemyWeapon.getWeaponElement() == masterProtagonist.getMyArmor()
                        .getArmorElement() )
                    {
                        HP -= masterProtagonist.getMyArmor()
                            .mitigate( eDamage * .5 );
                        output += "\nThe "
                            + enemyType
                            + " deals "
                            + masterProtagonist.getMyArmor()
                                .mitigate( eDamage * .5 )
                            + " damage to you, but it is reduced because your armor resists";
                        output += "\n the element of their attack!";
                    }
                    else
                    {
                        HP -= masterProtagonist.getMyArmor().mitigate( eDamage );
                        output += "\nThe " + enemyType + " deals "
                            + masterProtagonist.getMyArmor().mitigate( eDamage )
                            + " damage to you!";
                    }
                }
            }
            else
            {
                output += "\nThe " + enemyType + " missed!!!";
            }
            masterProtagonist.p.setHP( HP );
            output += "\nYou have " + HP + " Hit Points!";
            output += "\nThe " + enemyType + " has " + enemyHP + " Hit Points!";
        }
        output += "\nPress Continue!";
        return output;
    }


    /**
     * 
     * This returns the description of your fearsome foe
     * 
     * @return a long string with all your current enemy's gear.
     */
    public static String examine()
    {
        return "You are facing a fearsome " + enemyType + ". \nIt uses a "
            + defaultEnemyWeapon.getWeaponName()
            + " for its weapon, which deals "
            + defaultEnemyWeapon.getWeaponDamage() + " and has a "
            + defaultEnemyWeapon.getWeaponHitChance()
            + "% chance to hit.\nThe " + enemyType + " is protected by its "
            + defaultEnemyArmor.getArmorName() + ", which has "
            + defaultEnemyArmor.getPercBlock() + "% damage block and "
            + defaultEnemyArmor.getStaticBlock() + " static damage reduction.";
    }


    /**
     * 
     * You run from combat.
     * 
     * @return outputs a string which shows what you just did
     */
    public static String run()
    {
        return "You run away like a sissy coward.";
    }


    /**
     * 
     * Checks the gear you currently have equipped.
     * 
     * @return the gear you have equipped.
     */
    public static String checkInv()
    {
        return "NOT IMPLEMENTED YET";
    }


    /**
     * For testing purposes only.
     * @return the hp during a fight
     */
    protected double getHP()
    {
        return HP;
    }


    /**
     * For testing purposes only.
     * @param hp to be set
     */
    protected void setHP( double hp )
    {
        HP = hp;
    }

}
