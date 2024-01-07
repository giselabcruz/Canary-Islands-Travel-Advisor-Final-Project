package org.gisela.dacd.businessunit;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Schema(description = "All details about the travel. ")
public class Travel {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String passportNumber;

    public Travel() {
        super();
    }

    public Travel(Long id) {
        super();
        this.id = id;
    }
}
