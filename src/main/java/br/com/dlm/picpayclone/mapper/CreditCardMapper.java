package br.com.dlm.picpayclone.mapper;

import br.com.dlm.picpayclone.dto.CreditCardDTO;
import br.com.dlm.picpayclone.dto.TransactionDTO;
import br.com.dlm.picpayclone.model.CreditCard;
import br.com.dlm.picpayclone.model.Transaction;
import br.com.dlm.picpayclone.service.IUserService;
import br.com.dlm.picpayclone.util.CreditCardUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper extends MapperBase<CreditCard, CreditCardDTO> {

    @Autowired
    private IUserService userService;

    @Override
    public CreditCardDTO mapEntityToDto(CreditCard entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Transaction, TransactionDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entity, CreditCardDTO.class);
    }

    @Override
    public CreditCard mapDtoToEntity(CreditCardDTO dto) {
        return CreditCard
                .builder()
                .flg(dto.getCardFlag())
                .number(CreditCardUtil.mask(dto.getNumber()))
                .tokenNumber(dto.getToken())
                .user(userService.queryEntity(dto.getUserDTO().getLogin()))
                .build();
    }
}
