package frontend.coin;

import javax.swing.JLabel;
import gameNav.*;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Displays the dogecoin! Ok... maybe not the doge coin at first
 * 
 * @author Justin
 * @since 4/13/21
 * @category frontend.coin
 */
public class CoinDisplay extends JLabel 
{
    private static final long serialVersionUID = 0;

    /**
     * Constructs a coin!
     */
    public CoinDisplay() 
    {
        super();
        this.updateImage();
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBounds(700, 150, 500, 350);
        //this.setPreferredSize(new Dimension(500, 350));

        /*
            Responds to button clicks.
            Translated bc I can't read this java mess:

            this.addEventListener("click", () => {
                PlayerActions.click();
            })
        */
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                PlayerActions.click();
            }

            //Yes we're never going to use you smh
            //Pls stop with the warnings pls vsc 🥺
            public void mouseExit(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }
        });
    }

    /**
     * Update the coin display image according to the player's current coin
     */
    public void updateImage() 
    {
        this.setIcon(new ImageIcon(new ImageIcon(Player.getCoin().getImage()).getImage().getScaledInstance(350, 350, 16)));
    }
}