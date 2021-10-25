package hu.futureofmedia.task.contactsapi.adapters.dal.contact.manipulation;

import hu.futureofmedia.task.contactsapi.adapters.validators.contact.ContactValidator;
import hu.futureofmedia.task.contactsapi.application.repositories.contact.ContactRepository;
import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import hu.futureofmedia.task.contactsapi.usecases.contact.manipulation.ManipulationContactDataHandler;
import hu.futureofmedia.task.contactsapi.utils.sourcedata.SourceDataManager;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ManipulationContactDao implements ManipulationContactDataHandler {

    private final ContactRepository repository;
    private final SourceDataManager<Contact> manager;
    private final ContactValidator validator;

    @Override
    public Contact addContact(Contact contact) throws Exception {
        manager.validate(contact, validator);
        manager.setMetaData(contact);
        return repository.save(contact);
    }

}
