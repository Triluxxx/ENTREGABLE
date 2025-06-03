    package com.project.lab_clinico.service.impl;

    import com.project.lab_clinico.entity.LaboratoristaEntity;
    import com.project.lab_clinico.entity.MedicoEntity;
    import com.project.lab_clinico.entity.TypeUser;
    import com.project.lab_clinico.entity.UserEntity;
    import com.project.lab_clinico.repository.LaboratoristaRepository;
    import com.project.lab_clinico.repository.MedicoRepository;
    import com.project.lab_clinico.repository.UserRepository;
    import com.project.lab_clinico.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class UserServiceImpl implements UserService {
        @Autowired
        private  UserRepository userRepository;
        @Autowired
        private  MedicoRepository medicoRepository;
        @Autowired
        private  LaboratoristaRepository laboratoristaRepository;


        @Override
        public List<UserEntity> listar() {
            return userRepository.findAll();
        }

        @Override
        public Optional<UserEntity> buscarPorId(Long id) {
            return userRepository.findById(id);
        }

        @Override
        public UserEntity guardar(UserEntity user) {
            // Guardar usuario
            UserEntity savedUser = userRepository.save(user);

            // Si es médico y viene la especialidad, guardar en medico
            if (savedUser.getTipoUsuario() == TypeUser.MEDICO && user.getMedico() != null) {
                MedicoEntity medico = user.getMedico();
                medico.setUserEntity(savedUser);  // asignar usuario guardado
                medicoRepository.save(medico);
            }

            // Si es LABORATORISTA, guardar en la tabla laboratorista
            if (savedUser.getTipoUsuario() == TypeUser.LABORATORISTA && user.getMedico() == null) {
                LaboratoristaEntity laboratorista = new LaboratoristaEntity();
                laboratorista.setUserEntity(savedUser); // Asignar el usuario guardado
                laboratorista.setTurno("default turno");  // Asumiendo que viene del request
                laboratorista.setCorreo("default email");  // Asumiendo que viene del request
                laboratorista.setPassword("default contrasena");  // Asumiendo que viene del request
                laboratoristaRepository.save(laboratorista);
            }
            return savedUser;
        }

        @Override
        public UserEntity actualizar(Long id, UserEntity user) {
            return userRepository.findById(id)
                    .map(existingUser -> {
                        existingUser.setNombres(user.getNombres());
                        existingUser.setApellidos(user.getApellidos());
                        existingUser.setTelefono(user.getTelefono());
                        existingUser.setDni(user.getDni());
                        existingUser.setSexo(user.getSexo());
                        existingUser.setFechaNacimiento(user.getFechaNacimiento());
                        existingUser.setTipoUsuario(user.getTipoUsuario());
                        return userRepository.save(existingUser);
                    }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
        }

        @Override
        public void eliminar(Long id) {
            userRepository.deleteById(id);
        }

        @Override
        public List<UserEntity> listarPorTipo(TypeUser tipoUsuario) {
            return userRepository.findAllByTipoUsuario(tipoUsuario);
        }

        @Override
        public Optional<UserEntity> buscarPorDniYTipo(String dni, TypeUser tipoUsuario) {
            return userRepository.findByDniAndTipoUsuario(dni, tipoUsuario);
        }
    }
