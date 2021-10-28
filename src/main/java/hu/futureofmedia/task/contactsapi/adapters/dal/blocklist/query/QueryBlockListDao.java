package hu.futureofmedia.task.contactsapi.adapters.dal.blocklist.query;

import hu.futureofmedia.task.contactsapi.application.repositories.blocklist.BlockListRepository;
import hu.futureofmedia.task.contactsapi.models.entities.BlockList;
import hu.futureofmedia.task.contactsapi.usecases.blocklist.query.QueryBlockListDataHandler;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QueryBlockListDao implements QueryBlockListDataHandler {

    private final BlockListRepository repository;

    @Override
    public List<BlockList> findAll() {
        return (List<BlockList>) repository.findAll();
    }

}
