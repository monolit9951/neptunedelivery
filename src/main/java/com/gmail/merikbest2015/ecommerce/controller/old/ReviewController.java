package com.gmail.merikbest2015.ecommerce.controller.old;

//import com.gmail.merikbest2015.ecommerce.dto.review.ReviewRequest;
//import com.gmail.merikbest2015.ecommerce.dto.review.ReviewResponse;
//import com.gmail.merikbest2015.ecommerce.mapper.ReviewMapper;
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(API_V1_REVIEW)
//public class ReviewController {
//
//    private final ReviewMapper reviewMapper;
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @GetMapping(PERFUME_ID)
//    public ResponseEntity<List<ReviewResponse>> getReviewsByPerfumeId(@PathVariable Long perfumeId) {
//        return ResponseEntity.ok(reviewMapper.getReviewsByPerfumeId(perfumeId));
//    }
//
//    @PostMapping
//    public ResponseEntity<ReviewResponse> addReviewToPerfume(@Valid @RequestBody ReviewRequest reviewRequest,
//                                                             BindingResult bindingResult) {
//        ReviewResponse review = reviewMapper.addReviewToPerfume(reviewRequest, reviewRequest.getPerfumeId(), bindingResult);
//        messagingTemplate.convertAndSend("/topic/reviews/" + reviewRequest.getPerfumeId(), review);
//        return ResponseEntity.ok(review);
//    }
//}
