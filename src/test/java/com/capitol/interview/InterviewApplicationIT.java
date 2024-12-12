package com.capitol.interview;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class InterviewApplicationIT {

	@Autowired
	private MockMvc mockMvc;
	
	String jsonBody = "{\"fechaAplicacion\": \"%s\", \"idProducto\": %d, \"idCadena\": %d}";
	
	@Test
	public void peticion_a_las_diez_del_dia_catorce() {
		try {
			String request = String.format(jsonBody, "2020-06-14 10:00:00", 35455, 1);
			mockMvc.perform(MockMvcRequestBuilders.get("/price")
					.contentType(MediaType.APPLICATION_JSON)
					.content(request))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers
							.content()
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.price").value(35.50));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void peticion_a_las_dieciseis_del_dia_catorce() {
		try {
			String request = String.format(jsonBody, "2020-06-14 16:00:00", 35455, 1);
			mockMvc.perform(MockMvcRequestBuilders.get("/price")
					.contentType(MediaType.APPLICATION_JSON)
					.content(request))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers
							.content()
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.price").value(25.45));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void peticion_a_las_diez_del_dia_quince() {
		try {
			String request = String.format(jsonBody, "2020-06-15 10:00:00", 35455, 1);
			mockMvc.perform(MockMvcRequestBuilders.get("/price")
					.contentType(MediaType.APPLICATION_JSON)
					.content(request))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers
							.content()
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.price").value(30.50));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void peticion_a_las_veintiuna_del_dia_dieciseis() {
		try {
			String request = String.format(jsonBody, "2020-06-16 21:00:00", 35455, 1);
			mockMvc.perform(MockMvcRequestBuilders.get("/price")
					.contentType(MediaType.APPLICATION_JSON)
					.content(request))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers
							.content()
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.price").value(38.95));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void peticion_id_del_producto_inexistente() {
		try {
			String request = String.format(jsonBody, "2020-06-14 10:00:00", 35456, 1);
			mockMvc.perform(MockMvcRequestBuilders.get("/price")
					.contentType(MediaType.APPLICATION_JSON)
					.content(request))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isBadRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
