package utility_functions;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class Utility_Functions {

	WebDriver driver;
	public Utility_Functions(WebDriver driver) {
		this.driver = driver;
	}

	public String xmlreader(String filename, String Nodename) {
		String value = null;
		try {

			File XmlFile = new File("src/test/resources/"+filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(XmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			//doc.getDocumentElement().normalize();
			
			value = doc.getElementsByTagName(Nodename).item(0).getTextContent();
			
		    }
		catch (Exception e) {
			e.printStackTrace();
		    }
		return value;
	}

	public void getscreenshot(String screenshotName) throws Exception {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("Screenshots/"+screenshotName+".jpeg"));
	}
}
