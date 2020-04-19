package testinguy.appium.screens;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import testinguy.appium.driver.mobileAppDriver;

public class LoginScreen {

	//("pe.com.rimac.geo.procurador:id/email");
	private By txtUser = MobileBy.xpath("//android.widget.EditText[@content-desc=\"username\"]");
	private By txtPassword = MobileBy.xpath("//android.widget.EditText[@content-desc=\"password\"]");
	private By btnLogIn = MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"login\"]/android.widget.Button/android.widget.TextView");
	
	private AndroidDriver appdriver = null;

	public LoginScreen() throws Exception {
		this.appdriver = mobileAppDriver.inicializarDriver();
	}
	
	public void iniciarSesion(String user, String pass) {
	
		WebDriverWait wait = new WebDriverWait(this.appdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogIn));
        
		this.appdriver.findElement(txtUser).clear();
		this.appdriver.findElement(txtUser).sendKeys(user);
		
		this.appdriver.findElement(txtPassword).clear();
		this.appdriver.findElement(txtPassword).sendKeys(user);
		
		this.appdriver.findElement(btnLogIn).click();
	}
	
	public AndroidDriver getMobileDriver() {
		return appdriver;
	}
}
