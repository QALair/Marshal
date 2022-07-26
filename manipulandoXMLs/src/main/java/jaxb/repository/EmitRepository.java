package jaxb.repository;
import jaxb.Emit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmitRepository extends JpaRepository<Emit, Integer>{
}
