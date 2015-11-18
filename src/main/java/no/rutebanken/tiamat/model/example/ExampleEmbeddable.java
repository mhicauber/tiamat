package no.rutebanken.tiamat.model.example;


import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.util.Date;

@Embeddable
public class ExampleEmbeddable {

    public Date date;

    @OneToOne
    public AnotherExampleEntity anotherExampleEntity;
}