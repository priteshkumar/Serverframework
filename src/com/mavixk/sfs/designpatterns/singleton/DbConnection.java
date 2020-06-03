package com.mavixk.sfs.designpatterns.singleton;

public class DbConnection {

  private static DbConnection dbConnection;

  private DbConnection() {
  }

  public static DbConnection getDbConnection() {
    if (dbConnection == null) {
      dbConnection = new DbConnection();
    }
    return dbConnection;
  }
}
