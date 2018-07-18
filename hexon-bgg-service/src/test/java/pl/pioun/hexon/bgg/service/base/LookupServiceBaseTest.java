package pl.pioun.hexon.bgg.service.base;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pioun.hexon.bgg.configuration.HexonBggSpringBootTest;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.bgg.service.LookupService;

@HexonBggSpringBootTest
@RunWith(SpringRunner.class)
public class LookupServiceBaseTest {

    @Autowired
    private LookupService lookupService;

    @Test
    public void sth() {
        final List<BggBoardgame> boardgames = lookupService.lookup("Vikings Gone Wild");

        assertThat(boardgames).isNotEmpty();
        assertThat(boardgames.stream().findFirst().get()).hasNoNullFieldsOrProperties();
    }

}