package hu.futureofmedia.task.contactsapi.application.services.contact.manipulation;

import hu.futureofmedia.task.contactsapi.adapters.factories.contact.manipulation.ManipulationContactUseCaseFactory;
import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import hu.futureofmedia.task.contactsapi.usecases.contact.manipulation.ManipulationContactUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class ManipulationContactService {

    private final ManipulationContactUseCase useCase;

    @Autowired
    public ManipulationContactService(ManipulationContactUseCaseFactory factory) { this.useCase = factory.create(); }

    public Contact addContact(Contact contact) throws Exception { return useCase.addContact(contact); }

}
