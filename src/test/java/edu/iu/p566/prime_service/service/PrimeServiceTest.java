package edu.iu.p566.prime_service.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeServiceTest {
    PrimeService primeService = new PrimeService();

    @Test
    void isPrime() {
    int n=45;
    boolean exp = false;
    boolean act = primeService.isPrime(n);
    assertEquals(exp,act);
    }

    @Test
    void _231312312131312isPrime() {
        long n=231231312312L;
        boolean exp = false;
        boolean act = primeService.isPrime(n);
        assertEquals(exp,act);
    }

    @Test
    void _285191isPrime() {
        int n=285191;
        boolean exp = true;
        boolean act = primeService.isPrime(n);
        assertEquals(exp,act);
    }
}