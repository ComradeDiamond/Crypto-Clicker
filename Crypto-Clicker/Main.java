import frontend.*;
import gameNav.Player;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        //I got really stuck with a java swing bug when trying to remove components ;-;
        //So I decided to jump ship and just make this workable one
        //Also that's why there seems to be extra methods
        Scanner leScan = new Scanner(System.in);
        System.out.println("Select a coin to get started!");
        System.out.println("Options: Bitcoin, Dogecoin, Litecoin, Pepecoin");
        System.out.println("If you're just gettings started try Dogecoin, the cryptocurrency that's so easy to mine, it's actively deflating");

        while(!Player.swapCoin(leScan.nextLine()))
        {}

        leScan.close();

        GUI game = new GUI();
        Player.setGUI(game);
    }
}