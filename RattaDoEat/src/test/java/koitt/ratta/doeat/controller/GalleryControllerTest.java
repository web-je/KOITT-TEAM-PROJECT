package koitt.ratta.doeat.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import koitt.ratta.doeat.controller.GalleryController;
import koitt.ratta.doeat.domain.GalleryVo;
import koitt.ratta.doeat.service.GalleryService;

@WebMvcTest(controllers = GalleryController.class)
public class GalleryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private GalleryVo gallery;
	
	@Test
	public void galleryTest() throws Exception {
		
		mockMvc.perform(get("/gallery"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(view().name("gallery"))
			   .andExpect(model().attribute("gallery", gallery));
	}
	
}
