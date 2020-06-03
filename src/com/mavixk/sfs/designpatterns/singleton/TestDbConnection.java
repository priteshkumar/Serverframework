package com.mavixk.sfs.designpatterns.singleton;

public class TestDbConnection {

  public static void main(String[] args) {
    DbConnection dbM = DbConnection.getDbConnection();
    System.out.println(dbM);
    DbConnection dbC = DbConnection.getDbConnection();
    System.out.println(dbC);
  }
}
