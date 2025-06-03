package com.project.lab_clinico.service;

import com.project.lab_clinico.dto.autenticacion.LoginDTO;
import com.project.lab_clinico.dto.autenticacion.RegistroLaboratoristaDTO;
import com.project.lab_clinico.entity.LaboratoristaEntity;

public interface AuthService {
    LaboratoristaEntity registrar(RegistroLaboratoristaDTO dto);
    String login(LoginDTO dto); // Devuelve un token
    LaboratoristaEntity obtenerLaboratoristaDesdeToken(String token);

}
