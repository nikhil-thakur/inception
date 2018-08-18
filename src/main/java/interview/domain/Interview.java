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
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Long id;

    String interviewee;

    String interviewer;

    String status;

    @ManyToOne
    @JoinColumn(name = "practice.id")
    Practice practice;
}
