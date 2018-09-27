package dance.builder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Step")
@Table(name = "step")
public class Step {

    @Column(name = "name")
    private String stepName;

    @Column(name = "level")
    private String level;

    @Column(name = "follower_description")
    private String followerDescription;

    @Column(name = "lead_description")
    private String leadDescription;

    @Column(name = "demo_link")
    private String demoLink;



    //    @Column(name = "dance_type_id")
    @ManyToOne
    @JoinColumn(name = "dance_type_id", foreignKey = @ForeignKey(name = "step_pk"))
    private Dance dance;



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    public Step() {

    }


    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getStepName() {
        return stepName;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setFollowerDescription(String followerDescription) {
        this.followerDescription = followerDescription;
    }

    public String getFollowerDescription() {
        return followerDescription;
    }

    public void setLeadDescription(String leadDescription) {
        this.leadDescription = leadDescription;
    }

    public String getLeadDescription() {
        return leadDescription;
    }

    public void setDemoLink(String demoLink) {
        this.demoLink = demoLink;
    }

    public String getDemoLink() {
        return demoLink;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Dance getDance() {
        return dance;
    }

    public void setDance(Dance dance) {
        this.dance = dance;
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
