package sk.fri.uniza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.fri.uniza.model.Zamestnanec;
import sk.fri.uniza.service.ZamestnanecServiceImpl;

import java.util.Date;

@SpringBootApplication
public class SpringBootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudApplication.class, args);
    }

}
