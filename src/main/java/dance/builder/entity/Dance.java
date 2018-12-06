package dance.builder.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Class that represents Dance entity
 */
@Entity(name = "Dance")
@Table(name = "dance_type")
@Data
public class Dance {

    @Column(name = "name")
    private String danceName;

    @Column(name = "beats_per_minute")
    private int beatsPerMinute;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * No argument constructor
     */
    public Dance() {

    }

    /**
     * Constructor
     * @param danceName
     * @param beatsPerMinute
     */
    public Dance(String danceName, int beatsPerMinute) {
        this.danceName = danceName;
        this.beatsPerMinute = beatsPerMinute;
    }
}
