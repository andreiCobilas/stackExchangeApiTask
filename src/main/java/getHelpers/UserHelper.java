package getHelpers;

import retrofit2.Call;
import retrofit2.Response;
import API.APICalls;
import API.ListWrapper;
import API.StackOverflowService;
import API.pojo.User;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class UserHelper {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(UserHelper.class));

    public void getAllUsersByCriteria(int startPage,int endPage) throws InterruptedException {

        while (startPage <= endPage){
            TimeUnit.SECONDS.sleep(5);
            getUserByCriteriaPerCertainPage(startPage);
            startPage++;
        }
    }

    public void getUserByCriteriaPerCertainPage(int pageNumber){

        TagHelper tagHelper = new TagHelper();
        APICalls api = StackOverflowService.getStackOverflowAPI();
        Call<ListWrapper<User>> users = api.getUsers(pageNumber,99, "asc","reputation", 223,"java;docker;net","stackoverflow","!-AyE)dxdJdKUtjNQSVOEY");

        try {
            Response<ListWrapper<User>> execute = users.execute();
            ListWrapper<User> body = execute.body();
            List<User> items = body.items;
            for (User user : items) {
                verifyCriteriaAndLog(tagHelper, user);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Verified page " + pageNumber +" for users corresponding criteria" );
    }

    private void verifyCriteriaAndLog (TagHelper tagHelper, User user) throws InterruptedException {
        if(user.location !=null) {
            if (user.answerCount > 0 && user.location.contains("Moldova") || user.location.contains("Romania")) {
                TimeUnit.SECONDS.sleep(5);
                LOGGER.info("User name: " + user.userName + "\n Location: " + user.location
                        + "\n Answer Count: " + user.answerCount + "\n Question count: " + user.questionCount +
                        "\n User tags : " + tagHelper.getAllTagsOfID(user.userId) + "\n User link : " + user.profileLink
                        + "\n User Avatar Link: " + user.avatarLink);
            }
        }
    }

}
