package fr.slickteam.entity;

import fr.slickteam.entity.Human;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Long id;
    public String name;
    public LocalDate birth;
    @ManyToOne(targetEntity=Human.class, fetch=FetchType.EAGER)
    @JoinColumn(name="human_id")
    public Human owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
}