package sk.fri.uniza;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import sk.fri.uniza.repository.IRepository;
import sk.fri.uniza.model.Zamestnanec;

import java.util.Date;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ZamestanecDaoTest {
    @Autowired
    private IRepository repo;

    @Test
    void pridaj() {
        Zamestnanec zamestnanec = new Zamestnanec("Michael Grey",20);
        Zamestnanec zamestnanec1 = repo.save(zamestnanec);
        Assertions.assertThat(zamestnanec1).isNotNull();
        org.junit.jupiter.api.Assertions.assertTrue(repo.existsById(zamestnanec.getId()));
    }

    @ParameterizedTest
    @ValueSource(ints = {7})
    void testOdober(int id) {
        boolean exitujeID = repo.existsById(id);
        System.out.println(exitujeID);

        if (exitujeID) {
            Optional<Zamestnanec> zamestnanec = repo.findById(id);
            zamestnanec.ifPresent(value -> repo.delete(value));
            org.junit.jupiter.api.Assertions.assertFalse(repo.existsById(id));
        }
        System.out.println("polozka s takymto id neexistuje v db");
    }
    @Test
    void testList(){
        Iterable<Zamestnanec> vsetci = repo.findAll();
        Assertions.assertThat(vsetci).hasSizeGreaterThan(0);
    }
}
