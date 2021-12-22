import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="Decstringmove.class" height=500 width=500></applet>
*/

public class Decstringmove extends Applet implements ActionListener,Runnable{
    String n1="";
    int x,y,flag,ch,fon,chfont;
    TextField t1=new TextField(50);
    Label l1=new Label("Add Your Text");
    Button b3=new Button("MOVE");
    public void init(){
        x=100;
        y=200;
        ch=10;
        fon=100;
        chfont=2;
        Thread t=new Thread(this,"My Thread");
        t.start();
        add(l1);
        add(t1);
        add(b3);
        b3.addActionListener(this);
            }
    public void run(){
        while(true){
            x=x+ch;
            fon=fon-(chfont);
            
            if (x>400){
                x=100;
                y=200;
                fon=100;
            }
            
            repaint();
            try{
                Thread.sleep(150);
            }
            catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==b3){
            n1=t1.getText();

        }
    }
    public void paint(Graphics g){
        g.setFont(new Font("Times New Roman", Font.BOLD,fon));
        g.drawString(n1, y, x);
    }

    
}
