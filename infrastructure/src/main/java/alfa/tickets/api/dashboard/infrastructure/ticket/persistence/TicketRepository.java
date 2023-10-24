package alfa.tickets.api.dashboard.infrastructure.ticket.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = " FROM Ticket t WHERE EXTRACT(MONTH FROM t.openingDate) = :month AND EXTRACT(YEAR FROM t.openingDate) = :year")
	List<Ticket> findAllTicketsByYearAndMonth(@Param("month") Integer month, @Param("year") Integer year);
}
