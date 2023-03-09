package edu.sms.guardian;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sms.genericutility.EncryptedDecryptedUtility;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.GetPropertyPath;
import com.sms.genericutility.ListBoxUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.UtilityInstanceTransfer;
import com.sms.genericutility.VerificationUtility;
import com.sms.genericutility.WaitUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.genericutility.Base.BaseClass;
import com.sms.genericutility.Enums.ExcelKey;
import com.sms.genericutility.Enums.PropertyKey;
import com.sms.genericutility.annotations.Reports;
import com.sms.objectRepository.elements.AdminExamPage;
import com.sms.objectRepository.elements.AdminHomePage;
import com.sms.objectRepository.elements.AdminMyStudentPage;
import com.sms.objectRepository.elements.AdminSubjectPage;
import com.sms.objectRepository.elements.AdminSubjectRoutePage;
import com.sms.objectRepository.elements.GTeacherPage;
import com.sms.objectRepository.elements.GuardianHomePage;
import com.sms.objectRepository.elements.HomePage;
import com.sms.objectRepository.elements.LoginPage;
import com.sms.objectRepository.elements.MySonsExamPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddAndVerifyMySonsTeacher extends BaseClass{

	@Reports(author="Deepak",category="sanity")
	@Test(groups="system testing")
	public void addAndVerifyMySonsTeacher()
	{	
		LoginPage loginpage=new LoginPage(driver);
		AdminHomePage adminhomepage=new AdminHomePage(driver);
		AdminSubjectRoutePage adminsubroutepage=new AdminSubjectRoutePage(driver);
		HomePage homepage=new HomePage(driver);
		GuardianHomePage guardhomepage=new GuardianHomePage(driver);
		GTeacherPage guardianTeacherpage=new GTeacherPage(driver);
		AdminSubjectPage adminsubpage=new AdminSubjectPage(driver);

		
		//Excel info
		String sheetName = ExcelKey.GUARDIAN.getSheetName();	
		String testcasename ="AddAndVerifyMySonsTeacher" ;
		Map<String,String> map = excel.getExcelData(sheetName,testcasename);
		
		//Test Data
		long timeouts = Long.parseLong(property.getPropertyData(PropertyKey.TIMEOUTS));		
		String admin_un = property.getPropertyData(PropertyKey.ADMIN_UN);
		String admin_pwd = edutility.decoding(property.getPropertyData(PropertyKey.ADMIN_PWD));
		String teacher_un = property.getPropertyData(PropertyKey.TEACHER_UN);
		String teacher_pwd = property.getPropertyData(PropertyKey.TEACHER_PWD);
		String guardian_un = property.getPropertyData(PropertyKey.GUARDIAN_UN);
		String guardian_pwd = property.getPropertyData(PropertyKey.GUARDIAN_PWD);
		 
		String grade = map.get("grade_dropdown");
		String subject = map.get("subject_dropdown");
		String teacher = map.get("Teacher_dropdown");
		String fee=map.get("fee");
		
		String login="login";
		String etitle=map.get("expLogtitle");	
		String atitle = driver.getTitle();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "login page is displayed!");

		//admin login
		loginpage.loginAdmin(admin_un, admin_pwd);	
		
		String home="home";
	    atitle=driver.getTitle();
		etitle=map.get("expHometitle");
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "home page is displayed!");
		
		//subject routing
		adminhomepage.clickOnSubjectRouteTab();
		adminsubroutepage.clickonAddButton();
		
		String dd="add subject dropdown ";
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/subject_routing.php";
		atitle=driver.getCurrentUrl();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "add subject dropdown page is displayed!");
		
		 //DROPDOWN
		
		adminsubroutepage.addSubRouteDD(dropdown, grade, subject, teacher, fee);
	
		//EXPLICIT WAIT
		
		adminsubpage.explicitWait(wait, timeouts, driver);

		
		//admin logout
		homepage.adminLogout();
				
		//guardian - rajat
		
		loginpage.loginGuardian(guardian_un, guardian_pwd);
		
		String parent="guardian";
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/dashboard3.php";
		atitle=driver.getCurrentUrl();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "guardian home page is displayed!");
		
		
		//teacher tab
		guardhomepage.clickOnTeacherTab();
		guardhomepage.clickOnAllTeacherTab();
		
		String teachers="all teacher";
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/all_teacher3.php";
		atitle=driver.getCurrentUrl();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "all teacher page is displayed!");
		
		
		
		//click on view profile
		guardianTeacherpage.clickOnViewProfile();

		String expTeacher = guardianTeacherpage.getExpectedTeacher();
		String actTeacher = excel.getExcelData(sheetName, testcasename, expTeacher);
			
		Assert.assertEquals(actTeacher, expTeacher);
		report.info(UtilityInstanceTransfer.getExtentTest(), "added teacher is displayed in all teacher page , hence test case is pass!");
		
	}
	}

