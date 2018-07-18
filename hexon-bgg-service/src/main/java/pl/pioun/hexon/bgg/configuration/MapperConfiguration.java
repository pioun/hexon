package pl.pioun.hexon.bgg.configuration;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pioun.hexon.bgg.mapper.BggBoardgameMapper;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.bgg.model.Item;

@Configuration
public class MapperConfiguration {

    @Bean
    public MapperFactory mapperFactory() {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(BggBoardgame.class, Item.class).customize(new BggBoardgameMapper())
            .register();

        return mapperFactory;
    }


}
