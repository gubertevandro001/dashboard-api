package alfa.tickets.api.dashboard.infrastructure.ticket.persistence;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import alfa.tickets.api.dashboard.infrastructure.client.persistence.Client;
import alfa.tickets.api.dashboard.infrastructure.module.persistence.Module;
import alfa.tickets.api.dashboard.infrastructure.utils.DateUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "FK_ID_CLIENT")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "FK_ID_MODULE")
    private Module module;

    @Column(name = "OPENING_DATE")
    private LocalDate openingDate;

    @Column(name = "CLOSING_DATE")
    private LocalDate closingDate;

    public Ticket() {}

    private Ticket(final Long id, final String title, final Client client, final Module module) {
        this.id = Objects.requireNonNull(id);
        this.title = title;
        this.client = client;
        this.module = module;
        this.openingDate = DateUtils.getActualDate();
    }

    private Ticket(final String title, final Client client, final Module module) {
        this.title = title;
        this.client = client;
        this.module = module;
        this.openingDate = DateUtils.getActualDate();
    }


    public static Ticket newTicket(final String title, final Client client, final Module module) {
        return new Ticket(title, client, module);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Client getClient() {
        return client;
    }

    public Module getModule() {
        return module;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }
}
