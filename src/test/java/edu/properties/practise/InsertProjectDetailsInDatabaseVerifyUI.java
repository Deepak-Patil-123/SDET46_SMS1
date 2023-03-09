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
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertProjectDetailsInDatabaseVerifyUI {

	public static void main(String[] args) throws SQLException {


		Random r=new Random();
		int var = r.nextInt(1000);
		
		String username="rmgyantra";
		String password="rmgy@9999";
		String url="http://rmgtestingserver:8084/";
		String projectName="Selenium_SMS"+var;
		String projectManager="DeeptiMahi";
		
		String project_id="SMS"+var;
		
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
		
		int result = statement.executeUpdate("insert into project(project_id,project_name,created_by,created_on,status,team_size) values('"+project_id+"','"+projectName+"','Deepak','08/02/2023','created',15)");
		
		
		if(result==1)
		{
			System.out.println("Data is inserted!");
			
		}
		else
		{
			System.out.println("Data is not inserted!");
		}
		ResultSet result1 = statement.executeQuery("select * from project");
		while(result1.next())
		{
			System.out.println(result1.getString(""));
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
