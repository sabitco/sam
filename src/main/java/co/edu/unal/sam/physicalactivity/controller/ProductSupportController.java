package co.edu.unal.sam.physicalactivity.controller;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.unal.sam.physicalactivity.model.domain.ProductSupport;
import co.edu.unal.sam.aspect.exception.ResourceNotFoundException;
import co.edu.unal.sam.physicalactivity.model.repository.ProductSupportRepository;

@RestController
public class ProductSupportController {

    @Inject
    private ProductSupportRepository productSupportRepository;

    @RequestMapping(value = "/admin/productSupports", method = RequestMethod.POST)
    public ResponseEntity<Void> createProductSupport(@Valid @RequestBody ProductSupport productSupport) {
        productSupport = this.productSupportRepository.save(productSupport);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newProductSupportUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productSupport.getId()).toUri();
        responseHeaders.setLocation(newProductSupportUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/productSupports/{productSupportId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductSupport(@PathVariable Long productSupportId) {
        this.verifyProductSupport(productSupportId);
        ProductSupport p = this.productSupportRepository.findOne(productSupportId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/productSupports", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ProductSupport>> getAllproductSupports() {
        Iterable<ProductSupport> allproductSupports = this.productSupportRepository.findAll();
        return new ResponseEntity<>(allproductSupports, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/productSupports/{productSupportId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProductSupport(@RequestBody ProductSupport productSupport, @PathVariable Long productSupportId) {
        this.verifyProductSupport(productSupportId);
        this.productSupportRepository.save(productSupport);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/productSupports/{productSupportId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProductSupport(@PathVariable Long productSupportId) {
        this.verifyProductSupport(productSupportId);
        this.productSupportRepository.delete(productSupportId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyProductSupport(Long productSupportId) throws ResourceNotFoundException {
        ProductSupport productSupport = this.productSupportRepository.findOne(productSupportId);
        if (productSupport == null) {
            throw new ResourceNotFoundException("ProductSupport with id " + productSupportId + " not found");
        }
    }

}
