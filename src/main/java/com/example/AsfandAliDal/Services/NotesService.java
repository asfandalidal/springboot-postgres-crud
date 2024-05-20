package com.example.AsfandAliDal.Services;

import com.example.AsfandAliDal.Modal.Notes;
import com.example.AsfandAliDal.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public Notes createNotes(Notes note) {
        return notesRepository.save(note);
    }

    public void deleteUser(Long id) {
        notesRepository.deleteById(id);
    }

    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    public Notes getNoteById(Long id)
    {
        return notesRepository.findById(id).orElse(null);
    }

    public Notes saveUser(Notes notes) {
        return notesRepository.save(notes);
    }


}
