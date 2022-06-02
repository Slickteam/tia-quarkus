package fr.slickteam.tiaquarkus.repository;

import fr.slickteam.tiaquarkus.entity.Human;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HumanRepository implements PanacheRepository<Human> {

}
