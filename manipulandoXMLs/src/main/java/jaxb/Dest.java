package jaxb;

import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="dest", propOrder={"CPF","CNPJ","xNome", "xFantasia"})
public class Dest {
    @XmlElement(name="CPF")
    private String CPF;
    @XmlElement(name="CNPJ")
    private String CNPJ;
    @XmlElement(name="xNome")
    private String xNome;
    @XmlElement(name="xFantasia")
    private String xFantasia;


    public Dest(String CPF, String xNome) {
        this.CPF = CPF;
        this.xNome = xNome;
    }

    public Dest(String CNPJ, String xNome, String xFantasia) {
        this.CNPJ = CNPJ;
        this.xNome = xNome;
        this.xFantasia = xFantasia;
    }
}
