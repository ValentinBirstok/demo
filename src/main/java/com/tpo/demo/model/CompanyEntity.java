package com.tpo.demo.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Company")  // Cambiar de "Movie" a "Company"
public class CompanyEntity {
    @Id
    private final String name;  // Cambiar "title" a "name" para representar una empresa
    @Property("tagline")
    private final String description;
    
    @Relationship(type = "EMPLOYED_BY", direction = INCOMING)  // Cambiar "ACTED_IN" a "EMPLOYED_BY"
    private Set<PersonEntity> employees = new HashSet<>();  // Cambiar "actors" a "employees"
    
    @Relationship(type = "MANAGES", direction = INCOMING)  // Cambiar "DIRECTED" a "MANAGES"
    private Set<PersonEntity> bosses = new HashSet<>();  // Cambiar "directors" a "bosses"

    public CompanyEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<PersonEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<PersonEntity> employees) {
        this.employees = employees;
    }

    public Set<PersonEntity> getBosses() {
        return bosses;
    }

    public void setBosses(Set<PersonEntity> bosses) {
        this.bosses = bosses;
    }
}
