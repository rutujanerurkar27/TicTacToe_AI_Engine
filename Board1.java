/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import javax.swing.border.*;

/**
 *
 * @author Administrator
 */
public class Board1 extends JFrame implements ActionListener{

    //all variables which are frequently used
    private int xWins=0;
    private int oWins=0;
    private int draws=0;
    
    private JButtonComponent B1,B2,B3,B4,B5,B6,B7,B8,B9;
    private JLabel lblxWins,lbloWins,lblDraws;
    //object of a TicTacToe class
    private TicTacToe_MiniMax object;
    //these three lables will be used to show the score on the board
    private JLabel lblxWins_new;
    private JLabel lbloWins_new;
    private JLabel lblDraws_new;
    private JPanel container;
    private JButton btnNewgame;
    
    public static void main(String ars[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Board1 obj=new Board1();
                    obj.setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println("The error is:\t"+e.toString());
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        
        if(e.getSource()==btnNewgame)
        {
            B1.setText("");
            B2.setText("");
            B3.setText("");
            B4.setText("");
            B5.setText("");
            B6.setText("");
            B7.setText("");
            B8.setText("");
            B9.setText("");
        }
    }
    
    public class JButtonComponent extends JButton //this class is used to create multiple buttons in the class in order to add more buttons in the frame
    {
        private static final long serial_num=1L;//serial number value of
        public int Field_value=0;//this value is used to set the field wise value of jbuttonbox
    }
    
    private static final long serialUID=1L;
    
    
    //following is the constructor
    //this will help to create the frame and we can put the elements into the frame
    public Board1()
    {
        object=new TicTacToe_MiniMax();
        setBounds(100,100,512,278);
        setResizable(false);
        //this variable is used for adding the componets in the panel of frame
        container = new JPanel();
        container.setBorder(new EmptyBorder(3,3,3,3));
        setContentPane(container);
        container.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //below code will show and place the components in the frame with the respective places specified in the code
        B1=new JButtonComponent();
        B1.Field_value=1;
        B1.addMouseListener(new ButtonProperty(B1));
        B1.setFont(new Font("Tahoma",Font.BOLD,20));
        B1.setBackground(Color.DARK_GRAY);
        B1.setHorizontalAlignment(SwingConstants.CENTER);
        B1.setBounds(10, 10, 64, 64);
        B1.setOpaque(true);
        container.add(B1);
        
        B2=new JButtonComponent();
        B2.Field_value=2;
        B2.addMouseListener(new ButtonProperty(B2));
        B2.setFont(new Font("Tahoma",Font.BOLD,20));
        B2.setBackground(Color.DARK_GRAY);
        B2.setHorizontalAlignment(SwingConstants.CENTER);
        B2.setBounds(76, 10, 64, 64);
        B2.setOpaque(true);
        container.add(B2);
        
        B3=new JButtonComponent();
        B3.Field_value=3;
        B3.addMouseListener(new ButtonProperty(B3));
        B3.setFont(new Font("Tahoma",Font.BOLD,20));
        B3.setBackground(Color.DARK_GRAY);
        B3.setHorizontalAlignment(SwingConstants.CENTER);
        B3.setBounds(142, 10, 64, 64);
        B3.setOpaque(true);
        container.add(B3);
        
        B4=new JButtonComponent();
        B4.Field_value=4;
        B4.addMouseListener(new ButtonProperty(B4));
        B4.setFont(new Font("Tahoma",Font.BOLD,20));
        B4.setBackground(Color.DARK_GRAY);
        B4.setHorizontalAlignment(SwingConstants.CENTER);
        B4.setBounds(10, 76, 64, 64);
        B4.setOpaque(true);
        container.add(B4);
        
        B5=new JButtonComponent();
        B5.Field_value=5;
        B5.addMouseListener(new ButtonProperty(B5));
        B5.setFont(new Font("Tahoma",Font.BOLD,20));
        B5.setBackground(Color.DARK_GRAY);
        B5.setHorizontalAlignment(SwingConstants.CENTER);
        B5.setBounds(76, 76, 64, 64);
        B5.setOpaque(true);
        container.add(B5);
        
        B6=new JButtonComponent();
        B6.Field_value=6;
        B6.addMouseListener(new ButtonProperty(B6));
        B6.setFont(new Font("Tahoma",Font.BOLD,20));
        B6.setBackground(Color.DARK_GRAY);
        B6.setHorizontalAlignment(SwingConstants.CENTER);
        B6.setBounds(142, 76, 64, 64);
        B6.setOpaque(true);
        container.add(B6);
        
        B7=new JButtonComponent();
        B7.Field_value=7;
        B7.addMouseListener(new ButtonProperty(B7));
        B7.setFont(new Font("Tahoma",Font.BOLD,20));
        B7.setBackground(Color.DARK_GRAY);
        B7.setHorizontalAlignment(SwingConstants.CENTER);
        B7.setBounds(10, 142, 64, 64);
        B7.setOpaque(true);
        container.add(B7);
        
        B8=new JButtonComponent();
        B8.Field_value=8;
        B8.addMouseListener(new ButtonProperty(B8));
        B8.setFont(new Font("Tahoma",Font.BOLD,20));
        B8.setBackground(Color.DARK_GRAY);
        B8.setHorizontalAlignment(SwingConstants.CENTER);
        B8.setBounds(76, 142, 64, 64);
        B8.setOpaque(true);
        container.add(B8);
        
        B9=new JButtonComponent();
        B9.Field_value=9;
        B9.addMouseListener(new ButtonProperty(B8));
        B9.setFont(new Font("Tahoma",Font.BOLD,20));
        B9.setBackground(Color.DARK_GRAY);
        B9.setHorizontalAlignment(SwingConstants.CENTER);
        B9.setBounds(142, 142, 64, 64);
        B9.setOpaque(true);
        container.add(B9);
        
        btnNewgame=new JButton("New Game");
        btnNewgame.addActionListener(this);
        btnNewgame.setBounds(10, 216, 197, 23);
        container.add(btnNewgame);
        
        lblxWins = new JLabel("0");
	lblxWins.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblxWins.setBounds(314,13,169,36);
	container.add(lblxWins);

	lbloWins = new JLabel("0");
	lbloWins.setFont(new Font("Tahoma", Font.BOLD, 17));
	lbloWins.setBounds(314,46,169,36);
	container.add(lbloWins);

	lblDraws = new JLabel("0");
	lblDraws.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblDraws.setBounds(314,84,169,30);
	container.add(lblDraws);
               
        lblxWins_new = new JLabel("X wins:");
	lblxWins_new.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblxWins_new.setHorizontalAlignment(SwingConstants.RIGHT);
	lblxWins_new.setBounds(226, 13, 76, 36);
	container.add(lblxWins_new);

	lbloWins_new = new JLabel("O wins:");
	lbloWins_new.setFont(new Font("Tahoma", Font.BOLD, 17));
	lbloWins_new.setHorizontalAlignment(SwingConstants.RIGHT);
	lbloWins_new.setBounds(236,46,66,36);
	container.add(lbloWins_new);

	lblDraws_new = new JLabel("Draws:");
	lblDraws_new.setFont(new Font("Tahoma", Font.BOLD, 17));
	lblDraws_new.setHorizontalAlignment(SwingConstants.RIGHT);
	lblDraws_new.setBounds(226,84,76,30);
	container.add(lblDraws_new);
    }
        
        class ButtonProperty extends MouseAdapter
        {
            JButtonComponent sender;
            public ButtonProperty(JButtonComponent sender)
            {
                this.sender=sender;
            }
        
            public void mouseReleased(MouseEvent event)
            {
                int Game_Over=object.isGameOver();
                if(object.move(sender.Field_value, 1) && Game_Over==0)
                {
                    sender.setForeground(Color.PINK);
                    sender.setText("X");
                    computer_work(-1, Color.BLUE, 0);
                    //following condition will check if the game is over or not and it will calculate the points accordingly
                    if((Game_Over=object.isGameOver())!=0)
                    {
                        Point_Counters(Game_Over);
                    }
                }
            }
        }
        
        void computer_work(int player, Color move_color, int move)
        {
            //the following condition is more important here as it is going to set the text color and the background color on panel
            if(move==0)
            {
                move=object.isGameOver()==0 ? object.Gen_Move(player) : 0;
                String comp_move_text=(player==1)? "X" : "O";
                
                switch(move)
                {
                    case 1:
                        B1.setForeground(move_color);
                        B1.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 2:
                        B2.setForeground(move_color);
                        B2.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 3:
                        B3.setForeground(move_color);
                        B3.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 4:
                        B4.setForeground(move_color);
                        B4.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 5:
                        B5.setForeground(move_color);
                        B5.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 6:
                        B6.setForeground(move_color);
                        B6.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 7:
                        B7.setForeground(move_color);
                        B7.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 8:
                        B8.setForeground(move_color);
                        B8.setText(comp_move_text);
                        object.move(move, player);
                        break;
                    case 9:
                        B9.setForeground(move_color);
                        B9.setText(comp_move_text);
                        object.move(move, player);
                        break;
                }
            }
        }
        
        //this method is used to print the values of who won the match between human and a computer
        public void Point_Counters(int value)
        {
            switch(value)
            {
                case 1:
                    xWins++;
                    break;
                case -1:
                    oWins++;
                    break;
                case 2:
                    draws++;
                    break;
                case 0:
                    xWins=0;
                    oWins=0;
                    draws=0;
                    break;
            }
            //this will print the result on the board with the respected values
            lblxWins.setText(xWins + " ");
            lbloWins.setText(oWins + " ");
            lblDraws.setText(draws + " ");
        }
    }
