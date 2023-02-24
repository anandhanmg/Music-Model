package service;

import Entity.MusicModel;
import MusicRespository.Respository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {
 @Autowired
 Respository respository;

 public String saveMusic(MusicModel music) throws Exception {
     MusicModel music1 = music.getId()==null?new MusicModel():
             respository.findById(music.getId()).orElseThrow(() ->new RuntimeException("NO_DATE_FOUND"));
     if(music.getTitle()!=null){
         throw new Exception("Title should not be null");
     }
     if(music.getArtist()!=null){
         throw new Exception("Artist should not be null");
     }
     if(music.getGenre()!=null){
         throw new Exception("Genre should not be null");
     }
     if(music.getReleaseDate()!=null){
         throw new Exception("Release Date should not be null");
     }
     respository.save(music);
     return "CREATED";
 }
}
