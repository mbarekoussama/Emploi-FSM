package pi.enset;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pi.enset.entities.Module;
import pi.enset.entities.*;
import pi.enset.entities.enums.NumeroSemester;
import pi.enset.entities.enums.Periode;
import pi.enset.entities.enums.TypeAdmin;
import pi.enset.entities.enums.TypeSalle;
import pi.enset.repository.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class PiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiApplication.class, args);
    }

    @Bean
    CommandLineRunner lineRunner(UserRepository userRepository,
            DepartementRepostitory departementRepostitory,
            ClasseRepository classeRepository,
            ElementModuleRepository elementModuleRepository,
            SemestreRepository semestreRepository,
            SalleRepository salleRepository,
            FiliereRepository filiereRepository, ModuleRepository moduleRepository,
            NonDisponibiliteRepository nonDisponibiliteRepository) {
        return args -> {
            // Create the Admin
            Admin admin = new Admin();
            admin.setNom("oussama");
            admin.setPrenom("oussama");
            admin.setEmail("admin@admin.com");
            admin.setPassword("admin");
            admin.setTel("29292929");
            admin.setCivilite("M");
            admin.setLogin("admin");
            admin.setCne("88888888");
            admin.setAdmin_type(TypeAdmin.SUPER_ADMIN);
            userRepository.save(admin);

        };

    }

}
