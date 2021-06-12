package frontend.choiceBar.displays;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import gameNav.Player;

/**
 * Frontend class that displays a cover modal to update the coins!
 * Basically, Litecoin --> Dogecoin etc...
 * It'll cost alot of money tho.....
 * @author Justin
 * @since 6/7/21
 * @category frontend.choiceBar.displays
 */
public class CoinUpgrade extends Cover
{
    public CoinUpgrade()
    {
        super();

        JPanel centerPane = new JPanel();
        centerPane.setBorder(new EmptyBorder(40, 20, 40, 20));
        centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.PAGE_AXIS));
        centerPane.setBackground(Color.WHITE);

        JLabel title1 = new JLabel("Coin Upgrade!");
        title1.setFont(new Font("Trebuchet ms", Font.PLAIN, 48));
        Dimension tempDim = title1.getPreferredSize();
        tempDim.width = this.tpLength;
        title1.setPreferredSize(tempDim);
        //title1.setHorizontalAlignment(JLabel.RIGHT);
        title1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        centerPane.add(title1);
        
        //Const
        final int IMAGEWIDTH = 100;

        //jp1
        JPanel jp1 = new JPanel();
        jp1.setBackground(Color.WHITE);
        //jp1.setLayout(new BoxLayout(jp1, BoxLayout.LINE_AXIS));
        jp1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));

        int netWidth = this.tpLength - IMAGEWIDTH;

        JPanel jp1Word = new JPanel();
        jp1Word.setBackground(Color.WHITE);
        jp1Word.setLayout(new BoxLayout(jp1Word, BoxLayout.PAGE_AXIS));
        int prefHeight = jp1Word.getPreferredSize().height;
        jp1Word.setSize(netWidth, prefHeight);

        JLabel jp1Title = new JLabel(Player.getCoin().getName());
        jp1Title.setFont(new Font("Trebuchet ms", Font.BOLD, 22));

        JTextArea jp1Text = new JTextArea();
        jp1Text.setEditable(false);
        jp1Text.setWrapStyleWord(true);
        jp1Text.setLineWrap(true);
        jp1Text.setText("lorem ipsum dolor sit amet donut garcia me tree fee");
        jp1Text.setFont(new Font("Trebuchet ms", Font.PLAIN, 18));
        //Kinda took the shortcut here with abs size, because jtextarea is java is absurdly dumb
        //Like actually dumb. Responsive design goes poof
        jp1Text.setColumns(35); 
        //jp1Text.setSize(new Dimension(netWidth, jp1Text.getHeight()));

        jp1Word.add(jp1Title);
        jp1Word.add(jp1Text);

        JLabel jp1Img = new JLabel();
        ImageIcon imgIcon = new ImageIcon(new ImageIcon(Player.getCoin().getImage()).getImage().getScaledInstance(IMAGEWIDTH, IMAGEWIDTH, 16));
        jp1Img.setIcon(imgIcon);
        jp1Img.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jp1Img.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        jp1Img.setBorder(new EmptyBorder(10, 10, 0, 0));

        jp1.add(jp1Word);
        jp1.add(jp1Img);
        jp1.revalidate();
        jp1.repaint();

        //jp2
        JPanel jp2 = new JPanel();
        jp2.setBackground(Color.WHITE);
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));

        JPanel jp2Word = new JPanel();
        jp2Word.setBackground(Color.WHITE);
        jp2Word.setLayout(new BoxLayout(jp2Word, BoxLayout.PAGE_AXIS));
        int prefHeight1 = jp2Word.getPreferredSize().height;
        jp2Word.setSize(netWidth, prefHeight1);

        JLabel jp2Title = new JLabel(Player.getCoin().getName());
        jp2Title.setFont(new Font("Trebuchet ms", Font.BOLD, 22));

        JTextArea jp2Text = new JTextArea();
        jp2Text.setEditable(false);
        jp2Text.setWrapStyleWord(true);
        jp2Text.setLineWrap(true);
        jp2Text.setText("lorem ipsum dolor sit amet donut garcia me tree fee");
        jp2Text.setFont(new Font("Trebuchet ms", Font.PLAIN, 18));
        jp2Text.setColumns(35); 

        jp2Word.add(jp2Title);
        jp2Word.add(jp2Text);

        JLabel jp2Img = new JLabel();
        ImageIcon imgIcon2 = new ImageIcon(new ImageIcon(Player.nextCoin().getImage()).getImage().getScaledInstance(IMAGEWIDTH, IMAGEWIDTH, 16));
        jp2Img.setIcon(imgIcon2);
        jp2Img.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jp2Img.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        jp2Img.setBorder(new EmptyBorder(10, 10, 0, 0));

        jp2.add(jp2Word);
        jp2.add(jp2Img);
        jp2.revalidate();
        jp2.repaint();

        Cover dis = this;
        JButton btn = new JButton("Upgrade");
        btn.setBackground(Color.CYAN);
        btn.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                //To do: add doge coin
                //To do: Update frontend display again
                //Since we upgraded the coin, this getUnlockPrice woud be the unlock price of the coin we intended
                Player.upgradeCoin();
                Player.setCash(Player.getCash() - Player.getCoin().getUnlockPrice());
                dis.exit();
            }
        
            public void mouseReleased(MouseEvent e) {
            }
        
            public void mousePressed(MouseEvent e) {
            }
        
            public void mouseExited(MouseEvent e) {
            }
        
            public void mouseEntered(MouseEvent e) { 
                //Hex code
            }
        });
        btn.setBorder(new LineBorder(Color.BLUE));

        jp1.setBorder(new LineBorder(Color.BLACK));
        jp2.setBorder(new LineBorder(Color.BLACK));
        centerPane.add(jp1);
        centerPane.add(new JSeparator(JSeparator.HORIZONTAL));
        centerPane.add(jp2);
        centerPane.add(btn);
        
        this.getTextPanel().add(centerPane, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}
