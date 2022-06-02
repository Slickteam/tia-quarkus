package fr.slickteam.repository;

import fr.slickteam.entity.Human;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HumanRepository implements PanacheRepository<Human> {

}
