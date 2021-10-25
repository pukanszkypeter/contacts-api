package hu.futureofmedia.task.contactsapi.adapters.factories.contact.manipulation;

import hu.futureofmedia.task.contactsapi.usecases.contact.manipulation.ManipulationContactDataHandler;
import hu.futureofmedia.task.contactsapi.usecases.contact.manipulation.ManipulationContactInteraction;
import hu.futureofmedia.task.contactsapi.usecases.contact.manipulation.ManipulationContactUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ManipulationContactUseCaseMaker implements ManipulationContactUseCaseFactory {

    private final ManipulationContactDataHandler dataHandler;

    @Override
    public ManipulationContactUseCase create() {
        return new ManipulationContactInteraction(dataHandler);
    }

}
