import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


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
public class Console extends JPanel implements ActionListener
{
    private JTextArea text;
    public static JButton one, two, three, four;
    private String previousTurn;

    /**
     * 
     */
    public Console()
    {
        
    
        //create text area
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        JScrollPane pane = new JScrollPane();
        text = new JTextArea(25,30);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        text.setFocusable( false );
        pane.getViewport().add(text);
        panel.add(pane);
        
        text.setFont( new Font("Verdana",Font.PLAIN,20) );
        
        //create button area
        JPanel buttonpanel = new JPanel();
        buttonpanel.setLayout( new GridLayout(4,0) );

    
 
        one = new JButton("fight");
        one.addActionListener( this);
         
        
        two = new JButton("examine");
        two.addActionListener( this );
       
        
        three = new JButton("escape");
        three.addActionListener(this);
        
        
        four = new JButton("continue");
        four.addActionListener( this );
      
        
        one.setEnabled( false );
        two.setEnabled( false );
        three.setEnabled( false );
        four.setEnabled( false );
        

        one.setFocusable( false ); 
        two.setFocusable( false );
        three.setFocusable( false );
        four.setFocusable( false );
        
        
        buttonpanel.add( one );
        buttonpanel.add(two);
        buttonpanel.add(three);
        buttonpanel.add(four);
       
        
        add(panel,BorderLayout.WEST);
        add(buttonpanel,BorderLayout.CENTER);
        
       text.setEditable( false );
        setSize(new Dimension(350, 300));
        
     
        
    }
    
    /**
     * TODO Write your method description here.
     * @param str
     */
    public void append(String str)
    {
        text.append( str );
    }

    /**
     * TODO Write your method description here.
     * @param b
     */
    public void buttonControl(boolean b)
    {
        if (!b)
        {
             one.setEnabled( false );
             two.setEnabled( false );
             three.setEnabled( false );
             four.setEnabled( false );
        }
        else
        {
            one.setEnabled( true );
            two.setEnabled(true);
            three.setEnabled( true);
            four.setEnabled( true );
        }
    }
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand().equals("fight"))
        {
            text.append( "\n"+FinalFighter.startCombat() );
        }
        if (e.getActionCommand().equals("examine"))
        {
            text.append("\n"+FinalFighter.examine());
        }
        if (e.getActionCommand().equals("escape"))
        {
            masterProtagonist.p.setInFight(false);
            this.buttonControl( false );
            text.append("\n"+FinalFighter.run());
        }
        if (e.getActionCommand().equals("continue"))
        {
            
            text.append("\n"+FinalFighter.attackTurn());
        }
    }
    
  
   
    
 

    

}
