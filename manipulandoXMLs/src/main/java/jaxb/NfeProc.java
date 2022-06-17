package jaxb;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.portalfiscal.inf.br/nfe", name = "nfeProc")
@XmlType(propOrder={"versao","xmlns","xmlnsds","xmlnsxsi","nFe"})
public class NfeProc {
    @XmlAttribute(name = "versao")
    private String versao;
    @XmlAttribute(name = "xmlns")
    private String xmlns;
    @XmlAttribute(name = "xmlns:ds")
    private String xmlnsds;
    @XmlAttribute(name = "xmlns:xsi")
    private String xmlnsxsi;
    @XmlElement(name="nFe",namespace="http://www.portalfiscal.inf.br/nfe",required = true)
    private NFe nFe;

    // Getters e setters
    public String getVersao() {return versao;}
    public void setVersao(String versao) {
        this.versao = versao;
    }
    public String getXmlns() {
        return xmlns;
    }
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
    public String getXmlnsds() {
        return xmlnsds;
    }
    public void setXmlnsds(String xmlnsds) {
        this.xmlnsds = xmlnsds;
    }
    public String getXmlnsxsi() {
        return xmlnsxsi;
    }
    public void setXmlnsxsi(String xmlnsxsi) {
        this.xmlnsxsi = xmlnsxsi;
    }
    public NFe getnFe() {return nFe;}
    public void setnFe(NFe nFe) {this.nFe = nFe;}

    public NfeProc(String versao,String xmlns,String xmlnsds,String xmlnsxsi,NFe nFe){
        this.versao = versao;
        this.xmlns = xmlns;
        this.xmlnsds = xmlnsds;
        this.xmlnsxsi = xmlnsxsi;
        this.nFe = nFe;
    }
    public NfeProc(){
    }
    public NfeProc(NFe nFe){
        this.nFe = nFe;
    }

    @Override
    public String toString() {
        return "NfeProc{" +
                "versao='" + versao + '\'' +
                ", xmlns='" + xmlns + '\'' +
                ", xmlnsds='" + xmlnsds + '\'' +
                ", xmlnsxsi='" + xmlnsxsi + '\'' +
                ", nFe=" + nFe +
                '}';
    }
}
