package testinguy.appium.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class SliderScreen {
	
	private By slider = MobileBy.xpath("//android.widget.SeekBar[@content-desc=\"slider\"]");
	private By btnBack = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView");
	
	private AndroidDriver appdriver = null;

	public SliderScreen(AndroidDriver appDriver) {
		this.appdriver = appDriver;
	}
	
	public void realizar_Slide() {
		
		WebDriverWait wait = new WebDriverWait(this.appdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(slider));
		
		int var_X = this.appdriver.findElement(slider).getLocation().getX();
		int var_Y = this.appdriver.findElement(slider).getLocation().getY();
		int var_Ancho = this.appdriver.findElement(slider).getSize().width;
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(this.appdriver);
		action.press(PointOption.point(var_X,var_Y)).moveTo(PointOption.point(var_Ancho,var_Y)).release().perform();
		int moveTo = (int)(var_Ancho*0.4);
		action.press(PointOption.point(var_X,var_Y)).moveTo(PointOption.point(moveTo,var_Y)).release().perform();
		
	}
	
	public void regresar() {
		WebDriverWait wait = new WebDriverWait(this.appdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnBack));
		this.appdriver.findElement(btnBack).click();
	}
	
}
