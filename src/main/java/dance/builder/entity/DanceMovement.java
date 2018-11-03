package dance.builder.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

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

    public DanceMovement() {

    }

    public DanceMovement( String danceName, String danceMovement, String dancePosition) {
        this.danceName = danceName;
        this.danceMovement = danceMovement;
        this.dancePosition = dancePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DanceMovement that = (DanceMovement) o;
        return id == that.id &&
                deleted == that.deleted &&
                Objects.equals(danceName, that.danceName) &&
                Objects.equals(danceMovement, that.danceMovement) &&
                Objects.equals(dancePosition, that.dancePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, danceName, danceMovement, dancePosition, deleted);
    }
}
