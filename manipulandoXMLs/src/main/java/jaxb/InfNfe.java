package jaxb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="infNFe", propOrder={"versao","ide","emit", "dest"})
@XmlRootElement(name="infNFe")
public class InfNfe{
    @XmlElement(name="ide")
    private String ide;
    @XmlElement(name="emit",required = true)
    private Emit emit;
    @XmlAttribute(name="versao")
    private String versao = "1.0";
    @XmlElement(name="dest",required = true)
    private Dest dest;

    @Autowired
    public InfNfe(String versao, Emit emit, Dest dest){
        super();
        this.versao = versao;
        this.emit = emit;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "InfNfe{" +
                "ide='" + ide + '\'' +
                ", emit=" + emit +
                ", dest=" + dest +
                ", versao='" + versao + '\'' +
                '}';
    }
}
