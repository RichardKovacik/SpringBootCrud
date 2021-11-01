package sk.fri.uniza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.fri.uniza.model.Zamestnanec;
import sk.fri.uniza.repository.IRepository;

import java.util.List;

@Service
public class ZamestnanecService {
    @Autowired
    private IRepository repo;

    public List<Zamestnanec> getListAll() {
        return repo.findAll();
    }

    public Zamestnanec uloz(Zamestnanec zamestnanec) {
        return repo.save(zamestnanec);
    }


}
