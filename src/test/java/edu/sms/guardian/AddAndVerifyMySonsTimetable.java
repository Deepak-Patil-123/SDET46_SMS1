package edu.sms.guardian;

import java.io.FileInputStream;
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
import org.testng.asserts.SoftAssert;

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
import com.sms.objectRepository.elements.AdminHomePage;
import com.sms.objectRepository.elements.AdminSubjectRoutePage;
import com.sms.objectRepository.elements.AdminTimetablePage;
import com.sms.objectRepository.elements.GuardianAllTeacherPage;
import com.sms.objectRepository.elements.GuardianHomePage;
import com.sms.objectRepository.elements.HomePage;
import com.sms.objectRepository.elements.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddAndVerifyMySonsTimetable extends BaseClass {
	
	@Reports(author="Deepak",category="sanity")
 	@Test(groups={"system testing","regression"})
	public void addAndVerifyMySonsTimetable()
	{	
 		LoginPage loginpage=new LoginPage(driver);
 		AdminHomePage adminhomepage=new AdminHomePage(driver);
 		AdminTimetablePage admintimetablepage=new AdminTimetablePage(driver);
 		AdminSubjectRoutePage adminsubroutepage=new AdminSubjectRoutePage(driver);
 		HomePage homepage=new HomePage(driver);
 		GuardianHomePage Guardianhomepage=new GuardianHomePage(driver);
 		GuardianAllTeacherPage guardallteacherpage=new GuardianAllTeacherPage(driver);
 		
 		//Excel Info
 		String testcasename = "AddAndVerifyMySonsTimetable";			
		String sheetName = ExcelKey.GUARDIAN.getSheetName();
		Map<String, String> map = excel.getExcelData(sheetName, testcasename);
		
 		//Test Data
		String admin_un = property.getPropertyData(PropertyKey.ADMIN_UN);
		String admin_pwd =edutility.decoding(property.getPropertyData(PropertyKey.ADMIN_PWD));
		String guardian_un = property.getPropertyData(PropertyKey.GUARDIAN_UN);
		String guardian_pwd = property.getPropertyData(PropertyKey.GUARDIAN_PWD);
		long timeouts = Long.parseLong(property.getPropertyData(PropertyKey.TIMEOUTS));
	
		String grade1 = map.get("grade_dropdown");
		String day = map.get("day_dropdown");
		String subject = map.get("subject_dropdown");
		String teacher = map.get("Teacher_dropdown");
		String classroom = map.get("classroom_dropdown");
		String starttime=map.get("starttime");
		String endtime = map.get("endtime");
		String expsubject = map.get("subject_dropdown");
		String expteacher = map.get("Teacher_dropdown");
		String expclassroom = map.get("classroom_dropdown");
	
		String etitle=map.get("expLogtitle");	
		String atitle = driver.getTitle();
		SoftAssert a=new SoftAssert();
		
		a.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "login page is displayed!");
		//admin login
	
		loginpage.loginAdmin(admin_un, admin_pwd);	
 		
		
	    atitle=driver.getTitle();
		etitle=map.get("expHometitle");
		a.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "Admin home page is displayed!");
		
		// add timetable
		
		adminhomepage.clickOnTimeTableTab();
		
		//DROPDOWN
		
	    atitle=driver.getCurrentUrl();
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/timetable.php";
		a.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "timetable page is displayed!");
		
		admintimetablepage.addGradedropdown(dropdown, grade1);
		admintimetablepage.clickOnAddButton();	
		
		atitle=driver.getCurrentUrl();
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/timetable.php#";
		a.assertEquals(etitle, atitle);
		
		admintimetablepage.addSubjectRouteDD(dropdown, day, subject, teacher, classroom, starttime, endtime);
		
		
		//explicit wait
		
		adminsubroutepage.explicitwait1(wait, timeouts, driver);
		
		//subject routine tab
		adminhomepage.clickOnSubjectRouteTab();		
		adminsubroutepage.clickonAddButton();
		
		atitle=driver.getCurrentUrl();
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/subject_routing.php";
		a.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "add subject route dropdown page is displayed!");
		
		//dropdown
		
		adminsubroutepage.addSubRouteDD(dropdown, grade1, subject, teacher, sheetName);
		
		// explicit wait
		
		adminsubroutepage.explicitwait2(wait, timeouts, driver);
	
		//admin logout
		homepage.adminLogout();
		
		//guardian login
		
		loginpage.loginGuardian(guardian_un, guardian_pwd);	
		
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/dashboard3.php";
		atitle=driver.getCurrentUrl();
		a.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "guardian home page is displayed!");
		
		
		// timetable tab
		Guardianhomepage.clickOnTimetableTab();
		Guardianhomepage.alltimetabletab();
		
		etitle="http://rmgtestingserver/domain/Student_Management_System/view/all_timetable3.php";
		atitle=driver.getCurrentUrl();
		a.assertEquals(etitle, atitle);
		report.info(UtilityInstanceTransfer.getExtentTest(), "all timetable detailed page is displayed!");
		
			
		String atext = guardallteacherpage.getActualTextOfTeacher();

		//sign out parent
		
		Guardianhomepage.clickOnLogout();
		
		a.assertTrue(atext.equals(expsubject) && atext.equals(expteacher) && atext.equals(expclassroom));
		report.info(UtilityInstanceTransfer.getExtentTest(), "added timetable is displayed hence test case is pass!");
	}

}
