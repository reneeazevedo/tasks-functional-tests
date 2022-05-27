package br.ce.reneeazevedo.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TasksTest {


	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver","C://Users//mypc//dev//java//seleniumDrivers//chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	@Test
	public void deveExibirMensagemDeErro() {
		WebDriver driver = acessarAplicacao();
		try {
			driver.navigate().to("http://localhost:8001/tasks/");
			driver.findElement(By.xpath("//a[text()='Add Todo']")).click();
			driver.findElement(By.id("task")).sendKeys("Teste Selenium");
			driver.findElement(By.id("dueDate")).sendKeys("01/01/2030");
			driver.findElement(By.id("saveButton")).click();
			String textmessage = driver.findElement(By.id("message")).getText();
			Assert.assertEquals(textmessage,"Success!");
		} finally {
			driver.quit();
		}
			
	}
	@Test 
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
			driver.navigate().to("http://localhost:8001/tasks/");
			driver.findElement(By.xpath("//a[text()='Add Todo']")).click();
			driver.findElement(By.id("dueDate")).sendKeys("01/01/2030");
			driver.findElement(By.id("saveButton")).click();
			String textmessage = driver.findElement(By.id("message")).getText();
			Assert.assertEquals(textmessage,"Fill the task description");
		} finally {
			driver.quit();
		}
		
		
			
	}
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try {
			
				driver.navigate().to("http://localhost:8001/tasks/");
				driver.findElement(By.xpath("//a[text()='Add Todo']")).click();
				driver.findElement(By.id("task")).sendKeys("Teste Selenium");
				driver.findElement(By.id("saveButton")).click();
				String textmessage = driver.findElement(By.id("message")).getText();
				Assert.assertEquals(textmessage,"Fill the due date");
		} finally {
			driver.quit();
		}
	   
		

			
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		try {
			
				driver.navigate().to("http://localhost:8001/tasks/");
				driver.findElement(By.xpath("//a[text()='Add Todo']")).click();
				driver.findElement(By.id("task")).sendKeys("Teste Selenium");
				driver.findElement(By.id("dueDate")).sendKeys("01/01/1999");
				driver.findElement(By.id("saveButton")).click();
				String textmessage = driver.findElement(By.id("message")).getText();
				Assert.assertEquals(textmessage,"Due date must not be in past");
		} finally {
			driver.quit();
		}
	   
		

			
	}
	

}
