package bip.online.biplio2023.controller;

import bip.online.biplio2023.entity.ClientEntity;
import bip.online.biplio2023.responce.BaseResponse;
import bip.online.biplio2023.responce.DataResponse;
import bip.online.biplio2023.responce.ListResponse;
import bip.online.biplio2023.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Клиент", description="Содержит методы для работы с клиентами")
@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService service;
    @Operation(
            summary = "Вывод всех клиентов",
            description = "Позволяет получить имена всех клиентов в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ClientEntity>(true, "Список клиентов", service.findAll()));
    }
    @Operation(
            summary = "Поиск по id",
            description = "Позволяет найти  авторов по их id  в базе"
    )
    @GetMapping("/byId")
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<ClientEntity>(true, "Найден следующий клиент",
                            service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Добавить Клиента",
            description = "Позволяет добавить Клиента в базу"
    )
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody ClientEntity client) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<ClientEntity>(true, "Клиент сохранен", service.save(client)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "изменить автора",
            description = "Позволяет изменить данные о клиенте в базе"
    )
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ClientEntity author) {
        try {
            service.update(author);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Клиент сохранен"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Удалить автора",
            description = "Позволяет удалить данные о клиенте из базы"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Клиент удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}