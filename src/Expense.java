public class Expense extends LazyName
{
    // instances
    private Category category;
    private double amount;
    private String date; //should be mm-dd-yyyy

    // constructor
    public Expense(String name, Category category, double amount, String date) 
    {
        super(name);
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // getters-setter
    public String getCategory() 
    {
        return category.getName();
    }

    public double getAmount() 
    {
        return amount;
    }

    public String getDate() 
    {
        return date;
    }

    // returns true or false depending if it's over-under budget
    public boolean isOverBudget() {
        return amount > category.getBudget();
    }

    // clear view
    @Override
    public String toString() {
        return "Name: " + super.getName() + " | Category: " + category.getName() + " | Amount: $" + amount + " on " + date;
    }
}
