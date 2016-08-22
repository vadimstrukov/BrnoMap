package cz.brno.map.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by strukov on 8/22/16.
 */
@Entity
@Table(name = "PATH")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Path implements Serializable {

    @Id
    @Getter @Setter
    private String pathID;
    @Getter @Setter
    @Column(columnDefinition = "TEXT")
    private String coordinates;
    @Getter @Setter
    private String fill;
    @Getter @Setter
    private String stroke;
    @Getter @Setter
    private String stroke_width;
    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Circle> circles;
}
