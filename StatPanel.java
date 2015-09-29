import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatPanel extends JPanel implements ActionListener
{

    JLabel name, hp, exp, str, eye, spd, agi, def, luk;


    public StatPanel( Protagonist p )
    {

        name = new JLabel();
        hp = new JLabel();
        exp = new JLabel();
        str = new JLabel();
        eye = new JLabel();
        spd = new JLabel();
        agi = new JLabel();
        def = new JLabel();
        luk = new JLabel();

        name.setText( p.getMyName() );
        name.setBorder( BorderFactory.createTitledBorder( "Player" ) );
        hp.setText( p.getHP() + "" );
        hp.setBorder( BorderFactory.createTitledBorder( "HP" ) );
        exp.setText( p.getExperience() + "" );
        exp.setBorder( BorderFactory.createTitledBorder( "EXP" ) );
        str.setText( p.getStr() + "" );
        str.setBorder( BorderFactory.createTitledBorder( "STR" ) );
        eye.setText( p.getSkill() + "" );
        eye.setBorder( BorderFactory.createTitledBorder( "EYE" ) );
        spd.setText( p.getSpd() + "" );
        spd.setBorder( BorderFactory.createTitledBorder( "SPD" ) );
        agi.setText( p.getAgi() + "" );
        agi.setBorder( BorderFactory.createTitledBorder( "AGI" ) );
        def.setText( p.getDef() + "" );
        def.setBorder( BorderFactory.createTitledBorder( "DEF" ) );
        luk.setText( p.getLuck() + "" );
        luk.setBorder( BorderFactory.createTitledBorder( "LUK" ) );

        this.setLayout( new GridLayout( 10, 0 ) );
        add( name );
        add( hp );
        add( exp );
        add( str );
        add( eye );
        add( spd );
        add( agi );
        add( def );
        add( luk );

        setSize( 300, 100 );
    }


    /**
     * 
     * Checks if the action is performed. If it is, then the statpanel updates
     * with new stats (if protagonist levels up or takes damage).
     */
    @Override
    public void actionPerformed( ActionEvent arg0 )
    {
        if ( arg0.getActionCommand().equals( "proceed" ) )
        {

            refresh();
        }

    }

    /**
     * 
     * This method fetches the protagonist's current hp.
     */
    private void refresh()
    {
        hp.setText( masterProtagonist.p.getHP() + "" );
        System.out.println( masterProtagonist.p.getHP() + "" );
        hp.repaint();
    }

}
