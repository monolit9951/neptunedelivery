package com.gmail.merikbest2015.ecommerce.controller;

import com.gmail.merikbest2015.ecommerce.dto.discounts.request.DiscountRequest;
import com.gmail.merikbest2015.ecommerce.dto.discounts.response.DiscountResponseDTO;
import com.gmail.merikbest2015.ecommerce.mapper.DiscountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/discounts")
public class DiscountController {

   private final DiscountMapper discountMapper;

   @PostMapping("/add")
   public ResponseEntity<DiscountResponseDTO> createDiscount(@Valid @RequestBody DiscountRequest request){
      DiscountResponseDTO response = discountMapper.createDiscount(request);
      return ResponseEntity.ok(response);
   }
}
