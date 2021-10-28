package hu.futureofmedia.task.contactsapi.adapters.factories.contact.query;

import hu.futureofmedia.task.contactsapi.usecases.contact.query.QueryContactDataHandler;
import hu.futureofmedia.task.contactsapi.usecases.contact.query.QueryContactInteraction;
import hu.futureofmedia.task.contactsapi.usecases.contact.query.QueryContactUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QueryContactUseCaseMaker implements QueryContactUseCaseFactory {

    private final QueryContactDataHandler dataHandler;

    @Override
    public QueryContactUseCase create() {
        return new QueryContactInteraction(dataHandler);
    }

}
