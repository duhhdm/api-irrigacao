package br.com.fiap.apiirrigacao;

import br.com.fiap.apiirrigacao.controller.IrrigacaoController;
import br.com.fiap.apiirrigacao.model.IrrigacaoCadastroDTO;
import br.com.fiap.apiirrigacao.model.IrrigacaoExibicaoDTO;
import br.com.fiap.apiirrigacao.model.ListIrrigacaoExibicaoDTO;
import br.com.fiap.apiirrigacao.service.IrrigacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApiIrrigacaoApplicationTests {
  @Mock
  private IrrigacaoService irrigacaoService;

  @InjectMocks
  private IrrigacaoController irrigacaoController;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(irrigacaoController).build();
  }

  @Test
  public void testCadastrarIrrigacao_Success() throws Exception {
    IrrigacaoCadastroDTO cadastroDTO = null;
    // Preencher o cadastroDTO com os dados necessários

    IrrigacaoExibicaoDTO exibicaoDTO = null;
    // Preencher o exibicaoDTO com os dados necessários

    when(irrigacaoService.cadastrarIrrigador(any(IrrigacaoCadastroDTO.class))).thenReturn(exibicaoDTO);

    ResponseEntity<IrrigacaoExibicaoDTO> response = irrigacaoController.cadastrarIrrigacao(cadastroDTO);

    // Verificações
    assertEquals(200, response.getStatusCodeValue());
    assertEquals(exibicaoDTO, response.getBody());
  }

//  @Test
//  public void testCadastrarIrrigacao_Failure() {
//    IrrigacaoCadastroDTO cadastroDTO = null;
//    // Preencher o cadastroDTO com os dados necessários
//
//    when(irrigacaoService.cadastrarIrrigador(any(IrrigacaoCadastroDTO.class))).thenThrow(new RuntimeException());
//
//    ResponseEntity<IrrigacaoExibicaoDTO> response = irrigacaoController.cadastrarIrrigacao(null);
//
//    // Verificações
//    assertEquals(400, response.getStatusCodeValue());
//  }

  @Test
  public void testDeletaIrrigacao_Success() {
    Integer id = 1;

    doNothing().when(irrigacaoService).deletarIrrigacao(id);

    ResponseEntity response = irrigacaoController.deletaIrrigacao(id);

    // Verificações
    assertEquals(204, response.getStatusCodeValue());
  }

  @Test
  public void testDeletaIrrigacao_Failure() {
    Integer id = 1;

    doThrow(new RuntimeException()).when(irrigacaoService).deletarIrrigacao(id);

    ResponseEntity response = irrigacaoController.deletaIrrigacao(id);

    // Verificações
    assertEquals(400, response.getStatusCodeValue());
  }

  @Test
  public void testConsultaListaIrrigacao() {
    List<ListIrrigacaoExibicaoDTO> lista = Collections.singletonList(null);
    when(irrigacaoService.lista()).thenReturn(lista);

    ResponseEntity<List<ListIrrigacaoExibicaoDTO>> response = irrigacaoController.consultaListaIrrigacao();

    // Verificações
    assertEquals(200, response.getStatusCodeValue());
    assertEquals(lista, response.getBody());
  }
}
