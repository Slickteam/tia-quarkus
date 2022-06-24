package fr.slickteam.tiaquarkus.repository;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import fr.slickteam.tiaquarkus.entity.Dog;
import fr.slickteam.tiaquarkus.entity.Human;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@DBRider
@DBUnit(schema = "public", caseSensitiveTableNames = true, cacheConnection = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActivateRequestContext
public class DogRepositoryTest {

    @Inject
    protected DogRepository dogRepository;

    @Test
    @DataSet(value = "dogsAndHumans.yml")
    void findAll() {
        List<Dog> dogs = dogRepository.findAll().list();
        assertThat(dogs).hasSize(3);
    }

    @Test
    @DataSet(value = "dogsAndHumans.yml")
    void findById() {
        Dog dog = dogRepository.findById(1001L);
        assertThat(dog).extracting("name").isEqualTo("Toutou");
    }

}
