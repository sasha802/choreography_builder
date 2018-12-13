package dance.builder.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

/**
 * Class that represents Custom Steps entity
 */
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

    @Column(name = "deleted")
    private int deleted;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "users_id", foreignKey = @ForeignKey(name = "user_custom_steps_pk"))
    private User user;


    /**
     * no argument constrictor
     */
    public CustomSteps() {

    }

    /**
     * Constructor
     * @param stepName String step name
     * @param danceName String dance name
     * @param leadDescription String lead description
     * @param followerDescription String follower description
     * @param level String dance level type
     * @param user User user
     */
    public CustomSteps(String stepName, String danceName, String leadDescription, String followerDescription, String level, User user) {

        this.stepName = stepName;
        this.danceName = danceName;
        this.leadDescription = leadDescription;
        this.followerDescription = followerDescription;
        this.level = level;
        this.user = user;
    }

}
