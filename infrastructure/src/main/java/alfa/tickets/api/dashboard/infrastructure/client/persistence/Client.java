package alfa.tickets.api.dashboard.infrastructure.client.persistence;

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
@Table(name = "CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 4147084254867454512L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;

    public Client() {}

    private Client(final Long id, final String name) {
        this.id = id;
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public static Client with(final Long id, final String name) {
        return new Client(id, name);
    }

    public static Client with(final Client client) {
        return with(client.getId(), client.getName());
    }

    public Client addTicket(final Ticket ticket) {
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
