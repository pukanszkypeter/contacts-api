package hu.futureofmedia.task.contactsapi.models.entities;

import hu.futureofmedia.task.contactsapi.models.BaseEntity;
import hu.futureofmedia.task.contactsapi.models.type.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Contacts")
public class Contact extends BaseEntity {

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String eMail;

    @Column
    private String phoneNumber;

    @Column
    private long companyId;

    @Column
    private String comment;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

}
