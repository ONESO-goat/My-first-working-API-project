package com.example.springbotapp;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notes")
public class Notes {
  private final List<Note> notes = new ArrayList<>();

  @GetMapping
  public List<Note> getNotes(){
    return notes;
  }

  @PostMapping
  public String post(@RequestBody Note data){
    if(data == null || data.getTitle() == null || data.getContent() == null ){
      return "Error grabbing the data";
    }
    notes.add(data);
    return "Success creating the challenge";
  }

  @DeleteMapping("/{title}")
  public boolean deleteNote(@PathVariable String title){
    return notes.removeIf(note -> note.getTitle().equalsIgnoreCase(title));
}
}

