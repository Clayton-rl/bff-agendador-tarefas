package com.javanauta.bffagendadortarefas.infrastructure.client;

import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {


    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest dto);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO dto);

    @GetMapping
    UsuarioDTOResponse buscarUsuarioPorEmail(@RequestParam("email") String email,
                                             @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletarUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizarDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                             @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest dto,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastrarEndereco(@RequestBody EnderecoDTORequest dto,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastarTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);
}
