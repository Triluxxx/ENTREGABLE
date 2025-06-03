package com.project.lab_clinico.controller;
import com.project.lab_clinico.dto.autenticacion.LoginDTO;
import com.project.lab_clinico.dto.autenticacion.RegistroLaboratoristaDTO;
import com.project.lab_clinico.entity.LaboratoristaEntity;
import com.project.lab_clinico.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/registrar")
    public ResponseEntity<LaboratoristaEntity> registrar(@RequestBody RegistroLaboratoristaDTO dto) {
        return ResponseEntity.ok(authService.registrar(dto));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
    @GetMapping("/laboratorista-actual")
    public ResponseEntity<LaboratoristaEntity> getLaboratoristaActual(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            LaboratoristaEntity lab = authService.obtenerLaboratoristaDesdeToken(authHeader);
            return ResponseEntity.ok(lab);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
