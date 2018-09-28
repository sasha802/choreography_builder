package dance.builder.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;

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

    public Dance() {

    }

    public Dance(String danceName, int beatsPerMinute) {
        this.danceName = danceName;
        this.beatsPerMinute = beatsPerMinute;
    }




}
