package interview.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StageUpdateDTO {
    private Long hiringProcessStageId;

    private boolean complete;

    private Long employeeId;

    private boolean isComplete;
}
