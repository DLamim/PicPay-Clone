package br.com.dlm.picpayclone.resource;

import br.com.dlm.picpayclone.dto.TransactionDTO;
import br.com.dlm.picpayclone.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends ResourceBase<TransactionDTO> {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDTO> save(@RequestBody @Valid TransactionDTO transactionDTO, UriComponentsBuilder uriBuilder) {
        TransactionDTO transactionReturnDTO = transactionService.process(transactionDTO);
        return responseItemCreatedWithURI(transactionReturnDTO, uriBuilder, "/transactions/{code}", transactionReturnDTO.getCode());
    }
}
