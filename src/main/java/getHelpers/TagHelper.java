package getHelpers;

import API.APICalls;
import API.ListWrapper;
import API.StackOverflowService;
import API.pojo.Tags;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class TagHelper {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(TagHelper.class));

    private final APICalls api = StackOverflowService.getStackOverflowAPI();

    public String  getAllTagsOfID(int ID) {

        StringBuilder returnValue = new StringBuilder();

        Call<ListWrapper<Tags>> tags = api.getUsersTags(ID);

        try {

            Response<ListWrapper<Tags>> execute = tags.execute();
            ListWrapper<Tags> body = execute.body();
            List<Tags> items = body.items;

            for (Tags tag : items) {
                returnValue.append(",").append(tag.name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnValue.toString().replaceFirst(",","");
    }
}
