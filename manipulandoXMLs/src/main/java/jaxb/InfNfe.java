package jaxb;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="infNFe", propOrder={"versao","ide","emit"})
@XmlRootElement(name="infNFe")
public class InfNfe{
    @XmlElement(name="ide")
    private String ide;
    @XmlElement(name="emit",required = true)
    private Emit emit;
    @XmlAttribute(name="versao")
    private String versao = "1.0";


    public String getIde() {
        return ide;
    }
    public void setIde(String ide) {
        this.ide = ide;
    }
    public Emit getEmit() {
        return this.emit;
    }
    public void setEmit(Emit emit) {
        this.emit = emit;
    }
    public String getVersao() {
        return versao;
    }
    public void setVersao(String versao) {
        this.versao = versao;
    }

    public InfNfe(String versao, Emit emit){
      super();
      this.versao = versao;
      this.emit = emit;
    }

    public InfNfe(){
        super();
    }

    @Override
    public String toString() {
        return "InfNfe{" +
                "ide='" + ide + '\'' +
                ", emit=" + emit +
                ", versao='" + versao + '\'' +
                '}';
    }
}
