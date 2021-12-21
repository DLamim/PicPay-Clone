package br.com.dlm.picpayclone.resource;

import br.com.dlm.picpayclone.dto.TransactionDTO;
import br.com.dlm.picpayclone.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<TransactionDTO>> list(@PageableDefault(page = 0, size = 20) Pageable pageable, @RequestParam String login) {
        Page<TransactionDTO> transactions = transactionService.list(pageable, login);
        return responseListPagedItems(transactions);
    }
}
