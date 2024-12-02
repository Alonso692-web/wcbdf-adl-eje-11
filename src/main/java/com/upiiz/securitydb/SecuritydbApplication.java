package com.upiiz.securitydb;

import com.upiiz.securitydb.entities.*;
import com.upiiz.securitydb.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecuritydbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritydbApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            // Crear permisos
            PermissionEntity createPermission = PermissionEntity
                    .builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity
                    .builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity
                    .builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity
                    .builder()
                    .name("DELETE")
                    .build();

            PermissionEntity deployPermission = PermissionEntity
                    .builder()
                    .name("DEPLOY")
                    .build();

            // Guardar permisos en la base de datos
//			permissionRepository.saveAll(List.of(createPermission, readPermission, updatePermission, deletePermission, deployPermission));


            // Crear roles
            RoleEntity adminRol = RoleEntity
                    .builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission))
                    .build();

            RoleEntity guestRol = RoleEntity
                    .builder()
                    .roleEnum(RoleEnum.GUEST)
                    .permissions(Set.of(readPermission))
                    .build();

            RoleEntity userRol = RoleEntity
                    .builder()
                    .roleEnum(RoleEnum.USER)
                    .permissions(Set.of(readPermission, updatePermission))
                    .build();

            RoleEntity developerRol = RoleEntity
                    .builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission, deployPermission))
                    .build();

            // Guardar roles en la base de datos
//			rolRepository.saveAll(List.of(adminRol, guestRol, userRol, developerRol));


            // Crear usuarios
            UserEntity user1 = UserEntity
                    .builder()
                    .username("dev")
                    .password("1234")
                    .isEnable(true)
                    .isAccountNonExpired(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonLocked(true)
                    .roles(Set.of(developerRol))
                    .build();

            UserEntity user2 = UserEntity
                    .builder()
                    .username("alonso")
                    .password("1234")
                    .isEnable(true)
                    .isAccountNonExpired(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonLocked(true)
                    .roles(Set.of(userRol))
                    .build();

            UserEntity user3 = UserEntity
                    .builder()
                    .username("felipe")
                    .password("1234")
                    .isEnable(true)
                    .isAccountNonExpired(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonLocked(true)
                    .roles(Set.of(guestRol))
                    .build();

            UserEntity user4 = UserEntity
                    .builder()
                    .username("admin")
                    .password("1234")
                    .isEnable(true)
                    .isAccountNonExpired(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonLocked(true)
                    .roles(Set.of(adminRol))
                    .build();

            // Guardar en la base de datos - creamos el repositorio
            userRepository.saveAll(List.of(user1, user2, user3, user4));

        };
    }

}
