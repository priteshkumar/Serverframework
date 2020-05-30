package com.mavixk.sfs;

class SystemLog {
  private static SystemLog sysLog;
  /**
   * static method for singleton syslog instance
   * @return sysLog
   */
  public static SystemLog getSysLog(){
    if(sysLog == null) {
      System.out.println("creating syslog instance");
      sysLog = new SystemLog();
    }
    return sysLog;
  }

  public boolean writeLog(String msg){
    System.out.println("logging " + msg);
    return true;
  }
}

public class SysLogTest{
  public static void main(String[] args){
    SystemLog syslog = SystemLog.getSysLog();
    syslog.writeLog("jenkins build complete...");
    syslog = SystemLog.getSysLog();
    syslog.writeLog("docker image deployed...");
  }
}