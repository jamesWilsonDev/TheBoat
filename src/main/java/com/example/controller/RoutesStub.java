package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Route;

public class RoutesStub {
	private static Map<Long, Route> routes = new HashMap<Long, Route>();
	private static Long idIndex = 3L;

	//populate initial routes
	static {
		Route a = new Route(1L, "Route 1", "Description 1", "FAIR", 5000.00);
		routes.put(1L, a);
		Route b = new Route(2L, "Route 2", "Description 2", "GOOD", 2345.12);
		routes.put(2L, b);
		Route c = new Route(3L, "Route 3", "Description 3", "FAIR", 3245.12);
		routes.put(3L, c);
	}

	public static List<Route> list() {
		return new ArrayList<Route>(routes.values());
	}

	public static Route create(Route route) {
		idIndex += idIndex;
		route.setId(idIndex);
		routes.put(idIndex, route);
		return route;
	}

	public static Route get(Long id) {
		return routes.get(id);
	}

	public static Route update(Long id, Route route) {
		routes.put(id, route);
		return route;
	}

	public static Route delete(Long id) {
		return routes.remove(id);
	}
}
