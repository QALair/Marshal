package jaxb.abstractFactory;

import jaxb.*;

public interface ReceiptFactory {
    public abstract Emit buildEmit(String doc,String nome);
    public abstract InfNfe buildInfNfe(String versao, Emit emit, Dest dest);
    public abstract NfeProc buildNfeProc(String versao,NFe nfe);
    public abstract NFe buildNfe(InfNfe infnfe, String signature);
    public abstract Dest buildDest(String doc, String nome, String fantasia);

}
