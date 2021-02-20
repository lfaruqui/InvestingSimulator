import java.util.ArrayList;
public class Investor {
    String name;
    private ArrayList<Investment> portfolio = new ArrayList<Investment>();
    private double balance;
    public Investor(String newName)
    {
        name = newName;
    }
    public void changeBalance(double num)
    {
        balance += num;
    }
    public ArrayList<Investment> getPortfolio()
    {
        return portfolio;
    }
    public void printStats()//prints name, day, sorted portfolio, percentage difference, and price(2 decimal places)
    {
        System.out.println("Player: " + name);
        mergeSort(portfolio);
        System.out.println("You have a balance of: $" + balance);
        System.out.println("Here is your portfolio:");
        int count = 0;
        for(Investment i : portfolio)
        {
            count ++;
            if(i.getPercentDifference() >= 0)
            {
                System.out.println(count + ": " + i.getName() + " (+"  + String.format("%.2f ",i.getPercentDifference())+ "%) @ $" + String.format("%.2f",i.getBuyPrice()));
            }
            else
                {
                    System.out.println(count + ": " + i.getName() + " ("  + String.format("%.2f ",i.getPercentDifference()) + "%) @ $" + String.format("%.2f",i.getBuyPrice()));
                }
        }

    }
    public void mergeSort(ArrayList<Investment> p)//sorts prices from min to max
    {
        if(p.size() <= 1)
        {
            return;
        }

        int mid = p.size()/2;
        ArrayList<Investment> left = new ArrayList<Investment>();
        ArrayList<Investment> right = new ArrayList<Investment>();
        for(int i = 0; i < mid; i++) {
            left.add(p.remove(0));
        }
        while (p.size()!=0){
            right.add(p.remove(0)); // put the remainings in right
        }
        mergeSort(left);
        mergeSort(right);
//merge
        while (left.size()!=0 && right.size()!=0) {
            if (left.get(0).getBuyPrice() < right.get(0).getBuyPrice()) {
                p.add(left.remove(0));
            }
            else {
                p.add(right.remove(0));
            }
        }

        while(left.size()!=0) {
            p.add(left.remove(0));
        }
        while(right.size()!=0) {
            p.add(right.remove(0));
        }

    }

}
