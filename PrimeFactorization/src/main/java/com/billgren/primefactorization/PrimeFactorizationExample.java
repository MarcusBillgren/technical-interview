package com.billgren.primefactorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * This test is all about finding the smallest factor(s) of a given number. 
 * If the entered number is a prime, the list should only contain the number that was entered.
 * 
 * Examples: 
 * If the number entered is 8, the list of factors should contain three 2's (2 * 2 * 2 = 8)
 * If the number entered is 6, the list should contain a 2 and a 3 (2 * 3 = 6)
 * @author Marcus Billgren
 */
public class PrimeFactorizationExample {
    
    public List<Integer> calculateFactors(int number){
        List<Integer> factorsToReturn = new ArrayList<>();
          
        if(isPrime(number)){
            return Arrays.asList(number);
        }
        
        //Get factors
        List<Integer> factors = getFactors(number);
        //Find prime factor pair (the numbers that multiplies gives you the number passed in to the method).
        List<Integer> primeFactorizationPair = getPrimeFactorizationPair(factors, number);
        //Check if any of the primes can be factored further
        primeFactorizationPair.forEach(factor -> factorsToReturn.addAll(numberAsPrimeFactorPair(factor)));
        //Return result
        return factorsToReturn;
    }
    //Returns a list of possible new factors
    public List<Integer> numberAsPrimeFactorPair(Integer number){
        if(isPrime(number))
            return Arrays.asList(number);
        return getPrimeFactorizationPair(getFactors(number), number);
    }
    
    public List<Integer> getPrimeFactorizationPair(List<Integer> allFactors, int product){  
        for (int i = 0; i < allFactors.size()-1; i++) {
            int currentNumber = allFactors.get(i);
            //Check if the product of the currect factor equals the desired number
            if(currentNumber * currentNumber == product){
                return Arrays.asList(currentNumber, currentNumber);
            }
            //Otherwise, get the next number in the collection an try with that. 
            int nextNumber = allFactors.get(i+1);
            int result = currentNumber * nextNumber;
            if(result == product){                
                return Arrays.asList(currentNumber, nextNumber);
            }
        }
        return Collections.EMPTY_LIST; 
    }
        
    //Method to check if a number is a prime of not. 
    private boolean isPrime(int number){        
        List<Integer> factors = getFactors(number);
        //a prime number can only have two factors, 1 and itself
        if(factors.size() == 2){
            if(factors.containsAll(Arrays.asList(1,number)));
            return true;
        }        
        return false;
    }
    
    //Gets all factors for a given number
    private List<Integer> getFactors(int number){
        List<Integer> factors =  new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if(number % i == 0){
                factors.add(i);
            }
        }                      
        return factors;
    }
}
