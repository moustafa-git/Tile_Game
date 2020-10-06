package dev.codenmore.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display {
    
    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    private int width,height;
    
    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        
        createDisplay();
    }
    
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //MAKES SURE THAT YOUR WINDOWS CLOSES PROPERLY.
        frame.setResizable(false); //NOT ALLOWING THE USER TO RESIZE THE WINDOWS ON HIS OWN.(KEEP IT STATIC AS THE WIDTH AND HEIGHT ENTERED).
        frame.setLocationRelativeTo(null); //SO THAT WHEN THE WINDOWS OPENS, IT AUTOMATICALLY APPEARS AT THE CENTER OF THE SCREEN.
        frame.setVisible(true); //CUZ JFRAME BY DEFAULT ARENT VISIBLE, SO WE HAVE TO MANUALLY DO IT.
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        frame.add(canvas); //SIMPLY ADDING OUR CANVAS TO THE FRAME.

        frame.pack(); //IT SIMPLY RESIZES OUR WINDOW TO SEE THE CANVAS.
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
