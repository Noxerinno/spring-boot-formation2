package com.capgemini.springboot.tickets.events;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

    private final List<Venue> venues = List.of(
            new Venue(201, "Globomatics Main Office", "Test Street 325", "Melin", "USA"),
            new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "New York", "Indonesia")
    );

    public List<Venue> findAll() {
        return venues;
    }

    public Optional<Venue> findById(int id) {
        return venues.stream().filter(venue -> venue.id() == id).findAny();
    }
}
