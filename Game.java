import java.awt.GraphicsEnvironment;
import java.io.*;
import java.util.*;


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
public class Game
{
    public static final double MAXHP = 100;

    public static HashMap<String, Weapon> weapList; // capacity can be
                                                    // changed
                                                    // at will

    public static HashMap<String, Armor> armorList;

    public static Scanner weaponsIn;

    public static Scanner armorIn;

    public static Weapon myWeapon;

    public static Armor myArmor = null;

    public static Inventory myInventory = null;

    public String test;

    public static Protagonist prot;


    /**
     * Constructs the game by loading the weapon and armor lists from .txt files.
     */
    public Game()
    {

        loadLoot( "weaplist.txt", "armorlist.txt" );
    }


    /**
     * Starts the game.
     */
    public void newGame()
    {
        System.out.println( "Welcome!" );
        System.out.println( "What is your name?" );
        test = "hi";
    }


    /**
     * Loads the master weapon and armor lists
     * @param weaponListName filename holding all weapons
     * @param armorListName filename holding all armors
     */
    public void loadLoot( String weaponListName, String armorListName )
    {
        weapList = new HashMap<String, Weapon>();
        armorList = new HashMap<String, Armor>();
        int weaponCount = 0;
        int armorCount = 0;
        File weaps = new File( weaponListName );
        try
        {
            weaponsIn = new Scanner( weaps );
        }
        catch ( FileNotFoundException ex )
        {
            System.out.println( "There is no loot. Check cache and try again." );
            System.exit( 1 );
        }
        while ( weaponsIn.hasNextLine() )
        {
            String weaponLine = weaponsIn.nextLine().trim();
            int stat = Integer.parseInt( weaponLine.substring( weaponLine.length() - 6 ) );
            String weapName = weaponLine.substring( 0, weaponLine.length() - 6 )
                .trim();
            weapList.put( weapName, new Weapon( weapName, stat ) );
            weaponCount++;
        }
        System.out.println( "Loading... 50% complete" );
        File armor = new File( armorListName );
        try
        {
            armorIn = new Scanner( armor );
        }
        catch ( FileNotFoundException ex )
        {
            System.out.println( "There is no loot. Check cache and try again." );
            System.exit( 1 );
        }
        while ( armorIn.hasNextLine() )
        {
            String armorLine = armorIn.nextLine().trim();
            int stat = Integer.parseInt( armorLine.substring( armorLine.length() - 6 ) );
            String armorName = armorLine.substring( 0, armorLine.length() - 6 )
                .trim();
            armorList.put( armorName, new Armor( armorName, stat ) );
            armorCount++;
        }
        System.out.println( "Load complete." );
        // System.out.println( armorCount + " " + weaponCount);
        // for (int i = 0; i < weaponCount; i++)
        // {
        // System.out.print(weapList[i].getWeaponName() +
        // weapList[i].getWeaponStat() + " ");
        // }
        // for (int j = 0; j < armorCount; j++)
        // {
        // System.out.print(armorList[j].getArmorName() +
        // armorList[j].getArmorStat() + " ");
        // }
    }


    /**
     * Helps the main() select the player class.
     */
    private static void selectClass()
    {
        Scanner scan = new Scanner( System.in );
        System.out.println( "Are you a righteous noble heroic glory-seeking knight paladin (1)?" );
        System.out.println( "A dastardly sneaky highwayman thief rogue w/ heart of gold (2)?" );
        System.out.println( "Ar a chaotic-neutral wild barbaric powerful hulking berserker (3)?" );
        String playerClass = scan.next();
        try
        {
            masterProtagonist.p.setPlayerClass( Integer.parseInt( playerClass.trim() ) );
        }
        catch ( NumberFormatException ex )
        {
            selectClass();
        }
    }


    /**
     * Instantiates a new GUI per level.
     * @param level that the protagonist is on.
     */
    public static void openGUI( int level )
    {
        ArpegGUIo newGUI = new ArpegGUIo( level );
        newGUI.setVisible( true );
    }


    /**
     * 
     * This instantiates a new game and makes a new masterProtagonist.
     * 
     * @param args
     *            some vestige from the days of C programming
     */
    public static void main( String[] args )
    {

        Game g = new Game();
        g.newGame();
        Scanner scan = new Scanner( System.in );
        masterProtagonist.p = new Protagonist( scan.next() );
        selectClass();

        System.out.println( "Hello, " + masterProtagonist.p.getMyName() + "!" );
        System.out.println( "Shall we begin with our cliched plotline?" );
        System.out.println( "\nPress ENTER to continue." );
        scan.nextLine();
        scan.nextLine();
        // g.selectStartingWeapon( mainCharacter );
        story1 str = new story1();
        str.advanceTutorial();
        // gui startup here

      //  Game.openGUI( 1 );
        ArpegGUIo a4 = new ArpegGUIo(4);
        a4.setVisible(true);
        ArpegGUIo a3 = new ArpegGUIo( 3 );
        a3.setVisible( true );
        ArpegGUIo a1= new ArpegGUIo(1);
        a1.setVisible( true );
        a1.setAlwaysOnTop( true );
  
        
        //Game.openGUI( 2 );
       // Game.openGUI( 3 );3
        
       
    }

}
