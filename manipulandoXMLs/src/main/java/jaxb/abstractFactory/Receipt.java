package jaxb.abstractFactory;

import jaxb.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Receipt{
    Emit emit;
    InfNfe infNfe;
    NfeProc nfeProc;
    NFe nFe;
    Dest dest;
}
