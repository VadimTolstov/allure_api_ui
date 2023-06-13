package api.models;

import lombok.Data;

@Data
public class EditNameTestCaseResponse {

    private Long id;
    private String name, statusName, statusColor;
    private Long createdDate;
    private Boolean automated, external;

}
