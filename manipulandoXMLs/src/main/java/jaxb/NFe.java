package jaxb;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NFe",propOrder={"infNFe","Signature"})
@XmlRootElement(name="NFe")
public class NFe{
    @XmlElement(name="infNFe")
    private InfNfe infNFe;
    @XmlElement(name="Signature")
    private String Signature;


    public InfNfe getinfNFe() {
        return this.infNFe;
    }
    public void setInfNFE(InfNfe infNFe) {
        this.infNFe = infNFe;
    }
    public String getSignature() {return Signature;}
    public void setSignature(String signature) {
        this.Signature = signature;
    }

    @Autowired
    public NFe(InfNfe infNFe){
        super();
        this.infNFe = infNFe;
    }
    public NFe(){
        super();
    }

    @Override
    public String toString() {
        return "NFe{" +
                "infNFe=" + infNFe +
                ", Signature='" + Signature + '\'' +
                '}';
    }
}
