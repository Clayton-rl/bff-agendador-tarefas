package com.javanauta.bffagendadortarefas.controller;


import com.javanauta.bffagendadortarefas.business.UsuarioService;
import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Cadastro e login e usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salva Usuário", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> salvarUsuario(@RequestBody UsuarioDTORequest dto) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(dto));
    }

    @PostMapping("/login")
    @Operation(summary = "Login Usuário", description = "Login do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginRequestDTO dto) {
        return usuarioService.loginUsuario(dto);
    }

    @GetMapping
    @Operation(summary = "Busca Dados de Usuário Por Email", description = "Busca dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> buscarUsuarioPorEmail(@RequestParam("email") String email,
                                                                    @RequestHeader(name = "Authorization",
                                                                    required = false) String token) {
        return ResponseEntity.ok(usuarioService.buscaUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta Usuário por Id", description = "Deleta usuário")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@PathVariable String email,
                                                       @RequestHeader(name = "Authorization",
                                                               required = false) String token) {
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualiza Dados de Usuário", description = "Atualiza dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> atualizarDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                                                    @RequestHeader(name = "Authorization",
                                                                    required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualiza Endereço de Usuário", description = "Atualiza endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco(@RequestBody EnderecoDTORequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name = "Authorization",
                                                                 required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualiza Telefone de Usuário", description = "Atualiza telefone de usuário")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTOResponse> atualizarTelefone(@RequestBody TelefoneDTORequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name = "Authorization",
                                                                 required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Salva Endereço de Usuário", description = "Salva endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTOResponse> cadastrarEndereco(@RequestBody EnderecoDTORequest dto,
                                                                 @RequestHeader(name = "Authorization",
                                                                 required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastraEnderco(token, dto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salva Telefone de Usuário", description = "Salva telefone de usuário")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTOResponse> cadastarTelefone(@RequestBody TelefoneDTORequest dto,
                                                                @RequestHeader(name = "Authorization",
                                                                required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastraTelefone(token, dto));
    }
}
