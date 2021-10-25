package hu.futureofmedia.task.contactsapi.models.dto;

import hu.futureofmedia.task.contactsapi.models.type.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDto {

    private long id;

    private String lastName;

    private String firstName;

    private String eMail;

    private String phoneNumber;

    private String companyName;

    private String comment;

    private Status status;

}
