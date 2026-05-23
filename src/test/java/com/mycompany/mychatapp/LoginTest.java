/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mychatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
      Login login = new Login("Kyle", "Smith");
   
   @Test
   public void testValidUsername(){
       // must contain "_" and be <= 5 characters
       assertTrue(login.checkUserName("kyl_1"));  
   }
   
   @Test
   public void testInvalidUsername_NoUnderScore(){
       // no underscore
       assertFalse(login.checkUserName("Kyle"));
   }
   
   @Test
   public void testInvalidUsername_TooLong(){
       // more than 5 characters
       assertFalse(login.checkUserName("Milanathi_"));
   }

   @Test
   public void testInvalidUsername_LengthNoUnderscore(){
       // even if short, must still contain "_"
       assertFalse(login.checkUserName("Mila"));
   }

   @Test
   public void testInvalidPasswordComplexity(){
       // missing number and special character
       assertFalse(login.checkPasswordComplexity("Password"));
   }
   
   @Test
   public void testValidPasswordComplexity(){
       assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
   }
   
   @Test
   public void testInvalidCellNumber(){
       // missing +27 format
       assertFalse(login.checkCellPhoneNumber("083966553"));
   }
   
   @Test
   public void testValidCellPhone(){
       // must match +27 followed by 9 digits
       assertTrue(login.checkCellPhoneNumber("+27838968976"));
   }
   
   @Test
   public void testLoginSuccess(){
       // simulate registration steps
       login.checkUserName("kyl_1");
       login.checkPasswordComplexity("Ch&&sec@ke99!");
       
       assertTrue(login.loginUser("kyl_1","Ch&&sec@ke99!"));
   }

   @Test
   public void testLoginFail(){
       login.checkUserName("kyl_1");
       login.checkPasswordComplexity("Ch&&sec@ke99!");
       
       assertFalse(login.loginUser("kyle","Password"));
   }
}
