package JSON;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
 
public class ObjectMappers {

    public static final ObjectMapper INSTANCE = initObjectMapper();

    private static ObjectMapper initObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        JsonFactory jsonFactory = objectMapper.getFactory();
        jsonFactory.configure(JsonFactory.Feature.INTERN_FIELD_NAMES, false);
        jsonFactory.configure(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES, false);
        return objectMapper;
    }

}
