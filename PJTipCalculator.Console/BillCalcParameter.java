import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BillCalcParameter 
{
  private static Map<String, String> inputMap = new HashMap<String, String>();  
  private static String answerContinue = "Y";
  
    // 2014-05-14 [CD]:
    // 1. Add a class named Utils, and change this method to below and add to Utils class.
    //
    // public static Map<String, String> getPairInput(String[] args), return a dictionary of parameters
    //
    // Reason: This method is a common one, can be used for all projects.
    //
    // 2. A static method ususally doesn't involved in static variable, because it will be used everywhere.
    //
    // Here two static variables is involved, inputMap and answerContinue.
    //
    // 3. A static method usually doesn't involved in business logic.
    //
    // e.g. The three println() are asking input especially for BillCalculator.
    // e.g. answerContinue is set, this variable is especially for BillCalculator
    //
    // 4. Only use try catch when you know there will be an exception.
    //
    // To make it easy, we can assume the parameters are paired.  There is no single option mark without value, e.g. '-a -b -c'
    // That will be complicate and not the purpose for this project.
    //
    // With this assumption, you won't get any exception in this method.
  private static void getPairInput(String[] args)
  {
      try{for (int i = 0; i < args.length; i += 2) inputMap.put(args[i], args[i+1]);}
      catch(Exception ex){
          System.out.println("Please show all parameters to the program");
          System.out.println("-a billAmount, -p tipPercentage, -n divideNumber");
          System.out.println("for billAmount, tipPercentage and divideNumber, please input numbers only");
          answerContinue = "N";
      }
  }
  
  public static void main(String[] args)
  { 
    getPairInput(args);
      
      // 2014-05-14 [CD]: Do you meant to use while()?
    if (answerContinue.equals("Y"))
    {
      BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
      double billAmount = 0;
      double billTipPercent = 0;
      double divideNumber = 1;
        
        // 2014-05-14 [CD]: If -a is not provide, should ask him to input, like what we do before:
        /*
         boolean validAnswer = false;
         while(!validAnswer){
         try{
         System.out.println("What's the billing amount?(number only)");
         billAmount = Double.parseDouble(bufferRead.readLine());
         validAnswer = true;}
         catch(Exception ex){
         System.out.println("Invalid input. Please input numbers only");}
         }
         */
      try {billAmount = Double.parseDouble(inputMap.get("-a"));}
      catch(Exception ex) {System.out.println("Invalid input for -a. Please input number for bill amount, e.g.");}
        
        //  2014-05-14 [CD]: Same as above, if -p is not provide, should ask him to input
      try{billTipPercent = Double.parseDouble(inputMap.get("-p"));}
      catch(Exception ex) {System.out.println("Invalid input for -p. Please input number for tip percentage");}
      if (billTipPercent >= 1) billTipPercent /= 100;
        
        //  2014-05-14 [CD]: Same as above, if -n is not provide, should ask him to input
      try{divideNumber = Double.parseDouble(inputMap.get("-n"));}
      catch(Exception ex){System.out.println("Invalid input for -n. Please input number for bill to be divided to");}
      double totalPay = billAmount * (1 + billTipPercent);
      double eachPay = totalPay / divideNumber;
      System.out.println("The total is " + totalPay);
      System.out.println("Each person should pay " + eachPay);
      boolean validAnswer = false;
      while(!validAnswer){
        try{
          System.out.println("Do you want to continue?(Y/N)");
          answerContinue = bufferRead.readLine();}
        catch(Exception ex){System.out.println("Invalid input. Please input Y or N.");}
        if (answerContinue.equalsIgnoreCase("Y") || answerContinue.equalsIgnoreCase("N")) validAnswer = true;
        else System.out.println("Invalid input. Please input Y or N.");
      }
    }
    System.out.println("Thank you!"); 
    answerContinue = "Y";
  }
}
