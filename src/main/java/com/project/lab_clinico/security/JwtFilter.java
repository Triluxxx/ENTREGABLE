package com.project.lab_clinico.security;

import com.project.lab_clinico.entity.LaboratoristaEntity;
import com.project.lab_clinico.repository.LaboratoristaRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private LaboratoristaRepository laboratoristaRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (jwtUtils.validarToken(token)) {
                String correo = jwtUtils.extraerCorreo(token);
                LaboratoristaEntity lab = laboratoristaRepository.findByCorreo(correo).orElse(null);
                if (lab != null) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            correo, null, List.of(new SimpleGrantedAuthority("ROLE_LABORATORISTA")));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }  }        }
        filterChain.doFilter(request, response);
    }
}


