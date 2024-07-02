package com.onlineStore.EStore.Excptions;


public class CustomExpectation extends  Exception{
    public CustomExpectation(){
        System.out.println("This Is Myn Customized Expectation ");
    }
    public   CustomExpectation(String CustomMessage){
        super(CustomMessage);
    }
}
