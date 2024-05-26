package id.ac.ui.cs.advprog.book.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import id.ac.ui.cs.advprog.book.service.SeedService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeedController {
  private final SeedService seedService;

  public SeedController(SeedService seedService) {
    this.seedService = seedService;
  }

  @GetMapping("/seed-data")
  public ResponseEntity<String> seedMaster() {
    seedService.seed();
    return ResponseEntity.ok("Seeding data master completed successfully.");
  }
}
