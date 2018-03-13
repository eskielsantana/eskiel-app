package com.infotech.app.entity;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="event")
@NamedQueries({
        @NamedQuery(name="Event.returnAllEvents", query="SELECT e FROM Event e ORDER BY e.id")
})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="event_name")
    private String name;

    @Column(name="event_date")
    private Date eventDate;

    @Column(name="event_description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
