package repoOwner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.VetSurgery.Constants;
import com.qa.VetSurgery.VetSurgery;
import com.qa.VetSurgery.model.OwnerModel;
import com.qa.VetSurgery.repository.OwnerRepository;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(SpringRunner.class)
//Used to provide a bridge between Spring Boot test features and JUnit
@SpringBootTest(classes = {VetSurgery.class})
@DataJpaTest
public class OwnerRepositoryTest {
	
	public static ExtentReports report; 
	public static ExtentTest test;
	
	@Autowired
	private TestEntityManager entityManager; 
	
	@Autowired
	private OwnerRepository myRepo; 

	@BeforeClass
	public static void initial()
	{
		//setting up a report(file name, replace existing)
		report = new ExtentReports(Constants.REPORT_FILE, false);
	}
	
	//Test for the Get ID
	@Test
	public void retrieveByIdTest()
	{
		//starting the test 
		test = report.startTest("retrieve ID Test");
		test.log(LogStatus.INFO, "Getting an Owner by an ID");
		
		//create a new owner 
		OwnerModel model1 = new OwnerModel("Joel", "Bristol", "883883");
		entityManager.persist(model1);
		entityManager.flush();
		
		//If the owner has found by ID or not then it will be added to the report 
		if(myRepo.findById(model1.getId()).isPresent())
		{
			test.log(LogStatus.PASS, "the owner has been found by ID");
		}
		else
		{
			test.log(LogStatus.FAIL, "the owner has not been found by ID");
		}
		
		//Checking if the owner has been found by ID and asserting to the unit test
		assertTrue(myRepo.findById(model1.getId()).isPresent());
	}
	
	@Test
	public void retrieveByNameTest()
	{
		//starting the test 
		test = report.startTest("retrieve by Name Test");
		test.log(LogStatus.INFO, "Getting an Owner by a Name");
		
		OwnerModel model1 = new OwnerModel("Cooper", "Glasgow", "444446");
		entityManager.persist(model1);
		OwnerModel model2 = new OwnerModel("Kyle", "Bath", "4656354");
		entityManager.persist(model2);
		entityManager.flush();
		
		if(myRepo.findByName("Cooper").getName().equals("Cooper"))
		{
			test.log(LogStatus.PASS, "Owner Cooper has been found");
		}
		else
		{
			test.log(LogStatus.FAIL, "Owner Cooper has NOT been found");
		}
		
		assertEquals("There is no owner named Cooper", "Cooper", myRepo.findByName("Cooper").getName());
	}
	
	@Test
	public void retrieveByAddressTest()
	{
		//starting the test 
		test = report.startTest("retrieve by Address Test");
		test.log(LogStatus.INFO, "Getting an Owner by an Address");
		
		OwnerModel model1 = new OwnerModel("Cooper", "Glasgow", "434346");
		entityManager.persist(model1);
		OwnerModel model2 = new OwnerModel("Kyle", "Bath", "46d57565");
		entityManager.persist(model2);
		entityManager.flush();
		
		if(myRepo.findByAddress("Bath").getAddress().equals("Bath"))
		{
			test.log(LogStatus.PASS, "Owner in Bath has been found");
		}
		else
		{
			test.log(LogStatus.FAIL, "Owner in Bath has NOT been found");
		}
		
		assertEquals("There is no owner found with this Address", "Bath", myRepo.findByAddress("Bath").getAddress());
	}
	
	@Test
	public void retrieveByContactNumTest()
	{
		//starting the test 
		test = report.startTest("retrieve by Contact Number Test");
		test.log(LogStatus.INFO, "Getting an Owner by a Contact Address");
		
		OwnerModel model1 = new OwnerModel("Cooper", "Glasgow", "444446");
		entityManager.persist(model1);
		OwnerModel model2 = new OwnerModel("Kyle", "Bath", "4656354");
		entityManager.persist(model2);
		entityManager.flush();
		
		if(myRepo.findByContactNum("444446").getContactNum().equals("444446"))
		{
			test.log(LogStatus.PASS, "Owner in Bath has been found");
		}
		else
		{
			test.log(LogStatus.FAIL, "Owner in Bath has NOT been found");
		}
		
		assertEquals("There is no owner with the Contact Number", "444446", myRepo.findByContactNum("444446").getContactNum());
	}
	
	@After
	public void tearDown()
	{
		report.endTest(test);
	}
	
	
	@AfterClass
	public static void end()
	{
		report.flush(); 
	}
}
