package com.todo.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.Repository.todoRepository;
import com.todo.demo.todoEntity.todoEntity;

@RestController
@CrossOrigin("http://localhost:5173")
public class todocontroller {
	
	@Autowired
	 todoRepository repo;
	
	@PostMapping("/todo/add")
	
	public ResponseEntity<String> todoSave(@RequestBody todoEntity fields)
	{
		repo.save(fields);
		return ResponseEntity.ok("saved successfully");
		
	}
	
	@GetMapping("/todo/show")
	
	public List<todoEntity> todoArray()
	{
		return repo.findAll();
	}
	
   @DeleteMapping("/todo/delete")
   
   public ResponseEntity<String> todoDelete(@RequestParam(name="id") int id)
   {
	  Optional<todoEntity> find= repo.findById(id);
	   repo.delete(find.get());
	   return ResponseEntity.ok("Delete successfully");
   }
   
   @PutMapping("/todo/update")
   
   public ResponseEntity<String> todoupdate(@RequestBody todoEntity update)
   {
	   todoEntity find= repo.findById(update.getId()).get();
	   find.setTitle(update.getTitle());
	   find.setDescription(update.getDescription());
	   repo.save(find);
	   return ResponseEntity.ok("update successful");
   }
   
}
