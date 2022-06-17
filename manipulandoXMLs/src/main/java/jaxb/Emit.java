package jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Emit", propOrder={"CNPJ","xNome"})
public class Emit {
    @XmlElement(name="CNPJ")
    private String CNPJ;
    @XmlElement(name="xNome")
    private String xNome;


    public String getCNPJ() {return CNPJ;}
    public void setCNPJ(String CNPJ) {this.CNPJ = CNPJ;}
    public String getxNome() {return xNome;}
    public void setxNome(String xNome) {this.xNome = xNome;}

    public Emit(String CNPJ, String xNome){
        super();
        this.CNPJ = CNPJ;
        this.xNome = xNome;
    }
    public Emit() {
        super();
    }

    @Override
    public String toString() {
        return "Emit{" +
                "CNPJ='" + CNPJ + '\'' +
                ", xNome='" + xNome + '\'' +
                '}';
    }
}
