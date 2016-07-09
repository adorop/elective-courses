package by.it.academy.adorop.web.controllers;

import by.it.academy.adorop.model.users.User;
import by.it.academy.adorop.service.api.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public abstract class AbstractUserController<T extends User> {

    private static final String USER_ALREADY_EXISTS_MESSAGE = "User with the same document id already exists";

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveNewUser(@Valid T user, BindingResult bindingResult, Model model) {
        String path = definePath(user, bindingResult);
        processRequest(user, bindingResult, model);
        return path;
    }
    //TODO name
    private void processRequest(T user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
        } else if (getUserService().isAlreadyExists(user.getDocumentId())) {
            model.addAttribute("message", USER_ALREADY_EXISTS_MESSAGE);
            model.addAttribute("user", user);
        } else {
            getUserService().persist(user);
        }
    }

    private String definePath(T user, BindingResult bindingResult) {
        String path;
        if (bindingResult.hasErrors() || getUserService().isAlreadyExists(user.getDocumentId())) {
            path = "register";
        } else {
            path = "redirect:" + getPathToController();
        }
        return path;
    }

    protected abstract String getPathToController();

    protected abstract UserService<T> getUserService();
}