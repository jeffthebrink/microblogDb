package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MicroblogDbController {

    @Autowired
    MessageRepository messages;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String text) {
        Message message = new Message(text);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String edit(Model model, int id) {
        Message editMessage = messages.findOne(id);
        model.addAttribute("messages", editMessage);
        return "edit-message";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(int id, String text) {
        Message message = new Message(id, text);
        messages.save(message);
        return "redirect:/";
    }

}
