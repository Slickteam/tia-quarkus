package fr.slickteam.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Human {
    @Id @GeneratedValue
    private Long id;
    public String name;
    public LocalDate birth;
}
