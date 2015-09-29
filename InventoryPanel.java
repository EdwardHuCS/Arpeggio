import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class InventoryPanel extends JPanel
{

    private String[] armorlist = new String[10];

    private String[] weaponlist = new String[10];

    private ArrayList<Armor> temp1;

    private ArrayList<Weapon> temp2;

    private Inventory inventory;

    public JComboBox<String> armor;

    public JComboBox<String> weapon;


    /**
     * This is a visualization of the inventory system for the main character.
     * He can choose to use a weapon and a piece of armor.
     * 
     * @param inv
     *            the inventory from which we will take in our items.
     */
    public InventoryPanel( Inventory inv )
    {

        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout( 0, 2 ) );
        inventory = inv;

        loadItems();

        armor = new JComboBox<String>( armorlist );
        weapon = new JComboBox<String>( weaponlist );

        armor.setFocusable( false );
        weapon.setFocusable( false );

        armor.setBorder( BorderFactory.createTitledBorder( "Armor" ) );
        weapon.setBorder( BorderFactory.createTitledBorder( "Weapon" ) );

        armor.setSize( 100, 50 );
        weapon.setSize( 100, 80 );
        panel.add( armor );
        panel.add( weapon );

        panel.setPreferredSize( new Dimension( 300, 80 ) );
        panel.setBorder( BorderFactory.createTitledBorder( "Inventory" ) );

        add( panel );

    }


    /**
     * 
     * Takes in all our items from Inventory's arraylists.
     */
    public void loadItems()
    {

        temp1 = inventory.getArmor();
        int i = 0;
        for ( Armor arm : temp1 )
        {
            if ( i > 5 )
            {
                break;
            }
            armorlist[i] = arm.getArmorName();
            i++;

        }

        temp2 = inventory.getWeapons();
        i = 0;
        for ( Weapon weap : temp2 )
        {
            if ( i > 9 )
            {
                break;
            }
            weaponlist[i] = weap.getWeaponName();
            i++;

        }

    }


    /**
     * UNUSED
     * 
     * Creates the background image for our inventory screen.
     */
    private void setBackground()
    {
        Image myPicture = new ImageIcon( "jankInv.png" ).getImage();
        myPicture = myPicture.getScaledInstance( 200, 400, SOMEBITS );
        JLabel picLabel = new JLabel( new ImageIcon( myPicture ) );
        add( picLabel );
    }


    /**
     * 
     * Overrides the original paintComponent. Yes, it's supposed to be empty.
     */
    public void paintComponent( Graphics g )
    {

    }

}
