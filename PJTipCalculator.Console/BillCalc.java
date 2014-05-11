import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BillCalc 
{
	public static void main(String[] args)
    {	
		String answerContinue = "Y";
		while (answerContinue.equalsIgnoreCase("Y"))
		{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			double billAmount = 0;
			double billTipPercent = 0;
			double number = 0;
			boolean validAnswer = false;
			while(!validAnswer){
				try{
					System.out.println("What's the billing amount?(number only)");
					billAmount = Double.parseDouble(bufferRead.readLine());
					validAnswer = true;}
				catch(Exception ex){
					System.out.println("Invalid input. Please input numbers only");}
			}
			validAnswer = false;
			while(!validAnswer){
				try{
					System.out.println("What's the percentage you want to tip?(number only)");
					billTipPercent = Double.parseDouble(bufferRead.readLine());
					validAnswer = true;}
				catch(Exception ex){System.out.println("Invalid input. Please input numbers only");}
			}
		    if (billTipPercent >= 1) billTipPercent /= 100;
		    validAnswer = false;
		    while(!validAnswer){
		    	try{
		    		System.out.println("How many people?(number only)");
		    		number = Double.parseDouble(bufferRead.readLine());
		    		validAnswer = true;}
		    	catch(Exception ex){System.out.println("Invalid input. Please input numbers only");}
		    }
		    double totalPay = billAmount * (1 + billTipPercent);
		    double eachPay = totalPay / number;
		    System.out.println("The total is " + totalPay);
		    System.out.println("Each person should pay " + eachPay);
		    validAnswer = false;
		    while(!validAnswer){
		    	try{
		    		System.out.println("Do you want to continue?(Y/N)");
		    		answerContinue = bufferRead.readLine();}
		    	catch(Exception ex){System.out.println("Invalid input. Please input Y or N.");}
		    	//answerContinue.toUpperCase();
		    	if (answerContinue.equalsIgnoreCase("Y") || answerContinue.equalsIgnoreCase("N")) validAnswer = true;
		    	else System.out.println("Invalid input. Please input Y or N.");
		    }
		}
		System.out.println("Thank you!");	
    }
}
