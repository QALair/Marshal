package jaxb;

public class EmpresaCadastro {
    private String CNPJ;
    private String RazaoSocial;

    // getters e setters
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    public String getRazaoSocial() {
        return RazaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }


    public EmpresaCadastro() {
    }
}
