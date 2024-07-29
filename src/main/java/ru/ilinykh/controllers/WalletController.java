package ru.ilinykh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ilinykh.dto.WalletOperationRequest;
import ru.ilinykh.service.WalletService;
import ru.ilinykh.dao.WalletDao;
import ru.ilinykh.model.Wallet;

import java.util.UUID;

/**
 * @author Yury
 */

@Controller
@RequestMapping("/api/v1/wallet")
public class WalletController {


    private final WalletDao walletDao;
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletDao walletDao, WalletService walletService) {
        this.walletDao = walletDao;
        this.walletService = walletService;
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    @ResponseBody
    public Wallet getWallet(@PathVariable("uuid") UUID uuid){
        return walletDao.getWalletByUuid(uuid).get();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> updateWallet(@RequestBody WalletOperationRequest request){
        try {
            walletService.performOperation(request.getId(), request.getOperationType(), request.getBalance());
            return new ResponseEntity<>("Operation successful", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
