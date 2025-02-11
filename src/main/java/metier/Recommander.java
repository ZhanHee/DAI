package metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recommander")
public class Recommander {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdR")
    private Recommandation recommandation;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdUser")
    private Client client;

    public Recommander() {
    }

    public Recommander(Recommandation recommandation, Client client) {
        this.recommandation = recommandation;
        this.client = client;
    }
    // Getters and Setters

    public Recommandation getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(Recommandation recommandation) {
        this.recommandation = recommandation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recommander that = (Recommander) o;
        return Objects.equals(recommandation, that.recommandation) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recommandation, client);
    }

    @Override
    public String toString() {
        return "Recommander{" +
                "recommandation=" + recommandation +
                ", client=" + client +
                '}';
    }
}