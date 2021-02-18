import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame {
    JTextArea t1;
    JPanel p1;
    Marks(){}
    Marks(String str){
        setSize(500,600);
        setLayout(new BorderLayout());

        p1 = new JPanel();

       t1 = new JTextArea(50,15);
       JScrollPane jsp = new JScrollPane(t1);
       t1.setFont(new Font("Senserif",Font.ITALIC,18));
       
       add(p1,"North");
       
       add(jsp,"Center");
       
       setLocation(450,200);
       mark(str);
    }
    public void mark(String s){
        try{
            conn c=new conn();
            t1.setText("\tResult of Examination\n\nSubject\n");
            ResultSet rs1=c.s.executeQuery("select * from subject where roll_no="+s);
            if(rs1.next()){
                t1.append("\n\t"+rs1.getString("s1"));
                t1.append("\n\t"+rs1.getString("s2"));
                t1.append("\n\t"+rs1.getString("s3"));
                t1.append("\n\t"+rs1.getString("s4"));
                t1.append("\n\t"+rs1.getString("s5"));
                t1.append("\n-----------------------------------------");
                t1.append("\n");
            }   
            ResultSet rs2 = c.s.executeQuery("select * from marks where roll_no="+s);
           
            if(rs2.next()){
                t1.append("\nMarks\n\n\t"+rs2.getString("m1"));
                t1.append("\n\t"+rs2.getString("m2"));
                t1.append("\n\t"+rs2.getString("m3"));
                t1.append("\n\t"+rs2.getString("m4"));
                t1.append("\n\t"+rs2.getString("m5"));
                t1.append("\n-----------------------------------------");
                t1.append("\n");
            }
        }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        public  static void main(String[] args) {
            new Marks().setVisible(true);
        }
    }


