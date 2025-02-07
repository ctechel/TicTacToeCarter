import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private Image[] tileImages;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;
    private TicTacToe game;
    public TicTacToeViewer(TicTacToe game)
    {
        tileImages = new Image[2];
        tileImages[0] = new ImageIcon("Resources/O.png").getImage();
        tileImages[1] = new ImageIcon("Resources/X.png").getImage();
        this.game = game;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getTileImages() {
        return tileImages;
    }

    public TicTacToe getGame() {
        return game;
    }

    public void paint(Graphics g)
    {
        Square[][] squares = game.getBoard();
        // Draws the board
        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[0].length; j++)
            {
                game.getBoard()[i][j].draw(g);
            }
        }
        g.drawString("0", 150, 75);
        g.drawString("1", 250, 75);
        g.drawString("2", 350, 75);
        g.drawString("0", 50, 150);
        g.drawString("1", 50, 250);
        g.drawString("2", 50, 350);

        if (game.getGameOver())
        {
            if (game.getWinner() == TicTacToe.X_MARKER)
            {
                g.setFont(new Font("Serif", Font.PLAIN, 80));
                g.drawString("X Wins!", 125, 475);
            }
            else if (game.getWinner() == TicTacToe.O_MARKER)
            {
                g.setFont(new Font("Serif", Font.PLAIN, 80));
                g.drawString("O Wins!", 125, 475);
            }
            else
            {
                g.setFont(new Font("Serif", Font.PLAIN, 40));
                g.drawString("Game ends in a tie!", 100, 450);
            }
        }
    }
}
