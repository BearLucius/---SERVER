package bip.online.biplio2023.controller;



import bip.online.biplio2023.entity.ReceiptEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;

import bip.online.biplio2023.service.ReceiptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Квитанции", description="Содержит методы для работы с квитанциями")
@RestController
@RequestMapping("api/v1/receipts")
@AllArgsConstructor
public class ReceiptController {
    private final ReceiptService service;
    @Operation(
            summary = "Вывод Всех квитанций",
            description = "Позволяет вывести все квитанции, что есть в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ReceiptEntity>(true, "Список квитанций", service.findAll()));
    }
    @Operation(
            summary = "Поиск квитанции по id",
            description = "Позволяет искать квитанцию по его id"
    )
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
        return ResponseEntity.ok(
                new DataResponse<ReceiptEntity>(true, "Найдена следующая квитанция",
                        service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
///
    @GetMapping("/get")
    public  ResponseEntity<BaseResponse> getBookname(@RequestParam String bookName){
        return ResponseEntity.ok(new ListResponse(service.getReceiptName(bookName)));
    }
    @Operation(
            summary = "Добавить квитанцию",
            description = "Позволяет добавлять квитанции в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody ReceiptEntity books) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<ReceiptEntity>(true, "Квитанция сохранена", service.save(books)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    } @Operation(
            summary = "Изменить квитанцию",
            description = "Позволяет редактировать и изменять квитанцию"
    )
        @PutMapping
        public ResponseEntity<BaseResponse> update (@RequestBody ReceiptEntity books){
            try {
        service.update(books);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Квитанция сохранен"));
        } catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));
    }
}@Operation(
            summary = "Удалить квитанцию",
            description = "Позволяет удалить квитанцию из базы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Квитанция удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}
