package fr.slickteam.tiaquarkus.repository;

import fr.slickteam.tiaquarkus.entity.Dog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogRepository implements PanacheRepository<Dog> {

}
