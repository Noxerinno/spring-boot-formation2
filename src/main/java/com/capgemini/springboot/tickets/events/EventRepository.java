package com.capgemini.springboot.tickets.events;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    private final List<Event> events = List.of(
            new Event(501, "Globomatics Tech Conference",
                    new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
                    new Venue(201, "Globomatics Main Office", "Test Street 325", "Melin", "USA"),
                    LocalDate.of(2024, 10, 2), LocalDate.of(2024, 10, 4)),
            new Event(502, "Globomatics Developer Day",
                    new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
                    new Venue(201, "Globomatics Main Office", "Test Street 325", "Melin", "USA"),
                    LocalDate.of(2024, 11, 10), LocalDate.of(2024, 11, 10)),
            new Event(503, "Carved Rock New Products Day",
                    new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"),
                    new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "New York", "Indonesia"),
                    LocalDate.of(2024, 12, 29), LocalDate.of(2024, 12, 29))
    );

    public List<Event> findByOrganizerId(int organizerId) {
        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(event -> event.id() == id).findAny();
    }

    public List<Event> findAll() {
        return events;
    }
}
