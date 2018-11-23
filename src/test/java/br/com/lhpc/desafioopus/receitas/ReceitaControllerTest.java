package br.com.lhpc.desafioopus.receitas;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.lhpc.desafioopus.receitas.models.Ingrediente;
import br.com.lhpc.desafioopus.receitas.models.Receita;
import br.com.lhpc.desafioopus.receitas.repository.IngredienteRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ReceitaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testPostSaveReceitaController() throws Exception {
		
		Ingrediente ingrediente = new Ingrediente("Ovo");
		ingrediente = ingredienteRepository.save(ingrediente);

		Receita receita = new Receita("Ovo frito", 1, 10, Arrays.asList(ingrediente), "Frite o ovo na frigideira");
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(receita);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/receita")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isCreated());
		
	}
	
	@Test
	public void testGetReceitas() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/receitas"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testGetReceitaPorID() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/receitas/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	public void testGetIngredientesPorReceita() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/receitas/1/ingrediente"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	public void testGetReceitaComIngrediente () throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/receitas/-/ingrediente/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	public void testGetIngredienteEmReceitas () throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/receitas/ingredientes"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testGetIngredientes () throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ingredientes"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
