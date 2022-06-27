package jaxb;

import lombok.Builder;
import lombok.Data;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Data
@Builder
@Entity
@Service
@Table(name = "Emit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Emit", propOrder={"CNPJ","xNome"})
@NoArgsConstructor
public class Emit {
    @Id
    @Column(name = "id", nullable = false)
    @XmlTransient
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @XmlElement(name="CNPJ")
    private String CNPJ;
    @XmlElement(name="xNome")
    private String xNome;

    public Emit(Integer id, String CNPJ, String xNome) {
        super();
        this.id = id;
        this.CNPJ = CNPJ;
        this.xNome = xNome;
    }

    public Emit(String CNPJ, String xNome) {
        super();
        this.CNPJ = CNPJ;
        this.xNome = xNome;
    }

//    public Emit() {
//        super();
//    }

}
