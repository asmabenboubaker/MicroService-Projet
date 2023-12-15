package com.example.musicmservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/musicMS")
@CrossOrigin(origins = "*")
public class MusicRestAPI {


    @Autowired
    private MusicService musicService;

    @Autowired
    private TypeService typeService;


    private String title = "hello from Music api";


    @RequestMapping("/music/hello")
    public String sayHallo() {
        System.out.println(title);
        return title;
    }


    @PostMapping(value = "/music/addMusic/{idType}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Music addMusic(@RequestBody Music music, @PathVariable(value = "idType") int idType) {
        return musicService.addMusic(music, idType);
    }


    @GetMapping("/music/music/{id}")
    public Music getMusicById(@PathVariable Integer id) {
        return musicService.getMusicById(id);
    }

    @DeleteMapping(value = "/music/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteMusic(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(musicService.deleteMusic(id), HttpStatus.OK);
    }


    @PutMapping(value = "/music/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Music> updateCandidat(@PathVariable(value = "id") int id,
                                               @RequestBody Music music) {

        return new ResponseEntity<>(musicService.updateMusic(id, music),
                HttpStatus.OK);


    }



    @GetMapping("music/allMusics")
    @ResponseBody
    public List<Music> getAllMusics(){
        return  musicService.retrieveAllMusics();
    }

    //************************************************************


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("type/addType")
    public ResponseEntity<Type> createCandidat(@RequestBody Type type) {
        return new ResponseEntity<>(typeService.addType(type), HttpStatus.OK);
    }



    @GetMapping("type/type/{id}")
    public Type gettypeById(@PathVariable Integer id) {
        return typeService.getTypeById(id);
    }



    @PutMapping(value = "type/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Type> updateCandidat(@PathVariable(value = "id") int id,
                                               @RequestBody Type type) {
        return new ResponseEntity<>(typeService.updateType(id, type),
                HttpStatus.OK);


    }


    @DeleteMapping(value = "type/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteType(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(typeService.deleteType(id), HttpStatus.OK);
    }



    @GetMapping("type/allTypes")
    @ResponseBody
    public List<Type> getAllTypes(){
        return  typeService.retrieveAllTypes();
    }













}
