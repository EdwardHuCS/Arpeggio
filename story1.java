
import java.io.*;
import java.util.*;


/**
 * This class represents the first part of the story, including basic fighting
 * and navigation tutorials
 * 
 *
 * @author Ziou Dong, David Yang, Edward Hu
 * @version May 8, 2015
 * @author Period: 6
 * @author Assignment: somegame
 *
 * @author Sources: StackOverflow
 */
public class story1
{

    private int weaknessStickFactor;

    private double myHP;

    private String myName;

    private Weapon myCurrentWeapon;

    private Armor myCurrentArmor;

    /**
     * 1 is Knight 2 is Rogue 3 is Berserker
     */
    private int playerClass = 0;

    /**
     * To detect system inputs
     */
    private Scanner scan;


    public story1()
    {

        weaknessStickFactor = (int)Math.random() * 20;
        scan = new Scanner( System.in );
    }


    /**
     * Advances the tutorial in this class.
     * 
     * 
     */
    public void advanceTutorial( ) 
    {

    	masterProtagonist.p.setMyWeapon( new Weapon( "Green Gun", 102550 ) );
    	masterProtagonist.p.setMyArmor( new Armor( "Pecs", 100000 ) );
        myCurrentArmor = new Armor( "Pecs", 100000 );
        myCurrentWeapon = new Weapon( "Green Gun", 102550 );
        myName = masterProtagonist.p.getMyName();
        playerClass = masterProtagonist.p.getPlayerClass();
        System.out.println( "Oh no help!" );
        System.out.println( "\nLightning flashes across the pitch black sky, briefly illuminating a stereotypically ominous-looking castle." );
        System.out.println( "\nAs you draw your gaze to the topmost tower, you see a beautiful maiden princess, who cries:" );
        System.out.println( "\"Oh no, the evil antagonist has held me hostage! I need a strong, brave, masculine hero" );
        System.out.println( "(conveniently the fantasy projection of the primary gaming demographic)" );
        System.out.println( "to save me!\"" );
        ENTERcontinue();
        printTxtFile( "castle1.txt" );
        System.out.println( "\n\nWow." );
        ENTERcontinue();
        System.out.println( "As you make your way to the princess, a rat monster jumps out in front of you." );
        System.out.println( "\"Stop, in the name of plot progression!\"" );

        ENTERcontinue();
        System.out.println( "You scratch your head." );
        System.out.println( "Wouldn't it make sense for Dr. Evil to send his \nmost competent acolyte to stop you?" );
        System.out.println( "Oh right. This is the tutorial." );
        printTxtFile( "rat1.txt" );
        ENTERcontinue();
        masterProtagonist.p.setHP(PracFight.tutorialFIIIIIGHT( masterProtagonist.p,
            "Rat Monster",
            100,
            new Armor( "Pecs", 100000 ),
            new Weapon( "Little Timmy's Flimsy Rusty Stick", 500325 ) )); 
        System.out.println( "You have " + (masterProtagonist.p.getHP()) + " Hit Points remaining." );
        ENTERcontinue();
        System.out.println( "You can feel a dark, insidious presence. It whispers its demonic words into your ears. " );
        scan.nextLine();
        System.out.println( "\"Haa haa haa... very good, pathetic generic hero man. Let us see how you fare against one of my top lieutenants!\"" );
        ENTERcontinue();
        System.out.println( "\"What?!\" You protest. \"I’ve just started this game! How am I supposed to--\"" );
        ENTERcontinue();
        masterProtagonist.p.setHP(PracFight.tutorialFIIIIIGHT( masterProtagonist.p,
            "Dark Zombie Elder Dragon Guardian of the “Gate”",
            400,
            new Armor( "Shiny Scales", 101010 ),
            new Weapon( "Really Big Claws", 105090 ) )); 
        ENTERcontinue();
        System.out.println( "\"Woe is I!\" you gasp. \"I lost the scripted battle! Now they're going to take all my gear and reduce me to level one! DARN YOU GENERIC DEVIL MAAAAANNNN!!!!\"" );
        masterProtagonist.p.setHP(Game.MAXHP);
        ENTERcontinue();
        System.out.println( "Amazingly, a golden light shines over you. You feel empowered, and the whispers of the Gods and your ancestors are in your head. They whisper an arcane phrase: \"You are the chosen one.\"" );
        ENTERcontinue();
        masterProtagonist.p.setMyWeapon( Game.weapList.get( "Colonel Sander’s AH-64D Apache Longbow attack helicopter, which has machine guns AND missiles" ) );
        myCurrentWeapon = masterProtagonist.p.getMyWeapon();
        System.out.println( myCurrentWeapon.getWeaponName() + " GET!" );
        ENTERcontinue();
        masterProtagonist.p.setHP(PracFight.tutorialFIIIIIGHT( masterProtagonist.p,
            "Dark Zombie Elder Dragon Guardian of the “Gate”",
            400,
            new Armor( "Shiny Scales", 106010 ),
            new Weapon( "Really Big Claws", 105090 ) ));
        ENTERcontinue();
        System.out.println( "\"NO!\" the voice screams. \"My Dark Zombie Elder Dragon of the \"Gate\"! Those things are expensive, you know!\"" );
        ENTERcontinue();
        System.out.println( "As you step over the smouldered body of your foe, you see the beautiful princess beaming at you through her window. \n\"Oh valiant hero, you have won my admiration and love through your singular act of heroism!\"" );
        ENTERcontinue();
        System.out.println( "\"This seems a bit too easy if you ask me, but I'm not a complainer\" you say as you make your way to her." );
        System.out.println( "\nYou reach her, and fall to your knees to kiss her hand, ready for you inevitable marriage." );
        ENTERcontinue();
        System.out.println( "Your lips feel something hard and scaly instead of the princess's supple skin. \nYou open your eyes, and recoil in horror!" );
        ENTERcontinue();
        printTxtFile( "devil1.txt" );
        System.out.println( "\nEw." );
        ENTERcontinue();
        System.out.println( "\"HAHAHA FOOLISH MORTAL! IT IS I, MAXIMUS EVIL, DEMON OF THE 666TH REALM OF HELL!" );
        ENTERcontinue();
        System.out.println( "THE REAL PRINCESS IS HIDDEN IN MY ULTIMATE CASTLE, FAR AWAY FROM HERE. YOU WILL HAVE TO SLOG THROUGH MULTIPLE DUNGEONS TO REACH YOUR PRINCESS!!!" );
        ENTERcontinue();
        System.out.println( "EACH DUNGEON WILL BECOME PROGRESSIVELY HARDER, CONVENIENTLY PREPARING YOU FOR THE ULTIMATE SHOWDOWN!!!\"" );
        System.out.println( "“Max” does the stereotypical devil hand gestures and your Apache Attack chopper flies out of your hands." );
        System.out.println( "\n“How does that even work?!” You exclaim." );
        ENTERcontinue();
        System.out.println( "You watch helplessly as he squeezes into the cockpit, instantly learns how to fly the chopper, and soars away, shouting obscenities at your mother and female relatives as he does so." );
        if(weaknessStickFactor == 19)
        {
        	masterProtagonist.p.setMyWeapon(Game.weapList.get("Little Timmy's Flimsy Rusty Stick of Weakness"));
        	myCurrentWeapon = masterProtagonist.p.getMyWeapon();
        }
        else
        {
        	masterProtagonist.p.setMyWeapon(Game.weapList.get("Little Timmy’s Stick"));
        	myCurrentWeapon = masterProtagonist.p.getMyWeapon();
        }
        
        ENTERcontinue();
        printTxtFile( "devilrun.txt" );
        System.out.println( "“Why do I even bother with this guy?” You wonder. Shrugging your shoulders, you begin your quest. " );
        ENTERcontinue();
        System.out.println( "You pat your belt to make sure your weapon is still there...but it isn’t! \nMaximus must have stolen it while he was talking to you! He also somehow stole your armor. \n\nYou suddenly realize that you are quite naked." );
        System.out.println( "“Nooo!!!!!” You dramatically yell. “CURSE YOU, GAME BALANCE!!!”" );

        ENTERcontinue();
    }


    /**
     * Converts a .txt file into console character art, made public static so it
     * can be called in other classes if needed.
     * 
     * @param filename
     *            the file with the ASCII art
     */
    public static void printTxtFile( String filename )
    {
        String output;
        try
        {
            FileInputStream fstream = new FileInputStream( filename );
            BufferedReader br = new BufferedReader( new InputStreamReader( fstream ) );
            while ( ( output = br.readLine() ) != null )
            {

                System.out.println( output );
            }
            br.close();
        }
        catch ( Exception ex )
        {
            System.out.println( "You wake up. This was all a dream. Get to work." );
            System.exit( 1 );
        }

    }



    /**
     * Gets the protagonist's name.
     * 
     * @return the player's name
     */
    public String getMyName()
    {
        return myName;
    }

    /**
     * Gets the protagonist's HP.
     * 
     * @return the player's HP
     */
    public double getMyHP()
    {
        return myHP;
    }

    /**
     * Gets the protagonist's weapon.
     * 
     * @return the player's weapon
     */
    public Weapon getCurrentWeapon()
    {
        return myCurrentWeapon;
    }

    /**
     * Gets the protagonist's armor.
     * 
     * @return the player's armor
     */
    public Armor getCurrentArmor()
    {
        return myCurrentArmor;
    }
    
    /**
     * Gets the protagonist's chance of getting the worst item in the game.
     * 
     * @return the player's chance
     */
    public int getWeaknessStickFactor()
    {
    	return weaknessStickFactor;
    }


    private void ENTERcontinue()
    {
        System.out.println( "\nPress ENTER to continue." );
        scan.nextLine();

    }
}
