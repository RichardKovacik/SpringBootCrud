package sk.fri.uniza.service;

import org.springframework.beans.factory.annotation.Autowired;
import sk.fri.uniza.dao.ZamestanecDao;
import sk.fri.uniza.model.Zamestnanec;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ZamestnanecServiceImpl implements Service<Zamestnanec> {

    @Autowired
    private ZamestanecDao zamestanecDao;

    @Override
    public void pridaj(Zamestnanec o) {
        zamestanecDao.pridaj(o);
    }

    @Override
    public void update(Zamestnanec o) {
        zamestanecDao.update(o);
    }

    @Override
    public void vymaz(Zamestnanec o) {
        zamestanecDao.vymaz(o);
    }

    @Override
    public Zamestnanec getElemet(int id) {
        return zamestanecDao.getElemet(id);
    }

    @Override
    public List<Zamestnanec> getZoznam() {
        return zamestanecDao.getZoznam();
    }
}
