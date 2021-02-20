import java.util.Random;
public class ETF extends Investment implements Volatile{
    public ETF(String newName)
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
                 setBuyPrice(-.50);
            }
            else if(check == 101)
            {
                setBuyPrice(.50);
            }
            else if(check > 50 && check < 101)
            {
                setBuyPrice(-.01);
            }
            else if(check < 50)
                {
                    setBuyPrice(.01);
                }
        }
    }
    @Override
    public void appraise()
    {
        Random rand = new Random();
        setInitialPrice(rand.nextInt(20) + 10);
        setBuyPrice(getInitialPrice());
    }
}
