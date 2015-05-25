package testing;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AllTests extends TestCase {

	public AllTests(String s)
	{	super(s);
	
	}
	
	public static TestSuite suite()
	{ 
		TestSuite suite = new TestSuite();
		suite.addTestSuite(testing.Testc.class);
		suite.addTestSuite(testing.TestCaseSG.class);
		suite.addTestSuite(testing.TestCaseComanda.class);
		suite.addTestSuite(testing.TestCaseRaport.class);
		suite.addTestSuite(testing.TestCasePPromotional.class);
		
		suite.addTestSuite(testing.TestMock.class);
		return  suite;
	}
	

}
