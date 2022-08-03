package jaxb.abstractFactory;


import jaxb.*;

public interface ReceiptTypeFactory {

    static Receipt mountReceipt(String personType, String cnpjEmit, String nomeEmit, String docDest, String nomeDest, String fantasiaDest) {
        ReceiptFactory rf = null;
        Receipt rcp = new Receipt();
        switch (personType) {
            case "PF":
                rf = new ReceiptPfFactory();
                rcp.setDest(new Dest(docDest, nomeDest));
                break;
            case "PJ":
                rf = new ReceiptPjFactory();
                rcp.setDest(new Dest(docDest,nomeDest,fantasiaDest));
                break;
        }
        rcp.setEmit(rf.buildEmit(cnpjEmit, nomeEmit));
        rcp.setInfNfe(rf.buildInfNfe("1.1", rcp.getEmit(), rcp.getDest()));
        rcp.setNFe(rf.buildNfe(rcp.getInfNfe(),"a"));
        rcp.setNfeProc(rf.buildNfeProc("1",rcp.getNFe()));
        return rcp;
    }
}

