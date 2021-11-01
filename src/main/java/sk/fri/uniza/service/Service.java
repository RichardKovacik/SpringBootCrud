package sk.fri.uniza.service;

import java.util.List;

public interface Service<T> {
    void pridaj(T t);

    void update(T t);

    void vymaz(T t);

    T getElemet(int id);

    List<T> getZoznam();
}
