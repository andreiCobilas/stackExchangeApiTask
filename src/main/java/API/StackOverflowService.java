package API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StackOverflowService {


    private static APICalls api;

    public static synchronized APICalls getStackOverflowAPI() {

        if (api == null) {

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(APICalls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();

            api = retrofit.create(APICalls.class);
        }

        return api;

    }
}
