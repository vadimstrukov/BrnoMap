package cz.brno.map.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by strukov on 8/22/16.
 */
@Entity
@Table(name = "CIRCLE")
public class Circle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private String circleID;
    @Getter @Setter
    private String start_XY;
    @Getter @Setter
    private String end_XY;
    @Getter @Setter
    private String radius;
    @Getter @Setter
    private String fill;
    @Getter @Setter
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Path path;
}
