import java.util.Random;
public class Stock extends Investment implements Volatile{
    public Stock(String newName)
    {
        super(newName) ;
        appraise();
    }
    @Override
    public void change()
    {
        int check;
        Random rand = new Random();
        for(int i = 0; i < 1000; i ++)
        {
            check = rand.nextInt(100 ) + 3;
            if(check == 102)
            {
                setBuyPrice(-1.00);
            }
            else if(check == 101)
            {
                setBuyPrice(1.00);
            }
            else if(check > 50 && check < 101)
            {
                setBuyPrice(-.25);
            }
            else
            {
                setBuyPrice(.25);
            }
        }
    }
    @Override
    public void appraise()
    {
        Random rand = new Random();
        setInitialPrice(rand.nextInt(500) + 40);
        setBuyPrice(getInitialPrice());
    }
}
