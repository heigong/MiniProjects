import java.util.Scanner;

/*
 * Week 1: Console Application
- Display "What's the billing amount?"
- Wait for user input, e.g. 10
- Display "What's the percentage you want to tip?"
- Wait for user input, e.g. 20
- Display "How many people?"
- Wait for user input, e.g. 2
- Display the total, e.g. 12
- Display the total per person, e.g. 6
- Display "Do you want to continue?(Y/N)"
- Wait for input, e.g. Y
- Start another round
- or N, exit.
Day 1: Understand what is console application. Implementation, be careful of input validation. Commit codes.
Study Point:
Know how to create project
Know how to create classes
Know how to run the project in Eclipse.
Day 2: Build jar file. Run the jar in Command Line. Cross Review, find bugs.
Know how to build jar file.
Know how to run jar in terminal(Command Line).
Be able to think of thorough test cases.
Be able to find bug using test cases.
Day 3: Learn how to debug, set breakpoint, step over, step into, etc. If there is bugs, try to debug and find the reason.
Know how to debug.
Day 4(Advanced): Understand what is command line parameters. Modify existing code to support command line parameters.
e.g. -a Bill Amount
-p Tip Percentage
-n Number of Splits
If any of these parameters is missing, then ask user to input. If all are provided, display the result directly.
 * */
public class TipCalculator {

	public static void main(String[] args) {
		
		boolean done = false;
		
		while(!done){
			// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			
			System.out.println("What's the billing amount?");
			
			done = false;
			double amount = 0;
			while(!done){
				try{
					amount = scan.nextDouble();
					done = true;
				}
				catch(Exception ex){
					System.out.println("Invalid input, please enter your amount:");
					
					// NOTE: This is important to clear previous buffer.
					scan.next();
				}
			}
			
			System.out.println("What's the percentage you want to tip?");
			
			done = false;
			double percentage = 0;
			while(!done){
				try{
					percentage = scan.nextDouble();
					done = true;
				}
				catch(Exception ex){
					System.out.println("Invalid input, please enter your tip percentage:");
					
					// NOTE: This is important to clear previous buffer.
					scan.next();
				}
			}
			
			System.out.println("How many people?");
			
			done = false;
			int numberOfPeople = 0;
			while(!done){
				try{
					numberOfPeople = scan.nextInt();
					done = true;
				}
				catch(Exception ex){
					System.out.println("Invalid input, please enter number of people:");
					
					// NOTE: This is important to clear previous buffer.
					scan.next();
				}
			}
			
			double total = amount * (1 + percentage/100);
			System.out.println("Total is: " + total);
			
			double totalPerPerson = total/numberOfPeople;
			System.out.println("Total per person is: " + totalPerPerson);
			
			System.out.println();
			System.out.println("Do you want to continue? (Y/N)");
			
			String answer = null;
			done = false;
			while(!done){
				
				// TODO: Figure out why scan.nextLine() is working here.				
				answer = scan.next();

				if(answer.equals("N")){
					done = true;
					break;
				}
				else if(answer.equals("Y")){
					break;
				}
				else{
					System.out.println("Invalid input, please enter 'Y'(Yes) or 'N'(No).");
				}
			}
			
			System.out.println();
		}

	}

}
