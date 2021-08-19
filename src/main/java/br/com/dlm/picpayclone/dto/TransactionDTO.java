package br.com.dlm.picpayclone.dto;

import br.com.dlm.picpayclone.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@JsonInclude(Include.NON_NULL)
public class TransactionDTO {

    @NotBlank
    private String code;

    @NotNull
    private User origen;

    @NotNull
    private User destiny;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private Double value;

    private CreditCardDTO creditCardDTO;

    private Boolean isCreditCard = false;
}
