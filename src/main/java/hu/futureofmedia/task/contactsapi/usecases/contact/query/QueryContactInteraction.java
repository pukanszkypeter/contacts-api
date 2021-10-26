package hu.futureofmedia.task.contactsapi.usecases.contact.query;

import hu.futureofmedia.task.contactsapi.models.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.models.others.Page;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QueryContactInteraction implements QueryContactUseCase {

    private final QueryContactDataHandler dataHandler;

    @Override
    public List<ContactDto> findAllActive(Page page) {
        return dataHandler.findAllActive(page);
    }

    @Override
    public Integer countAllActive() {
        return dataHandler.countAllActive();
    }

}
