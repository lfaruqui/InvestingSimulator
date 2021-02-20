import java.util.Random;
public class CryptoCurrency extends Investment implements Volatile{
    public CryptoCurrency(String newName)
    {
        super(newName);
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
                setBuyPrice(-5.00);
            }
            else if(check == 101)
            {
                setBuyPrice(5.00);
            }
            else if(check > 50 && check < 101)
            {
                setBuyPrice(-1.00);
            }
            else
            {
                setBuyPrice(1.00);
            }
        }
    }
    @Override
    public void appraise()
    {
        Random rand = new Random();
        setInitialPrice(rand.nextInt(10000) + 100);
        setBuyPrice(getInitialPrice());
    }
}
