//package rinha.backend.configuration;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import rinha.backend.domain.model.Client;
//import rinha.backend.domain.repositories.ClientRepository;
//
//import java.util.Arrays;
//
//@Configuration
//@RequiredArgsConstructor
//public class StartProjectConfigurations implements CommandLineRunner {
//
//    private final ClientRepository repository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Client client1 = new Client(1L, "Samuel", 0, 100000);
//
//        Client client2 = new Client(2L, "Client2", 0, 80000);
//
//        Client cliente3 = new Client(3L, "Client4", 0, 1000000);
//
//        Client client4 = new Client(4L, "cliente5", 0, 10000000);
//
//        Client client5 = new Client(5L, "Client6", 0, 500000);
//
//        repository.saveAll(
//                Arrays.asList(client1, client2, cliente3, client4, client5)
//        );
//    }
//}
