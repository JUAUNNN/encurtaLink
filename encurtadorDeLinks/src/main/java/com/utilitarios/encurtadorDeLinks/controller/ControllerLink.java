package com.utilitarios.encurtadorDeLinks.controller;



import com.utilitarios.encurtadorDeLinks.model.Link;
import com.utilitarios.encurtadorDeLinks.model.ResponseLink;
import com.utilitarios.encurtadorDeLinks.service.ServiceLink;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class ControllerLink {

    @Autowired
    private ServiceLink serviceLink;

    @PostMapping("/encurtar")
    public ResponseEntity<ResponseLink> criarLinkcurto(@RequestBody Map<String, String> request){

        String urlOriginal = request.get("urlLong");
        Link link = serviceLink.encurtarUrl(urlOriginal);

        String urlDeRedirecionamento =  "http://localhost:8081/r/" + link.getUrlEncurtada();

        ResponseLink responseLink = new ResponseLink(link.getId(),
                link.getUrlLong(), urlDeRedirecionamento, link.getUrlCriarTempo());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseLink);
    }

    @GetMapping("/pks/{urlEncurtada}")
    public void redirecionarLink(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException {
        Link link = serviceLink.getUrlOriginal(urlEncurtada);

        if (link != null) {
            response.sendRedirect(link.getUrlLong());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
