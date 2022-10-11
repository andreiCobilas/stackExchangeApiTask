package API;

import API.pojo.Tags;
import API.pojo.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APICalls {

    String BASE_URL = "https://api.stackexchange.com/2.3/";

    @GET("users?e*SCjBf6Z3bTZu)0fJs3qQ((=4G5Z(htfThkwt2tjdM(FMw))")
    Call<ListWrapper<User>> getUsers(@Query("page") int page,
                                     @Query("pagesize") int pageSize,
                                     @Query("order") String order,
                                     @Query("sort") String sort,
                                     @Query("min") int min,
                                     @Query("tagged") String tagged,
                                     @Query("site") String site,
                                     @Query("filter") String filter);

    @GET("users/{userId}/tags?e*SCjBf6Z3bTZu)0fJs3qQ((=4G5Z(htfThkwt2tjdM(FMw))&site=stackoverflow")
    Call<ListWrapper<Tags>> getUsersTags (@Path("userId") int userId);

    }
