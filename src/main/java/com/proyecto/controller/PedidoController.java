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
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @Autowired 
    private TipoService tipoService;

    @GetMapping("/listado")
    public String listado(Model model){
        var pedidos = pedidoService.getPedidos(false);
        model.addAttribute("pedidos", pedidos);
        var tipos = tipoService.getTipos(false);
        model.addAttribute("tipos", tipos);
        
        return "/pedido/listado";
    }

    @GetMapping("/nuevo")
    public String pedidoNuevo(Pedido pedido) {
        return "/pedido/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/eliminar/{idPedido}")
    public String pedidoEliminar(Pedido pedido) {
        pedidoService.delete(pedido);
        return "redirect:/pedido/listado";
    }

    @GetMapping("/modificar/{idPedido}")
    public String pedidoModificar(Pedido pedido, Model model) {
        var tipos = tipoService.getTipos(false);
        model.addAttribute("tipos", tipos);
        pedido = pedidoService.getPedido(pedido);
        model.addAttribute("pedido", pedido);
        return "/pedido/modifica";
    }
    


    @GetMapping("/orden")
    public String pedidoNuevo(Pedido pedido, Model model) {
        var tipos = tipoService.getTipos(false);
        model.addAttribute("tipos", tipos);
        return "/pedido/orden";
    }


    @PostMapping("/guardar")
    public String pedidoGuardar(Pedido pedido, @RequestParam("imagenFile") MultipartFile imagenFile) {        

        
        if (!imagenFile.isEmpty()) {
            pedidoService.save(pedido);
            pedido.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "pedido", 
                            pedido.getIdPedido()));
        }
        pedidoService.save(pedido);
        return "/pedido/orden";
    }
    
}
