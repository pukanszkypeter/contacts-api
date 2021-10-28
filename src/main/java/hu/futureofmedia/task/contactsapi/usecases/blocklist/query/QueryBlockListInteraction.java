package hu.futureofmedia.task.contactsapi.usecases.blocklist.query;

import hu.futureofmedia.task.contactsapi.models.entities.BlockList;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QueryBlockListInteraction implements QueryBlockListUseCase {

    private final QueryBlockListDataHandler dataHandler;

    @Override
    public List<BlockList> findAll() {
        return dataHandler.findAll();
    }

}
