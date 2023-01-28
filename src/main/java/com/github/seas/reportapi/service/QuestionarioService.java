package com.github.seas.reportapi.service;

import com.github.seas.reportapi.controller.dto.QuestionarioDto;
import com.github.seas.reportapi.controller.dto.QuestionarioResponse;
import com.github.seas.reportapi.controller.form.QuestionarioRequest;
import com.github.seas.reportapi.domain.Cidadao;
import com.github.seas.reportapi.domain.Cidade;
import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.domain.Servico;
import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.repository.CidadaoRepository;
import com.github.seas.reportapi.repository.CidadeRepository;
import com.github.seas.reportapi.repository.QuestionarioRepository;
import com.github.seas.reportapi.repository.ServicoRepository;
import com.github.seas.reportapi.repository.UsuarioRepository;
import com.github.seas.reportapi.utils.QuestionarioConverter;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class QuestionarioService {

	@Autowired
	private QuestionarioRepository questionarioRepository;

	@Autowired
	private CidadaoRepository cidadaoRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public ResponseEntity<Page<QuestionarioDto>> getAll (Pageable pageable) {

		Page<Questionario> questionarios = questionarioRepository.findAll(pageable);
		Page<QuestionarioDto> questionariosDto = questionarios.map(questionario -> new QuestionarioConverter().convert(questionario));
		return ResponseEntity.ok(questionariosDto);
	}

	public ResponseEntity<QuestionarioResponse> create (QuestionarioRequest questionarioRequest) throws BadHttpRequest {
		Cidadao cidadao = cidadaoRepository.findById(questionarioRequest.getIdCidadao()).orElseThrow(BadHttpRequest::new);
		Cidade cidade = cidadeRepository.findById(questionarioRequest.getIdCidadeOrigem()).orElseThrow(BadHttpRequest::new);
		Set<Servico> servicos = servicoRepository.findByIdIn(questionarioRequest.getServicoBuscaJundiai());
		Set<Usuario> responsaveisPreenchimento = usuarioRepository.findByIdIn(questionarioRequest.getResponsavelPreenchimento());

		Questionario questionario = new Questionario();
		questionario.setDtInsert(LocalDateTime.now());
		questionario.setLocal(questionarioRequest.getLocal());
		questionario.setCidadao(cidadao);
		questionario.setCidadeOrigem(cidade);
		questionario.setMotivoAbordagem(questionarioRequest.getMotivoAbordagem());
		questionario.setNumeroChamado(questionarioRequest.getNumeroChamado());
		questionario.setTempoJundiai(questionarioRequest.getTempoJundiai());
		questionario.setTempoSituacaoRua(questionarioRequest.getTempoSituacaoDeRua());
		questionario.setServicoBuscaJundiai(servicos);
		questionario.setResponsavelPreenchimento(responsaveisPreenchimento);
		questionario.setObservacao(questionarioRequest.getObservacao());
		questionario.setQtPessoasAbordadas(questionarioRequest.getPessoasAbordadas());
		questionario.setOrientacao(questionarioRequest.getOrientacoes());
		questionario.setEncaminhamento(questionarioRequest.getEncaminhadoPara());

		Questionario questionarioSaved = questionarioRepository.save(questionario);
		QuestionarioResponse questionarioResponse = new QuestionarioResponse();
		questionarioResponse.setId(questionarioSaved.getId());
		questionarioResponse.setDateRegister(LocalDateTime.now());

		return ResponseEntity.ok(questionarioResponse);
	}
}
