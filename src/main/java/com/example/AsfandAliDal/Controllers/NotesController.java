package com.example.AsfandAliDal.Controllers;


import com.example.AsfandAliDal.Modal.Notes;
import com.example.AsfandAliDal.Repository.NotesRepository;
import com.example.AsfandAliDal.Services.NotesService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping
    public Notes createNotes(@RequestBody Notes note) {
        return notesService.createNotes(note);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        notesService.deleteUser(id);
    }

    @GetMapping
    public List<Notes> getAllNotes()
    {
        return  notesService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Notes getUserById(@PathVariable Long id) {
        return notesService.getNoteById(id);
    }
    @PutMapping
    public Notes updateUser(@RequestBody Notes note) {
        Notes existingUser = notesService.getNoteById(note.getId()); // Assuming getId() method exists in the Notes class
        if (existingUser != null) {
            existingUser.setTitle(note.getTitle());
            existingUser.setDescription(note.getDescription());
            return notesService.saveUser(existingUser);
        } else {
            return null;
        }
    }



}
