package guijo.la.chupa.spring.controller;

import guijo.la.chupa.spring.dto.UserDTO;
import guijo.la.chupa.spring.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "dni") final Long dni) {
        return ResponseEntity.ok(userService.get(dni));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createUser(@RequestBody @Valid final UserDTO userDTO) {
        final Long createdDni = userService.create(userDTO);
        return new ResponseEntity<>(createdDni, HttpStatus.CREATED);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Long> updateUser(@PathVariable(name = "dni") final Long dni,
            @RequestBody @Valid final UserDTO userDTO) {
        userService.update(dni, userDTO);
        return ResponseEntity.ok(dni);
    }

    @DeleteMapping("/{dni}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "dni") final Long dni) {
        userService.delete(dni);
        return ResponseEntity.noContent().build();
    }

}
