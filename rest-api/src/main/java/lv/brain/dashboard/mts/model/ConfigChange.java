package lv.brain.dashboard.mts.model;

import javax.persistence.*;

@Entity
@Table
public class ConfigChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String jira;
    @ManyToOne
    User user;
    @ManyToOne
    Environment environment;
    @ManyToOne
    ConfigType type;
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJira() {
        return jira;
    }

    public void setJira(String jira) {
        this.jira = jira;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public ConfigType getType() {
        return type;
    }

    public void setType(ConfigType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
