import java.util.InputMismatchException;
import java.util.Scanner;

public class BudgetCreation 
{
    public static void main(String[] args) 
    {
        BudgetList tracker = new BudgetList();
        userInput();
    }

    //class variable
    private static BudgetList tracker = new BudgetList();

    //asks for user input
    public static void userInput()
    {
        Scanner scanner = new Scanner(System.in);

        boolean on = true;
        //loops until turned off
        while (on) 
        {
            //instructions
            System.out.println("\n--- Creating a budget (Options) ---");
            System.out.println("1. Add a Category");
            System.out.println("2. Add an Expense");
            System.out.println("3. Delete a Category");
            System.out.println("4. Delete an Expense");
            System.out.println("5. View Sheet");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine(); 

            //instruction to choice
            switch (userChoice) 
            {
                case 1:
                    System.out.print("Enter category name: ");
                    String categoryName = scanner.nextLine();
                    //handle exeption
                    while (true) 
                    { 
                        try
                        {
                            System.out.print("Enter category budget: ");
                            double budget = scanner.nextDouble();
                            tracker.addCategory(categoryName, budget);
                            break;
                        }
                        catch(InputMismatchException e)
                        {
                            scanner.nextLine();
                            System.out.println("Please, NUMBERS ONLY!");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter expense name: ");
                    String expenseName = scanner.nextLine();
                    System.out.print("Enter category name: ");
                    categoryName = scanner.nextLine();
                    // handle exeption again
                    while (true) 
                    { 
                        try
                        {
                            System.out.print("Enter expense amount: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); 
                            System.out.print("Enter expense date (mm-dd-yyyy): ");
                            String date = scanner.nextLine();
                            tracker.addExpense(expenseName, categoryName, amount, date);
                            break;
                        }
                        catch(InputMismatchException e)
                        {
                            scanner.nextLine();
                            System.out.println("Please, NUMBERS ONLY!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter category name: ");
                    String deleteCategoryName = scanner.nextLine();
                    tracker.removeCategory(tracker.findCategoryIndex(deleteCategoryName));
                    break;

                case 4:
                    System.out.print("Enter expense name: ");
                    String deleteExpenseName = scanner.nextLine();
                    tracker.removeExpense(tracker.findExpenseIndex(deleteExpenseName));
                    break;

                case 5:
                    tracker.viewSheet();
                    break;

                case 6:
                    on = false;
                    System.out.println("Turning Off.");
                    break;
                default:
                    System.out.println("You can only choose between 1-6 (including 1 & 6).");
            }
        }

        scanner.close();
    }
}
