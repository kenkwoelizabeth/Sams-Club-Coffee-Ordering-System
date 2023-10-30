package com.techbridge.sams.club.supplier;


import com.techbridge.sams.club.exception.ResourceNotFoundException;
import com.techbridge.sams.club.menuItem.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToMany;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Suppliers does not exist with the ID: " + supplierId));
    }

    @Override
    public Supplier updateSupplier(long supplierId, Supplier supplier) {
       Supplier existingSupplier= supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment does not exist with the ID: " + supplierId));
        existingSupplier.setName(supplier.getName());
        existingSupplier.setLocation(supplier.getLocation());
        existingSupplier.setPhoneNumber(supplier.getPhoneNumber());



        return  supplierRepository.save(existingSupplier);
    }


    @Override
    public void deleteSupplier(long supplierId) {
        Supplier existingSuppliers= supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("suppliers does not exist with the ID: " + supplierId));
supplierRepository.delete(existingSuppliers);
    }
}
