package com.example.posbackendspring.service.impl;


import com.example.posbackendspring.dao.ItemDao;
import com.example.posbackendspring.dto.impl.ItemDTO;
import com.example.posbackendspring.entity.impl.CustomerEntity;
import com.example.posbackendspring.entity.impl.ItemEntity;
import com.example.posbackendspring.exception.DataPersistException;
import com.example.posbackendspring.service.ItemService;
import com.example.posbackendspring.util.AppUtil;
import com.example.posbackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
