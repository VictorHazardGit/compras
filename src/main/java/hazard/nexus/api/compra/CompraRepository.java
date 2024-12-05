package hazard.nexus.api.compra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    Page<Compra> findAllByAtivoTrue(Pageable paginacao);
}
