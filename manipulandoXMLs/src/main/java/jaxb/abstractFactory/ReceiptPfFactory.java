package jaxb.abstractFactory;

import jaxb.*;

public class ReceiptPfFactory implements ReceiptFactory {
    @Override
    public Emit buildEmit(String doc, String nome) {
        Emit buildEmit = new Emit(doc,nome);
        return buildEmit;
    }

    @Override
    public InfNfe buildInfNfe(String versao, Emit emit, Dest dest) {
        InfNfe buiInfNfe = new InfNfe(versao, emit, dest);
        return buiInfNfe;
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
    public Dest buildDest(String doc, String nome, String fantasia) {
        Dest buildDest = new Dest(doc, nome);
        return buildDest;
    }

}
