/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import rzd.vivc.documentexamination.model.dto.security.Account;
import rzd.vivc.documentexamination.model.dto.users.User;

/**
 * Интерфейс репозитория для учетныйх записей {@link Account}
 *
 * @author VVolgina
 */
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>, AccountFilter{
    Account findByUser(User user);
}
