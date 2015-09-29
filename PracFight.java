import java.util.*;


public class PracFight
{
    private static double HP = 0;

    private static double enemyHP = 0;

    public static String enemyType = "";

    public static Weapon defaultWeapon = new Weapon( "Mega lazor", 902599 );

    public static Armor defaultArmor = new Armor( "Rusty Chainmail", 100510 );

    public static int gold = 100;

    public static Weapon defaultEnemyWeapon = new Weapon( "Friendship hug",
        201099 );

    public static Armor defaultEnemyArmor = new Armor( "Leathery hide", 201010 );

    public static boolean enfeeble = false;

    public static boolean ignite = false;

    private static boolean startingFight = false;

    private static int strength = 0;

    private static int skill = 0;

    // private static int speed = 0;

    private static int agility = 0;

    private static int luck = 0;


    public PracFight(
        double yourHP,
        double opponentHP,
        int money,
        Weapon yourWeapon,
        Weapon enemyWeapon,
        Armor yourArmor,
        Armor enemysArmor,
        boolean isStartingFight )
    {
        HP = yourHP;
        enemyHP = opponentHP;
        defaultWeapon = yourWeapon;
        defaultArmor = yourArmor;
        gold = money;
        defaultEnemyArmor = enemysArmor;
        startingFight = isStartingFight;
    }


    public PracFight()
    {
        HP = 100;
        enemyHP = 100;
        enemyType = "grue";
    }


    public static double tutorialFIIIIIGHT(
        Protagonist p,
        String enemytype,
        double enemyhp,
        Armor enemyarmor,
        Weapon enemyweapon )
    {
        PracFight myFight = new PracFight( p.getHP(),
            enemyhp,
            gold,
            p.getMyWeapon(),
            enemyweapon,
            p.getMyArmor(),
            enemyarmor,
            true );
        // Get stats from protagonist
        strength = p.getStr();
        skill = p.getSkill();
        // speed = p.getSpd();
        agility = p.getAgi();
        luck = p.getLuck();

        // Get the enemy's weapons, name, and armor.
        enemyType = enemytype;
        defaultEnemyWeapon = enemyweapon;
        defaultEnemyArmor = enemyarmor;

        // You start the encounter.
        System.out.println( "You have encountered a " + enemytype + " ("
            + enemyhp + " Hit Points)" );
        System.out.println( "Press '1' to examine enemy. "
            + "Press '2' to examine inventory. "
            + "Press '3' to run (any time during the battle). "
            + "Press ENTER to fight." );
        Scanner scan = new Scanner( System.in );
        String input = scan.nextLine();
        if ( input.equals( "1" ) )
        {
            examine( enemytype, enemyweapon, enemyarmor, p );
        }
        else if ( input.equals( "2" ) )
        {
            System.out.println( "You don't know what that is." );
            startCombat( p );
            return HP;
        }
        else if ( input.equals( "3" ) )

        {
            if ( startingFight == true )
            {
                System.out.println( "Bruh. Why are you running from the tutorial? You are punished by having to fight (again). Now." );
                System.out.println( "You ready your "
                    + p.getMyWeapon().getWeaponName() );
                startCombat( p );
                return HP;
            }
            else
            {
                System.out.println( "You run away like a sissy coward." );
                return HP;
            }
        }
        else
        {
            System.out.println( "You ready your "
                + p.getMyWeapon().getWeaponName() + "." );
            startCombat( p );
            return HP;
        }
        return HP;

    }


    public static double FIIIIIGHT(
        Protagonist p,
        String enemytype,
        double enemyhp,
        Armor enemyarmor,
        Weapon enemyweapon )
    {
        PracFight myFight = new PracFight( p.getHP(),
            enemyhp,
            gold,
            p.getMyWeapon(),
            enemyweapon,
            p.getMyArmor(),
            enemyarmor,
            false );
        enemyType = enemytype;
        defaultEnemyWeapon = enemyweapon;
        defaultEnemyArmor = enemyarmor;

        // You start the encounter.
        System.out.println( "You have encountered a " + enemytype + " ("
            + enemyhp + " Hit Points)" );
        System.out.println( "Press '1' to examine enemy. "
            + "Press '2' to examine inventory. "
            + "Press '3' to run (any time during the battle). "
            + "Press ENTER to fight." );
        Scanner scan = new Scanner( System.in );
        String input = scan.nextLine();
        if ( input.equals( "1" ) )
        {
            examine( enemytype, enemyweapon, enemyarmor, p );
        }
        else if ( input.equals( "2" ) )
        {
            System.out.println( "LOL not implemented yet" );
            startCombat( p );
            return HP;
        }
        else if ( input.equals( "3" ) )

        {
            if ( startingFight == true )
            {
                System.out.println( "Bruh. Why are you running from the tutorial? You are punished by having to fight (again). Now." );
                System.out.println( "You ready your "
                    + p.getMyWeapon().getWeaponName() + "." );
                startCombat( p );
            }
            else
            {
                System.out.println( "You run away like a sissy coward." );
                return HP;
            }
        }
        else
        {
            System.out.println( "You ready your "
                + p.getMyWeapon().getWeaponName() + "." );
            startCombat( p );
            return HP;
        }
        return HP;

    }


    private static void startCombat( Protagonist p )
    {
        Scanner scan = new Scanner( System.in );
        System.out.println( "FIGHT!" );
        System.out.println();
        double enemyMaxHP = enemyHP;
        while ( HP > 0 && enemyHP > 0 )
        {
            // Nobody has died.
            attackTurn( defaultWeapon,
                defaultEnemyWeapon,
                defaultArmor,
                defaultEnemyArmor,
                enemyType );
            if ( HP > 0 && enemyHP > 0 )
            {
                System.out.println( "The next bout begins... (press Enter, press 3 to run)" );
                scan.nextLine();
            }
            else
            {
                continue;
            }
        }
        if ( HP <= 0 )
        {
            // Protagonist dies. Game over.
            System.out.println( "You died. Game over." );
        }
        else if ( enemyHP <= 0 )
        {
            // Victory screens! They become more ludicrous the more overkill you
            // do.
            System.out.println( "You have won! (press Enter)" );
            new Scanner( System.in ).nextLine();
            if ( enemyHP == 0 )
            {
                System.out.println( "You have triumphed over the " + enemyType
                    + "." );
                p.addExp( 2 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 10 )
            {
                System.out.println( "You utterly rekt the " + enemyType + "." );
                p.addExp( 2 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 5 )
            {
                System.out.println( "You annihiliate the " + enemyType + "." );
                p.addExp( 3 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 / 2 )
            {
                System.out.println( "You vaporize the " + enemyType
                    + " into fine soot." );
                p.addExp( 3 );
            }
            else if ( enemyHP >= enemyMaxHP * -1 )
            {
                System.out.println( "You reduce the " + enemyType
                    + " to subatomic particles." );
                p.addExp( 4 );
            }
            else
            {
                System.out.println( "You break the game, sending the "
                    + enemyType + " straight into the recycling bin." );
                p.addExp( 5 );
            }
        }
    }


    /**
     * 
     * Now using 100% more Weapon and Armor class!
     * 
     * @param myWeap
     *            your equipped weapon
     * @param enemyWeap
     *            your enemy's equipped weapon
     * @param myArmor
     *            your equipped armor
     * @param enemyArmor
     *            your enemy's equipped armor
     * @param enemyType
     *            the name of your fearsome foe
     */
    public static void attackTurn(
        Weapon myWeap,
        Weapon enemyWeap,
        Armor myArmor,
        Armor enemyArmor,
        String enemyType )
    {
        double hitChance = myWeap.getWeaponHitChance();
        double damage = myWeap.getWeaponDamage();
        double eHitChance = enemyWeap.getWeaponHitChance();
        double eDamage = enemyWeap.getWeaponDamage();

        boolean blind = false;
        boolean exacerbate = false;
        boolean stun = false;
        boolean terrify = false;
        boolean nullify = false;

        Random hitChanceb = new Random();
        double hitOrNot = hitChanceb.nextInt( 100 ) + luck;
        Random eHitChanceb = new Random();
        int eHitOrNot = eHitChanceb.nextInt( 100 );

        // DIVINE CHECK
        if ( myWeap.getWeaponElement() == 9 )
        {
            System.out.println( "Your weapon is blessed by the Gods! " );
            System.out.println( "It can never miss and is unaffected by enemy armor!" );
            if ( hitOrNot - skill / 2 < hitChance / 5 )
            {
                enemyHP -= ( damage + strength * 5 ) * 3;
                System.out.println( "You use your " + myWeap.getWeaponName()
                    + " to deal " + damage * 3 + " damage to the " + enemyType
                    + "! CRITICAL HIT!!!" );
            }
            else
            {
                enemyHP -= damage + strength * 5;
                System.out.println( "You use your " + myWeap.getWeaponName()
                    + " to deal " + damage + " damage to the " + enemyType
                    + "!" );
            }

            // ENEMY'S ATTACK TURN
            if ( eHitOrNot < eHitChance )
            {
                if ( eHitOrNot < eHitChance / 5 )
                {
                    if ( enemyWeap.getWeaponElement() == myArmor.getArmorElement() )
                    {
                        HP -= myArmor.mitigate( eDamage * 1.5 );
                        System.out.println( "The "
                            + enemyType
                            + " deals "
                            + myArmor.mitigate( eDamage * 1.5 )
                            + " damage to you, but it is reduced because your armor resists" );
                        System.out.println( " the element of their attack! CRITICAL HIT!!!" );
                    }
                    else
                    {
                        HP -= myArmor.mitigate( eDamage * 3 );
                        System.out.println( "The " + enemyType + " deals "
                            + myArmor.mitigate( eDamage * 3 )
                            + " damage to you! CRITICAL HIT!!!" );
                    }
                }
                else
                {
                    if ( enemyWeap.getWeaponElement() == myArmor.getArmorElement() )
                    {
                        HP -= myArmor.mitigate( eDamage * .5 );
                        System.out.println( "The "
                            + enemyType
                            + " deals "
                            + myArmor.mitigate( eDamage * .5 )
                            + " damage to you, but it is reduced because your armor resists" );
                        System.out.println( " the element of their attack!" );
                    }
                    else
                    {
                        HP -= myArmor.mitigate( eDamage );
                        System.out.println( "The " + enemyType + " deals "
                            + myArmor.mitigate( eDamage ) + " damage to you!" );
                    }
                }
            }
            return;
        }

        // NORMAL BATTLE ROUND (NON-DIVINE)
        if ( hitOrNot - skill < hitChance )
        {
            // AIR ELEMENTAL CHECK
            if ( myWeap.getWeaponElement() == 3 )
            {
                // AIR CRIT (50% chance)
                if ( hitOrNot - skill / 2 < hitChance / 2 )
                {
                    System.out.println( "The air element of your weapon grants you increased critical hit chance!" );
                    if ( myWeap.getWeaponElement() == enemyArmor.getArmorElement() )
                    {
                        enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 );
                        System.out.println( "You use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + enemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 )
                            + " damage to the "
                            + enemyType
                            + ", but their armor resists the element of your weapon! CRITICAL HIT!!!" );
                    }
                    else
                    {
                        enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) * 3 );

                        System.out.println( "You use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + enemyArmor.mitigate( ( damage + strength * 5 ) * 3 )
                            + " damage to the " + enemyType
                            + "! CRITICAL HIT!!!" );
                    }
                }
                else
                {
                    System.out.println( "Your weapon has an air element! It only deals half damage on non-critical hits!" );
                    if ( myWeap.getWeaponElement() == enemyArmor.getArmorElement() )
                    {
                        enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) * .25 );
                        System.out.println( "You use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + enemyArmor.mitigate( ( damage + strength * 5 ) * .25 )
                            + " damage to the "
                            + enemyType
                            + ", but their armor resists the element of your weapon!" );
                    }
                    else
                    {
                        enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) * .5 );
                        System.out.println( "You use your "
                            + defaultWeapon.getWeaponName()
                            + " to deal "
                            + enemyArmor.mitigate( ( damage + strength * 5 ) * .5 )
                            + " damage to the " + enemyType + "!" );
                    }
                }
            }

            // NON-AIR CRIT (20% chance)
            else if ( hitOrNot - skill / 2 < hitChance / 5 )
            {
                if ( myWeap.getWeaponElement() == enemyArmor.getArmorElement() )
                {
                    enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 );
                    System.out.println( "You use your "
                        + myWeap.getWeaponName()
                        + " to deal "
                        + enemyArmor.mitigate( ( damage + strength * 5 ) * 1.5 )
                        + " damage to the "
                        + enemyType
                        + ", but their armor resists the element of your weapon! CRITICAL HIT!!!" );
                }
                else
                {
                    enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) * 3 );

                    System.out.println( "You use your "
                        + myWeap.getWeaponName() + " to deal "
                        + enemyArmor.mitigate( ( damage + strength * 5 ) * 3 )
                        + " damage to the " + enemyType + "! CRITICAL HIT!!!" );
                }
                /*
                 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                 */
                // WEAPON ELEMENTAL CRITICAL EFFECTS
                // DARK
                if ( defaultWeapon.getWeaponElement() == 2 )
                {
                    System.out.println( "Your enemy is blinded by your "
                        + defaultWeapon.getWeaponName()
                        + "'s dark element! They are blinded!" );
                    blind = true;
                }
                // EARTH
                else if ( defaultWeapon.getWeaponElement() == 5 )
                {
                    HP += (int)defaultWeapon.getWeaponDamage() / 3;
                    System.out.println( "Your " + defaultWeapon.getWeaponName()
                        + " channels the power of the Earth, healing you for "
                        + (int)defaultWeapon.getWeaponDamage() / 3
                        + " hit points! (" + HP + ")" );
                }
                // PSYCHO
                else if ( defaultWeapon.getWeaponElement() == 8 )
                {
                    System.out.println( "Your enemy is terrified by your "
                        + defaultWeapon.getWeaponName() + "!" );
                    terrify = true;
                }
            }
            else
            {
                if ( myWeap.getWeaponElement() == enemyArmor.getArmorElement() )
                {
                    enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) * .5 );
                    System.out.println( "You use your "
                        + defaultWeapon.getWeaponName()
                        + " to deal "
                        + enemyArmor.mitigate( ( damage + strength * 5 ) * .5 )
                        + " damage to the "
                        + enemyType
                        + ", but their armor resists the element of your weapon!" );
                }
                else
                {
                    enemyHP -= enemyArmor.mitigate( ( damage + strength * 5 ) );
                    System.out.println( "You use your "
                        + defaultWeapon.getWeaponName() + " to deal "
                        + enemyArmor.mitigate( ( damage + strength * 5 ) )
                        + " damage to the " + enemyType + "!" );
                }
            }

            /*
             * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             */
            // OTHER WEAPON ELEMENTAL EFFECTS
            // WATER
            if ( defaultWeapon.getWeaponElement() == 4 && !enfeeble )
            {
                System.out.println( "Your enemy is numbened by your "
                    + defaultWeapon.getWeaponName()
                    + "'s water element! They deal 10% less damage, and cannot crit!" );
                enfeeble = true;
            }
            // FIRE
            if ( defaultWeapon.getWeaponElement() == 6 && !ignite )
            {
                System.out.println( "You set your enemy ablaze!" );
                ignite = true;
            }
            if ( ignite )
            {
                if ( enemyArmor.getArmorElement() == 6 )
                {
                    System.out.println( "Your "
                        + defaultWeapon.getWeaponName()
                        + " would have done extra burn damage if their armor didn't resist fire!" );
                }
                else
                {
                    System.out.println( "Your enemy takes "
                        + enemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 )
                        + " fire damage from your "
                        + defaultWeapon.getWeaponName()
                        + "'s fire element! BURN, BABY, BURN!!" );
                    enemyHP -= enemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 );
                }
            }

            // // EXPLOSIVE
            if ( defaultWeapon.getWeaponElement() == 7
                && hitChanceb.nextInt( 100 ) + luck <= 25 )
            {
                System.out.println( "BOOM!" );
                System.out.println( "Your enemy is stunned from your "
                    + defaultWeapon.getWeaponName() + "'s explosion!" );
                stun = true;
            }
        }

        else
        {
            System.out.println( "Your " + defaultWeapon.getWeaponName()
                + " missed!!" );

            // FIRE
            if ( ignite )
            {
                if ( enemyArmor.getArmorElement() == 6 )
                {
                    System.out.println( "Your "
                        + defaultWeapon.getWeaponName()
                        + " would have done extra burn damage if their armor didn't resist fire!" );
                }
                else
                {
                    System.out.println( "Your enemy takes "
                        + enemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 )
                        + " fire damage from your "
                        + defaultWeapon.getWeaponName() + "'s fire element!" );
                    enemyHP -= enemyArmor.mitigate( defaultWeapon.getWeaponDamage() / 3 );
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
            System.out.println( "Your enemy is dazed!" );
        }
        else if ( terrify )
        {
            System.out.println( "The " + enemyType + " shudders in fear!" );
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
                    if ( enemyWeap.getWeaponElement() == myArmor.getArmorElement() )
                    {
                        HP -= myArmor.mitigate( eDamage * .5 ) * 0.9;
                        System.out.println( "The "
                            + enemyType
                            + " deals "
                            + myArmor.mitigate( eDamage * .5 )
                            * 0.9
                            + " damage to you, but it is reduced because your armor resists" );
                        System.out.println( "the element of their attack and because they are numbened from your water attack!" );
                    }
                    else
                    {
                        HP -= myArmor.mitigate( eDamage ) * 0.9;
                        System.out.println( "The "
                            + enemyType
                            + " deals "
                            + myArmor.mitigate( eDamage )
                            * 0.9
                            + " damage to you, but it is reduced because they are numbened from your water attack!" );
                    }
                }
                else if ( eHitOrNot + agility < eHitChance / 5 )
                {
                    if ( enemyWeap.getWeaponElement() == myArmor.getArmorElement() )
                    {
                        HP -= myArmor.mitigate( eDamage * 1.5 );
                        System.out.println( "The "
                            + enemyType
                            + " deals "
                            + myArmor.mitigate( eDamage * 1.5 )
                            + " damage to you, but it is reduced because your armor resists");
                            System.out.println("the element of their attack! CRITICAL HIT!!!" );
                    }
                    else
                    {
                        HP -= myArmor.mitigate( eDamage * 3 );
                        System.out.println( "The " + enemyType + " deals "
                            + myArmor.mitigate( eDamage * 3 )
                            + " damage to you! CRITICAL HIT!!!" );
                    }
                }
                else if ( eHitOrNot + agility < eHitChance )
                {
                    if ( enemyWeap.getWeaponElement() == myArmor.getArmorElement() )
                    {
                        HP -= myArmor.mitigate( eDamage * .5 );
                        System.out.println( "The "
                            + enemyType
                            + " deals "
                            + myArmor.mitigate( eDamage * .5 )
                            + " damage to you, but it is reduced because your armor resists");
                            System.out.println(" the element of their attack!" );
                    }
                    else
                    {
                        HP -= myArmor.mitigate( eDamage );
                        System.out.println( "The " + enemyType + " deals "
                            + myArmor.mitigate( eDamage ) + " damage to you!" );
                    }
                }
            }

            else
            {
                System.out.println( "The " + enemyType + " missed!!!" );
            }
            System.out.println( "You have " + HP + " Hit Points!" );
            System.out.println( "The " + enemyType + " has " + enemyHP
                + " Hit Points!" );
        }
    }


    @SuppressWarnings("resource")
    public static void examine(
        String enemyName,
        Weapon enemyWeapon,
        Armor enemyArmor,
        Protagonist p )
    {
        System.out.println( "You are facing a fearsome " + enemyName );
        System.out.println( "It uses a " + enemyWeapon.getWeaponName()
            + " for its weapon, which deals " + enemyWeapon.getWeaponDamage()
            + " and has a " + enemyWeapon.getWeaponHitChance()
            + "% chance to hit." );
        System.out.println( "The " + enemyName + " is protected by its "
            + enemyArmor.getArmorName() + ", which has "
            + enemyArmor.getPercBlock() + "% damage block and "
            + enemyArmor.getStaticBlock() + " static damage reduction." );
        System.out.println( "(Press Enter to Continue)" );
        new Scanner( System.in ).nextLine();
        startCombat( p );
    }

}
