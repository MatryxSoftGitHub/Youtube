package Youtube.YoutubeChannnel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 System.out.println("ChromeDriver. ");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("JavascriptExecutor. ");
		
		
		driver.manage().window().maximize();
		
		String baseUrl = "https://www.youtube.com/watch?v=RgdqZMMCxjA";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
		
 
            
            
                    WebElement Slider = driver.findElement(By.className("ytp-progress-bar"));   
//                 // elem is WebElement
//                   // WebElement elem=driver.findElement(By.className("ytp-progress-bar"));  
//                    WebElement elem= driver.findElement(By.xpath("ytp-progress-bar"));
//
//                    String s = (String) elem.getAttribute("aria-valuenow");
                    
 //                   System.out.println("aria-valuenow. "+s);

                    String valuemax; 
                    
                    valuemax=Slider.getAttribute("aria-valuemax");
                    double dvaluemax = Double.parseDouble(valuemax);
                    double dvaluenow=dvaluemax/2;
                    double dQuatervaluenow=dvaluemax/3;
                    double dFullvaluenow=dvaluemax;
                    
                    
                    System.out.println("aria-valuenow. "+valuemax);    
                    int PixelsToMove = GetPixelsToMove(Slider, dQuatervaluenow, dvaluemax, 0);
            		Actions SliderAction = new Actions(driver);
                    

            		SliderAction.clickAndHold(Slider).moveByOffset((-(int)Slider.getSize().getWidth() / 2),0).moveByOffset(PixelsToMove, 0).release().perform();
            		Thread.sleep(2000);
            		int PixelsToMove1 = GetPixelsToMove(Slider, dvaluenow, dvaluemax, 0);
            		SliderAction.clickAndHold(Slider).moveByOffset((-(int)Slider.getSize().getWidth() / 2),0).moveByOffset(PixelsToMove1, 0).release().perform();
            		
            		Thread.sleep(2000);
            		int PixelsToMove2 = GetPixelsToMove(Slider, dFullvaluenow, dvaluemax, 0);
            		SliderAction.clickAndHold(Slider).moveByOffset((-(int)Slider.getSize().getWidth() / 2),0).moveByOffset(PixelsToMove2, 0).release().perform();
    }    
            
            
            
            		public static int GetPixelsToMove(WebElement Slider, double Amount, double SliderMax, double SliderMin)
            	    {
            	        int pixels = 0;
            	        double tempPixels = Slider.getSize().getWidth();
            	        tempPixels = tempPixels / (SliderMax - SliderMin);
            	        tempPixels = tempPixels * (Amount - SliderMin);
            	        pixels = (int) (tempPixels);
            	       // pixels = (tempPixels);
            	        return pixels;
            	    }   
            
            
                       
//            driver.close();
            }
    

