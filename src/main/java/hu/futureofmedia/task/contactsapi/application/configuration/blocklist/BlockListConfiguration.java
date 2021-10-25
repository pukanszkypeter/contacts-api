package hu.futureofmedia.task.contactsapi.application.configuration.blocklist;

import hu.futureofmedia.task.contactsapi.adapters.dal.blocklist.query.QueryBlockListDao;
import hu.futureofmedia.task.contactsapi.adapters.factories.blocklist.query.QueryBlockListUseCaseFactory;
import hu.futureofmedia.task.contactsapi.adapters.factories.blocklist.query.QueryBlockListUseCaseMaker;
import hu.futureofmedia.task.contactsapi.application.repositories.blocklist.BlockListRepository;
import hu.futureofmedia.task.contactsapi.usecases.blocklist.query.QueryBlockListDataHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlockListConfiguration {

    @Bean
    public QueryBlockListDataHandler queryBlockListDataHandler(BlockListRepository blockListRepository) {
        return new QueryBlockListDao(blockListRepository);
    }

    @Bean
    public QueryBlockListUseCaseFactory queryBlockListUseCaseFactory(QueryBlockListDataHandler queryBlockListDataHandler) {
        return new QueryBlockListUseCaseMaker(queryBlockListDataHandler);
    }

}
