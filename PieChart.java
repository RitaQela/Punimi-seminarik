import javax.swing.*;
import java.awt.*;

public class PieChart extends JPanel 
{private int size; //krijimi i 6 te dhenave dhe kendet e tyre
 private int angle1;
 private String s1;
 private int angle2;
 private String s2;
 private int angle3;
 private String s3;
 private int angle4;
 private String s4;
 private int angle5;
 private String s5;
 private int angle6;
 private String s6;
 private int sum;
 private int diameter;
 private int x;
 private int y;
 
 public void getangles(int angle1,String s1,int angle2,String s2,int angle3,String s3,
                       int angle4,String s4,int angle5,String s5,int angle6,String s6,int diameter,int x,int y)
 {this.angle1=angle1; //referimi i te dhenave bashke me shumen e tyre
  this.s1=s1;
  this.angle2=angle2;
  this.s2=s2;
  this.angle3=angle3;
  this.s3=s3;
  this.angle4=angle4;
  this.s4=s4;
  this.angle5=angle5;
  this.s5=s5;
  this.angle6=angle6;
  this.s6=s6;
  this.diameter=diameter;
  this.x=x;
  this.y=y;
  sum=angle1+angle2+angle3+angle4+angle5+angle6;
 }


 public PieChart(int size,String title)
 {this.size=size; //krijimi i kornizes ne te cilen do te shfaqet rrethi
  JFrame frame=new JFrame();
  frame.setSize(size,size);
  frame.setTitle(title);
  frame.getContentPane().add(this);
  frame.setVisible(true);
 }

 public void paintComponent(Graphics g)
 {double a=(angle1*100.0/sum)+(angle2*100.0/sum)+(angle3*100.0/sum)+(angle4*100.0/sum)+(angle5*100.0/sum); //ndarja e kendeve, raportet mes kendeve
 int b=(int)(a-(int)(a)+1);
  //caktimi i ngjyrave te kendeve ne menyre qe te dallohen perqindjet 
  int startangle2=slice(angle1,0,Color.red,g); 
  g.setColor(Color.red);
  g.drawString(s1+"  "+(int)(angle1*100.0/sum)+"%",x+diameter+50,y);
 
  int startangle3=slice(angle2,startangle2,Color.blue,g);
  g.setColor(Color.blue);
  g.drawString(s2+"  "+(int)(angle2*100.0/sum)+"%",x+diameter+50,y+20);
 
  int startangle4=slice(angle3,startangle3,Color.green,g);
  g.setColor(Color.green);
  g.drawString(s3+"  "+(int)(angle3*100.0/sum)+"%",x+diameter+50,y+40);
 
  int startangle5=slice(angle4,startangle4,Color.yellow,g);
  g.setColor(Color.yellow);
  g.drawString(s4+"  "+(int)(angle4*100.0/sum)+"%",x+diameter+50,y+60);
 
  int startangle6=slice(angle5,startangle5,Color.cyan,g);
  g.setColor(Color.cyan);
  g.drawString(s5+"  "+(int)(angle5*100.0/sum)+"%",x+diameter+50,y+80);
 
  int startangle7=slice(angle6+b,startangle6,Color.pink,g);
  g.setColor(Color.pink);
  g.drawString(s6+"  "+(int)(angle6*100.0/sum)+"%",x+diameter+50,y+100); 
 }
 //mbushja e kendeve dhe percaktimi i tyre sipas 360 shkalleve
 private int slice(int angle,int startangle,Color c,Graphics pen)
 {pen.setColor(c);
  pen.fillArc(x,y,diameter,diameter,startangle,(int)(((double)angle/(double)sum)*360));
  int a=startangle+(int)(((double)angle/(double)sum)*360);
  return a;
 }


}