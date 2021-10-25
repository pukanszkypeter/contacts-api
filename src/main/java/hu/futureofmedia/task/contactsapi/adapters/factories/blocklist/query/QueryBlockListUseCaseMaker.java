package hu.futureofmedia.task.contactsapi.adapters.factories.blocklist.query;

import hu.futureofmedia.task.contactsapi.usecases.blocklist.query.QueryBlockListDataHandler;
import hu.futureofmedia.task.contactsapi.usecases.blocklist.query.QueryBlockListInteraction;
import hu.futureofmedia.task.contactsapi.usecases.blocklist.query.QueryBlockListUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QueryBlockListUseCaseMaker implements QueryBlockListUseCaseFactory {

    private final QueryBlockListDataHandler dataHandler;

    @Override
    public QueryBlockListUseCase create() {
        return new QueryBlockListInteraction(dataHandler);
    }

}
