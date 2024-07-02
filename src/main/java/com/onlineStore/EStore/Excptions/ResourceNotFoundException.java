package com.onlineStore.EStore.Excptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        System.out.println(
                " Resource Not Found Exception"
        );
    }

    public ResourceNotFoundException(String message)
    {
  super(message);
    }
}

