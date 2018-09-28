package dance.builder.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "CustomSteps")
@Table(name = "user_custom_steps")
@Data
public class CustomSteps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "step_name")
    private String stepName;

    @Column(name = "dance_name")
    private String danceName;

    @Column(name = "lead_description")
    private String leadDescription;

    @Column(name = "follower_description")
    private String followerDescription;

    @Column(name = "level")
    private String level;

    @Column(name = "users_id")
    private int userId;


    public CustomSteps() {

    }

    public CustomSteps(String stepName, String danceName, String leadDescription, String followerDescription, String level, int userId) {

        this.stepName = stepName;
        this.danceName = danceName;
        this.leadDescription = leadDescription;
        this.followerDescription = followerDescription;
        this.level = level;
        this.userId = userId;
    }


}
