import getHelpers.TagHelper;
import getHelpers.UserHelper;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Runner {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(Runner.class));

    @org.junit.Test
    public void testGetAllUsersByCriteria() throws InterruptedException {
        //main runner of app, should log the wanted users by criteria, number of pages is determined in dependence of time/request left for the day
        UserHelper userHelper = new UserHelper();
        //first int startPage should be always bigger then second int , this is done due to throttle violation
        userHelper.getAllUsersByCriteria(10, 20);
    }

    @org.junit.Test
    public void testGetUserByCriteriaPerCertainPage() throws InterruptedException {
        //not a test, used for debugging a function
        UserHelper userHelper = new UserHelper();
        userHelper.getUserByCriteriaPerCertainPage(26);
    }

    @org.junit.Test
    public void testGetTagsForID() {

        String controlString = "c#,.net,html,javascript,visual-studio,webforms,json,json.net,mysql,node.js,postgresql,readfile,script-component,spring-data,spring-mvc,sql,ssis,iis,internet-explorer,java,android-studio,asp.net,asp.net-mvc,csv,discord.js,docker,entity-framework,excel,ftp,gridview";
        TagHelper tagHelper = new TagHelper();
        //Test that formatted values of tags for id 3566926 are equal to controlString, check with api https://api.stackexchange.com/2.3/users/3566926/tags?site=stackoverflow
        assertEquals(tagHelper.getAllTagsOfID(3566926),controlString);
    }

    @Test
    public void rst(){
        String a = "gama";
        System.out.println("User name: " + a + "\n Location: "+ a + "\n Location: ");
    }
}
