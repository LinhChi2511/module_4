package codegym.exam.controller;

import codegym.exam.model.Transaction;
import codegym.exam.service.impl.CustomerService;
import codegym.exam.service.impl.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String showList (Model model){
        List<Transaction> list = transactionService.getAll();
        model.addAttribute("list",list);
        return "transaction/list";
    }

    @GetMapping("/detail")
    public String showDetail(Model model){
        List<Transaction> list = transactionService.getAll();
        model.addAttribute("list", list);
        return "transaction/detail";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("listCus", customerService.getAll());
        return "transaction/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("transaction") Transaction transaction,
                         BindingResult result,
                         Model model, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            model.addAttribute("listCus", customerService.getAll());
            return "transaction/create";
        }
        transactionService.save(transaction);
        redirectAttributes.addFlashAttribute("message","Them moi thanh cong");
        return "redirect:/transaction/list";

    }

}
