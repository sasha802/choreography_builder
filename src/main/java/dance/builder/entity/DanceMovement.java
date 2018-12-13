package dance.builder.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Class that represents Dance Movement entity
 */
@Entity(name = "DanceMovement")
@Table(name = "dance_movement")
@Data
public class DanceMovement {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @JsonProperty("danceName")
    @Column(name = "dance_name")
    private String danceName;

    @JsonProperty("danceMovement")
    @Column(name = "movement")
    private String danceMovement;

    @JsonProperty("dancePosition")
    @Column(name = "dance_position")
    private String dancePosition;

    @JsonProperty("deleted")
    @Column(name = "deleted")
    private int deleted;

    /**
     * No argument constructor
     */
    public DanceMovement() {

    }

    /**
     * Constructor
     * @param danceName String dance name
     * @param danceMovement String dance movement description
     * @param dancePosition String dance position description
     */
    public DanceMovement( String danceName, String danceMovement, String dancePosition) {
        this.danceName = danceName;
        this.danceMovement = danceMovement;
        this.dancePosition = dancePosition;
    }

}
