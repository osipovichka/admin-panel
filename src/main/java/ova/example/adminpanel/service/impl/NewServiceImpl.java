package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.NewDTO;
import ova.example.adminpanel.models.New;
import ova.example.adminpanel.repository.NewsRepository;
import ova.example.adminpanel.service.NewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewServiceImpl implements NewService {

    private final NewsRepository newsRepo;

    @Override
    public List<NewDTO> getAllNews() {
        List<NewDTO> newDTOList = new ArrayList<>();
        for(New n : newsRepo.findAll()){
            newDTOList.add(NewDTO.fromModel(n));
        }
        return newDTOList;
    }

    @Override
    public NewDTO getNewById(long id) {
        Optional<New> optionalNew = newsRepo.findById(id);
        if(optionalNew.isEmpty()){
            log.error("Новость с id - {} не найдена", id);
        }
        return NewDTO.fromModel(optionalNew.get());
    }

    @Override
    public NewDTO createNew(NewDTO newDTO) {
        New newsItem = new New(newDTO);

        return NewDTO.fromModel(newsRepo.saveAndFlush(newsItem));
    }

    @Override
    public NewDTO updateNew(NewDTO details) {
        Optional<New> optionalNew = newsRepo.findById(details.getId());
        if(optionalNew.isEmpty()){
            log.error("Новость с id - {} не найдена", details.getId());
        }
        New newsItem = optionalNew.get();
        newsItem.setTitle(details.getTitle());
        newsItem.setContent(details.getContent());

        return NewDTO.fromModel(newsRepo.saveAndFlush(newsItem));
    }

    @Override
    public void deleteNewDTO(long id) {
        newsRepo.deleteById(id);
    }
}
