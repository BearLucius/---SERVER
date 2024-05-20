package bip.online.biplio2023.controller;


import bip.online.biplio2023.entity.ServiceCostEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;

import bip.online.biplio2023.service.ServiceCostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Стоимость услуги", description="Содержит методы для работы с ???")
@RestController
@RequestMapping("api/v1/servcost")
@AllArgsConstructor
public class ServiceCostController {
    private final ServiceCostService serviceCost;
    @Operation(
            summary = "Вывод ???",
            description = "Позволяет получить ??? в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ServiceCostEntity>(true, "Список ???", serviceCost.findAll()));
    }
    @Operation(
            summary = "поиск ??? по id",
            description = "Позволяет получить ??? по его id"
    )
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
        return ResponseEntity.ok(
                new DataResponse<ServiceCostEntity>(true, "Найден следующий ???", serviceCost.findById(id).orElseThrow()));
    }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
    @Operation(
            summary = "добавить ???",
            description = "Позволяет добавить ??? в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody ServiceCostEntity servCost) {
        try{
        return ResponseEntity.ok(
                new DataResponse<ServiceCostEntity>(true, "??? сохранен", serviceCost.save(servCost)));
    }catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));

    }
}
    @Operation(
            summary = "Изменить издателя",
            description = "Позволяет вносить изменения в издателя"
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ServiceCostEntity servCost) {
       try{
        serviceCost.update(servCost);
        return ResponseEntity.ok(
                new BaseResponse(true, "??? сохранен"));
    }catch (RuntimeException e) {
        return ResponseEntity.ok(
                new BaseResponse(false, e.getMessage()));

    }
}
    @Operation(
            summary = "Удалить ???",
            description = "Позволяет удалить ??? из базы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            serviceCost.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "??? удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}