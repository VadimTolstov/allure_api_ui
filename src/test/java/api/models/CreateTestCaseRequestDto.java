package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTestCaseRequestDto {
    private final String name,
            description;
    private final Long projectId;
}
