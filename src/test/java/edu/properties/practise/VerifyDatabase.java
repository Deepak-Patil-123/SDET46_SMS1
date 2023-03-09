package edu.properties.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyDatabase {

	public static void main(String[] args) throws SQLException {
		
		Random r=new Random();
		int var = r.nextInt(1000);
		
		String username="rmgyantra";
		String password="rmgy@9999";
		String url="http://rmgtestingserver:8084/";
		String projectName="Selenium_SMS"+var;
		String projectManager="DeeptiMahi";
		
		Connection connection=null;
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	WebDriverWait wait=new WebDriverWait(driver, 10);	
		
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		
		driver.get(url);
		driver.findElement(By.id("usernmae")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys(projectManager);
		
		WebElement projectdrop = driver.findElement(By.xpath("//label[text()='Project Status ']/parent::div[@class='form-group']//select[@name='status']"));
		
		Select s1=new Select(projectdrop);
		s1.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[conatains(text(),'Successfuly Added']")));
		
		int count=0;
		
		List<WebElement> colname = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']//th"));
		
		// inorder to get to know that col index.
		
		for(int i=0; i<colname.size(); i++)
		{
			String col = colname.get(i).getText();
			
			if(col.equals("ProjectName"))
			{
				count=i+1;
			}
		}
		
		List<WebElement> projName = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']//td["+count+"]"));
		for(WebElement element:projName)
		{
			String actualProName = element.getText();
			if(actualProName.equals(projectName))
			{
				System.out.println("project is created in UI!");
			}	
			
		}
		
		try {
	 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery("select * from project");
		
		int colcount = result.getMetaData().getColumnCount();
		int temp=0;
		for(int i=1; i<=colcount; i++)
		{
			String dbcolname = result.getMetaData().getColumnName(i);
			if(dbcolname.equals("project_name"))
					{
						temp=i;
					}
		}
		while(result.next())
		{
			String name = result.getString(temp);
			
			if(name.equals(projectName))
			{
				System.out.println("project is created in the database!");
				System.out.println(name);
				break;
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("exception handled");
		}
		
		finally
		{
			connection.close();
		}
		
		
	}

}
