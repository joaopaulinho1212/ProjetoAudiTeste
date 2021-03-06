package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;


public class BaseTest {

    private AndroidDriver<MobileElement> driver;

    @Rule
    public TestName testName = new TestName();



    @Before
    public void inicializaAppium() throws InterruptedException {
        driver = Conexao.getDriver();
        Thread.sleep(6000);
    }

    @AfterClass
    public static void fecharClassTest(){
        Conexao.close();
    }

    @After
    public void tearDown() {
        gerarScreenShot();
        Conexao.getDriver().resetApp();
    }
    public void gerarScreenShot(){
        try {
            File imagem = (File) Conexao.getDriver().getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/ZeDelivery/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


