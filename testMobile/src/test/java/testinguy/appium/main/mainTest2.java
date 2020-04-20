package testinguy.appium.main;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testinguy.appium.screens.DragDropScreen;
import testinguy.appium.screens.LoginScreen;
import testinguy.appium.screens.SampleListScreen;
import testinguy.appium.screens.SliderScreen;
import testinguy.appium.screens.NativeViewScreen;


public class mainTest2 {

	private LoginScreen oLoginScreen; 
	private SampleListScreen oSampleListScreen;
	private NativeViewScreen oNativeViewScreen;
	private SliderScreen oSliderScreen;
	private DragDropScreen oDragDropScreen;

	@BeforeTest
	public void inicioClase() throws Exception {
		oLoginScreen = new LoginScreen();
		oSampleListScreen = new SampleListScreen(oLoginScreen.getMobileDriver());
		oNativeViewScreen = new NativeViewScreen(oLoginScreen.getMobileDriver());
		oSliderScreen = new SliderScreen(oLoginScreen.getMobileDriver());
		oDragDropScreen = new DragDropScreen(oLoginScreen.getMobileDriver());
	}

	static String rutaArchivo1 = "";
	
	@Parameters({"user", "pass"})
	@Test  (description="Login")
	public void IniciarSesion(String usuario, String password) throws Exception {
		try {	
			Thread.sleep(2000);
			oLoginScreen.iniciarSesion(usuario, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			Assert.fail();
		}
	}

	@Test  (description="Acceder a una ventana y leer elementos") //, enabled = false
	public void Test_NativeView() throws Exception {
		try {		
			Thread.sleep(2000);
			oSampleListScreen.seleccionarNativeView();
			Thread.sleep(2000);
			oNativeViewScreen.listarElementos();
			Thread.sleep(2000);
			oNativeViewScreen.regresar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			 Assert.fail();
		}
	}
	
	@Test (description="Ejercicio de presionar y soltar", enabled = false)
	public void Test_Slider() throws Exception {
		try {			
			Thread.sleep(1000);
			oSampleListScreen.seleccionarSlider();
			Thread.sleep(2000);
			oSliderScreen.realizar_Slide();
			oSliderScreen.regresar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 Assert.fail();
		}
	}
	
	@Test (description="Ejercicio de presionar, arrastrar y soltar")
	public void Test_DragAndDrop() throws Exception {
		try {			
			Thread.sleep(2000);
			oSampleListScreen.seleccionarDragDrop();
			Thread.sleep(2000);
			
			String valorActual = oDragDropScreen.dragBoton();
			String valorEsperado = "Circle dropped"; //droppedxD

			Assert.assertEquals(valorActual, valorEsperado);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			Assert.fail();
		}
	}
	
	@Test (dependsOnMethods = { "Test_DragAndDrop" })
	public void testCaseSkipException(){
			System.out.println("Im in skip exception");
			
		}
}
