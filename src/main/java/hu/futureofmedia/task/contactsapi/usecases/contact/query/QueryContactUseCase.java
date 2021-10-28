package hu.futureofmedia.task.contactsapi.usecases.contact.query;

import hu.futureofmedia.task.contactsapi.models.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.models.others.Page;

import java.util.List;

public interface QueryContactUseCase {

    List<ContactDto> findAllActive(Page page);

    Integer countAllActive();

}
