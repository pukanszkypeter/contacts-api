package hu.futureofmedia.task.contactsapi.usecases.contact.manipulation;

import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ManipulationContactInteraction implements ManipulationContactUseCase {

    private final ManipulationContactDataHandler dataHandler;

    @Override
    public Contact addContact(Contact contact) throws Exception {
        return dataHandler.addContact(contact);
    }

}
