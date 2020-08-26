package com.mavixk.sfs;

import java.util.HashMap;

public class ProxyPattern {

  static class Bank {

    public void getBalance() {
      System.out.println("get balance");
    }

    public HashMap<String, String> getUser(String cardNum) {
      if (cardNum.equals("1023") == true) {
        HashMap<String, String> userLogin = new HashMap<>();
        userLogin.put(cardNum, "5234");
        return userLogin;
      } else
        return null;
    }
  }

  /**
   * ATM software acts a proxy to bank
   * it controls user's direct access to bank
   * ATM acts as a surrogate class to Bank
   */
  static class ATM{
    private Bank bank = new Bank();
    public void getBalance(String cardNum,String pin){
      HashMap<String,String> userLogin = bank.getUser(cardNum);
      if(userLogin != null && userLogin.get(cardNum).equals(pin))
        bank.getBalance();
      else
        System.out.println("Invalid pin...");
    }
  }

  public static void main(String[] args){
    ATM atm = new ATM();
    atm.getBalance("1023","5234");
  }

}