import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Draws the map and console that displays fighting information LevelMap is a
 * JPanel with two sections, a map and a console. The map is randomly generated
 * using algorithms from the MapGenerator class.The user moves around on map and
 * encounters monsters. The monsters are fought through the console, and the
 * user interacts with the console.
 *
 * @author Edward, Oliver, David
 * @version May 25, 2015
 * @author Period: 6
 * @author Assignment: ARPEGGIO
 *
 * @author Sources: Zetacode Java 2d Minesweeper
 */
public class LevelMap extends JPanel implements ActionListener
{
    private static final int NUM_IMAGES = 4;

    public static final int CELL_SIZE = 50;

    public static final int N_ROWS = 10;

    public static final int N_COLS = 10;

    private int lvl;

    private Image[] img;

    MapGenerator level;

    private JLabel statusbar;

    private Timer timer;

    private HeroGUI HeroGUI;

    private Console cons;

    private mob[] currentmobArray;

    private mob boss;


    /**
     * creates a tileMap with a statusbar underneath
     * 
     * @param sbar
     *            statusbar
     */
    public LevelMap( Console c, int level, mob[] mArray )
    {

        lvl = level;
        cons = c;
        currentmobArray = mArray;
        createHeroGUI( masterProtagonist.p, level );
        initBoard( level );
        loadBoss( level );
    }


    /**
     * Loads the boss for a given level
     * @param level that protagonist is on
     */
    private void loadBoss( int level )
    {
        if ( level == 1 )
        {
            boss = new mob( "Benny the Big Bad Bandito",
                50,
                new Weapon( "Revolving Bandito Revolver", 101060 ),
                new Armor( "Obnoxious Bandito Hat", 100505 ) );
        }
        if ( level == 2 )
        {
            boss = new mob( "Creepy Hangman Executioner Dude",
                150,
                new Weapon( "Executioner's Axe of Impractical Size", 803060 ),
                new Armor( "Cloak with Excessive Number of Skulls Attatched to it",
                    102000 ) );
        }
        if ( level == 3 )
        {
            boss = new mob( "Humuhumunukunukuapu'apua",
                300,
                new Weapon( "Surf", 410070 ),
                new Armor( "C Major Scales of Fish", 105010 ) );

        }
        if ( level == 4 )
        {
            boss = new mob( "!(Creepy Hangman Executioner Dude)",
                500,
                new Weapon( "Familiar Looking Executioner's Axe of Impractical Size",
                    830060 ),
                new Armor( "Familiar Looking Cloak with Excessive Number Number of Skulls Attatched to it",
                    120010 ) );
        }
    }


    /**
     * Creates the HeroGUI, which is an icon on top of the map. He is controlled
     * by arrow keys and moves 1 tile (50 x 50 pixels) at a time
     * 
     * @param p
     *            protagonist
     */
    private void createHeroGUI( Protagonist p, int level )
    {

        setFocusable( true );

        setDoubleBuffered( true );

        HeroGUI = new HeroGUI( level );

        timer = new Timer( 130, this );
        timer.start();

        addKeyListener( new TAdapter() );
    }


    /**
     * generates the map via map generation algorithms and loads all land images
     * into an image array
     */
    private void initBoard( int level )
    {
        generateMap();
        loadImage( level );

    }


    /**
     * creates instance of MapGenerator and makes the map
     */
    private void generateMap()
    {
        level = new MapGenerator( 0, 15 );
        level.initLevel();
        level.makeLake();
        level.makeRoad( 0, 0 );
        level.makeTrees( 10 );
        level.printLevel();

    }


    /**
     * first checks level and then loads all images into an image array
     * @param level the level the character is on
     */
    private void loadImage( int level )
    {
        img = new Image[NUM_IMAGES];

        if ( level == 1 || level == 2 )
        {

            for ( int i = 0; i < NUM_IMAGES; i++ )
            {
                img[i] = ( new ImageIcon( i + ".png" ) ).getImage();

            }
        }

        if ( level == 3 )
        {

            for ( int i = 0; i < NUM_IMAGES; i++ )
            {
                img[i] = ( new ImageIcon( "sea" + i + ".png" ) ).getImage();

            }
        }
        if ( level == 4 )
        {

            for ( int i = 0; i < NUM_IMAGES; i++ )
            {
                img[i] = ( new ImageIcon( "space" + i + ".png" ) ).getImage();

            }
        }

    }


    /**
     * first paints the map. then paints the HeroGUI on top
     * 
     * @param g
     *            graphics
     */
    public void paintComponent( Graphics g )
    {
        if ( masterProtagonist.bossLife1 )
        {

            super.paintComponent( g );
            int imgIndex = 1;
            for ( int r = 0; r < MapGenerator.grid.length; r++ )
            {
                for ( int c = 0; c < MapGenerator.grid[0].length; c++ )
                {
                    int tileVal = MapGenerator.grid[r][c];
                    if ( tileVal == 0 )
                    {
                        imgIndex = 0;
                    }
                    else if ( tileVal == 1 )
                    {
                        imgIndex = 1;
                    }
                    else if ( tileVal == 2 )
                    {
                        imgIndex = 2;
                    }
                    else if ( tileVal == 3 )
                    {
                        imgIndex = 3;
                    }

                    g.drawImage( img[imgIndex],
                        ( CELL_SIZE * c ),
                        ( CELL_SIZE * r ),
                        this );

                }
            }

            Graphics2D g2d = (Graphics2D)g;

            g2d.drawImage( HeroGUI.getImage(),
                HeroGUI.getX(),
                HeroGUI.getY(),
                this );

            Toolkit.getDefaultToolkit().sync();

            g.dispose();
        }
        else
        {

            ImageIcon i = new ImageIcon("berserkerBoss1.png");
            g.drawImage(i.getImage(),0,0,this );
        }

    }


    /**
     * when an action is performed, moves the HeroGUI icon accordingly and
     * repaints map
     * 
     * @param arg0
     *            an action event
     */
    @Override
    public void actionPerformed( ActionEvent arg0 )
    {

        if ( !masterProtagonist.p.isInFight() && !masterProtagonist.p.dead )
        {
            HeroGUI.move();
            repaint();
        }

    }


    /**
     * 
     * This class processes keyboard inputs from the user and decides if the
     * player encounters a monster
     * 
     * @author Edward,Oliver,David
     * @version May 9, 2015
     * @author Period: 6
     * @author Assignment: ArpegGUIo
     *
     * @author Sources: Zetacode Minesweeper
     */
    private class TAdapter extends KeyAdapter
    {

        int a = 0;

        int b = 0;


        /**
         * when a key is released, calls HeroGUI's key release method
         */
        public void keyReleased( KeyEvent e )
        {

            HeroGUI.keyReleased( e );
        }


        /**
         * First checks if player is dead. If not, allows player to move around
         * and RNG decides if encounter monster happens. Then calls HeroGUI's
         * key pressed method to move hero tile
         * 
         * @param e
         *            key press
         */
        public void keyPressed( KeyEvent e )
        {
            
            
            if ( masterProtagonist.p.dead )
            {

                cons.append( "\nYou are dead. Game Over" );
                System.exit( 0 );
            }
            if ( !masterProtagonist.p.dead && !masterProtagonist.p.isInFight() )
            {
                b++;

                if ( Math.random() > 0.87 )
                {
                    masterProtagonist.p.setInFight( true );
                    cons.buttonControl( true );
                    a++;

                    int i = (int)( Math.random() * 5 );
                    System.out.println( i );
                    mob temp = currentmobArray[i];

                    if ( masterProtagonist.p.level > lvl)
                    {

                        masterProtagonist.p.bossLife1 = false;
                        repaint();
                       
                        temp = boss;
                    }
                    cons.append( FinalFighter.encounter( temp.getMobName(),
                        temp.getMobHP(),
                        temp.getMobArmor(),
                        temp.getMobWeapon() ) );
                    cons.append( "\n" + a + " number of battles out of " + b
                        + " battles" );
                }
                else
                {
                    cons.buttonControl( false );
                }
                HeroGUI.keyPressed( e );

            }
            else
            {
                cons.append( "\nYou must decide what to do" );
            }
        }
    }

}
