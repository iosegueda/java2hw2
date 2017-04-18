//Iris Osegueda 
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

public class HW2 extends JFrame implements  ChangeListener
{
    Container container;
    JSlider slider;
    JTextArea circleInfo;
    JPanel bottomPanel;
    final int DEFAULTRADIUS = 150;
    int radius;
    double diameter;
    double area; 
    double circumference;

    public HW2()
    {
        super( "Circle 1" );

        container = getContentPane();

        container.setLayout (new BorderLayout());
        bottomPanel = new JPanel(new BorderLayout());

        slider = new JSlider(  SwingConstants.HORIZONTAL, 100, 200, DEFAULTRADIUS );
        slider.addChangeListener( this );
        slider.setMajorTickSpacing( 10 );
        slider.setPaintTicks( true );
        slider.setPaintLabels( false );

        radius = DEFAULTRADIUS;
        diameter = 2 * radius;
        area = Math.PI * radius * radius ;
        circumference = 2 * Math.PI * radius ;

        circleInfo = new JTextArea( 5, 5 );
        circleInfo.setEditable( false );
        circleInfo.setText(  "Radius: " + radius +
                "\nDiameter: " + diameter +
                "\nArea: " + area +
                "\nCircumference: " + circumference);

        bottomPanel.add( new JScrollPane( circleInfo), BorderLayout.NORTH );
        bottomPanel.add( slider, BorderLayout.SOUTH );
        container.add(bottomPanel, BorderLayout.SOUTH );

        setSize(450, 575);
        setLocation( 200, 200 );
        setVisible( true );
    }

    public void stateChanged( ChangeEvent ce )
    {
        radius = slider.getValue();
        diameter = 2 * radius;
        area = Math.PI * radius * radius;
        circumference = 2 * Math.PI * radius;

        circleInfo.setText( "Radius: " + radius +
                "\nDiameter: " + diameter +
                "\nArea: " + area +
                "\nCircumference: " + circumference);

       super.repaint();
    }

    public void paint (Graphics g)
    {
        int x = 20;
        int y = 35;

        super.paint( g );

        g.drawOval ( x, y, (int)diameter, (int)diameter);
    }


    public static void main(String[] args)
    {
        HW2 demo = new HW2();
        demo.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
private class MyDrawingPanel extends JPanel
{
    int x = 20;
    int y = 35;
    
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        
        g.drawOval ( x, y, (int)diameter, (int)diameter);

    }
    
    public void setShape( int val )
    {
        shape = val;
        repaint();
    }
}