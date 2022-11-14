package com.emse.spring.faircorp.model;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    public Building() {
    }

    public Building(String name) {
        this.name = name;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Set<Room> getRoom() {

        return rooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
}


