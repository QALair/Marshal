package jaxb;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="NFe",propOrder={"infNFe","Signature"},namespace="http://www.portalfiscal.inf.br/nfe")
public class NFe{
    @XmlElement(name="infNFe")
    private InfNfe infNFe;
    @XmlElement(name="Signature")
    private String Signature;
    @XmlAttribute(name="xmlns")
    private String xmlns;


    public InfNfe getinfNFe() {
        return infNFe;
    }
    public void setInfNFE(InfNfe infNFe) {
        this.infNFe = infNFe;
    }
    public String getSignature() {
        return this.Signature;
    }
    public void setSignature(String signature) {
        this.Signature = signature;
    }


    public String getXmlns() {return this.xmlns;    }
    public void setXmlns(String xmlns) {this.xmlns = xmlns;    }

    public NFe(String xmlns, InfNfe infNFe){
        this.xmlns  = xmlns;
        this.infNFe = infNFe;
    }

    public NFe(){
    }

    @Override
    public String toString() {
        return "NFe{" +
                "infNFe=" + infNFe +
                ", Signature='" + Signature + '\'' +
                ", xmlns='" + xmlns + '\'' +
                '}';
    }
}
