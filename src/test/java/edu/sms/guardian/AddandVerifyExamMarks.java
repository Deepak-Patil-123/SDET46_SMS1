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
import com.sms.objectRepository.elements.GuardianHomePage;
import com.sms.objectRepository.elements.HomePage;
import com.sms.objectRepository.elements.LoginPage;
import com.sms.objectRepository.elements.MySonsExamPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddandVerifyExamMarks extends BaseClass {
	
		@Reports(author="Deepak",category="sanity")
		@Test(groups={"regression","minor"})
		public void addandVerifyExamMarks()
		{
		LoginPage loginpage=new LoginPage(driver);
		HomePage homepage=new HomePage(driver);
		AdminHomePage adminhomepage=new AdminHomePage(driver);
		AdminExamPage adminexampage=new AdminExamPage(driver);
		AdminMyStudentPage adminmystdntpage=new AdminMyStudentPage(driver);
		GuardianHomePage guardianhomepage=new GuardianHomePage(driver);
		MySonsExamPage mysonexampage=new MySonsExamPage(driver);
		
		//excel info
		String sheet = ExcelKey.GUARDIAN.getSheetName();
		String testcasename ="AddandVerifyExamMarks" ;
		Map<String,String> map = excel.getExcelData(sheet,testcasename);		
		
		//Test Data
		long timeouts = Long.parseLong(property.getPropertyData(PropertyKey.TIMEOUTS));		
		String admin_un = property.getPropertyData(PropertyKey.ADMIN_UN);
		String admin_pwd =edutility.decoding(property.getPropertyData(PropertyKey.ADMIN_PWD));
		String teacher_un = property.getPropertyData(PropertyKey.TEACHER_UN);
		String teacher_pwd = property.getPropertyData(PropertyKey.TEACHER_PWD);
		String guardian_un = property.getPropertyData(PropertyKey.GUARDIAN_UN);
		String guardian_pwd = property.getPropertyData(PropertyKey.GUARDIAN_PWD);
		
		String expLogtitle=map.get("expLogtitle");
		String expHometitle=map.get("expHometitle");
		String gradeoption = map.get("grade_dropdown");
		String examoption = map.get("Exam_dropdown"); 
		String mathmarks=map.get("mathmarks");
		String seleniummarks=map.get("seleniummarks");
		String subject1=map.get("subject 1");
		String subject2=map.get("subject 2");
		String examoption1=map.get("Exam_dropdown");
		
		String actlLogtitle = driver.getTitle();
		Assert.assertEquals(expLogtitle, actlLogtitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "login page is displayed!");
		
		//admin login
		loginpage.loginAdmin(admin_un, admin_pwd);
		
		String actlHometitle=driver.getTitle();	
		Assert.assertEquals(expHometitle, actlHometitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "Admin home page is displayed!");
		
		//exam tab
		adminhomepage.clickOnExamTab();
		
		String exam="Exam";
		String etitle = "http://rmgtestingserver/domain/Student_Management_System/view/student_exam_marks.php";
		String atitle=driver.getCurrentUrl();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "exam page is displayed!");
				
		//DROPDOWN
		adminexampage.selectDropdown1(dropdown, gradeoption, examoption);
			
		adminmystdntpage.clickOnEditExamMark();
		
		String editexam="Edit Exam marks dropdown";
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/student_exam_marks.php#";
		atitle=driver.getCurrentUrl();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "marks editor page is displayed!");
		
		
		adminmystdntpage.editExamMarksDD(mathmarks, seleniummarks);
	
		adminmystdntpage.viewexammarks();
		
		String viewexam="view Exam marks";
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/student_exam_marks.php#";
		atitle=driver.getCurrentUrl();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "view exam marks page is displayed!");
		
		
		String Actualmathmarks = adminexampage.fetchSubjectData(subject1);
		String Actualseleniummarks = adminexampage.fetchSubjectData(subject2);
			
		homepage.adminLogout();
			
		//login as guardian.
		
		loginpage.loginGuardian(guardian_un, guardian_pwd);
		
		String parent="guardian home";
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/dashboard3.php";
		atitle=driver.getCurrentUrl();
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "guardian home page is displayed!");
		
		guardianhomepage.clickOnExamTab();

		mysonexampage.selectexamdd(dropdown, examoption1);
		
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/my_sons_exam_marks.php";
		atitle=driver.getCurrentUrl();
		
		String mark="my son's exam marks";
		String Expectedmathmarks = mysonexampage.fetchSubjectData(subject1);
		String ExpectedSeleniummarks = mysonexampage.fetchSubjectData(subject2);
		Assert.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "sons exam marks page is displayed!");
		  
		Assert.assertTrue(Actualmathmarks.equals(Expectedmathmarks) && Actualseleniummarks.equals(ExpectedSeleniummarks));
		report.info(UtilityInstanceTransfer.getExtentTest(), "added marks are visible to parent,test case is pass!");
		
	} 

}
 