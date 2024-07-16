package challenge.forumhub.Forum.Hub.Controller;

import challenge.forumhub.Forum.Hub.InfraSecurity.TokenResponseDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.LoginDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.RegisterDTO;
import challenge.forumhub.Forum.Hub.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Authentication {

    @Autowired
    AuthenticationService service;

    @Autowired
    AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid LoginDTO dados) {
        String token = service.login(dados, manager);
        return ResponseEntity.ok(new TokenResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO dados) {
        service.register(dados);
        return ResponseEntity.ok().build();
    }


}