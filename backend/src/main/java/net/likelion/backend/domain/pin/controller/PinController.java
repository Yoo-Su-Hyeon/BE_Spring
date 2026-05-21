package net.likelion.backend.domain.pin.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.likelion.backend.domain.pin.dto.PinRequestDto;
import net.likelion.backend.domain.pin.dto.PinResponseDto;
import net.likelion.backend.domain.pin.service.PinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "pins", description = "메모 고정 API")
@RestController
@RequestMapping("/pins")
@RequiredArgsConstructor

public class PinController {

    private final PinService pinService;


    @Operation(summary = "고정 메모 조회", description ="고정한 메모를 전부 조회합니다." )
    @ApiResponse(responseCode="200", description="조회 성공")
    @GetMapping
    public ResponseEntity<List<PinResponseDto>> getAll(){
        return ResponseEntity.ok(pinService.getAll());
    }
    @Operation(summary = "메모 고정", description ="memos에서 생성한 메모를 고정합니다." )
    @ApiResponse(responseCode="201", description="고정 성공")
    @PostMapping
    public ResponseEntity<PinResponseDto> create(@RequestBody @Valid PinRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(pinService.create(request));
    }

}
