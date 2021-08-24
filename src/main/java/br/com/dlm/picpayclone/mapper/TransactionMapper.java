package br.com.dlm.picpayclone.mapper;

import br.com.dlm.picpayclone.dto.TransactionDTO;
import br.com.dlm.picpayclone.model.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;

@Component
public class TransactionMapper extends MapperBase<Transaction, TransactionDTO> {

    @Autowired
    private IUserService userService;

    @Override
    public TransactionDTO mapEntityToDto(Transaction entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Transaction, TransactionDTO>() {
           @Override
           protected void configure() {
           }
        });
        return modelMapper.map(entity, TransactionDTO.class);
    }

    @SuppressWarnings("unchecked")
    public Page<TransactionDTO> mapPageEntityToDto(Page<Transaction> entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Page<Transaction>, Page<TransactionDTO>>(){
           @Override
           protected void configure() {
           }
        });
        return modelMapper.map(entity, Page.class);
    }

    @Override
    public Transaction mapDtoToEntity(TransactionDTO dto) {
        return Transaction.builder()
                .code(dto.getCode())
                .dateTime(dto.getDateTime())
                .value(dto.getValue())
                .destiny(userService.queryEntity(dto.getDestiny().getLogin()))
                .origen(userService.queryEntity(dto.getOrigen().getLogin()))
                .build();
    }
}
