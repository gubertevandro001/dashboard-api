package alfa.tickets.api.dashboard.infrastructure.module.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.ticket.persistence.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MODULE")
public class Module implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "module")
    private List<Ticket> tickets;

    public Module() {}

    private Module(final Long id, final String name) {
        this.id = id;
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public static Module with(final Long id, final String name) {
        return new Module(id, name);
    }

    public static Module with(final Module module) {
        return with(module.getId(), module.getName());
    }

    public Module addTicket(final Ticket ticket) {
        this.tickets.add(ticket);
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

}
