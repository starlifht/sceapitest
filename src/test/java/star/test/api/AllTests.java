package star.test.api;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({OtherOpenTest.class})
public class AllTests  extends TestSuite {
	 public static Test suite()
	 {
	  TestSuite suite = new TestSuite("All tests from part1");//表明这个标识性东西
	  suite.addTestSuite(OtherOpenTest.class);
	 // suite.addTestSuite(CalcTest.class);
	 // suite.addTest(new TTmmTest("testHelloworld"));//这里可以添加单个的测试方法
	  return suite;
	 }
	
}
