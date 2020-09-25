import java.applet.*;

import java.awt.*;

public class Runnable_Demo extends Applet implements Runnable{



  Thread t;

  String txt="HSBC TECHNOLOGY";

  int pos;

  int y=15;

  Color c;



   public void init()

{

 resize(1200,20);

 t=new Thread(this);

 pos=getSize().width;

 t.start();

}



     public void paint(Graphics g)

 {

   g.setColor(c);

   g.drawString(txt,pos,y);

  }



 public void run()

 {

   while(true)

 {

 int r=(int)(Math.random()*255);

 int ge=(int)(Math.random()*255);

 int b=(int)(Math.random()*255);



c=new Color(r,ge,b);



   try

{

   t.sleep(100);

     if(pos<=0)

       {

       pos=1200;

        }


    else

       {

        pos-=10;

        }

       repaint();

 }

   catch(Exception e)

  {

  
System.out.println(e.getMessage()); 


  }

}



}



}       




/*
<applet code="MarqueeText" width="1200" height="20"></applet>
*/