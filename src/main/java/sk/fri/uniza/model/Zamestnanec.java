package sk.fri.uniza.model;

import com.sun.istack.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "zamestnanci")
public class Zamestnanec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "age", nullable = false, length = 3)
    private int age;

    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date date;

    public Zamestnanec() {
        this.date = new Date(System.currentTimeMillis());
    }

    public Zamestnanec(String name, int age) {
        this.name = name;
        this.age = age;
        this.date = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Zamestnanec{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
