package TIcTocToe;
/**
 * @author  Md. Facihul Azam   
 * 
 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GameBoard extends JFrame{
 // Whose Turn
	private char Turn = 'X';
	private boolean gameover = false;
	// Create Board 
	
		public Cell[][] cells = new Cell[3][3];
// Create Status label
	JLabel jlbstatus = new JLabel("X's turn ");  
	public GameBoard(){
		
		JPanel panel = new JPanel(new GridLayout(3,3,0,0)); 
		for (int i = 0; i<3; i++ )
			for(int j = 0; j<3; j++)
				panel.add(cells[i][j] = new Cell());
		
				panel.setBorder(new LineBorder(Color.red, 1));
				jlbstatus.setBorder(new LineBorder(Color.GREEN,1));
				add(panel, BorderLayout.CENTER);
				add(jlbstatus, BorderLayout.SOUTH); 
				
			
		} 

	/*
	 * determines whether board is full. 
	 * @return true if board id full, otherwise false 
	 */
	
	public boolean boardstaus(){
		for (int i = 0; i<3; i++ )
			for(int j = 0; j<3; j++)
				if(cells[i][j].getToken() ==  ' ')
				    return false;
		return true;        
	}

		/*
		 * @param token 
		 * return 
		 */
		public boolean Win(char token){
			
		// Row wise check 
			for(int i = 0; i<3; i++)
				if((cells[i][0].getToken() ==  token)
					&& (cells[i][1].getToken() ==  token)
					&& (cells[i][2].getToken() ==  token))
				{	
				    return true;
		     	}
			
			// column wise check 
					for(int i = 0; i<3; i++)
						if((cells[0][i].getToken() ==  token)
							&& (cells[1][i].getToken() ==  token)
							&& (cells[2][i].getToken() ==  token))
						{	
						    return true;
					    }
						
		   // diagonal wise check 
				
						if((cells[0][0].getToken() ==  token)
							&& (cells[1][1].getToken() ==  token)
							&& (cells[2][2].getToken() ==  token))
						{	
						    return true;
						}
						
						if((cells[0][2].getToken() ==  token)
								&& (cells[1][1].getToken() ==  token)
								&& (cells[2][0].getToken() ==  token))
						{	
							    return true;	
						}
					
			return false;
		}
		
	
		public class Cell extends JPanel{
			
			private char token = ' ';
			
			
			public Cell(){
				setBorder(new LineBorder(Color.black,1));
				addMouseListener(new MyMouseListner());
				
			}
			
			public char getToken(){
				
				return token;	
				
			}
		   
			public void setToken(char c){
				
				token = c ; 
				repaint();
				
			}
			
			
			@Override 
			protected void paintComponent(Graphics g){
				
				super.paintComponent(g);
				if(token == 'X'){
					g.drawLine(10, 10, getWidth()-10, getHeight()-10);
					g.drawLine(getWidth()-10, 10, 10, getHeight()-10);
					
				}
				else if (token == 'O'){
					g.drawOval(10, 10, getWidth()-20, getHeight()-20);
					
					
				}
				
				
			}
			
    	private class MyMouseListner extends MouseAdapter {
				
				 
				public void mouseClicked(MouseEvent e){
				  	if(gameover)
                       return ;					
				  	else if(token == ' ' && Turn != ' ' )
						setToken(Turn);
					else if(Win(Turn)){
						jlbstatus.setText(Turn + "Won The game");
						Turn = ' '; 
						gameover= true;
					}
					else if (boardstaus()){
						jlbstatus.setText("Game Tie");
						Turn = ' '; 
						gameover = true;
					}
					else {
						Turn = (Turn == 'X') ? 'O': 'X';
						jlbstatus.setText(Turn + "'s Turn");
					}
				
				}
				
			} // End of MyMouseListner Class
			
			
			

		} // End of Cell Class
	
	} // End of GameBoard




