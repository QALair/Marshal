package jaxb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Service
@Table(name = "Emit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Emit", propOrder={"CNPJ","xNome"})
public class Emit {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @XmlElement(name="CNPJ")
    private String CNPJ;
    @XmlElement(name="xNome")
    private String xNome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCNPJ() {return CNPJ;}
    public void setCNPJ(String CNPJ) {this.CNPJ = CNPJ;}
    public String getxNome() {return xNome;}
    public void setxNome(String xNome) {this.xNome = xNome;}
    public Emit(Integer id, String CNPJ, String xNome){
        super();
        this.id = id;
        this.CNPJ = CNPJ;
        this.xNome = xNome;
    }
    public Emit(String CNPJ, String xNome){
        super();
        this.CNPJ = CNPJ;
        this.xNome = xNome;
    }
    @Autowired
    public Emit() {
        super();
    }

    @Override
    public String toString() {
        return "Emit{" +
                "ID='" + id + '\''+
                ", CNPJ='" + CNPJ + '\'' +
                ", xNome='" + xNome + '\'' +
                '}';
    }
}
