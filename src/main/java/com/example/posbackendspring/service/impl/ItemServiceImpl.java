package com.example.posbackendspring.service.impl;


import com.example.posbackendspring.dao.ItemDao;
import com.example.posbackendspring.dto.impl.ItemDTO;
import com.example.posbackendspring.entity.impl.CustomerEntity;
import com.example.posbackendspring.entity.impl.ItemEntity;
import com.example.posbackendspring.exception.DataPersistException;
import com.example.posbackendspring.exception.NoteNotFoundException;
import com.example.posbackendspring.service.ItemService;
import com.example.posbackendspring.util.AppUtil;
import com.example.posbackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setCode(AppUtil.generateItemId());
        ItemEntity savedNote = itemDao.save(mapping.toItemEntity(itemDTO));
        if(savedNote == null){
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public ItemDTO getItem(String itemCode) {
        ItemEntity item = itemDao.getReferenceById(itemCode);

        return mapping.toItemDto(item);

    }

    @Override
    public void updateItem(String itemCode, ItemDTO updateditemDto) {
        Optional<ItemEntity> foundItem=itemDao.findById(itemCode);
        if(!foundItem.isPresent()){
            throw new NoteNotFoundException("Item with id " + itemCode + " not found");
        }else {
            foundItem.get().setName(updateditemDto.getName());
            foundItem.get().setDescription(updateditemDto.getDescription());
            foundItem.get().setQty(Integer.parseInt(updateditemDto.getQty()));
            foundItem.get().setUnitPrice(Integer.parseInt(updateditemDto.getUnitPrice()));
        }
    }

    @Override
    public void deleteItem(String itemCode) {

        Optional<ItemEntity> foundNote=itemDao.findById(itemCode);
        if(!foundNote.isPresent()){
            throw new NoteNotFoundException("Item with id " + itemCode + " not found");
        }else {
            itemDao.deleteById(itemCode);
        }
    }


}
