package jaxb;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="infNFe", propOrder={"versao","ide","emit"})
public class InfNfe{
    @XmlElement(name="ide")
    private String ide;
    @XmlElement(name="emit",required = true)
    private Emit emit;
    @XmlAttribute(name="versao")
    private String versao;


    public String getIde() {
        return this.ide;
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
        return this.versao;
    }
    public void setVersao(String versao) {
        this.versao = versao;
    }

    public InfNfe(String versao, Emit emit){
      this.versao = versao;
      this.emit = emit;
    }

    public InfNfe(){
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
