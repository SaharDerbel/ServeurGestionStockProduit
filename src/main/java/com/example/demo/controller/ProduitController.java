package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Produit;
import com.example.demo.service.IProduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin
//n the current implementation of the User class, the @CrossOrigin annotation only allows cross-origin HTTP requests from a single origin. We can take a less restrictive approach and specify multiple origins, on a per-use-case need.
public class ProduitController {

	@Autowired
	private IProduitService produitServcie;
	@GetMapping
	public List<Produit> getProduits() {
		return produitServcie.getProduits();
		}
	@PostMapping
	public void addProduit(@RequestBody Produit produit) {
		produitServcie.addProduit(produit);
	}
	@PutMapping
	public void updateProduit(@RequestBody Produit produit) {
		produitServcie.updateProduit(produit);
	}
	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable Long id) {
		produitServcie.deleteProduit(id);
	}
}
