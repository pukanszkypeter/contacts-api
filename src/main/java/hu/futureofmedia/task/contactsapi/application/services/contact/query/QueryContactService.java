package hu.futureofmedia.task.contactsapi.application.services.contact.query;

import hu.futureofmedia.task.contactsapi.adapters.factories.contact.query.QueryContactUseCaseFactory;
import hu.futureofmedia.task.contactsapi.models.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.models.others.Page;
import hu.futureofmedia.task.contactsapi.usecases.contact.query.QueryContactUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class QueryContactService {

    private QueryContactUseCase useCase;

    @Autowired
    public QueryContactService(QueryContactUseCaseFactory factory) { this.useCase = factory.create(); }

    public List<ContactDto> findAllActive(Page page) {
        return useCase.findAllActive(page);
    }

    public Integer countAllActive() { return useCase.countAllActive(); }

}
