package com.billgren.primefactorization;
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
public class Main {
    
     public static void main(String[] args) {
         PrimeFactorizationExample primeFactorization = new PrimeFactorizationExample();
       
        int numberToTest = 15;
        List<Integer> calculateFactors = primeFactorization.calculateFactors(numberToTest);
        Integer sum = calculateFactors.stream().reduce(1, (a,b)-> a*b);
        if(sum == numberToTest){
            System.out.println("Success!");
        }
     }
}
