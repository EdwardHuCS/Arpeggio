import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


/**
 * This class controls the hero tile and its movement properties within the map
 * Selects the hero tile icon, and then loads in the hero tile directional tiles. Every time
 * hero tile is moved in the map
 *
 *  @author  Edward,David,Oliver
 *  @version May 25, 2015
 *  @author  Period: 6
 *  @author  Assignment: ARPEGGIO
 */
public class HeroGUI
{
    private int dx;

    private int dy;

    private int x;

    private int y;

    private Image image, up, left, right,down;


    /**
     * Constructs the gui
     * @param level of the character
     */
    public HeroGUI(int level)
    {
        String heroPicName="rogueTile";
        if (masterProtagonist.p.getPlayerClass() == 1)
        {
         heroPicName = "warriorTile";   
        }
        else if (masterProtagonist.p.getPlayerClass() == 2)
        {
            heroPicName = "rogueTile";
        }
        else
        {
            heroPicName = "berserkerTile";
        }
       
        
        if(level == 3)
        {
            heroPicName+="Sea";
        }
        if (level == 4)
        {
            heroPicName+="Space";
        }
       
        ImageIcon ii = new ImageIcon(heroPicName+"Left.png");
        left = ii.getImage();
        ii = new ImageIcon(heroPicName+"Right.png");
        right = ii.getImage();
        ii = new ImageIcon(heroPicName+"Up.png");
        up = ii.getImage();
        ii = new ImageIcon( heroPicName+"Down.png" );
        down = ii.getImage();
        image = down;
        
        x = 350;
        y = 350;
    }


    /**
     *moves the character. if he is out of bounds, resets position to last tile
     */
    public void move()
    {
        if ( x < 0 )
        {
            x = 0;
        }
        if ( y < 0 )
        {
            y = 0;
        }
        if ( x > 699)
        {
            x = 700;
        }
        if ( y > 699 )
        {
            y = 700;
        }
        
     

        x += dx;
        y += dy;
        
 
    }


    /**
     * Gets X value of the character
     * @return x value
     */
    public int getX()
    {
        return x;
    }


    /**
     * Gets Y value of the character
     * @return y value
     */
    public int getY()
    {
        return y;
    }


    /**
     * Gets the image at the current location.
     * @return the image
     */
    public Image getImage()
    {
        return image;
    }

    /**
     * sets the image of at the current location
     */
    public void setImage()
    {
        ImageIcon i = new ImageIcon("deadTile.png");
       image = i.getImage();
    }

    /**
     * moves the main character image in the given direction
     * @param e direction to be moved
     */
    public void keyPressed( KeyEvent e )
    {

        int key = e.getKeyCode();
        
    
        if ( key == KeyEvent.VK_LEFT )
        {
            image = left;
            dx = -50;
            if (x==0)
            {
                dx = 0;
            }
        
            

        }

        if ( key == KeyEvent.VK_RIGHT )
        {
            image = right;
            dx = 50;
            if (x==700)
            {
                dx = 0;
            }
        }

        if ( key == KeyEvent.VK_UP )
        {
        
            image = up;
            dy = -50;
            if (y == 0)
            {
                dy = 0;
            }
        }

        if ( key == KeyEvent.VK_DOWN )
        {
            image = down;
            dy = 50;
            if (y==700)
            {
                dy = 0;
            }
        }
    }


    /**
     * moves the location of the character
     * @param e the direction.
     */
    public void keyReleased( KeyEvent e )
    {
        int key = e.getKeyCode();

        if ( key == KeyEvent.VK_LEFT )
        {
            
            dx = 0;
        }

        if ( key == KeyEvent.VK_RIGHT )
        {
            dx = 0;
        }

        if ( key == KeyEvent.VK_UP )
        {
            dy = 0;
        }

        if ( key == KeyEvent.VK_DOWN )
        {
            dy = 0;
        }
    }
}