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
	
	private AndroidDriver newappdriver = null;

	public LoginScreen() throws Exception {
		this.newappdriver = mobileAppDriver.inicializarDriver();
	}
	
	public void iniciarSesion(String user, String pass) {
	
		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogIn));
        
		this.newappdriver.findElement(txtUser).clear();
		this.newappdriver.findElement(txtUser).sendKeys(user);
		
		this.newappdriver.findElement(txtPassword).clear();
		this.newappdriver.findElement(txtPassword).sendKeys(user);
		
		if(this.newappdriver.isKeyboardShown()) { this.newappdriver.hideKeyboard(); }
		
		this.newappdriver.findElement(btnLogIn).click();
	}
	
	public AndroidDriver getMobileDriver() {
		return newappdriver;
	}
}
