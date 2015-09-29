import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.*;
import java.util.*;


/**
 *  This is the main class that handles all GUI related things.
 *
 *  @author  Edward
 *  @version May 25, 2015
 *  @author  Period: 6
 *  @author  Assignment: ARPEGGIO
 */
public class ArpegGUIo extends JFrame
{


    private mob[] mobLevelList = new mob[5];


    /**
     * @param level
     */
    public ArpegGUIo( int level )
    {
        
        for (String key : Game.armorList.keySet())
        {
            masterProtagonist.p.getMyInventory().armors.add(Game.armorList.get(key));
            
        }
        
        for (String key : Game.weapList.keySet())
        {
            masterProtagonist.p.getMyInventory().weaps.add(Game.weapList.get( key ));
        }

        
       
   
      
        setSize(1450, 900);
        setTitle( "Arpeggio "+level+"" );
        fillMobArray( level );

        Console con = new Console();
        LevelMap map = new LevelMap( con, level, mobLevelList );
        InventoryPanel inv = new InventoryPanel( masterProtagonist.p.getMyInventory() );
     

        JPanel overlord = new JPanel();
        overlord.setLayout( new BorderLayout() );
        overlord.add( map, BorderLayout.CENTER );
        overlord.add( inv, BorderLayout.SOUTH );
        overlord.add( con, BorderLayout.EAST );
       
        
       

        add( overlord );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setResizable( false );
      
    }


    /**
     * Fills the randomly-selected mob array from a text file.
     * @param lvl the level of the protagonist
     */
    @SuppressWarnings("resource")
    public void fillMobArray( int lvl )
    {
        Queue<String> mobtextline = new LinkedList<String>();
        Scanner scan = new Scanner( System.in );
        File mobList = new File( "mobList" + lvl + ".txt" );
        try
        {
            scan = new Scanner( mobList );
        }
        catch ( FileNotFoundException ex )
        {
            System.out.println( "you have no mobs." );
            System.exit( 1 );
        }
        while ( scan.hasNextLine() )
        {
            mobtextline.add( scan.nextLine() );
        }
        String[] parts;

        for ( int i = 0; i < mobLevelList.length; i++ )
        {
            String total = mobtextline.remove();
            String delims = "[,\n]";
            parts = total.split( delims );
            String name = parts[0];
            mobLevelList[i] = ( new mob( name,
                Double.parseDouble( parts[1] ),
                new Weapon( parts[2], Integer.parseInt( parts[3].trim() ) ),
                new Armor( parts[4], Integer.parseInt( parts[5] ) ) ) );
        }
    }


    // public ArpegGUIo()
    // {
    // Protagonist p = new Protagonist("test");
    // p.getMyInventory().weaps.add(new Weapon("testing gun", 100000));
    //
    //
    // p.setPlayerClass( 2 );
    // setSize( 1000,900);
    // setTitle( "Arpeggio" );
    //
    // GUIBoard map = new GUIBoard (p);
    // InventoryPanel inv = new InventoryPanel (p.getMyInventory());
    // Console con = new Console();
    // StatPanel stat = new StatPanel(p);
    //
    //
    //
    //
    // //overlord = biggest baddest JPanel of them all (conglomeration of all
    // other jpanels)
    // JPanel overlord = new JPanel();
    // overlord.setLayout( new BorderLayout() );
    // overlord.add(map, BorderLayout.CENTER);
    // overlord.add( inv, BorderLayout.EAST );
    // overlord.add( con, BorderLayout.SOUTH );
    // overlord.add(stat,BorderLayout.WEST);
    // //overlord.add( statusbar, BorderLayout.SOUTH );
    //
    //
    //
    //
    // add(overlord);
    //
    //
    //
    //
    //
    //
    //
    // setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    // setLocationRelativeTo( null );
    // }
    //
//    //
//    public static void main( String[] args )
//    {
//
//        // EventQueue.invokeLater( new Runnable()
//        // {
//        // @Override
//        // public void run()
//        // {
//        // ArpegGUIo ex = new ArpegGUIo();
//        // ex.setVisible( true );
//        // ex.revalidate();
//        // }
//        // } );
//        // ArpegGUIo ex = new ArpegGUIo();
//        // ex.setVisible( true );
//
//        ArpegGUIo a = new ArpegGUIo( 1 );
//        a.fillMobArray( 1 );
//
//    }
}