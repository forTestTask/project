package Parent;

import BrowserConfig.MyChromeBrowserClass;
import Models.CRMApiWork;
import Models.CsvFileWriter;
import Models.Utilities;
import Pages.MailRandomizer;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class BaseTest {

    protected ArrayList<String> list = new ArrayList<>();
    protected Utilities utilities = new Utilities();
    protected CRMApiWork crmApiWork = new CRMApiWork();
    protected CsvFileWriter csvFileWriter = new CsvFileWriter();
    protected MailRandomizer mailRandomizer = new MailRandomizer();
    protected Map reportData;
    Map actualData;
    protected Logger logger = LogManager.getLogger();


    @BeforeClass
    protected   void setup() {
        Configuration.browser = MyChromeBrowserClass.class.getName();
        Configuration.timeout = 20000;
        Configuration.startMaximized = true;
        reportData = new HashMap();
        actualData = new HashMap();
        utilities.setRegistrationLinks();
        utilities.setAuthorizationLinks();
        utilities.setPagesList();
        ThreadContext.put("className", getClass().getName());
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @DataProvider
    public Object[][] registration(){
        String [][] dir = utilities.registrationUrlLost;
        Object[][] listUrl = new Object[dir.length][2];

        for (int i = 0; i < dir.length; i++) {
            for (int j = 0; j < 2; j++) {
                listUrl[i][j] = dir[i][j];
            }
        }
        return listUrl;
    }

    @DataProvider
    public Object[][] authorization(){
        String [][] dir = utilities.authorizationUrlList;
        Object[][] listUrl = new Object[dir.length][2];

        for (int i = 0; i < dir.length; i++) {
            for (int j = 0; j < 2; j++) {
                listUrl[i][j] = dir[i][j];
            }
        }
        return listUrl;
    }

    @DataProvider
    public Object[] pages(){
        String [] dir = utilities.pagesList;
        Object[] listUrl = new Object[dir.length];

        for (int i = 0; i < dir.length; i++) {
            listUrl[i] = dir[i];
        }
        return listUrl;
    }

    @AfterMethod()
    public void clear() {
        reportData.clear();
    }

}
