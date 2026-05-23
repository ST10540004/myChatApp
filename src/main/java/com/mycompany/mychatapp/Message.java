/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class Message {
    private String messageID ;
    private String recipient ;
    private String messageText;
    private String messageHash;
    private int messsageNumber;
    
    public Message (String recipient,String messageText,int messageNumber ){
        this.recipient = recipient;
        this.messageText= messageText;
        this.messsageNumber = messageNumber;
        this.messageID= generateMessageID ();
        this.messageHash= createMessageHash();
        
    }
    
    //1.Check Messsage ID is max 10 characters
    public boolean checkMessageID(){
        return messageID.length()<=10;
    }
    //2.Check recicipent cell number format
    public String checkRecipientCell(){
        if (recipient!= null && recipient.length()<=10 && recipient.startsWith("+")){
            return "Cell phone number successfully captured.";    
        }else {
            return "Cell phone is incorrectly formatted or does not contain an international code.Please correct the number and try again ";
            
        }
    }
    
    //3.Create Message Hash using substring and split
    public String createMessageHash(){
        String idPart= messageID.length()>= 2? messageID.substring(0,2):messageID;
        String[]words= messageText.trim().split("\\s+");
        String firstWord= words[0].toUpperCase();
        String lastWord= words[words.length - 1].toUpperCase();
        return idPart +":" + lastWord;
    }
    
    //4. Send/Store/Disregard logic
    public String sentMessager(int choice){
        switch(choice){
            case 1:return "Message successsfully sent.";
            case 2:return "Message successfully stored .";
            case 3:return "Message successfully stored.";
            default: return"Invalid choice.";
        
        }
    }
    //5.Print message details in order 
    public String printMessage(){
        return "Message ID:"+ messageID +"\n"+
                "Recipient:"+ recipient +"\n"+
                "Message: "+ messageText +"\n"+
                "Hash:" + messageHash;
    }
     //Getters for testing 
    public String getMessageID(){return messageID; }
    public String getRecipient(){return recipient; }
    public String getMessageText(){return messageText;}
    public String getMessageHash(){return messageHash;}
    
    //Helpers:Generate 10 digit random ID 
    private String generateMessageID(){
        Random rand = new Random();
        Long number =1000000L + rand.nextLong(9000000L);
        return String.valueOf(number);
    }
}

