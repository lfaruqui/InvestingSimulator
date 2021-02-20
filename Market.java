import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class Market {
    private int days = 1;
    private Investor player;
    public void simulate()//runs game
    {
        System.out.println("Welcome to the investing simulation game.\nMake your character:");
        makeACharacter();
        makeAStock();
        if(player instanceof Newbie)
        {
            newbieGame();
        }
        else if(player instanceof Casual)
        {
            casualGame();
        }
        else
            {
                expertGame();
            }
    }
    public void sell()//takes input and removes investment from list
    {
        Scanner in = new Scanner(System.in);
        int input;
        player.printStats();
        System.out.println("Choose an investment to remove from your portfolio.");
        try
        {
            input=in.nextInt();
        }
        catch (InputMismatchException e)
        {
            Random rand = new Random();
            input = rand.nextInt(player.getPortfolio().size()) + 1;
            System.out.println("Sort that was an invalid input. The following investment will be removed: " + player.getPortfolio().get(input - 1).getName());
        }
        player.changeBalance(player.getPortfolio().get(input-1).getBuyPrice());
        player.getPortfolio().remove(input - 1);
    }
    public void newbieGame()
    {
        int input = 0;
        while(input != 4)
        {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \nDay " + days);
            player.printStats();
            if(player.getPortfolio().size() > 3)
            {
                System.out.println("Please choose an investment to discard.");
                sell();
            }
            else if(player.getPortfolio().size() == 0)
            {
                System.out.println("Please buy an investment.");
                makeAStock();
            }
            input = prompt();
            if(input == 1)
            {
                makeAStock();
            }
            else if(input == 2)
            {
                sell();
            }
            else if(input == 3)
            {
                hold();
                days ++;
            }
            else if(input > 4)
                {
                    System.out.println("Invalid input. You will hold for a day.");
                }
        }
        System.out.println("Thanks for playing! \n Your final stats were: ");
        player.printStats();
    }
    public void casualGame()
    {
        int input = 0;
        while(input != 4)
        {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \nDay " + days);
            player.printStats();
            if(player.getPortfolio().size() > 5)
            {
                System.out.println("Please choose an investment to discard.");
                sell();
            }
            else if(player.getPortfolio().size() == 0)
            {
                System.out.println("Please buy an investment.");
                makeAStock();
            }
            input = prompt();
            if(input == 1)
            {
                makeAStock();
            }
            else if(input == 2)
            {
                sell();
            }
            else if(input == 3)
            {
                hold();
                days ++;
            }
            else if(input > 4)
            {
                System.out.println("Invalid input. You will hold for a day.");
            }
        }
        System.out.println("Thanks for playing! \n Your final stats were: ");
        player.printStats();
    }
    public void expertGame()
    {
        int input = 0;
        while(input != 4)
        {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \nDay " + days);
            player.printStats();
            if(player.getPortfolio().size() > 10)
            {
                System.out.println("Please choose an investment to discard.");
                sell();
            }
            else if(player.getPortfolio().size() == 0)
            {
                System.out.println("Please buy an investment.");
                makeAStock();
            }
            input = prompt();
            if(input == 1)
            {
                makeAStock();
            }
            else if(input == 2)
            {
                sell();
            }
            else if(input == 3)
            {
                hold();
                days ++;
            }
            else if(input > 4)
            {
                System.out.println("Invalid input. You will hold for a day.");
            }
        }
        System.out.println("Thanks for playing! \nYour final stats were: ");
        player.printStats();
    }
    public void hold()//simulates a days worth of changes
    {
        System.out.println("You chose to hold for a day.");
        for(Investment i: player.getPortfolio())
        {
            i.change();
        }
    }
    public void makeAStock()//asks for input to make investment object
    {
        Scanner in = new Scanner(System.in);
        String ticker;
        int type;
        Investment temp;
        System.out.println("Type a name for your investment:");
        ticker = in.next();
        System.out.println("What type of investment would you like?\n 1. Stock \n 2. ETF \n 3. Crypto");
        try
        {
            type = in.nextInt();
            chooseAStock(type, ticker);
        }
        catch (InputMismatchException e)
        {
            System.out.println("That was an invalid input, you get an ETF.");
            player.getPortfolio().add(new ETF(ticker));
        }
        temp =   player.getPortfolio().get((player.getPortfolio().size()) - 1);
        System.out.println( temp.getName() + " is worth $" + temp.getBuyPrice() + "!");
    }
    public void chooseAStock(int i, String s)
    {

        if(i == 1)
        {
            player.getPortfolio().add(new Stock(s));
        }
        else if (i == 2)
        {
            player.getPortfolio().add(new ETF(s));
        }
        else if(i == 3)
        {
            player.getPortfolio().add(new CryptoCurrency(s));
        }
        else
            {
                System.out.println("That was an invalid input, you get an ETF.");
                player.getPortfolio().add(new ETF(s));
            }
    }

    public int prompt()//asks what to do each round, uses scanner for input
    {
        Scanner in = new Scanner(System.in);
        int input ;
        System.out.println("Would you like to: \n 1. Buy \n 2. Sell \n 3. Hold \n 4. Quit");
        try
        {
            input=in.nextInt();
            return input;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Sorry, that was an invalid input. You will hold for a day.");
            return 3;
        }

    }
    public void makeACharacter()//prompts, gets name, makes character based on difficulty
    {
        Scanner in = new Scanner(System.in);
        String str;
        int input;
        System.out.println("What is your name?");
        str = in.next();
        System.out.println("Which best describes your investing experience?(Input the corresponding number) \n 1:Newbie \n 2:Casual \n 3:Expert ");
        try
        {
            input = in.nextInt();
            chooseDifficulty(input, str);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Sorry, that was an invalid input! You will begin as a newbie!");
            player = new Newbie(str);
            System.out.println("Great! You can have up to three investments at a time and now you can choose your very first investment! ");
        }
    }
    public void chooseDifficulty(int i, String name)// takes input and initializes player object
    {
        if(i == 1)
        {
            player = new Newbie(name);
            System.out.println("Great! You can have up to three investments at a time and now you can choose your very first investment! ");
        }
        else if(i == 2)
        {
            player = new Casual(name);
            System.out.println("Great! You can have up to five investments at a time and now you can choose your very first investment! ");
        }
        else if(i == 3)
        {
            player = new Expert(name);
            System.out.println("Great! You can have up to ten investments at a time and now you can choose your very first investment! ");
        }
        else
        {
            player = new Newbie(name);
            System.out.println("It seems you are a newbie.");
            System.out.println("You can have up to three investments at a time and now you can choose your very first investment! ");
        }
    }
}
