package jaxb.abstractFactory;

import jaxb.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class ReceiptPjFactory implements ReceiptFactory{

    @Override
    public Emit buildEmit(String nome, String doc) {
        Emit buildEmit = new Emit(nome,doc);
        return buildEmit;
    }

    @Override
    public InfNfe buildInfNfe(String versao, Emit emit, Dest dest) {
        InfNfe buildInfNfe = new InfNfe(versao, emit, dest);
        return buildInfNfe;
    }

    @Override
    public NfeProc buildNfeProc(String versao, NFe nfe) {
        NfeProc buildNfeProc = new NfeProc(versao, nfe);
        return buildNfeProc;
    }

    @Override
    public NFe buildNfe(InfNfe infnfe, String signature) {
        NFe buildNfe = new NFe(infnfe, signature);
        return buildNfe;
    }

    @Override
    public Dest buildDest(String doc, String nome, String fantasia){
        Dest buildDest = new Dest(doc, nome, fantasia);
        return buildDest;
    }
}
