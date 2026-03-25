package com.example.Thymeleaf.Demo.config;

import com.example.Thymeleaf.Demo.Model.Fighter;
import com.example.Thymeleaf.Demo.Model.Player;
import com.example.Thymeleaf.Demo.repository.FighterRepository;
import com.example.Thymeleaf.Demo.repository.PlayerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final PlayerRepository playerRepository;
    private final FighterRepository fighterRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(PlayerRepository playerRepository,
                      FighterRepository fighterRepository,
                      PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.fighterRepository = fighterRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {

        seedAdmin();
        seedFighters();
    }

    private void seedAdmin() {
        Player existingAdmin = playerRepository.findByUsername("admin");

        if (existingAdmin == null) {
            Player admin = new Player();
            admin.setName("Admin");
            admin.setEmail("admin@example.com");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");

            playerRepository.save(admin);
        }
    }

    private void seedFighters() {
        if (fighterRepository.count() > 0) {
            return;
        }

        addFighter("Kazuya Mishima", 1400, 95.0, 8.5);
        addFighter("Xiaoyu Ling", 1050, 42.5, 3.2);
        addFighter("Marshall Law", 1100, 88.75, 6.0);
        addFighter("King", 1350, 92.0, 7.8);
        addFighter("Nina Williams", 1080, 85.5, 5.5);
        addFighter("Hwoarang", 1120, 84.0, 5.2);
        addFighter("Yoshimitsu", 1090, 76.25, 4.8);
        addFighter("Armor King", 1320, 89.0, 7.2);
        addFighter("Paul Phoenix", 1200, 91.5, 6.8);
        addFighter("Jack-8", 1450, 85.0, 9.0);
        addFighter("Asuka Kazama", 1070, 72.0, 4.5);
        addFighter("Steve Fox", 1110, 79.5, 5.3);
        addFighter("Eddy Gordo", 1130, 81.25, 5.6);
        addFighter("Alisa Bosconovitch", 1095, 75.75, 4.9);
        addFighter("Zafina", 1025, 73.5, 4.1);
        addFighter("Lili", 1080, 68.0, 3.8);
        addFighter("Forest Law", 1150, 82.5, 5.8);
        addFighter("Miguel", 1320, 90.25, 7.1);
        addFighter("Sergei Dragunov", 1380, 87.5, 8.2);
        addFighter("Devil Kazuya", 1420, 98.0, 9.2);
        addFighter("Lars Alexandersson", 1200, 80.75, 6.2);
        addFighter("Leo Kliesen", 1160, 83.5, 5.9);
        addFighter("Marduk", 1440, 86.0, 8.8);
        addFighter("Bob", 1460, 78.5, 9.1);
        addFighter("Raven", 1105, 77.25, 5.4);
        addFighter("Kunimitsu II", 1095, 81.0, 5.1);
        addFighter("Lucky Chloe", 1035, 65.5, 3.5);
        addFighter("Claudio Seraphim", 1125, 79.75, 5.5);
        addFighter("Josie Rizal", 1110, 70.25, 4.7);
        addFighter("Katarina Alves", 1140, 75.5, 5.0);
        addFighter("Gigas", 1480, 80.0, 9.3);
        addFighter("Shaheen", 1220, 84.75, 6.5);
        addFighter("Akuma", 1250, 96.5, 7.3);
        addFighter("Ganryu", 1300, 82.0, 7.5);
    }

    private void addFighter(String name, int health, double damage, double resistance) {
        Fighter fighter = new Fighter();
        fighter.setName(name);
        fighter.setHealth(health);
        fighter.setDamage(damage);
        fighter.setResistance(resistance);

        fighterRepository.save(fighter);
    }
}