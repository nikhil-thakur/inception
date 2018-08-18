package interview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String additionalDetails;
}
