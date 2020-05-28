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



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "https://www.youtube.com/watch?v=RgdqZMMCxjA";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
//    	//String time = Txt_VideoDurationTime.getText(); //mm:ss
//        String[] units = time.split(":"); //will break the string up into an array
//        int minutes = Integer.parseInt(units[0]); //first element
//        int seconds = Integer.parseInt(units[1]); //second element
//        int finalduration = 60 * minutes + seconds; //add up our values
//        for(int i=0;i<=finalduration;i++)
//        {
//     	   //System.out.println("Loop: Enter into VideoStream Functinality.");
//     	   
//     	   //Mouse Hover Action on Video Slider(to fetch the time duration)
//        	 Actions builder = new Actions(driver);
////            WebElement Scrollbar = Scrollbar_Indicator;
//            //System.out.println("Mouse over on Duration Bar");
		
            WebElement elem = driver.findElement(By.className("ytp-progress-bar"));
            WebElement elem1=driver.findElement(By.xpath("//div[@class='ytp-progress-list']"));
            		WebElement btn=driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
            btn.click();
            int width = elem.getSize().getWidth();
            System.out.println("Video width: " +width);
          
                           
            
            Point point = elem.getLocation();
            int xcord = point.getX();
            System.out.println("Position of the webelement from left side is "+xcord +" pixels");
            int ycord = point.getY();
            System.out.println("Position of the webelement from top side is "+ycord +" pixels");
            
            
            Thread.sleep(3000);
          Actions act = new Actions(driver);
            act.moveToElement(elem).moveByOffset((width/(width-2)), 0).click().perform();
            Thread.sleep(3000);
         //   elem1.sendKeys(Keys.ARROW_RIGHT);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("document.getElementsByTagName(\"video\")[0].currentTime += 30;");
            
            
            
//            int widthXaxis = elem.getRect().getX();
//            System.out.println("X axis: " +widthXaxis);
//            int widthYaxis =elem.getRect().getY();
//            
//            act.moveToElement(elem).moveByOffset((widthXaxis-50), 0).click().perform();
//            Thread.sleep(3000);
          //  act.moveToElement(elem).moveByOffset((widthXaxis), 0).click().perform();
//            act.moveToElement(elem).moveByOffset((widthXaxis-(widthXaxis/2)), 0).click().perform();
//            
//            Thread.sleep(2000);
//            act.moveToElement(elem).moveByOffset((widthXaxis), 0).click().perform();
//            System.out.println("Y axis: " +widthYaxis);
//            
//            Actions moveSlider = new Actions(driver);
            
//            Action action = moveSlider.dragAndDropBy(elem, 171, 0).build();
//            action.perform();
//            System.out.println(elem.getAttribute("aria-valuemax"));
            
//            Thread.sleep(1000);
//            act.moveToElement(elem).moveByOffset((width-25), 0).click().perform();
//            Thread.sleep(1000);
//            act.moveToElement(elem).moveByOffset((width/2)-2, 0).click().perform();
//            Thread.sleep(1000);
            
//            Action mouseMovement=builder.moveToElement(Scrollbar).build();
//            mouseMovement.perform();
//            System.out.println("Final Duration: " +Txt_VideoDurationTime.getText());
//            Thread.sleep(2000);
//            System.out.println("Current Duration: " +Txt_VideoCurrentTime.getText());
//            driver.close();
            }
    
    }
    
