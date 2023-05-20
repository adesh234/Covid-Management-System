package com.example.Covid.Vaccination.System.Exception;

public class NotEligibleForDoseException extends Exception{
    public NotEligibleForDoseException(String message){
        super(message);
    }
}
