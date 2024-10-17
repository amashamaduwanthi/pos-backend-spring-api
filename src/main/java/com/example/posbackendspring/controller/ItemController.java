package com.example.posbackendspring.controller;

import com.example.posbackendspring.dto.impl.CustomerDTO;
import com.example.posbackendspring.dto.impl.ItemDTO;
import com.example.posbackendspring.exception.DataPersistException;
import com.example.posbackendspring.exception.ItemNotFoundException;
import com.example.posbackendspring.service.ItemService;
import com.example.posbackendspring.util.RegEx;
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
        try {
            if(!RegEx.itemCodeMatcher(itemCode) || updateditemDto == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        //validation
        itemService.updateItem(itemCode, updateditemDto);
            logger.info("Item update successful");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (ItemNotFoundException e){
            logger.warn("Returning 400 Bad Request",e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Item update unsuccessful",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("itemCode") String itemCode) {
        try {
            if(!RegEx.itemCodeMatcher(itemCode)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        itemService.deleteItem(itemCode);
            logger.info("Item delete successful");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            logger.warn("Returning 404 Not Found",e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Item delete unsuccessful",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
