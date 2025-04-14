package edu.iu.p566.prime_service.service;

import org.springframework.stereotype.Service;


@Service
public  class PrimeService implements IPrimeService{
    @Override
    public boolean isPrime(long n){
        if (n==2){
            return true;
        }
        for(int i=3;i<n;i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}

