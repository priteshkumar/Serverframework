package com.mavixk.sfs.designpatterns.singleton;

public class DbThreadSafe {

  //dbConnection is volatile for dcl working
  private static volatile DbThreadSafe dbConnection = null;

  private DbThreadSafe() {
    //prevent reflection class from instantiating
    if (dbConnection != null) {
      throw new RuntimeException("instance already created");
    }
  }

  /**
   * uses dcl mechanism to prevent race condition between 2 threads attempting to get instance at
   * the same time
   *
   * @return
   */
  public static DbThreadSafe getDbConnection() {
    if (dbConnection == null) {
      synchronized (DbThreadSafe.class) {
        if (dbConnection == null) {
          dbConnection = new DbThreadSafe();
        }
      }
    }
    return dbConnection;
  }
}
