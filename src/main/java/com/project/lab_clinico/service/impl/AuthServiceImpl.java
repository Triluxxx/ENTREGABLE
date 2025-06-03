package com.project.lab_clinico.service.impl;
import com.project.lab_clinico.dto.autenticacion.LoginDTO;
import com.project.lab_clinico.dto.autenticacion.RegistroLaboratoristaDTO;
import com.project.lab_clinico.entity.LaboratoristaEntity;
import com.project.lab_clinico.entity.UserEntity;
import com.project.lab_clinico.repository.LaboratoristaRepository;
import com.project.lab_clinico.repository.UserRepository;
import com.project.lab_clinico.security.JwtUtils;
import com.project.lab_clinico.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private LaboratoristaRepository laboratoristaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // BCrypt
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public LaboratoristaEntity registrar(RegistroLaboratoristaDTO dto) {
        UserEntity usuario = userRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        LaboratoristaEntity laboratorista = new LaboratoristaEntity();
        laboratorista.setUserEntity(usuario);
        laboratorista.setCorreo(dto.getCorreo());
        laboratorista.setPassword(passwordEncoder.encode(dto.getPassword()));
        return laboratoristaRepository.save(laboratorista);
    }
    @Override
    public String login(LoginDTO dto) {
        LaboratoristaEntity laboratorista = laboratoristaRepository.findByCorreo(dto.getCorreo())
                .orElseThrow(() -> new RuntimeException("Correo no registrado"));
        if (!passwordEncoder.matches(dto.getPassword(), laboratorista.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        // Aquí generamos el token JWT (lo haremos en el siguiente paso)
        return jwtUtils.generarToken(dto.getCorreo());
    }

    @Override
    public LaboratoristaEntity obtenerLaboratoristaDesdeToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Quitamos "Bearer "
        }
        String correo = jwtUtils.extraerCorreo(token);
        return laboratoristaRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Laboratorista no encontrado"));
    }

}
