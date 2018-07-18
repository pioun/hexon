package pl.pioun.hexon.bgg.service.base;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pioun.hexon.bgg.configuration.HexonBggSpringBootTest;
import pl.pioun.hexon.bgg.model.Item;
import pl.pioun.hexon.bgg.service.BggService;

@HexonBggSpringBootTest
@RunWith(SpringRunner.class)
public class BggServiceBaseTest {

    @Autowired
    private BggService bggService;

    @Test
    public void shouldReturnNotEmptyGameList() {
        final List<Item> items = bggService.findItems("Vikings gone wild");

        assertThat(items).isNotEmpty();
    }

    @Test
    public void shouldReturnEmptyGameList() {
        final List<Item> items = bggService.findItems(RandomStringUtils.randomAlphabetic(30));

        assertThat(items).isNull();
    }

    @Test
    public void shouldReturnNotEmptyThingList() {
        final List<Item> items = bggService
            .findBoardgames(Collections.singletonList(Item.builder().id("12345").build()));

        assertThat(items).isNotEmpty();
    }

}