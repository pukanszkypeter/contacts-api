package hu.futureofmedia.task.contactsapi.usecases.contact.manipulation;

import hu.futureofmedia.task.contactsapi.models.entities.Contact;

public interface ManipulationContactUseCase {

    Contact addContact(Contact contact) throws Exception;

}
