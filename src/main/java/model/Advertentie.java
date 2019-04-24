package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Advertentie.findOne", query = "select a from Advertentie a where a.id = :id"),
        @NamedQuery(name = "Advertentie.getAll", query = "select a from Advertentie a")
}
)
@Table(name = "Advertentie")
public class Advertentie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "advertentie_id")
    private Integer id;
    @Column(name = "titel")
    private String Naam;

    public Advertentie() {

    }

    public Advertentie(String naam) {
    }

    public Integer getId() {
        return id;
    }

    public Advertentie setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNaam() {
        return Naam;
    }

    public Advertentie setNaam(String naam) {
        Naam = naam;
        return this;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_id", referencedColumnName = "auto_id")
    private Auto auto;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public User getUser() {
        return user;
    }

    public Advertentie setUser(User user){
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return id + " " + Naam;
    }
}
