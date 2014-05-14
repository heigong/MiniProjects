import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BillCalcParameter 
{
  private static Map<String, String> inputMap = new HashMap<String, String>();  
  private static String answerContinue = "Y";
  
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
    if (answerContinue.equals("Y"))
    {
      BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
      double billAmount = 0;
      double billTipPercent = 0;
      double divideNumber = 1;
      try {billAmount = Double.parseDouble(inputMap.get("-a"));}
      catch(Exception ex) {System.out.println("Invalid input for -a. Please input number for bill amount, e.g.");}
      try{billTipPercent = Double.parseDouble(inputMap.get("-p"));}
      catch(Exception ex) {System.out.println("Invalid input for -p. Please input number for tip percentage");}
      if (billTipPercent >= 1) billTipPercent /= 100;
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