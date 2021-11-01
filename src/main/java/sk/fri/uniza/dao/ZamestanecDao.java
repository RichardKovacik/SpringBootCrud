package sk.fri.uniza.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.fri.uniza.model.Zamestnanec;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ZamestanecDao implements Dao<Zamestnanec> {

    @Autowired
    private EntityManager manager;

    @Override
    public void pridaj(Zamestnanec zamestnanec) {
        getSession().save(zamestnanec);

    }

    @Override
    public void update(Zamestnanec zamestnanec) {
        getSession().update(zamestnanec);
    }

    @Override
    public void vymaz(Zamestnanec zamestnanec) {
        getSession().delete(zamestnanec);
    }

    @Override
    public Zamestnanec getElemet(int id) {
       return getSession().get(Zamestnanec.class, id);
    }

    @Override
    public List<Zamestnanec> getZoznam() {
        List list = getSession().createSQLQuery("select * from zoznam.zamestnanci").addEntity(Zamestnanec.class).getResultList();
       // System.out.println(list);
        return list;
    }
    private Session getSession(){
        return manager.unwrap(Session.class);
    }
}
