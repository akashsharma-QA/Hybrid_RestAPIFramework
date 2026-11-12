package testcases;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import routes.Routes;
import utils.ConfigReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class baseclass {

    RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter();
    ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter();

    ConfigReader configReader ;
    @BeforeClass
    public void setup() throws FileNotFoundException {
        RestAssured.baseURI= Routes.QA_BASE_URL;
        configReader = new ConfigReader();

        FileOutputStream fos= new FileOutputStream("..//logs");
        PrintStream ps= new PrintStream(fos,true);
        requestLoggingFilter=new RequestLoggingFilter(ps);
        responseLoggingFilter=new ResponseLoggingFilter(ps);
        RestAssured.filters(requestLoggingFilter, responseLoggingFilter);



    }

    boolean issortindescending(List<Integer> list){
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i)<list.get(i+1)){
                return false;
            }
            }

        return true;
    }
    boolean issortinasecending(List<Integer> list){
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i)>list.get(i+1))
            {
                return false;
            }
        }
        return true;
    }
}
