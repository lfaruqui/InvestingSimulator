import java.util.Random;
public class Investment implements Volatile {
    private double initialPrice;
    private double buyPrice;
    private String name;
    public Investment(String newName)
    {
        name = newName;
    }
    public String getName()
    {
        return name;
    }
    public double getPercentDifference()
    {
        return ((buyPrice - initialPrice)/initialPrice) * 100;
    }
    public double getInitialPrice()
    {
        return initialPrice;
    }
    public void setInitialPrice(double num)
    {
        initialPrice = num;
    }
    public double getBuyPrice()
    {
        return buyPrice;
    }
    public void setBuyPrice(double num)
    {
        buyPrice = buyPrice + num;
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
                buyPrice -= .50;
            }
            else if(check == 101)
            {
                buyPrice += .50;
            }
            else if(check > 50 && check < 101)
            {
                buyPrice -= .01;
            }
            else
            {
                buyPrice += .01;
            }
        }
    }
    @Override
    public void appraise()
    {
        Random rand = new Random();
        initialPrice = (rand.nextInt(1000) + 5.00);
        buyPrice = initialPrice;
    }
}
