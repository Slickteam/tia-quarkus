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
}