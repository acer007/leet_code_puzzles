// Win an award (or not) depending on whether the user input matches the 
// winning lottery numbers

import java.util.Scanner;

public class LotteryDigits{
    
    public static void main (String args[]){
        
        try{
            
            //Declare Scanner
            Scanner scanInput = new Scanner(System.in);
            int guess1 = 0;
            int guess2 = 0;
            int guess3 = 0;
            boolean sentinel1 = true, loop1 = true;
            
            
            //Generate lottery numbers
            int lotNum1 = (int)(Math.random() * 100);
            int lotNum2 = (int)(Math.random() * 100 % 7);
            int lotNum3 = (int)(Math.random() * 100);
            System.out.println("Cheat: " + lotNum1 + " " + lotNum2 + 
                                " " + lotNum3);
            
            //Prompt User Input
            System.out.print("Enter three guesses: ");
            
            //Verify inputs
            while (loop1){
                
                while (sentinel1){
                    guess1 = verifyInput(scanInput);
                    guess2 = verifyInput(scanInput);
                    guess3 = verifyInput(scanInput);
                    
                    if (guess1 != -1 && guess2 != -1 && guess3 != -1){
                        sentinel1 = false;
                        loop1 = false;
                    }
                    else{
                        System.out.print("\nRe-enter the Lottery: ");
                    }
                }
            }
            
            //Check the guess
            if (guess1 == lotNum1 && guess2 == lotNum2 && guess3 == lotNum3){
                System.out.println("Congratulations! You have made an exact match. You im $10,000");
            }
            else if ((guess1 == lotNum1 && guess2 == lotNum3 && guess3 == lotNum2) ||
                     (guess1 == lotNum3 && guess2 == lotNum2 && guess3 == lotNum1) ||
                     (guess1 == lotNum3 && guess2 == lotNum1 && guess3 == lotNum2) ||
                     (guess1 == lotNum2 && guess2 == lotNum1 && guess3 == lotNum3) ||
                     (guess1 == lotNum2 && guess2 == lotNum3 && guess3 == lotNum1)
            ){
                System.out.println("Matched all digits: You win $3000!");
            }
            else if ((guess1 == lotNum1 || guess2 == lotNum1 || guess3 == lotNum1) ||
                     (guess1 == lotNum2 || guess2 == lotNum2 || guess3 == lotNum2) ||
                     (guess1 == lotNum3 || guess2 == lotNum3 || guess3 == lotNum3)
            ){
                System.out.println("Matched one digit: You win $1000!");
            }
            else{
                System.out.println("No matches. Try your luck next time.");
            }
            
            
        }
        
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    //Method
    /* Verify input
     * Parameters: Scanner
     * return: integer
     */
    public static int verifyInput(Scanner scanInput){
        
        int input = -1;
        if (scanInput.hasNextInt()){
            
            input = scanInput.nextInt();
            
            if (input >= 0)
                return input;
                
            else{
                int badInputInt = input;
                return -1;
            }
            
        }
        else{
            String badInputStr = scanInput.next();
            return -1;
        }
        
    }
    
    
}