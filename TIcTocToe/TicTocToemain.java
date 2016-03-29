package TIcTocToe;
/**
 * Basic Tic Tac Toe Game.
 * This is main class that runs the game 
 * For player needs double click the the mouse to change turn. 
 */
import javax.swing.JFrame;

public class TicTocToemain {


	public static void main(String[] args) {
		
		JFrame f = new GameBoard();
		f.setTitle("TicTocToe Game");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
	}
}
