package com.example;

import com.example.controller.RoutesController;
import com.example.model.Route;
import com.example.repository.RoutesRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Work on 12/06/2016.
 */
public class RoutesControllerTest {

    @InjectMocks
    private RoutesController rc;

    @Mock
    private RoutesRepository routesRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRouteGet() {
        Route r = new Route();
        r.setId(1l);
        when(routesRepository.findOne(1l)).thenReturn(r);

        Route route = rc.get(1l);
        verify(routesRepository).findOne(1l);
        //assertEquals(route.getId().longValue(), 1l);
        assertThat(route.getId(), is(1l));
    }
}
