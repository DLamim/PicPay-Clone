package br.com.dlm.picpayclone.service.impl;

import br.com.dlm.picpayclone.dto.CreditCardDTO;
import br.com.dlm.picpayclone.mapper.CreditCardMapper;
import br.com.dlm.picpayclone.model.CreditCard;
import br.com.dlm.picpayclone.repository.CreditCardRepository;
import br.com.dlm.picpayclone.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardMapper creditCardMapper;

    @Autowired
    private UserService userService;

    @Override
    public CreditCardDTO save(CreditCardDTO creditCardDTO) {
        CreditCardDTO creditCardResponse = null;
        if (creditCardDTO.getIsSave()) {
            CreditCard creditCard = creditCardMapper.mapDtoToEntity(creditCardDTO);
            userService.validate(creditCard.getUser());
            CreditCard creditCardSaved = creditCardRepository.save(creditCard);
            creditCardResponse = creditCardMapper.mapEntityToDto(creditCardSaved);

        }
        return creditCardResponse;
    }
}
