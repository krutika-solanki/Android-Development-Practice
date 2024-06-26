package com.krutikasolanki.testapp1;

public class PrimeNumber {
    public static boolean checkForPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
    // Time Complexity = O(n^(1/2))

//    public static void main(String[] args) {
//        checkForPrime(10);
//    }
}
