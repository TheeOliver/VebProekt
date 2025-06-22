package mk.ukim.finki.projectapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Metric {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MetricType type;

    @ElementCollection
    @OrderColumn
    private List<String> comments;


    public Metric() {}

    public Metric(String name, MetricType type) {
        this.name = name;
        this.type = type;

        for(int i = 0; i < comments.size(); i++) {
            if(type == MetricType.YES_NO) {
                switch(i) {
                    case 0: comments.set(i, "Doesn't have " + this.name); break;
                    case 1: comments.set(i, "Has " + this.name); break;
                }
            }
            else {
                switch(i) {
                    case 0: comments.set(i, "Horrible " + this.name); break;
                    case 1: comments.set(i, "Bad " + this.name); break;
                    case 2: comments.set(i, "Alright " + this.name); break;
                    case 3: comments.set(i, "Good " + this.name); break;
                    case 4: comments.set(i, "Great " + this.name); break;
                }
            }
        }
    }

    public Metric(String name, MetricType type, List<String> comments) {
        this.name = name;
        this.type = type;

        for(int i = 0; i < comments.size(); i++) {
            if(comments.get(i).equals("")) {
                if(type == MetricType.YES_NO) {
                    switch(i) {
                        case 0: this.comments.set(i, "Doesn't have " + this.name); break;
                        case 1: this.comments.set(i, "Has " + this.name); break;
                    }
                }
                else {
                    switch(i) {
                        case 0: this.comments.set(i, "Horrible " + this.name); break;
                        case 1: this.comments.set(i, "Bad " + this.name); break;
                        case 2: this.comments.set(i, "Alright " + this.name); break;
                        case 3: this.comments.set(i, "Good " + this.name); break;
                        case 4: this.comments.set(i, "Great " + this.name); break;
                    }
                }
            }
            else {
                this.comments.set(i, comments.get(i).replace(" ", ""));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MetricType getType() {
        return type;
    }

    public List<String> getComments() {
        return comments;
    }

    void setComments(List<String> comments) {
        this.comments = comments;
    }

}
