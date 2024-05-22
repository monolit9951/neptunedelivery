package com.neptunes.controller;

import com.neptunes.dto.discounts.request.DiscountRequest;
import com.neptunes.dto.discounts.response.DiscountResponseDTO;
import com.neptunes.mapper.DiscountMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
