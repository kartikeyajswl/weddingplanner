package com.wedding.WeddingPlanner.service;


import com.wedding.WeddingPlanner.dto.VendorDto;
import com.wedding.WeddingPlanner.entity.Vendor;
import com.wedding.WeddingPlanner.repository.VendorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorService {

    private VendorRepository vendorRepository;
    private ModelMapper modelMapper;

    public VendorService(VendorRepository vendorRepository, ModelMapper modelMapper) {
        this.vendorRepository = vendorRepository;
        this.modelMapper = modelMapper;
    }

    public VendorDto addVendor(VendorDto vendorDto) {
        Vendor vendor=modelMapper.map(vendorDto,Vendor.class);
        Vendor save = vendorRepository.save(vendor);
        return modelMapper.map(save, VendorDto.class);
    }

    public List<VendorDto> getVendorList() {
        List<Vendor> vendor = vendorRepository.findAll();
         return vendor.stream().map(s -> modelMapper.map(s, VendorDto.class))
                 .collect(Collectors.toList());

    }

    public VendorDto getVendorListById(long vendorId) {
        Vendor vendor1 = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Could not find vendor" + vendorId));
        return modelMapper.map(vendor1, VendorDto.class);
    }


    public VendorDto updateVendor(long vendorId, boolean isAvailable) {
        Vendor vendor1 = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Could not find vendor" + vendorId));
        vendor1.setAvailable(isAvailable);
        Vendor save = vendorRepository.save(vendor1);
        return modelMapper.map(save, VendorDto.class);
    }
}
