package br.com.dlm.picpayclone.dto;

import br.com.dlm.picpayclone.enums.CardFlag;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreditCardDTO {

    @NotBlank
    private CardFlag cardFlag;

    @NotBlank
    private String secureCode;

    @NotBlank
    private String expirationDate;

    @NotBlank
    private String OwnerName;

    private String number;

    private String token;

    @NotNull
    private UserDTO userDTO;

    private Boolean isSave = false;
}
