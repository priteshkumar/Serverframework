package com.mavixk.sfs;

public class TestSuite {

  protected boolean functionalTest;
  protected boolean memoryTest;
  protected boolean performanceTest;
  protected boolean stressTest;

  public TestSuite(TestBuilder builder) {
    this.functionalTest = builder.functionalTest;
    this.memoryTest = builder.memoryTest;
    this.performanceTest = builder.performanceTest;
    this.stressTest = builder.stressTest;
  }

  public void runTests() {
    System.out.println("running tests...");
  }

  static class TestBuilder {

    private boolean functionalTest;
    private boolean memoryTest;
    private boolean performanceTest;
    private boolean stressTest;

    public TestBuilder addFuncTest() {
      this.functionalTest = true;
      return this;
    }

    public TestBuilder addmemoryTest() {
      this.memoryTest = true;
      return this;
    }

    public TestBuilder addperformanceTest() {
      this.performanceTest = true;
      return this;
    }

    public TestSuite build() {
      return new TestSuite(this);
    }
  }

  public static void main(String[] args) {
    TestSuite testsuite = new TestSuite.TestBuilder().addFuncTest().addmemoryTest()
        .addperformanceTest().build();
    testsuite.runTests();
  }
}
