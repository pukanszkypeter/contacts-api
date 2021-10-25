package hu.futureofmedia.task.contactsapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    protected long id;

    @Column
    @JsonIgnore
    protected Date created;

    @Column
    @JsonIgnore
    protected Date modified;

}
