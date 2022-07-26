package jaxb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "nfeProc")
@XmlType(propOrder={"versao","nFe"})
public class NfeProc {
    @XmlAttribute(name = "versao")
    private String versao = "2.0";
    @XmlElement(name="nFe",required = true)
    private NFe nFe;

    // Getters e setters
    public String getVersao() {return this.versao;}
    public void setVersao(String versao) {
        this.versao = versao;
    }
    public NFe getnFe() {return this.nFe;}
    public void setnFe(NFe nFe) {this.nFe = nFe;}

    @Autowired
    public NfeProc(String versao,NFe nFe){
        this.versao = versao;
        this.nFe = nFe;
    }

    @Override
    public String toString() {
        return "NfeProc{" +
                "versao='" + versao + '\'' +
                ", nFe=" + nFe +
                '}';
    }

}
