import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BillCalcParameter 
{
  private static String answerContinue = "Y";
  
  public static void main(String[] args)
  { 
    Utils utils = new Utils();
    Map<String, String> inputMap = utils.getPairInput(args);
    while (answerContinue.equals("Y"))
    {
      BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
      double billAmount = 0;
      double billTipPercent = 0;
      double divideNumber = 1;
      try 
      {
          billAmount = Double.parseDouble(inputMap.get("-a"));
          answerContinue = "N";}
      catch(Exception ex) 
      {
          System.out.println("Invalid input for -a. Please input number for bill amount, e.g.");
          break;}
      try
      {
          billTipPercent = Double.parseDouble(inputMap.get("-p"));
          answerContinue = "N";}
      catch(Exception ex) 
      {
          System.out.println("Invalid input for -p. Please input number for tip percentage");
          break;}
      if (billTipPercent >= 1) billTipPercent /= 100;
      try
      {
          divideNumber = Double.parseDouble(inputMap.get("-n"));
          answerContinue = "N";}
      catch(Exception ex)
      {
          System.out.println("Invalid input for -n. Please input number for bill to be divided to");
          break;}
      double totalPay = billAmount * (1 + billTipPercent);
      double eachPay = totalPay / divideNumber;
      System.out.println("The total is " + totalPay);
      System.out.println("Each person should pay " + eachPay);
      /*
      boolean validAnswer = false;
      while(!validAnswer){
        try{
          System.out.println("Do you want to continue?(Y/N)");
          answerContinue = bufferRead.readLine();}
        catch(Exception ex){System.out.println("Invalid input. Please input Y or N.");}
        if (answerContinue.equalsIgnoreCase("Y") || answerContinue.equalsIgnoreCase("N")) validAnswer = true;
        else System.out.println("Invalid input. Please input Y or N.");
      }
      */
    }
    System.out.println("Thank you!"); 
    //answerContinue = "Y";
  }
}
