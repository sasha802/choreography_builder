package dance.builder.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Objects;

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


    @ManyToOne
    @JoinColumn(name = "users_id", foreignKey = @ForeignKey(name = "user_custom_steps_pk"))
    private User user;


    public CustomSteps() {

    }

    public CustomSteps(String stepName, String danceName, String leadDescription, String followerDescription, String level, User user) {

        this.stepName = stepName;
        this.danceName = danceName;
        this.leadDescription = leadDescription;
        this.followerDescription = followerDescription;
        this.level = level;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSteps that = (CustomSteps) o;
        return id == that.id &&
                Objects.equals(stepName, that.stepName) &&
                Objects.equals(danceName, that.danceName) &&
                Objects.equals(leadDescription, that.leadDescription) &&
                Objects.equals(followerDescription, that.followerDescription) &&
                Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stepName, danceName, leadDescription, followerDescription, level);
    }
}
