package frontend;
import javax.swing.*;

/**
 * Constructs a javax swing GUI for the app.
 * @author Justin
 * @since 4/12/21
 * @category frontend
 */
public class GUI extends JFrame
{
    private static final long serialVersionUID = 0;

    public GUI() throws Exception
    {
        super("Crypto Clicker");
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("./images/Dogecoin.png");
        this.setIconImage(icon.getImage());

        JLabel label = new JLabel("Crypto Clicker");
    }
}
