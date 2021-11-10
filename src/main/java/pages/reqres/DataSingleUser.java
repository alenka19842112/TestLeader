package pages.reqres;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class DataSingleUser {
    @Expose
    int id;
    @Expose
    String email;
    @Expose
    String first_name;
    @Expose
    String last_name;
    @Expose
    String avatar;
}
