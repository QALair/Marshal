package jaxb;

import jaxb.repository.EmitRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmitService implements ApplicationRunner {

    private static final Logger LOGGER = Logger.getLogger(EmitService.class.getName());

    private final EmitRepository repository;

    public EmitService (EmitRepository repository){
        this.repository = repository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Emit emit = new Emit("01.031.451/0001-71","Nome ficticio");
        LOGGER.log(Level.INFO,"Persist");
        repository.save(emit);
        LOGGER.log(Level.INFO, emit.toString());

        LOGGER.log(Level.INFO, "Find");
        repository.findById(Math.toIntExact(emit.getId())).ifPresent(it -> {
            LOGGER.log(Level.INFO, emit.toString());
        });
        Emit emit2 = new Emit("01.031.451/0001-72","Nome ficticio2");

        LOGGER.log(Level.INFO, "Persist");
        repository.save(emit2);
        LOGGER.log(Level.INFO, emit2.toString());

        emit2.setxNome("Nome ficticio3");
        LOGGER.log(Level.INFO, "Update");
        repository.save(emit2);
        LOGGER.log(Level.INFO, emit2.toString());

        LOGGER.log(Level.INFO, "FindAll");
        repository.findAll().forEach(it -> LOGGER.log(Level.INFO, it.toString()));

        LOGGER.log(Level.INFO, "Delete");
        repository.delete(emit2);
        LOGGER.log(Level.INFO, emit2.toString());
    }
}
