/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rzd.vivc.documentexamination.model.dto.security.Role;
import rzd.vivc.documentexamination.model.dto.users.Department;

/**
 * Интерфейс репозитория для Ролей
 *
 * @author VVolgina
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

}
