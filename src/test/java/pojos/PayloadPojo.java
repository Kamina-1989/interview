package pojos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class PayloadPojo {
    private String searchString;
    private String order;

    public static String toJsonString(@NonNull String searchString, String order) { //It is possible to delete this lombok annotation in order to test the 400 statusCode response

        order = (order == null) ? "ASC" : order; // With this ternary operator the order value is set to ASC if it is null

        PayloadPojo payloadPojo = PayloadPojo.builder()
                .searchString(searchString)
                .order(order)
                .build();

        Gson gson = new GsonBuilder().create();
        return gson.toJson(payloadPojo);
    }
}
