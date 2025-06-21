public class Category extends LazyName
{
    //instance 
    double budget;
    double totalExpenses = 0.0;

    //constructor
    public Category(String name, double budget)
    {
        super(name);
        this.budget = budget;
    }

    //getters
    public double getBudget() {
        return budget;
    }
    public double getTotalExpenses()
    {
        return totalExpenses;
    }

    //setter 
    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString()
    {
        return "Name: " + super.getName() + " | Budget: " + budget + " | Total Expenses: " + totalExpenses;
    }

    //add up the amount
    public void addExpense(double amount) {
        totalExpenses += amount;
    }

    public boolean isOverBudget()
    {
        return totalExpenses >= budget;
    }

}
