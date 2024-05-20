package bip.online.biplio2023.controller;



import bip.online.biplio2023.entity.ServiceEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;


import bip.online.biplio2023.service.ServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Услуга", description="Содержит методы для работы с услугами")
@RestController
@RequestMapping("api/v1/services")
@AllArgsConstructor
public class ServiceController {
    private final ServiceService service;

    @Operation(
            summary = "Вывод всех услуг",
            description = "Позволяет выводить все услуги, что есть в БД."
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {

        return ResponseEntity.ok(
                new ListResponse<ServiceEntity>(true, "Список услуг: ", service.findAll()));
    }
    @Operation(
            summary = "Поиск услуги по id.",
            description = "Позволяет искать услугу по его Id."
    )
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
        return ResponseEntity.ok(
                new DataResponse<ServiceEntity>(true, "Найден следующая услуга: ", service.findById(id).orElseThrow()));
    } catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));
    }
}
    @Operation(
            summary = "Добавить город.",
            description = "Позволяет добовить новый город в БД."
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody ServiceEntity serviceName) {
        try {
        return ResponseEntity.ok(
                new DataResponse<ServiceEntity>(true, "Услуга сохранена: ", service.save(serviceName)));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить услугу",
            description = "Позволяет редактировать и изменять услугу"
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ServiceEntity serviceName) {
        try {
        service.update(serviceName);
        return ResponseEntity.ok(
                new BaseResponse(true, "Услуга сохранена: "));
    }catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));
    }
}
    @Operation(
            summary = "Удалить услугу",
            description = "Позволяет удалить услугу из БД"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Услуга удалена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}