/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;
import com.mycompany.chatapppart1.Login;
import java.util.ArrayList;
import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        Login login = new Login(firstName, lastName);

        String username;
        String password;
        String cell;

        // USERNAME LOOP
        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.println(login.registerUsername(username));
        } while (!login.checkUserName(username));

        // PASSWORD LOOP
        do {
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            System.out.println(login.registerPassword(password));
        } while (!login.checkPasswordComplexity(password));

        // CELL NUMBER LOOP
        do {
            System.out.print("Enter cell phone number (e.g. +27831234567): ");
            cell = scanner.nextLine();
            System.out.println(login.registerCellPhoneNumber(cell));
        } while (!login.checkCellPhoneNumber(cell));

        System.out.println("\n--- Login ---");

        String loginUser;
        String loginPass;

        // LOGIN LOOP (must be correct before proceeding)
        do {
            System.out.print("Enter username: ");
            loginUser = scanner.nextLine();

            System.out.print("Enter password: ");
            loginPass = scanner.nextLine();

            System.out.println(login.returnLoginStatus(loginUser, loginPass));

        } while (!login.loginUser(loginUser, loginPass));
        //---PART2:Messaging only if logged in---
         System.out.println("Welcome to ChatApp.");
         ArrayList<Message>messages= new ArrayList<>();
         int choice;

     do{
         System.out.println("n1.Send Messages");
         System.out.println("2. Show Recent Message");
          System.out.println("3. Quit");
          System.out.print("Choose an option:");
         choice=scanner.nextInt();
         scanner .nextLine();
        
       if(choice==1){
             //Add your for loops+ messages sending logic here
             System.out.print("How many messages?");
             int num= scanner.nextInt();
             scanner.nextLine();
       
         for(int i=0; i<num; i++){
           System.out.println("---Message"+(i+1)+"----");
           System.out.print("Enter recipient:");
           String recipient= scanner.nextLine();
           System.out.print("Enter message:");
           String text= scanner.nextLine();
           
           Message msg =new Message(recipient,text,i+1);
           System.out.println(msg.checkRecipientCell());
           System.out.println("Hash:"+msg.createMessageHash());
         }
      }else if (choice==2){
         for(Message m :messages){
          System.out.println("Hash:"+msg.createMessageHash());
        }
     }
   } while (choice!=3) ;
     
     System.out.println("Goodbye!");
     scanner.close();
}
}
