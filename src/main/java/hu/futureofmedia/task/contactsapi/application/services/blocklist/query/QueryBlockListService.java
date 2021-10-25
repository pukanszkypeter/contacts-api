package hu.futureofmedia.task.contactsapi.application.services.blocklist.query;

import hu.futureofmedia.task.contactsapi.adapters.factories.blocklist.query.QueryBlockListUseCaseFactory;
import hu.futureofmedia.task.contactsapi.models.entities.BlockList;
import hu.futureofmedia.task.contactsapi.usecases.blocklist.query.QueryBlockListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class QueryBlockListService {

    private QueryBlockListUseCase useCase;

    @Autowired
    public QueryBlockListService(QueryBlockListUseCaseFactory factory) { this.useCase = factory.create(); }

    public List<BlockList> findAll() { return useCase.findAll(); }

}
