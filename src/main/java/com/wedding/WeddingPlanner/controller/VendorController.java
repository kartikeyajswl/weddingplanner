package com.wedding.WeddingPlanner.controller;


import com.wedding.WeddingPlanner.dto.VendorDto;
import com.wedding.WeddingPlanner.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {
@Autowired
private VendorService vendorService;


@PostMapping
public ResponseEntity<VendorDto>addVendor(@RequestBody  VendorDto vendorDto){
    VendorDto vendorDto1 = vendorService.addVendor(vendorDto);
    return ResponseEntity.ok(vendorDto1);
}

    @GetMapping("/listOfVendors")
    public ResponseEntity<List<VendorDto>> getVendorList(){
        List<VendorDto> vendorList = vendorService.getVendorList();
        return ResponseEntity.ok(vendorList);
    }

    @GetMapping("listById")
    public ResponseEntity<VendorDto>getVendorListById(@RequestParam  long vendorId){
        VendorDto vendorDto1 = vendorService.getVendorListById(vendorId);
        return ResponseEntity.ok(vendorDto1);
    }

    @PutMapping(" /vendors/{id}/updateAvailability")
    public ResponseEntity<VendorDto> updateVendor(@PathVariable  long vendorId,
                                                  @RequestParam boolean isAvailable){
    VendorDto vendorDto1 = vendorService.updateVendor(vendorId, isAvailable);
    return ResponseEntity.ok(vendorDto1);


}
}
