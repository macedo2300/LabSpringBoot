package com.br.vms.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.vms.projeto.Enum.SituacaoEnum;
import com.br.vms.projeto.Interface.UsuariosInterface;
import com.br.vms.projeto.model.Usuario;


@Controller
@RequestMapping("/projeto/usuarios")
public class UsuarioController {
	
	
	private static final String CADASTRO_USUARIO = "cadastroUsuario";
	
	@Autowired
	private UsuariosInterface usuarioInterface;
	
	@RequestMapping()
	public ModelAndView usuarios() {
		List<Usuario> listaUsuario = this.usuarioInterface.findAll();
		ModelAndView mv = new ModelAndView("usuarios");
		mv.addObject("titulos", listaUsuario);
		return mv;
	}
	
	@RequestMapping("/novoUsuario")
	public ModelAndView novoUsuario() {
		ModelAndView mv = new ModelAndView(CADASTRO_USUARIO);
		mv.addObject("listSituacao", SituacaoEnum.values());
		mv.addObject(new Usuario());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Usuario usuario,Errors erros) {

		ModelAndView mv = new ModelAndView(CADASTRO_USUARIO);
		mv.addObject("listSituacao", SituacaoEnum.values());
		if(erros.hasErrors()) {
			return mv;
		}
		usuarioInterface.save(usuario);
		mv.addObject("mensagem", "Usuário Cadastrado com sucesso!!");
		mv.addObject(new Usuario());
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo) {
		
		Optional op = usuarioInterface.findById(codigo);
		Usuario usuario = (Usuario) op.get();
		ModelAndView mv = new ModelAndView(CADASTRO_USUARIO);
		mv.addObject("listSituacao", SituacaoEnum.values());
		mv.addObject(usuario);
		return mv;
		
	}

}
