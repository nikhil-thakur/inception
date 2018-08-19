package interview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @JoinColumn(name = "candidate.id")
    @NotNull
    private Candidate candidate;

    @OneToOne
    @JoinColumn(name = "employee.id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "stage.name")
    @NotNull
    private Stage stage;

    private boolean complete;

}
