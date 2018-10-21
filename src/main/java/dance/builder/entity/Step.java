package dance.builder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "Step")
@Table(name = "step")
@Data
public class Step {

    @JsonProperty("name")
    @Column(name = "name")
    private String stepName;

    @JsonProperty("level")
    @Column(name = "level")
    private String level;

    @JsonProperty("fdesc")
    @Column(name = "follower_description")
    private String followerDescription;

    @JsonIgnore
    @Column(name = "lead_description")
    private String leadDescription;

    @JsonIgnore
    @Column(name = "demo_link")
    private String demoLink;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dance_type_id", foreignKey = @ForeignKey(name = "step_pk"))
    private Dance dance;

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    public Step() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return dance.getId() == step.dance.getId() &&
                id == step.id &&
                Objects.equals(stepName, step.stepName) &&
                Objects.equals(level, step.level) &&
                Objects.equals(followerDescription, step.followerDescription) &&
                Objects.equals(leadDescription, step.leadDescription) &&
                Objects.equals(demoLink, step.demoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stepName, level, followerDescription, leadDescription, demoLink, dance.getId(), id);
    }
}
