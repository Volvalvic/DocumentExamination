package rzd.vivc.documentexamination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.vivc.documentexamination.model.dto.users.User;
import rzd.vivc.documentexamination.repository.UserRepository;

/**
 * Контроллер для /users
 *
 * @author VVolgina
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserRepository userRepository;

    /**
     * Конструктор.
     *
     * @param repository репозиторий
     */
    @Autowired
    public UsersController(UserRepository repository) {
        this.userRepository = repository;
    }

    /**
     * При GET запросе к /users в модель добавляется список пользователей
     *
     * @return списопользователей
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> users() {
        List<User> findFiltered = userRepository.findAll();
        return findFiltered;
    }

    /**
     * При GET запросе c path parameter в модель добавляется пользователь с
     * заданным id
     *
     * @param userID id пользователя
     * @param model модель с данными для view
     * @return user
     */
    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public String user(@PathVariable(value = "userID") long userID, Model model) {

        model.addAttribute(userRepository.findWithDependencies(userID));

        return "user";
    }
}
