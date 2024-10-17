package com.example.posbackendspring.controller;

import com.example.posbackendspring.dto.impl.CustomerDTO;
import com.example.posbackendspring.dto.impl.ItemDTO;
import com.example.posbackendspring.exception.DataPersistException;
import com.example.posbackendspring.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    private static Logger logger= LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO){
        try {
            itemService.saveItem(itemDTO);
            logger.info("Item save successful");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO getItem(@PathVariable("itemCode") String itemCode){
        return itemService.getItem(itemCode);
    }

    @PutMapping(value = "/{itemCode}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("itemCode") String itemCode,
                                               @RequestBody ItemDTO updateditemDto) {
        //validation
        itemService.updateItem(itemCode, updateditemDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("itemCode") String itemCode) {
        itemService.deleteItem(itemCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
