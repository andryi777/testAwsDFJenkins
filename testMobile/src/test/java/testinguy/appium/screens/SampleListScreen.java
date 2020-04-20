package testinguy.appium.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class SampleListScreen {

	private By opcNativeView = MobileBy.xpath("//android.widget.TextView[@content-desc=\"chainedView\"]");
	private By opcSlider = MobileBy.xpath("//android.widget.TextView[@content-desc=\"slider1\"]");
	private By opcVerticalSwiping = MobileBy.xpath("//android.widget.TextView[@content-desc=\"verticalSwipe\"]");
	private By opcDragDrop = MobileBy.xpath("//android.widget.TextView[@content-desc=\"dragAndDrop\"]");
	private By opcDoubleTap = MobileBy.xpath("//android.widget.TextView[@content-desc=\"doubleTap\"]");
	private By opcLongPress = MobileBy.xpath("//android.widget.TextView[@content-desc=\"longPress\"]");
	private By opcPhotoView = MobileBy.xpath("//android.widget.TextView[@content-desc=\"photoView\"]");
	private By opcWebView = MobileBy.xpath("//android.widget.TextView[@content-desc=\"webView\"]");
	private By opcCarousel = MobileBy.xpath("//android.widget.TextView[@content-desc=\"carousel\"]");
	private By opcWheelPicker = MobileBy.xpath("//android.widget.TextView[@content-desc=\"wheelPicker\"]");
	
	private AndroidDriver newappdriver = null;

	public SampleListScreen(AndroidDriver appDriver) {
		this.newappdriver = appDriver;
	}
	
	public void seleccionarNativeView() throws InterruptedException {	
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(opcSlider));
        try {
        	this.newappdriver.findElement(opcNativeView).click();	
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }	

	}
	
	public void seleccionarSlider() throws InterruptedException {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(opcSlider));
        
        this.newappdriver.findElement(opcSlider).click();	
//		while(this.appdriver.findElement(opcSlider).isDisplayed()) {
//			try {
//				this.appdriver.findElement(opcSlider).click();	
//				Thread.sleep(1000);
//			}catch (Exception ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
	}
	
	public void seleccionarVerticalSwiping() {
		this.newappdriver.findElement(opcVerticalSwiping).click();

	}
	
	public void seleccionarDragDrop() throws InterruptedException {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(opcDragDrop));
        
        this.newappdriver.findElement(opcDragDrop).click();
//		while(newappdriver.appdriver.findElement(opcDragDrop).isDisplayed()) {
//			try {
//				this.appdriver.findElement(opcDragDrop).click();
//				Thread.sleep(1000);
//			}catch (Exception ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
	}
	
	public void seleccionarDoubleTap() {
		this.newappdriver.findElement(opcDoubleTap).click();

	}
	
	public void seleccionarLongPress() {
		this.newappdriver.findElement(opcLongPress).click();

	}
	
	public void seleccionarPhotoView() {
		this.newappdriver.findElement(opcPhotoView).click();

	}
	
	public void seleccionarWebView() {
		this.newappdriver.findElement(opcWebView).click();

	}
	
	public void seleccionarCarousel() {
		this.newappdriver.findElement(opcCarousel).click();

	}
	
	public void seleccionarWheelPicker() {
		this.newappdriver.findElement(opcWheelPicker).click();

	}
	
}
