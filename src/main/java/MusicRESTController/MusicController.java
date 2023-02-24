package MusicRESTController;

import Entity.MusicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MusicService;

@RestController
@RequestMapping("/muisc")
@CrossOrigin("*")
public class MusicController {
    @Autowired
    MusicService musicService;

    @PostMapping("/save")
    public String save(MusicModel music) throws Exception {
        return musicService.saveMusic(music);
    }

}
