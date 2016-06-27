package com.example;

import com.example.model.Route;
import com.example.repository.RoutesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Work on 12/06/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TheBoatApplication.class)
public class RouteRepositoryIntegrationTest {

    @Autowired
    private RoutesRepository routesRepository;

    @Test
    public void testFindAll() {
        List<Route> wrecks = routesRepository.findAll();
        assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
    }
}
