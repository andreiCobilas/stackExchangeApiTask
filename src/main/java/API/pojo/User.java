package API.pojo;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("location")
    public String location;

    @SerializedName("profile_image")
    public String avatarLink;

    @SerializedName("link")
    public String profileLink;

    @SerializedName("user_id")
    public int userId;

    @SerializedName("answer_count")
    public int answerCount;

    @SerializedName("question_count")
    public String questionCount;

    @SerializedName("display_name")
    public String userName;

}
