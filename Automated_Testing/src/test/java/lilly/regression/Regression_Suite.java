package lilly.regression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driver.DriverFactory;
import pageFactory.AEPC;
import pageFactory.AllTabs;
import pageFactory.HomePage;
import pageFactory.Login;
import pageFactory.Patient;
import pageFactory.Program;
import utility_functions.Utility_Functions;

public class Regression_Suite {
	
WebDriver driver = DriverFactory.getdriver() ;	

//*********************************************************************************************************
//Regression Script ID: TS-000001
//Description: The below script is used to create Patient, Program, AEPC
//Test Script Author: Sandilya Garimella
//Date: 2/5/2018
//Reviewed By: Mohan Krishna
//*********************************************************************************************************

@Test
public void AEPC_Creation() throws Exception {
	
	String w = System.getenv("TEST_PWD");
	System.out.println("w:::"+w);
	if(w!=null && w.equals("12345")) {
		System.out.println("Matched!!!!!!!!");
	}
	
	//Page Instance
	Utility_Functions util = new Utility_Functions(driver);
	Login login = new Login(driver);
	HomePage homepage = new HomePage(driver);
	AllTabs allTabs = new AllTabs(driver);
	Patient patient = new Patient(driver);
	Program program = new Program(driver);
	AEPC aepc = new AEPC(driver);
	
	//Variables - Data
	String username = util.xmlreader("AEPC.xml", "username");
	String password = util.xmlreader("AEPC.xml", "password");
	String user = util.xmlreader("AEPC.xml", "loginuser");
	String patientFN = util.xmlreader("AEPC.xml", "patientFN");
	String patientLN = util.xmlreader("AEPC.xml", "patientLN");
	String patientGender = util.xmlreader("AEPC.xml", "patientGender");
	String patientDOB = util.xmlreader("AEPC.xml", "patientDOB");
	String patientName = patientLN+", "+patientFN;
	
	
	//User Login (Login)
	driver.get("https://test.salesforce.com/");
	login.userLogin(username, password);
	
	//Select user (Abema_US_ Claudia) (Home Page)
	homepage.userLogin(user);
	util.getscreenshot("Step1_loginuser");
	
	//Select Patient Tab
	allTabs.selectTab("Patients");
	
	//Create Patient (Patient)
	patient.createPatient(patientFN, patientLN, patientGender, patientDOB);
	util.getscreenshot("Step2_Patient");
		
	//Select Program Tab
	allTabs.selectTab("Programs");
	
	//Create Program
	String program_id = program.createProgram(patientName);
	util.getscreenshot("Step3_Program");
	
	//Select AEPC Tab
	allTabs.selectTab("Adverse Events / Product Complaints");
	
	//Create AEPC
	//aepc.createAEPC(program_id);
	aepc.createAEPC("P-0000213850");
	//util.getscreenshot("Step4_AEPC");	
	
	//driver.quit();
	
}



}