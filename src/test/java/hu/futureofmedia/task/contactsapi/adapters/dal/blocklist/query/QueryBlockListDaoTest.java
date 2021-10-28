package hu.futureofmedia.task.contactsapi.adapters.dal.blocklist.query;

import hu.futureofmedia.task.contactsapi.application.repositories.blocklist.BlockListRepository;
import hu.futureofmedia.task.contactsapi.models.entities.BlockList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QueryBlockListDaoTest {

    @Mock
    private BlockListRepository repository;

    @InjectMocks
    private QueryBlockListDao dao;

    @Test
    public void shouldFindAllBlockList() {
        BlockList example_1 = new BlockList(1, "maildrop.cc");
        BlockList example_2 = new BlockList(2, "noreply.com");
        BlockList example_3 = new BlockList(3, "trashmail.se");
        Iterable<BlockList> blockList = Arrays.asList(example_1, example_2, example_3);

        Mockito.when(repository.findAll()).thenReturn(blockList);

        List<BlockList> list =  dao.findAll();

        assertEquals(3, list.size());
        assertEquals("maildrop.cc", list.get(0).getDomain());
        assertEquals(3, list.get(2).getId());
    }

}
