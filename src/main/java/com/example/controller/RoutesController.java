package com.example.controller;

import com.example.model.Route;
import com.example.repository.RoutesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Work on 11/06/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class RoutesController {

    @Autowired
    private RoutesRepository routesRepository;

    @RequestMapping(value = "routes", method = RequestMethod.GET)
    public List<Route> list() {
        return routesRepository.findAll();
    }

    @RequestMapping(value = "routes", method = RequestMethod.POST)
    public Route create(@RequestBody Route route) {
        return routesRepository.saveAndFlush(route);
    }

    @RequestMapping(value = "routes/{id}", method = RequestMethod.GET)
    public Route get(@PathVariable long id) {
        return routesRepository.findOne(id);
    }

    @RequestMapping(value = "routes/{id}", method = RequestMethod.PUT)
    public Route update(@PathVariable long id,@RequestBody Route route) {
        Route existingRoute = routesRepository.findOne(id);
        BeanUtils.copyProperties(route, existingRoute);
        return routesRepository.saveAndFlush(route);
    }

    @RequestMapping(value = "routes/{id}", method = RequestMethod.DELETE)
    public Route delete(@PathVariable long id) {
        Route existingRoute = routesRepository.findOne(id);
        routesRepository.delete(existingRoute);
        return existingRoute;
    }
}
