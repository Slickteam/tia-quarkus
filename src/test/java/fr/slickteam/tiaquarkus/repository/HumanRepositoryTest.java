package fr.slickteam.tiaquarkus.repository;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import fr.slickteam.tiaquarkus.entity.Human;
import fr.slickteam.tiaquarkus.repository.HumanRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@DBRider
@DBUnit(schema = "public", caseSensitiveTableNames = true, cacheConnection = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActivateRequestContext
public class HumanRepositoryTest {

    @Inject
    protected HumanRepository humanRepository;

    @Inject
    protected DogRepository dogRepository;

    @BeforeAll
    @Transactional
    void init() {
        dogRepository.deleteAll();
        humanRepository.deleteAll();
    }

    @Test
    @DataSet(value = "humans.yml")
    void findAll() {
        List<Human> humans = humanRepository.findAll().list();
        assertThat(humans).hasSize(3);
    }

    @Test
    @DataSet(value = "humans.yml")
    void findById() {
        Human human = humanRepository.findById(3001L);
        assertThat(human).extracting("name").isEqualTo("Michel");
    }

}
