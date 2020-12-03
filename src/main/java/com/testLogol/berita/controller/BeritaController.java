package com.testLogol.berita.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testLogol.berita.model.Berita;
import com.testLogol.berita.repository.BeritaRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/berita/v1")
public class BeritaController {

	@Autowired
	private BeritaRepository beritaRepository;
	
	@GetMapping("/GetAllBerita")
	public List<Berita> getAllBerita() {
		return beritaRepository.findAll();
	}
	
	@GetMapping("GetFindById/{id}")
	public ResponseEntity<Berita> getBeritaById(@PathVariable(value = "id") String BeritaId)
		throws NotFoundException {
		Berita berita = beritaRepository.findById(BeritaId)
				.orElseThrow(() -> new NotFoundException("Berita not found for this id ::" + BeritaId));
		return ResponseEntity.ok().body(berita);
	}
	
	@PostMapping("/AddBerita")
	public Berita createBerita(@Validated @RequestBody Berita berita) {
		return beritaRepository.save(berita);
	}
	
	@PutMapping("/EditBerita/{id}")
	public ResponseEntity<Berita> updateBerita(@PathVariable(value = "id") String BeritaId,
			@Validated @RequestBody Berita BeritaDetails) throws NotFoundException{
		Berita berita = beritaRepository.findById(BeritaId)
				.orElseThrow(() -> new NotFoundException("Berita not found for this id ::" + BeritaId));
		berita.setDeskripsi(BeritaDetails.getDeskripsi());
		berita.setCreate_date(BeritaDetails.getCreate_date());
		berita.setJudul(BeritaDetails.getJudul());
		final Berita updateBerita = beritaRepository.save(berita);
		return ResponseEntity.ok(updateBerita);
	}
	
	@DeleteMapping("/DeleteBerita/{id}")
	public Map<String, Boolean> deleteSiswa(@PathVariable(value = "id") String BeritaId)
		throws NotFoundException{
		Berita berita = beritaRepository.findById(BeritaId)
				.orElseThrow(() -> new NotFoundException("Berita not found for this id ::" + BeritaId));
		beritaRepository.delete(berita);
		Map<String, Boolean> response = new HashMap<>();
		return response;
	}
	
}
