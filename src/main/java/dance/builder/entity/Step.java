package dance.builder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that represents Step entity
 */
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

    @EqualsAndHashCode.Exclude
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

}
