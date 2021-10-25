package hu.futureofmedia.task.contactsapi.usecases.contact.query;

import hu.futureofmedia.task.contactsapi.models.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.models.others.Page;

import java.util.List;

public interface QueryContactDataHandler {

    List<ContactDto> findAllActive(Page page);

}
