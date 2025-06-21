// import
import java.util.ArrayList;

public class BudgetList
{
    // instance
    private ArrayList<Category> categories;
    private ArrayList<Expense> expenses;

    // constructor
    public BudgetList() {
        categories = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    // add a category to the category list if it doesn't exist
    public void addCategory(String name, double budget) 
    {
        //loop to see if a category is in the list
        boolean contains = false;
        for(Category category: categories)
        {
            if(category.getName().equalsIgnoreCase(name))
            {
                contains = true;
                break;
            }
        }

        if(contains == true)
        {
            System.out.println("Category already exist");
        }
        else
        {
            categories.add(new Category(name, budget));
            System.out.println("Category added: " + name + " with a budget of $" + budget);
        }
    }

    // find and return a category by its name
    public Category findCategory(String name) 
    {
        for (Category category : categories) 
        {
            if (category.getName().equalsIgnoreCase(name)) 
            {
                return category;
            }
        }
        return null;
    }

    //find the index of the expense/category
    public int findCategoryIndex(String name) 
    {
        for (int i = 0; i < categories.size(); i ++) 
        {
            if (categories.get(i).getName().equalsIgnoreCase(name)) 
            {
                return i;
            }
        }
        return -1;
    }
    public int findExpenseIndex(String name) 
    {
        for (int i = 0; i < expenses.size(); i ++) 
        {
            if (expenses.get(i).getName().equalsIgnoreCase(name)) 
            {
                return i;
            }
        }
        return -1;
    }

    //  add an expense to the list & increase the amount used
    public void addExpense(String name, String categoryName, double amount, String date) 
    {
        Category category = findCategory(categoryName);
        if (category != null) 
        {
            Expense expense = new Expense(name, category, amount, date);
            expenses.add(expense);
            category.addExpense(amount);
            System.out.println("Expense added: " + expense);

            if (category.isOverBudget()) {
                System.out.println("This category went over the budget! Total expenses: $" + category.getTotalExpenses());
            }
        } 
        else 
        {
            System.out.println("The Category you entered doesn't exist, add it first or enter the correct one.");
        }
    }

    // Shows the categories-expenses
    public void viewSheet() 
    {
        System.out.println("\n--- Categories ---");
        
        for (Category category : categories) 
        {
            System.out.println(category);
        }

        System.out.println("\n--- Expenses ---");
        for (Expense expense : expenses) 
        {
            System.out.println(expense);
        }
    }

    //removes a category-expense
    public void removeCategory(int categoryIndex) 
    {
        //if the list isn't empty and the index is inbounds
        if((categories != null) && (categoryIndex >= 0 && categoryIndex < categories.size()))
        {    
            boolean has = false;
            //check whether expenses has this category, so it can't delete if it has
            for(Expense expense: expenses)
            {
                if (expense.getCategory().equals(categories.get(categoryIndex).getName())) 
                {
                    has = true; 
                    break; 
                }
            }
            if(!has)
            {
                System.out.println("Removed category" + categories.get(categoryIndex));
                categories.remove(categoryIndex);
            }
            else
            {
                System.out.println("This category has an expense active, so it cannot be deleted.");
            }
        }
        else
        {
            System.out.println("Add the category first");
        }
    }

    public void removeExpense(int expenseIndex) 
    {
        if((expenses != null) && (expenseIndex >= 0 && expenseIndex < expenses.size()))
        {
            System.out.println("Removed expense " + expenses.get(expenseIndex));
            expenses.remove(expenseIndex);
        }
        else
        {
            System.out.println("Add the expense first");
        }
    }
}
