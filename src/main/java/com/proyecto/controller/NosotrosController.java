package com.proyecto.controller;
import com.proyecto.domain.Pedido;
import com.proyecto.service.TipoService;
import com.proyecto.service.PedidoService;
import com.proyecto.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/nosotros")
public class NosotrosController {
    

    @GetMapping("/conocenos")
    public String nosotrosLink() {

        return "/nosotros/conocenos";
    }
    
}

