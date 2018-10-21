package dance.builder.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity(name = "DanceTechnique")
@Table(name = "dance_technique")
@Data
public class DanceTechnique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "movement")
    private String danceMovement;

    @Column(name = "dance_position")
    private String dancePosition;

    @Column(name = "deleted")
    private int deleted;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dance_type_id")
    private Dance dance;


    public DanceTechnique() {

    }

    public DanceTechnique(String danceMovement, String dancePosition, Dance dance) {

        this.danceMovement = danceMovement;
        this.dancePosition = dancePosition;
        this.dance = dance;

    }
}
