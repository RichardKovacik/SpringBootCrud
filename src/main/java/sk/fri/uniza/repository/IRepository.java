package sk.fri.uniza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.fri.uniza.model.Zamestnanec;

public interface IRepository extends JpaRepository<Zamestnanec,Integer> {

}
