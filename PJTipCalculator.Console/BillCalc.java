import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BillCalc 
{
	public static void main(String[] args)
    {		
		try{
			String answerContinue = "Y";
			while (answerContinue.equals("Y"))
			{
				System.out.println("What's the billing amount?(number only)");
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				double billAmount = Double.parseDouble(bufferRead.readLine());
				System.out.println("What's the percentage you want to tip?(number only)");
		    	double billTipPercent = Double.parseDouble(bufferRead.readLine());
		    	if (billTipPercent >= 1) billTipPercent /= 100;
		    	System.out.println("How many people?(number only)");
		    	double number = Double.parseDouble(bufferRead.readLine());
		    	double totalPay = billAmount * (1 + billTipPercent);
		    	double eachPay = totalPay / number;
		    	System.out.println("The total is " + totalPay);
		    	System.out.println("Each person should pay " + eachPay);
		    	System.out.println("Do you want to continue?(Y/N)");
		    	answerContinue = bufferRead.readLine();
		    	if (answerContinue.equals("y")) answerContinue = "Y";
		    	//if (answerContinue == "Y") System.out.println("let's do it again!");
		    }
			System.out.println("Thank you!");
		}
			
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
    }
}
