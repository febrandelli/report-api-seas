package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.dto.QuestionarioDto;
import com.github.seas.reportapi.converter.QuestionarioConverter;
import com.github.seas.reportapi.domain.Questionario;
import com.github.seas.reportapi.domain.Servico;
import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.repository.CidadaoRepository;
import com.github.seas.reportapi.repository.CidadeRepository;
import com.github.seas.reportapi.repository.QuestionarioRepository;
import com.github.seas.reportapi.repository.ServicoRepository;
import com.github.seas.reportapi.repository.UsuarioRepository;
import javassist.tools.web.BadHttpRequest;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionarioService {
		private final QuestionarioRepository questionarioRepository;
		private final CidadaoRepository cidadaoRepository;
		private final ServicoRepository servicoRepository;
		private final UsuarioRepository usuarioRepository;
		private final CidadeRepository cidadeRepository;
		private final QuestionarioConverter questionarioConverter;

		@Autowired
		public QuestionarioService(QuestionarioRepository questionarioRepository, CidadaoRepository cidadaoRepository, ServicoRepository servicoRepository, UsuarioRepository usuarioRepository,
						CidadeRepository cidadeRepository, QuestionarioConverter questionarioConverter) {
				this.questionarioRepository = questionarioRepository;
				this.cidadaoRepository = cidadaoRepository;
				this.servicoRepository = servicoRepository;
				this.usuarioRepository = usuarioRepository;
				this.cidadeRepository = cidadeRepository;
				this.questionarioConverter = questionarioConverter;
		}

		public ResponseEntity<Page<QuestionarioDto>> getAll(Pageable pageable) {

				Page<Questionario> questionarios = questionarioRepository.findAll(pageable);
				Page<QuestionarioDto> questionariosDto = questionarios.map(questionario -> questionarioConverter.toDto(questionario));
				return ResponseEntity.ok(questionariosDto);
		}

		public Questionario create(Questionario newQuestionario) throws BadHttpRequest {

				newQuestionario.setDtInsert(LocalDateTime.now());
				newQuestionario.setCidadao(cidadaoRepository.findById(newQuestionario.getCidadao().getId()).orElseThrow(BadHttpRequest::new));
				newQuestionario.setCidadeOrigem(cidadeRepository.findById(newQuestionario.getCidadeOrigem().getId()).orElseThrow(BadHttpRequest::new));
				newQuestionario.setServicoBuscaJundiai(servicoRepository.findByIdIn(
								newQuestionario.getServicoBuscaJundiai().stream().map(Servico::getId).collect(Collectors.toList())
				));
				newQuestionario.setResponsavelPreenchimento(usuarioRepository.findByNomeCompletoIn(
								newQuestionario.getResponsavelPreenchimento().stream().map(Usuario::getNomeCompleto).collect(Collectors.toList())
				));

				newQuestionario = questionarioRepository.save(newQuestionario);

				return newQuestionario;
		}

		public Questionario update(Questionario questionarioUpdate) {
				Optional<Questionario> questionario = questionarioRepository.findById(questionarioUpdate.getId());
				return questionario.orElse(questionarioUpdate);
		}

		public Questionario getById(Long id) throws NotFound {
				return questionarioRepository.findById(id).orElseThrow(NotFound::new);
		}
}
