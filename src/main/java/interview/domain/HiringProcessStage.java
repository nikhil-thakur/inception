package interview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HiringProcessStage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    private Candidate candidate;

    @OneToOne
    @MapsId
    private Employee employee;

    @OneToOne
    @MapsId
    private Stage stage;

    private boolean complete;

  /*  @OneToOne
    @MapsId
    StageDetail stageDetail;*/

}
